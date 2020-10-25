package element;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ElementTest extends Base {
    Page pa;

    @BeforeMethod
    public void setup() {

        pa = new Page(driver);
    }

    @Test
    public void TextBox() throws InterruptedException {
        pa.EnterFullName();
        pa.EnterEmail();
        pa.EnterCurrentAdd();
        pa.EnterPerAdd();
        Thread.sleep(2000);
        pa.ClickBtnSubmit();
    }

    @Test
    public void RadioBtn() {
        pa.ClickRadioTab();
        pa.RadioButton();

    }

    @Test
    public void CheckBox() {
        pa.ClickCheckBoxTab();
        pa.CheckBox();

    }

}
