package element;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static element.Common.javascriptEx;

public class Page<name> {

    WebDriver driver;
    By fullname = By.xpath("//input[@id='userName']");
    By email = By.cssSelector("#userEmail");
    By currentAdd = By.cssSelector("textarea[class='form-control']");
    By perAdd = By.xpath("//textarea[@id='permanentAddress']");
    By btnSubmit = By.xpath("//button[contains(text(),'Submit')]");
    By radiobtn = By.xpath("//label[@for='yesRadio']");
    String baseURl="https://demoqa.com/";
//    Actions act = new Actions(driver);

    By checkBox = By.xpath("//label[@for='tree-node-notes']");
    //data test
//    name="dangha";
//    email="danghongha96@gmail.com";


    //span[text()='Notes']/preceding-sibling::input
//input[@id='yesRadio']/preceding-sibling::div[@class='custom-control custom-radio custom-control-inline']
    public Page(WebDriver base) {
        driver = base;
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");
    }



    public void clickRadioButton() {
//       =>done
        driver.findElement(By.xpath("//span[contains(text(), 'Radio Button')]")).click();
        driver.findElement(radiobtn).click();
        checkToCheckBoxOrRadio(radiobtn);
        Assert.assertTrue(isRadioOrCheckboxSelected(radiobtn));
        String messageYes = driver.findElement(By.xpath("//p[@class='mt-3']")).getText();
        System.out.println("You have selected Yes");
        Assert.assertEquals(messageYes, "You have selected Yes");


    }


    public void CheckBox() {
        driver.findElement(By.xpath("//span[contains(text(),'Check Box')]")).click();
        driver.findElement(By.xpath("//button[@title='Expand all']")).click();
        driver.findElement(checkBox).click();
        Assert.assertTrue(isRadioOrCheckboxSelected(checkBox));

        String messDefault = driver.findElement(By.xpath("//span[contains(text(),'You have selected :')]")).getText();
        Assert.assertEquals(messDefault, "You have selected :");
        String messResult = driver.findElement(By.cssSelector(".text-success")).getText();
        Assert.assertEquals(messResult, "notes");
        System.out.println(messDefault+messResult);
//        System.out.println(messResult);
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

    public void verifyWebTable() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");
        driver.findElement(By.xpath("//span[contains(text(),'Web Tables')]")).click();
        driver.findElement(By.xpath("//button[@id='addNewRecordButton']")).click();
        driver.findElement(By.cssSelector("#firstName")).sendKeys("dang");
        driver.findElement(By.cssSelector("#lastName")).sendKeys("ha");
        driver.findElement(By.cssSelector("#userEmail")).sendKeys("dangha@gmail.com");
        driver.findElement(By.cssSelector("#age")).sendKeys("10");
        driver.findElement(By.cssSelector("#salary")).sendKeys("10000");
        driver.findElement(By.cssSelector("#department")).sendKeys("ABC");
        // verify button enale
        boolean subBtnPresence = driver.findElement(By.cssSelector("#submit")).isDisplayed();
        boolean subBtnEnable = driver.findElement(By.cssSelector("#submit")).isEnabled();
        if (subBtnPresence == true && subBtnEnable == true) {
            System.out.println("Button is enable and presence");
            WebElement subBtn = driver.findElement(By.cssSelector("#submit"));
            subBtn.click();
        }
        // count rows
        List<WebElement> buttons = driver.findElements(By.cssSelector(".action-buttons"));
        System.out.println("Total num of buttons:" + buttons.size());

        // print content of added rows
        WebElement newRow = driver.findElement(By.xpath("//div[@class='rt-tr-group'][4]"));
        System.out.println("Value in table:\n" + newRow.getText());
//        for (int j = 0; j < newRow.size() - 1; j++) {
//            System.out.println(newRow.get(j).getText());
//		for (int j = 0; j < rows.size() - 1; j++) {
//		    -> get from rows: can print but get from newRow: cannot
//			System.out.println(rows.get(j).getText());
// compare value <=> textbox

    }

