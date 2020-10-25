package waitFunction;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Wait {
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
    public void TC_01_Wait_Visible() {
        driver.get("http://live.demoguru99.com/index.php/customer/account/login/");
        // Wait for Last name text box
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.name("login[username]")));
        Assert.assertTrue(driver.findElement(By.name("login[username]")).isDisplayed());
    }
    //33:23
    @Test
    public void TC_01_Wait_InVisible() {
        driver.get("http://live.demoguru99.com/index.php/customer/account/login/");
        // Wait for Last name text box
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.name("login[username]")));
        Assert.assertTrue(driver.findElement(By.name("login[username]")).isDisplayed());
    }



    @AfterClass
    public void quit() {
        driver.close();
    }


}
