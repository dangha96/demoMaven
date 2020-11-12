package handleWebTable;

import org.openqa.selenium.WebDriver;
import Common.Base;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class test extends Base {
    tablePage table;
    @BeforeMethod
    public void setUp(){
        table=new tablePage(driver);
    }
    @Test
    public void verifyTable(){
        table.inputData();
        table.verifyBtn();
        table.countValue();

    }

}
