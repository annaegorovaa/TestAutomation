package homework2;

import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class DP4TextsTest extends TestBase {

    private WebDriver driver;

    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://jdi-framework.github.io/tests/index.htm");
    }

    @AfterTest
    public void tearDown() {
        driver.close();
    }

    @DataProvider(parallel = true)
    public Object[][] dp() {
        return new Object[][]{
                {0, "To include good practices and ideas from successful EPAM projec"},
                {1, "To be flexible and customizable"},
                {2, "To be multiplatform"},
                {3, "Already have good base (about 20 internal and some external projects), wish to get more…"},
        };
    }

    @Test(dataProvider = "dp")
    public void assert4TextsUsingDPTest(int index, String text) {
        List<WebElement> elements = driver.findElements(By.xpath("//*[@class='benefit-txt']"));
        assertEquals(elements.get(index).getText().replaceAll("\n", " "), text);
    }
}