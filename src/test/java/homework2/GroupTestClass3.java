package homework2;

import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GroupTestClass3 extends TestBase{

    @Test(groups = {"Smoke", "Regression"})
    public void headerTextDisplayedTest() {
        WebElement element = driver.findElement(By.cssSelector("body > div > div > main > div.main-content > h3"));
        Assert.assertTrue(element.isDisplayed());
    }

    @Test(groups = {"Smoke", "Regression"})
    public void mainTextDisplayedTest() {
        WebElement element = driver.findElement(By.cssSelector("body > div > div > main > div.main-content > p"));
        Assert.assertTrue(element.isDisplayed());
    }
}
