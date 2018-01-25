package homework2;

import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import static org.testng.Assert.assertTrue;

public class GroupTestClass3 extends TestBase {

    private WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://jdi-framework.github.io/tests/index.htm");
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        driver.close();
    }

    @Test(groups = {"Smoke", "Regression"})
    public void headerTextDisplayedTest() {
        assertTrue(driver.findElement(By.xpath("//h3[contains(@class, 'main-title')]")).isDisplayed());
    }

    @Test(groups = {"Smoke", "Regression"})
    public void mainTextDisplayedTest() {
        assertTrue(driver.findElement(By.xpath("//p[contains(@class, 'main-txt')]")).isDisplayed());
    }
}