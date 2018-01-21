package homework4;

import base.SelenideTestBase;
import org.testng.annotations.Test;
import pageObjects.SelenideIndexPage2;

import static com.codeborne.selenide.Selenide.open;

public class SliderSelectionTest extends SelenideTestBase {

    private SelenideIndexPage2 indexPage = new SelenideIndexPage2();

    @Test
    public void testSliderSelection() {
        open("https://jdi-framework.github.io/tests");
        indexPage.login("epam", "1234");
        indexPage.checkUserIsLoggedIn();
        indexPage.selectDatesPage();
        indexPage.selectMaxSliderRange(0, 100);
        indexPage.selectMaxSliderRange(0, 0);
        indexPage.selectMaxSliderRange(100, 100);
        indexPage.selectMaxSliderRange(30, 70);
    }
}