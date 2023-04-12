package demoqaTestBox;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;

public class RadioButtonTest {
    @Test
    public void chekLoginTestBox() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/radio-button");

        driver.findElement(By.xpath("//label[@for='yesRadio']")).click();

        Assert.assertTrue(driver.findElement(By.xpath("//span[@class='text-success']")).isDisplayed());

        sleep(2000);
        driver.quit();
    }
}
