package demoqaTestBox;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;

public class TestBoxTesting {

    @Test
    public void chekLoginTestBox() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/text-box");

        driver.findElement(By.xpath("//input[@id='userName']")).sendKeys("Roman Roman");
        driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys("email1@gmail.com");
        driver.findElement(By.xpath("//textarea[@id='currentAddress']")).sendKeys("hshbqsbbxbshq");
        driver.findElement(By.xpath("//textarea[@id='permanentAddress']")).sendKeys("hdfgjsgef");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", "");

        sleep(1000);
        driver.findElement(By.xpath("//button[@id='submit']")).click();

        Assert.assertEquals(driver.findElement(By.xpath("//p[@id='name']")).getText(), "Name:Roman Roman");

        sleep(1500);
        driver.quit();
    }
}
