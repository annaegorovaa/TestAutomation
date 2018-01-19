package homework2;

import base.TestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class GroupTestClass3 extends TestBase {

    @Test(groups = {"Smoke", "Regression"})
    public void headerTextDisplayedTest() {
        assertTrue(driver.findElement(By.xpath("//h3[contains(@class, 'main-title')]")).isDisplayed());
    }

    @Test(groups = {"Smoke", "Regression"})
    public void mainTextDisplayedTest() {
        assertTrue(driver.findElement(By.xpath("//p[contains(@class, 'main-txt')]")).isDisplayed());
    }
}