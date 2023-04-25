package demoqaTestBox;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;
import static org.testng.Assert.*;

public class BrokenLinksTest {
    WebDriver driver = new ChromeDriver();

    @BeforeClass
    public void setUp() {
        driver.get("https://demoqa.com/broken");
        driver.manage().window().maximize();
    }

    @Test
    public void brokenLink() throws InterruptedException {

        WebElement validImage = driver.findElement(By.xpath("//div[@class='col-12 mt-4 col-md-6'][descendant::img[@src='/images/Toolsqa.jpg']]"));
        assertTrue(validImage.isDisplayed(), "Valid image is displayed");

        WebElement brokenImage = driver.findElement(By.xpath("//div[@class='col-12 mt-4 col-md-6'][descendant::img[@src='/images/Toolsqa_1.jpg']]"));
        assertTrue(brokenImage.isDisplayed());

        driver.findElement(By.xpath("//a[@href='http://demoqa.com']")).click();

        String expectedTitle = "DEMOQA";
        String actualTile = driver.getTitle();

        assertEquals(expectedTitle, actualTile);

        driver.navigate().back();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", "");

        driver.findElement(By.xpath("//a[@href='http://the-internet.herokuapp.com/status_codes/500']")).click();
        sleep(500);

        String firstResult = driver.findElement(By.xpath("//*[@id='content']/div/p/text()[1]")).getText();
        Assert.assertTrue(firstResult.contains("500"));

        driver.findElement(By.xpath("//a[@href='/status_codes']")).click();

        driver.navigate().back();
        sleep(1100);


    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
