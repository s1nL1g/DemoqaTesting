package demoqaTestBox;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;

public class RadioButtonTest {
    WebDriver driver = new ChromeDriver();

    @BeforeClass
    public void setUp() {
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/radio-button");
    }

    @Test
    public void chekLoginTestBox() throws InterruptedException {


        WebElement radioButtonNo = driver.findElement(By.xpath("//input[@id='noRadio']"));

        Assert.assertFalse(radioButtonNo.isEnabled(), "RadioButton 'No' should be disabled.");

        driver.findElement(By.xpath("//label[@for='yesRadio']")).click();

        Assert.assertTrue(driver.findElement(By.xpath("//span[@class='text-success']")).isDisplayed());

        driver.findElement(By.xpath("//label[@for='impressiveRadio']")).click();

        Assert.assertTrue(driver.findElement(By.xpath("//span[@class='text-success']")).isDisplayed());

        sleep(1000);
    }

    @AfterClass
    public void enging() {
        driver.quit();
    }


}
