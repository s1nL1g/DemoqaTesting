package demoqaTestBox;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;

public class CheckBoxTest {
    @Test
    public void doIt() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/checkbox");

        driver.manage().window().maximize();
        driver.findElement(By.xpath("//label[@for='tree-node-home']/preceding-sibling::button")).click();
        sleep(2000);
        driver.findElement(By.xpath("//label[@for='tree-node-downloads']/preceding-sibling::button")).click();
        driver.findElement(By.xpath("//label[@for='tree-node-excelFile']//span[@class='rct-checkbox']")).click();

        Assert.assertTrue(driver.findElement(By.xpath("//span[@class='text-success']")).isDisplayed());

        sleep(2000);
        driver.quit();
    }
}


