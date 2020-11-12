package Button;

import Common.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import javax.swing.*;

public class btnStep extends Base {
    WebDriver driver;
    Actions act= new Actions(driver);
    By btnTab= By.xpath("//span[contains(text(), 'Buttons')]");
    By doubleClick= By.cssSelector("#doubleClickBtn");
    By validateMess=By.cssSelector("#doubleClickMessage");
    By rightClick= By.cssSelector("#rightClickBtn");
    By validateRightMess= By.cssSelector("#rightClickMessage");
    By clickMe= By.xpath("//div[@class='mt-4']/following::button");
    By clickMeMess= By.cssSelector("#dynamicClickMessage");

    public btnStep(WebDriver base){
        driver=base;
    }
    public void clickTab(){
        find(btnTab).click();
    }
    public void doubleClick(){
        WebElement doublAction = find(doubleClick);
        act.doubleClick(doublAction).perform();
        System.out.println("Click success");
        String errorDouble= find(validateMess).getText();
        Assert.assertEquals(errorDouble,"You have done a double click");
    }
    public void setRightClick(){
        WebElement rightAct = find(rightClick);
        act.contextClick(rightAct).perform();
        String errorRight= find(validateRightMess).getText();
        Assert.assertEquals(errorRight,"You have done a right click");


    }
}

