package base;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class TestBase {

    private static final ThreadLocal<RemoteWebDriver> drivers = new ThreadLocal<>();

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        RemoteWebDriver driver = new ChromeDriver();
        driver.navigate().to("https://jdi-framework.github.io/tests/index.htm");
        drivers.set(driver);
    }

    @AfterMethod
    public void cleanupBrowser() {
        RemoteWebDriver driver = driver();
        driver.quit();
    }

    protected RemoteWebDriver driver() {
        RemoteWebDriver driver = drivers.get();
        if (driver == null) {
            throw new IllegalStateException("Driver should have not been null.");
        }
        return driver;
    }
}