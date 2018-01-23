package homework4;

import base.SelenideTestBase;
import org.testng.annotations.Test;
import pageObjects.SelenideIndexPage2;

public class SliderSelectionTest extends SelenideTestBase {

    private SelenideIndexPage2 indexPage = new SelenideIndexPage2();

    @Test
    public void testSliderSelection() {

        //1 Open test site by URL
        indexPage.openURL();

        //2 Perform login
        indexPage.login("epam", "1234");

        //3 Assert User name in the left-top side of screen that user is loggined
        indexPage.checkUserIsLoggedIn();

        //4 Open Service -> Dates
        indexPage.selectDatesPage();

        //5 Using drag-and-drop set Range sliders. left - 0, right - 100
        indexPage.selectMaxSliderRange(0, 100);

        //6 Using drag-and-drop set Range sliders. left - 0, right - 0
        indexPage.selectMaxSliderRange(0, 0);

        //7 Using drag-and-drop set Range sliders. left - 100, right - 100
        indexPage.selectMaxSliderRange(100, 100);

        //8 Using drag-and-drop set Range sliders. left - 30, right - 70
        indexPage.selectMaxSliderRange(30, 70);
    }
}