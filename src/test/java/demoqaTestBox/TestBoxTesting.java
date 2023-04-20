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

public class TestBoxTesting {

    WebDriver driver = new ChromeDriver();

    @BeforeClass
    public void setUp() {
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/broken");
    }

    @Test
    public void chekLoginTestBox() throws InterruptedException {
        driver.findElement(By.xpath("//input[@id='userName']")).sendKeys("Roman Roman");
        driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys("email1@gmail.com");
        driver.findElement(By.xpath("//textarea[@id='currentAddress']")).sendKeys("hshbqsbbxbshq");
        driver.findElement(By.xpath("//textarea[@id='permanentAddress']")).sendKeys("hdfgjsgef");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", "");

        sleep(1000);
        driver.findElement(By.xpath("//button[@id='submit']")).click();

        assertEquals(driver.findElement(By.xpath("//p[@id='name']")).getText(), "Name:Roman Roman");

        sleep(1500);

    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
