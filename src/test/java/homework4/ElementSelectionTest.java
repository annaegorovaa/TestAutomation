package homework4;

import base.SelenideTestBase;
import com.codeborne.selenide.Selenide;
import enums.CheckboxElementsEnum;
import enums.ColorDropdownEnum;
import enums.MetalRadiosEnum;
import enums.ServiceMenuItemsEnum;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.SelenideIndexPage;

import static com.codeborne.selenide.Selenide.close;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class ElementSelectionTest extends SelenideTestBase {

    private SelenideIndexPage indexPage = Selenide.page(SelenideIndexPage.class);

    @BeforeTest
    public void setUp() {
        getWebDriver();
    }

    @AfterTest
    public void tearDown() {
        close();
    }

    @Test
    public void testElementSelection() {

        //1 Open test site by URL
        indexPage.openURL();

        //2 Perform login
        indexPage.login("epam", "1234");

        //3 Assert User name in the left-top side of screen that user is loggined
        indexPage.checkUserIsLoggedIn();

        //4 Check interface on Home page, it contains all needed elements.
        indexPage.checkHomepageInterface();

        //5 Click on "Service" subcategory in the header and check that drop down contains options
        indexPage.checkHeaderServiceMenu(ServiceMenuItemsEnum.values());

        //6 Click on Service subcategory in the left section and check that drop down contains options
        indexPage.checkLeftServiceMenu(ServiceMenuItemsEnum.values());

        //7 Open through the header menu Service -> Different Elements Page
        indexPage.openDifferentElementPage();

        //8 Check interface on Service page, it contains all needed elements.
        indexPage.checkServicePageInterface();

        //9 Select and assert checkboxes
        indexPage.selectWaterWindCheckboxes();

        //10 Select radio
        indexPage.selectRadio();

        //11 Select in dropdown
        indexPage.selectDropdown();

        //12 Check in logs section selected values and status (true|false)
        indexPage.checkLog(0, "Colors", ColorDropdownEnum.YELLOW.color);
        indexPage.checkLog(1, "metal", MetalRadiosEnum.SELEN.metal);
        indexPage.checkLog(2, CheckboxElementsEnum.WIND.element, true);
        indexPage.checkLog(3, CheckboxElementsEnum.WATER.element, true);

        //13 Unselect and assert checkboxes
        indexPage.removeWaterWindSelection();

        //14 Check in logs section unselected values and status (true|false)
        indexPage.checkLog(0, CheckboxElementsEnum.WIND.element, false);
        indexPage.checkLog(1, CheckboxElementsEnum.WATER.element, false);
    }
}