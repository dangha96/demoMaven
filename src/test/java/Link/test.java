package Link;

import Button.btnStep;
import Common.Base;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class test extends Base {
    linkStep link;

    @BeforeMethod
    public void Setup() {
        link = new linkStep(driver);

    }

    @Test
    public void verifyLink() {
        link.getLinkWithText();
        link.getAllLink();
    }
}