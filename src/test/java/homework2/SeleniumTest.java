package homework2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import static java.lang.System.setProperty;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class SeleniumTest {

    private WebDriver driver;

    @BeforeSuite
    public void setUpBeforeSuite() {
        setProperty("webdriver.chrome.driver", "chromedriver.exe");
    }

    @BeforeTest
    public void setUpBeforeTest() {
        driver = new ChromeDriver();
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println(System.currentTimeMillis());
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println(driver.getTitle());
    }

    @AfterTest
    public void tearDownAfterTest() {
        driver.close();
    }

    @AfterSuite
    public void tearDownAfterSuite() {
        if (driver.toString().contains("null")) {
            driver.quit();
        }
    }

    @Test
    public void simpleTest() {
        driver.manage().window().maximize();

        driver.navigate().to("https://www.epam.com");
        assertEquals(driver.getTitle(), "EPAM | Software Product Development Services");

        driver.findElement(By.xpath("//button[contains(@class, 'header-search')]")).click();

        WebElement menuButton = driver.findElement(By.xpath("//button[contains(@class, 'hamburger-menu')]"));
        assertTrue(menuButton.isDisplayed());
        assertEquals(menuButton.getText(), "MENU");
    }
}