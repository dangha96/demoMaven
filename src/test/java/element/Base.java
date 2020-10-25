package element;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class Base {
    public static WebDriver driver;
    private static String PAGE_URL = "https://www.demoqa.com/text-box";
    public static JavascriptExecutor javascriptEx;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        javascriptEx = (JavascriptExecutor) driver;
        driver.manage().window().maximize();
        driver.get(PAGE_URL);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

    }

    @AfterClass
    public void quit() {
        driver.close();
    }
}
