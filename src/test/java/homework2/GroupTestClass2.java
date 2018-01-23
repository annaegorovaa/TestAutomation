package homework2;

import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class GroupTestClass2 extends TestBase {

    @Test(groups = {"Regression"})
    public void assertTitleTest() {
        assertEquals(driver().getTitle(), "Index Page");
    }

    @Test(groups = {"Regression"})
    public void assertImagesDisplayedTest() {
        List<WebElement> images = driver().findElements(By.xpath("//*[@class='benefit-icon']"));
        assertEquals(images.size(), 4);
        for (WebElement icon : images) {
            assertTrue(icon.isDisplayed());
        }
    }

    @Test(groups = {"Regression"})
    public void assert4ElementsTest() {
        List<WebElement> texts = driver().findElements(By.xpath("//*[@class='benefit-txt']"));
        assertEquals(texts.size(), 4);
    }
}