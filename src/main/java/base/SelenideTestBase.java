package base;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeSuite;

public abstract class SelenideTestBase {

    @BeforeSuite
    public void setUpSuite() {
        Configuration.browser = "chrome";
        Configuration.startMaximized = true;
    }
}