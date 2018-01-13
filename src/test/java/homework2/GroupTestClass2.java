package homework2;

import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class GroupTestClass2 extends TestBase{

    @Test(groups = {"Regression"})
    public void assertTitleTest() {
        Assert.assertEquals(driver.getTitle(), "Index Page");
    }

    @Test(groups = {"Regression"})
    public void assertImagesDisplayedTest() {
        List<WebElement> images = driver.findElements(By.className("benefit-icon"));
        Assert.assertEquals(images.size(), 4);
        for (WebElement icon: images) {
            Assert.assertTrue(icon.isDisplayed());
        }
    }

    @Test(groups = {"Regression"})
    public void assert4ElementsTest() {
        List<WebElement> texts = driver.findElements(By.className("benefit-txt"));
        Assert.assertEquals(texts.size(), 4);
    }
}
