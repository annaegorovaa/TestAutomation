package homework4;

import base.SelenideTestBase;
import com.codeborne.selenide.Selenide;
import enums.*;
import org.testng.annotations.*;
import pageObjects.HW4DifferentElementsPage;
import pageObjects.HW4IndexPage;

import static com.codeborne.selenide.Selenide.close;
import static enums.ColorsEnum.YELLOW;
import static enums.MenuTypesEnum.COLORS;

public class ElementSelectionTest extends SelenideTestBase {

    private HW4IndexPage indexPage;
    private HW4DifferentElementsPage differentElementsPage;

    @BeforeClass
    public void setUpClass() {
        indexPage = Selenide.page(HW4IndexPage.class);
        differentElementsPage = Selenide.page(HW4DifferentElementsPage.class);
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        close();
    }

    @Test
    public void testElementSelection() {

        //1 Open test site by URL
        indexPage.open();

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
        differentElementsPage.checkServicePageInterface();

        //9 Select and assert checkboxes
        differentElementsPage.selectWaterWindCheckboxes();

        //10 Select radio
        differentElementsPage.selectRadio();

        //11 Select in dropdown
        differentElementsPage.selectDropdown();

        //12 Check in logs section selected values and status (true|false)
        differentElementsPage.checkLog(0, COLORS.menuType, YELLOW.color);
        differentElementsPage.checkLog(1, MenuTypesEnum.METAL.menuType, MetalsEnum.SELEN.metal);
        differentElementsPage.checkLog(2, ElementsEnum.WIND.element, BooleanValuesEnum.TRUE.booleanValue);
        differentElementsPage.checkLog(3, ElementsEnum.WATER.element, BooleanValuesEnum.TRUE.booleanValue);

        //13 Unselect and assert checkboxes
        differentElementsPage.removeWaterWindSelection();

        //14 Check in logs section unselected values and status (true|false)
        differentElementsPage.checkLog(0, ElementsEnum.WIND.element, BooleanValuesEnum.FALSE.booleanValue);
        differentElementsPage.checkLog(1, ElementsEnum.WATER.element, BooleanValuesEnum.FALSE.booleanValue);
    }
}