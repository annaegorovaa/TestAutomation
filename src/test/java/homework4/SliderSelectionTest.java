package homework4;

import base.SelenideTestBase;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.*;
import pageObjects.HW4DatesPage;
import pageObjects.HW4IndexPage;

import static com.codeborne.selenide.Selenide.close;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class SliderSelectionTest extends SelenideTestBase {

    private HW4IndexPage indexPage;
    private HW4DatesPage datesPage;

    @BeforeClass
    public void setUpClass() {
        getWebDriver();
        indexPage = Selenide.page(HW4IndexPage.class);
        datesPage = Selenide.page(HW4DatesPage.class);
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        close();
    }

    @Test
    public void testSliderSelection() {

        //1 Open test site by URL
        indexPage.open();

        //2 Perform login
        indexPage.login("epam", "1234");

        //3 Assert User name in the left-top side of screen that user is loggined
        indexPage.checkUserIsLoggedIn();

        //4 Open Service -> Dates
        indexPage.selectDatesPage();

        //5 Using drag-and-drop set Range sliders. left - 0, right - 100
        datesPage.selectMaxSliderRange(0, 100);

        //6 Using drag-and-drop set Range sliders. left - 0, right - 0
        datesPage.selectMaxSliderRange(0, 0);

        //7 Using drag-and-drop set Range sliders. left - 100, right - 100
        datesPage.selectMaxSliderRange(100, 100);

        //8 Using drag-and-drop set Range sliders. left - 30, right - 70
        datesPage.selectMaxSliderRange(30, 70);
    }
}