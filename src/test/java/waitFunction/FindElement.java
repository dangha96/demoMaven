package waitFunction;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class FindElement {
    WebDriver driver;
    WebDriverWait explicitWait;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        explicitWait = new WebDriverWait(driver, 20);

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

    }

    @Test
    public void TC_01_FindElement() {
        driver.get("https://automationfc.github.io/multiple-fields/index.html");
        WebElement lastnameTextBox=  driver.findElement(By.xpath("//input[@id='last_45']"));
        lastnameTextBox.sendKeys("ha@gmail.com");

    }
//12:323
    @Test
    public void TC_02_FindElements() {
        driver.get("https://automationfc.github.io/multiple-fields/index.html");
        List <WebElement> allCheckboxes= driver.findElements(By.xpath("//input[@type='checkbox']"));
        System.out.println("Number of checkbox="+ allCheckboxes.size());
        for (WebElement checkbox :allCheckboxes){
            checkbox.click();
            sleepInSecond(1);
        }
        for (WebElement selected :allCheckboxes){
            Assert.assertTrue(selected.isSelected());
            sleepInSecond(1);
        }

    }



    @AfterClass
    public void quit() {
        driver.close();
    }
public  void sleepInSecond(long timeout){
    try {
        Thread.sleep(timeout*1000);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
}

}

