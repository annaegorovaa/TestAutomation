package homework2;

import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

public class DP4TextsTest extends TestBase {

    @DataProvider(parallel = true)
    public Object[][] dp() {
        return new Object[][] {
                {"To include good practices\n" +
                        "and ideas from successful\n" +
                        "EPAM projec"},
                {"To be flexible and\n" +
                        "customizable"},
                {"To be multiplatform"},
                {"Already have good base\n" +
                        "(about 20 internal and\n" +
                        "some external projects),\n" +
                        "wish to get more…"}
        };
    }

    @Test(dataProvider = "dp")
    public void assert4TextsUsingDPTest(String s) {
        List<WebElement> elements = driver.findElements(By.className("benefit-txt"));
        boolean textFound = false;
        for (WebElement element: elements) {
            if (element.getText().equals(s)) {
                textFound = true;
                break;
            }
        }
        Assert.assertTrue(textFound);
    }
}