    public void clickButton() {
        driver.findElement(By.xpath("//span[contains(text(),'Buttons')]")).click();
        Actions act = new Actions(driver);

//Double click on element

        WebElement wb2 = driver.findElement(By.cssSelector("#doubleClickBtn"));
        act.doubleClick(wb2).perform();
        System.out.println("Click success");
        String errorMess = driver.findElement(By.cssSelector("#doubleClickMessage")).getText();
        Assert.assertEquals(errorMess, "You have done a double click");
        System.out.println("You have done a double click");
        //Right click
        WebElement elementLocator = driver.findElement(By.cssSelector("#rightClickBtn"));
        act.contextClick(elementLocator).perform();
        String errorMess2 = driver.findElement(By.cssSelector("#rightClickMessage")).getText();
        Assert.assertEquals(errorMess2, "You have done a right click");
        // click me
        driver.findElement(By.xpath("//div[@class='mt-4']/following::button")).click();
        String err3 = driver.findElement(By.cssSelector("#dynamicClickMessage")).getText();
        Assert.assertEquals(err3, "You have done a dynamic click");


    }

    public void verifyBrokenLink() {
//        js.executeScript("window.scrollBy(0,1000)");
//        driver.findElement(By.xpath("//span[contains(text(), 'Broken Links')]")).click();
        List<WebElement> ele = driver.findElements(By.tagName("a"));
        System.out.println("size:" + ele.size());
        boolean isValid = true;
        for (int i = 0; i < ele.size(); i++) {
            // System.out.println(ele.get(i).getAttribute("href"));
            isValid = getResponseCode(ele.get(i).getAttribute("href"));
            if (isValid) {
                System.out.println("ValidLinks:" + ele.get(i).getAttribute("href"));
            } else {
                System.out.println("InvalidLinks:" + ele.get(i).getAttribute("href"));
            }
        }
    }

    public static boolean getResponseCode(String urlString) {
        boolean isValid = true; // -> if define true print valid link and if false print invalid ????
        try {
            URL u = new URL(urlString);
            HttpURLConnection h = (HttpURLConnection) u.openConnection();
            h.setRequestMethod("GET");
            h.connect();
            System.out.println(h.getResponseCode());
            if (h.getResponseCode() != 404) {
                isValid = true;
            }
        } catch (Exception e) {

        }
        return isValid;

    }


    //done
    public void verifyLink() throws InterruptedException {
        driver.findElement(By.xpath("//span[contains(text(),'Links')]")).click();
        List<WebElement> ele = driver.findElements(By.xpath("//div[@id='linkWrapper']//a"));
        int eleSize= ele.size();
        System.out.println("Number of links:" + ele.size());
        Assert.assertEquals(eleSize, 9);
        driver.findElement(By.cssSelector("#simpleLink")).click();
// 1st Way
        ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1)); //switches to new tab
        String currentUrl=  driver.getCurrentUrl();
        Assert.assertEquals(currentUrl,"https://www.demoqa.com/");
        //ctrl tab
//        driver.findElement(By.cssSelector("#simpleLink")).sendKeys(Keys.CONTROL+"t");
        driver.switchTo().window(tabs.get(0));

        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.chord(Keys.CONTROL, Keys.TAB)).perform();
        actions
                .keyDown(Keys.CONTROL).sendKeys(Keys.TAB)
                .keyUp(Keys.CONTROL)
                .build().perform();
        Thread.sleep(3000);
//        driver.get("https://www.demoqa.com/");
//                driver.switchTo().window(tabs.get(0)); // switch back to main screen
//                driver.get("https://demoqa.com/links");


        //Way 2
//        WebElement elementLocator = driver.findElement(By.cssSelector("#rightClickBtn"));
//        act.contextClick(elementLocator).perform();






    }

    public void UploadSeleniumSendKey() {
        driver.findElement(By.xpath("//li[@class='btn btn-light active']")).click();
        driver.navigate().to("https://www.demoqa.com/upload-download");
        WebElement upload = driver.findElement(By.xpath("//input[@type='file']"));

    }

    public void getLinkWithText() {
        driver.findElement(By.xpath("//span[contains(text(),'Links')]")).click();

        driver.findElement(By.cssSelector("#invalid-url")).click();
        String text = driver.findElement(By.cssSelector("#linkResponse")).getText();

       Assert.assertEquals(text, "Link has responded with staus 404 and status text Not Found");
        System.out.println("Mess:" + text);



    }

    public void getAllLinks() {
        driver.findElement(By.xpath("//span[contains(text(), 'Broken Links')]")).click();
        List<WebElement> elment = driver.findElements(By.tagName("a"));
        System.out.println(elment.size());
        for (int i = 1; i <= elment.size() - 1; i = i + 1) {
            System.out.println(elment.get(i).getText());
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
