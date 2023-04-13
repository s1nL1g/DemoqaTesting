package demoqaTestBox;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



public class WebTablesTest {
    WebDriver driver = new ChromeDriver();

    @BeforeClass
    public void setUp() {
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/webtables");
    }

    @Test
    public void testWebTable() {

        driver.findElement(By.xpath("//button[@id='addNewRecordButton']")).click();
        driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys("Oleg");
        driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys("Vyacheslavenko");
        driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys("o.vyach@gmail.com");
        driver.findElement(By.xpath("//input[@id='age']")).sendKeys("18");
        driver.findElement(By.xpath("//input[@id='salary']")).sendKeys("5000");
        driver.findElement(By.xpath("//input[@id='department']")).sendKeys("Dep 1");
        driver.findElement(By.xpath("//button[@id='submit']")).click();
        driver.findElement(By.xpath("//span[@id='delete-record-2']")).click();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", "");

        driver.findElement(By.xpath("//input[@id='searchBox']")).sendKeys("Oleg");

        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='rt-tr -odd']")).isDisplayed());
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
