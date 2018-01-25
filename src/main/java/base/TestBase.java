package base;

import org.testng.annotations.BeforeSuite;

import static java.lang.System.setProperty;

public abstract class TestBase {

    @BeforeSuite
    public void setUp() {
        setProperty("webdriver.chrome.driver", "chromedriver.exe");
    }
}