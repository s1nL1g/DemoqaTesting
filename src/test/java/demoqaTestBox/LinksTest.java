package demoqaTestBox;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;

public class LinksTest {

    WebDriver driver = new ChromeDriver();

    @BeforeClass
    public void setUp() {
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/links");
    }

    @Test
    public void testLinks() throws InterruptedException {
        String currentTab = driver.getWindowHandle();

        driver.findElement(By.xpath("//a[@id='simpleLink']")).click();

        String expectedTitle = "DEMOQA";
        String actualTitle = driver.getTitle();

        Assert.assertEquals(actualTitle, expectedTitle);

        driver.switchTo().window(currentTab);
        driver.findElement(By.xpath("//a[@id='dynamicLink']")).click();

        Assert.assertEquals(actualTitle, expectedTitle);

        driver.switchTo().window(currentTab);
        sleep(500);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", "");

        driver.findElement(By.xpath("//a[@id='created']")).click();
        sleep(200);

        String resultCreated = driver.findElement(By.xpath("//p[@id='linkResponse']")).getText();

        Assert.assertTrue(resultCreated.contains("201"));
        Assert.assertTrue(resultCreated.contains("Created"));

        driver.findElement(By.xpath("//a[@id='no-content']")).click();
        sleep(200);

        String resultNoContent = driver.findElement(By.xpath("//p[@id='linkResponse']")).getText();

        Assert.assertTrue(resultNoContent.contains("204"));
        Assert.assertTrue(resultNoContent.contains("No Content"));

        driver.findElement(By.xpath("//a[@id='moved']")).click();
        sleep(200);

        String resultMoved = driver.findElement(By.xpath("//p[@id='linkResponse']")).getText();

        Assert.assertTrue(resultMoved.contains("301"));
        Assert.assertTrue(resultMoved.contains("Moved Permanently"));

        driver.findElement(By.xpath("//a[@id='bad-request']")).click();
        sleep(200);

        String resultBadRequest = driver.findElement(By.xpath("//p[@id='linkResponse']")).getText();

        Assert.assertTrue(resultBadRequest.contains("400"));
        Assert.assertTrue(resultBadRequest.contains("Bad Request"));

        driver.findElement(By.xpath("//a[@id='unauthorized']")).click();
        sleep(200);

        String resultUnauthorized = driver.findElement(By.xpath("//p[@id='linkResponse']")).getText();

        Assert.assertTrue(resultUnauthorized.contains("401"));
        Assert.assertTrue(resultUnauthorized.contains("Unauthorized"));


        driver.findElement(By.xpath("//a[@id='forbidden']")).click();
        sleep(200);

        String resultForbidden = driver.findElement(By.xpath("//p[@id='linkResponse']")).getText();

        Assert.assertTrue(resultForbidden.contains("403"));
        Assert.assertTrue(resultForbidden.contains("Forbidden"));

        driver.findElement(By.xpath("//a[@id='invalid-url']")).click();
        sleep(300);

        String resultNotFound = driver.findElement(By.xpath("//p[@id='linkResponse']")).getText();

        Assert.assertTrue(resultNotFound.contains("404"));
        Assert.assertTrue(resultNotFound.contains("Not Found"));
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}

