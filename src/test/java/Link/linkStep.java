package Link;

import Common.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.util.List;

public class linkStep extends Base {
    WebDriver driver;
    Actions act= new Actions(driver);
    By linkTab=By.xpath("//span[text()= 'Links']");
    By invalidUrl= By.cssSelector("#invalid-url");
    By brokenLink= By.xpath("//span[contains(text(), 'Broken Links')]");
    By tagName = By.tagName("a");
    By linkRespond= By.cssSelector("#linkResponse");
    By allLink= By.xpath("//div[@id='linkWrapper']//a");


    public linkStep(WebDriver base){
        driver=base;
    }
    public void clickTab(){
        find(linkTab).click();
    }
    public void getLinkWithText(){
        find(invalidUrl).click();
        String text= find(linkRespond).getText();
        Assert.assertEquals(text, "Link has responded with staus 404 and status text Not Found");
        System.out.println("Mess:" + text);

    }
    public void getAllLink(){
        List<WebElement> ele= driver.findElements(allLink);
        int eleSize= ele.size();
        System.out.println("Number of link:"+ ele.size());
        Assert.assertEquals(eleSize, 9);


    }
}

