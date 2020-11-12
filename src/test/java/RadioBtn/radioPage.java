package RadioBtn;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import Common.Base;

import java.util.concurrent.TimeUnit;

public class radioPage extends Base {
    WebDriver driver;
    By radioTab = By.xpath("//span[contains(text(), 'Radio Button')]");
    By radiobtn = By.xpath("//label[@for='yesRadio']");
    By yesMessage = By.xpath("//p[@class='mt-3']");

    public radioPage(WebDriver base) {
        driver = base;
        //        JavascriptExecutor js = (JavascriptExecutor) driver;
        //        js.executeScript("window.scrollBy(0,1000)");
    }

    public void clickRadioTab() {

        find(radioTab).click();
    }

    public void clickRadioBtn() {
        checkToCheckBoxOrRadio(radiobtn);
        Assert.assertTrue(isRadioOrCheckboxSelected(radiobtn));
        String messageYes = find(yesMessage).getText();
        System.out.println("You have selected Yes");
        Assert.assertEquals(messageYes, "You have selected Yes");
    }


    public void checkToCheckBoxOrRadio(By locator) {
        WebElement element = driver.findElement(locator);
        if (!element.isSelected()) {
            element.click();
        }
    }

    public void uncheckToCheckBox(By locator) {
        WebElement element = driver.findElement(locator);
        if (element.isSelected()) {
            element.click();
        }
    }


    public boolean isRadioOrCheckboxSelected(By locator) {
        WebElement element = driver.findElement(locator);
        if (!element.isSelected()) {
            System.out.println("Checkbox or Radio is selected");
            return true;
        } else {
            System.out.println("Checkbox or Radio is deselected");
            return false;
        }
    }
}
