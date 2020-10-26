package element;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

import static element.Base.javascriptEx;

public class Page {
    WebDriver driver;
    By fullname = By.xpath("//input[@id='userName']");
    By email = By.cssSelector("#userEmail");
    By currentAdd = By.cssSelector("textarea[class='form-control']");
    By perAdd = By.xpath("//textarea[@id='permanentAddress']");
    By btnSubmit = By.xpath("//button[contains(text(),'Submit')]");
    By radiobtn = By.xpath("//label[@for='yesRadio']");

    By checkBox = By.xpath("////label[@for='tree-node-notes']");

    //span[text()='Notes']/preceding-sibling::input
//input[@id='yesRadio']/preceding-sibling::div[@class='custom-control custom-radio custom-control-inline']
    public Page(WebDriver base) {
        driver = base;
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public void EnterFullName() {

        driver.findElement(fullname).sendKeys("dang ha");
    }

    public void EnterEmail() {
        driver.findElement(email).sendKeys("dangha@gmail.com");
    }

    public void EnterCurrentAdd() {
        driver.findElement(currentAdd).sendKeys("abc");
    }

    public void EnterPerAdd() {
        driver.findElement(perAdd).sendKeys("123");

    }
//    public void ClickSubmitBtn(){
//        driver.findElement(btnSubmit).click();
//    }

    public void ClickBtnSubmit() {

        try {
            driver.findElement(btnSubmit).click();
        } catch (Exception e) {
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", driver.findElement(btnSubmit));
        }
    }

    public void ClickRadioTab() {

        driver.findElement(By.xpath("//span[contains(text(), 'Radio Button')]")).click();
        driver.navigate().to("https://www.demoqa.com/radio-button");

    }

    public void RadioButton() {
        driver.findElement(radiobtn).click();
        checkToCheckBoxOrRadio(radiobtn);
        Assert.assertTrue(isRadioOrCheckboxSelected(radiobtn));
        String MessageYes = driver.findElement(By.xpath("//p[@class='mt-3']")).getText();
        System.out.println("You have selected Yes");
        Assert.assertEquals(MessageYes, "You have selected Yes");
//        System.out.println("You have selected Yes");


    }

    public void ClickCheckBoxTab() {

        driver.findElement(By.xpath("//span[contains(text(), 'Check Box')]")).click();
        driver.navigate().to("https://www.demoqa.com/text-box");

    }

    public void CheckBox() {
//        driver.findElement(By.xpath("//button[@title='Toggle']")).click();
        driver.findElement(checkBox).click();
        checkToCheckBoxOrRadioByJava(checkBox);
//        driver.findElement(checkBox).click();
//        checkToCheckBoxOrRadio(checkBox);
//        Assert.assertTrue(isRadioOrCheckboxSelected(checkBox));
//        String MessCheck =driver.findElement(By.cssSelector("#result")).getText();
//        Assert.assertEquals(MessCheck,"You have selected : notes");
//        System.out.println("MessCheck");
    }


    public void checkToCheckBoxOrRadio(By locator) {
        WebElement element = driver.findElement(locator);
        if (!element.isSelected()) {
            element.click();
        }
    }

    public void checkToCheckBoxOrRadioByJava(By locator) {
        WebElement element = driver.findElement(locator);
        javascriptEx.executeScript("arguments[0].click();", element);

    }

    public void clickWebtable() {

        driver.findElement(By.xpath("//li[@class='btn btn-light active']")).click();
        driver.navigate().to("https://www.demoqa.com/webtables");
        driver.findElement(By.xpath("//button[@id='addNewRecordButton']")).click();
        driver.findElement(By.cssSelector("#firstName")).sendKeys("dang");
        driver.findElement(By.cssSelector("#lastName")).sendKeys("ha");
        driver.findElement(By.cssSelector("#userEmail")).sendKeys("dangha@gmail.com");
        driver.findElement(By.cssSelector("#age")).sendKeys("10");
        driver.findElement(By.cssSelector("#salary")).sendKeys("10000");
        driver.findElement(By.cssSelector("#department")).sendKeys("ABC");
        boolean subBtnPresence = driver.findElement(By.cssSelector("#submit")).isDisplayed();
        boolean subBtnEnable = driver.findElement(By.cssSelector("#submit")).isEnabled();

        if (subBtnPresence == true && subBtnEnable == true) {
            System.out.println("Button is enable and presence");
            WebElement subBtn = driver.findElement(By.cssSelector("#submit"));
            subBtn.click();
        }

    }

    public void ClickDouble(){
        driver.findElement(By.xpath("//li[@class='btn btn-light active']")).click();
        driver.navigate().to("https://www.demoqa.com/buttons");
        Actions act = new Actions(driver);

//Double click on element
        WebElement wb2 = driver.findElement(By.cssSelector("#doubleClickBtn"));
        act.doubleClick(wb2).perform();
        System.out.println("Click success");
        String errorMess=driver.findElement(By.cssSelector("#doubleClickMessage")).getText();
        Assert.assertEquals(errorMess, "You have done a double click");
        System.out.println("You have done a double click");
        //Right click
        WebElement elementLocator = driver.findElement(By.cssSelector("#rightClickBtn"));
        act.contextClick(elementLocator).perform();
        String errorMess2=driver.findElement(By.cssSelector("#rightClickMessage")).getText();
        Assert.assertEquals(errorMess2,"You have done a right click");
        // click me
        driver.findElement(By.xpath("//div[@class='mt-4']/following::button")).click();
        String err3=driver.findElement(By.cssSelector("#dynamicClickMessage")).getText();
        Assert.assertEquals(err3,"You have done a dynamic click");



       }

       public void UploadSeleniumSendKey(){
           driver.findElement(By.xpath("//li[@class='btn btn-light active']")).click();
           driver.navigate().to("https://www.demoqa.com/upload-download");
           WebElement upload= driver.findElement(By.xpath("//input[@type='file']"));

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
