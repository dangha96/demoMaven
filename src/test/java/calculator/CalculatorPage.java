package calculator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class CalculatorPage {

    WebDriver driver;
    By firstInput = By.xpath("//input[@ng-model='first']");
    By operator = By.xpath("//select[@ng-model='operator']");
    By secondInput = By.xpath("//input[@ng-model='second']");
    By btnGo = By.id("gobutton");
    By result = By.xpath("//h2[@class='ng-binding']");


    public CalculatorPage(WebDriver baseDriver) {
        driver = baseDriver;
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public void enterFirstTextBox(String a) {
        WebElement firstTextBox = driver.findElement(firstInput);
        firstTextBox.clear();
        firstTextBox.sendKeys(a);
    }


    public void enterSecondTextBox(String b) {
        WebElement secondTextBox = driver.findElement(secondInput);
        secondTextBox.clear();
        secondTextBox.sendKeys(b);
    }

    public void selectOperator(String operator) {
        Select selector = new Select(driver.findElement(this.operator));
        selector.selectByValue(operator);
    }

    public void clickBtnGo() {
        driver.findElement(btnGo).click();
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

//    public void getResult() {
//        driver.findElement(result).getText();
//    }
    public void compareResult (String expectedResult){
        Assert.assertEquals(driver.findElement(result).getText(), expectedResult);
    }


}
