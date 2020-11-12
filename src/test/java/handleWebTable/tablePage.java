package handleWebTable;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import Common.Base;

import java.util.List;
import java.util.Random;

public class tablePage extends Base {
    WebDriver driver;
    String emailData, nameData,lastData, ageData, salData, departData;
    By addBtn = By.xpath("//button[@id='addNewRecordButton']");
    By firstName= By.cssSelector("#firstName");
    By lastName= By.cssSelector("#lastName");
    By email= By.cssSelector("#userEmail");
    By age= By.cssSelector("#age");
    By salary= By.cssSelector("#salary");
    By department= By.cssSelector("#department");
    By submitBtn= By.cssSelector("#submit");
    By actionBtn= By.cssSelector(".action-buttons");
    By row =By.xpath("//div[@class='rt-tr-group'][4]");
    By get1row= By.xpath("//div[@role='rowgroup'][4]//div[@class='rt-td'][1]"); // get text Ha

  public tablePage(WebDriver base){
      driver=base;
      driver= new ChromeDriver();
      driver.get("https://demoqa.com/webtables");
      //data input
      emailData ="autotest" + randomNum()+ "@gmail.com";
      nameData="ha";
      lastData="dang";
      ageData="20";
      salData= "100";
      departData="abc";
  }
public void inputData () {
    //input data
    sendKeyToElement(firstName, nameData);
    sendKeyToElement(lastName, lastData);
    sendKeyToElement(email, emailData);
    sendKeyToElement(age, ageData);
    sendKeyToElement(salary, salData);
    sendKeyToElement(department, departData);
}

public void verifyBtn() {
    //verify btn enable
    boolean subBtnPresence = find(submitBtn).isDisplayed();
    boolean subBtnEnable = find(submitBtn).isEnabled();
    if (subBtnPresence == true && subBtnEnable == true) {
        System.out.println("Button is enable and presence");
        WebElement subBtn = find(submitBtn);
        subBtn.click();
    }
}
public void countValue(){
    //count buttons
    List<WebElement> button= driver.findElements(actionBtn);
    System.out.println("Number of button"+ button.size());
    //print content of added row
    WebElement newRow= find(row);
    System.out.println("Value in table:\n"+ newRow.getText());
    // verify content
    Assert.assertEquals(find(get1row).getText(), nameData);

}
public int randomNum(){
    Random rand = new Random();
    // Obtain a number between [0 - 999].
    int number = rand.nextInt(1000);
    return number;
}
}
