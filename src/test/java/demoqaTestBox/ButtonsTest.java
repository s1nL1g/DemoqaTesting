package demoqaTestBox;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ButtonsTest {
    WebDriver driver = new ChromeDriver();

    @BeforeClass
    public void setUp() {
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/buttons");
    }

    @Test
    public void testButtonClicks() {

        driver.findElement(By.xpath("//button[text()='Click Me']")).click();

        Actions actions = new Actions(driver);

        WebElement rightClickButton = driver.findElement(By.xpath("//button[text()='Right Click Me']"));
        actions.contextClick(rightClickButton).build().perform();

        WebElement doubleClickButton = driver.findElement(By.xpath("//button[text()='Double Click Me']"));
        actions.doubleClick(doubleClickButton).build().perform();

        driver.findElement(By.xpath("//button[text()='Click Me']")).click();

        WebElement messageElement = driver.findElement(By.xpath("//p[@id='dynamicClickMessage']"));
        String message = messageElement.getText();

        Assert.assertEquals(message, "You have done a dynamic click");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}


