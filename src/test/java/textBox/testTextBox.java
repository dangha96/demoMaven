package textBox;


import Common.Base;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class testTextBox extends Base {
     textBox textBoxPage;
    @BeforeMethod
    public void setUp(){
        textBoxPage= new textBox(driver);
    }
    @Test
    public void verifyTextBox() {
        textBoxPage.inputUserName();
        textBoxPage.inputEmail();
        textBoxPage.inputFullName();
        textBoxPage.inputCurrentAdd();
        textBoxPage.inputPermanentAdd();
        textBoxPage.clickBtn();
        textBoxPage.getText();
    }


}
