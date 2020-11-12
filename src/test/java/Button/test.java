package Button;

import Common.Base;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class test extends Base {
    btnStep button;

    @BeforeMethod
    public void Setup() {
button= new btnStep(driver);

    }
    @Test
    public void verifyBtn(){
        button.clickTab();
        button.doubleClick();
        button.setRightClick();
    }
}