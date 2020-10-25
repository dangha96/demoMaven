package calculator;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Random;

public class CalculatorTest extends BaseTest {
    int maxValue = 101;
    String a = String.valueOf(new Random().nextInt(maxValue));
    String b = String.valueOf(new Random().nextInt(maxValue));

    CalculatorPage cal;

    @BeforeMethod
    public void setup() {
        cal = new CalculatorPage(driver);
    }

    @Test
    public void plus() throws InterruptedException {
        cal.enterFirstTextBox(a);
        cal.enterSecondTextBox(b);
        cal.selectOperator("ADDITION");
        cal.clickBtnGo();
        String expectedResult = String.valueOf(Integer.parseInt(a) + Integer.parseInt(b));
        cal.compareResult(expectedResult);
        Thread.sleep(2000);
    }

    @Test
    public void division() {
//        CalculatorPage cal = new CalculatorPage(driver);
//        cal.enterFirstTextBox(a);
        System.out.println("a: " + a);
//        cal.enterSecondTextBox(b);
        System.out.println("b: " + b);
//        cal.selectOperator("DIVISION");
//        cal.clickBtnGo();
//        cal.getResult();
//        String expectedResult = String.valueOf((double) );
        System.out.println("expectedResult:" + Double.valueOf(a) / Double.valueOf(b));

//        cal.compareResult(expectedResult);
    }

    @Test
    public void testMultiplication() throws InterruptedException {
        CalculatorPage cal = new CalculatorPage(driver);
        cal.enterFirstTextBox(a);
        cal.enterSecondTextBox(b);
        cal.selectOperator("MULTIPLICATION");
        cal.clickBtnGo();
//        cal.getResult();
        cal.compareResult("3");
    }

}


