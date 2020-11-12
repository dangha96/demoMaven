package RadioBtn;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import Common.Base;


public class test extends Base {

    radioPage radio;

    @BeforeMethod
    public void setUp() {

        radio = new radioPage (driver);
    }

    @Test
    public void verifyRadioBtn() {
        radio.clickRadioTab();
//        radio.checkToCheckBoxOrRadio();
        radio.clickRadioBtn();
    }
}
