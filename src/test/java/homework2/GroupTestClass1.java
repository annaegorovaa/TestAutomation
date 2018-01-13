package homework2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class GroupTestClass1 {

    @DataProvider
    public Object[][] dp() {
        return new Object[][]
                {
                        {1, "string1"},
                        {2, "string2"}
                };
    }

    @Test(dataProvider = "dp", groups = {"Smoke"})
    public void dpTest(int i, String s) {
        System.out.println("int: " + i + " String: " + s);
    }

    @Test(groups = {"Smoke"})
    public void simpleFirefoxTest() {
        WebDriver driver = new FirefoxDriver();
        driver.navigate().to("https://www.epam.com");
        driver.close();
    }
}
