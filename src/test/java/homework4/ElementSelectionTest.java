package homework4;

import base.SelenideTestBase;
import enums.ServiceMenuItemsEnum;
import org.testng.annotations.Test;
import pageObjects.SelenideIndexPage;

import static com.codeborne.selenide.Selenide.open;

public class ElementSelectionTest extends SelenideTestBase {

    private SelenideIndexPage indexPage = new SelenideIndexPage();

    @Test
    public void testElementSelection() {
        open("https://jdi-framework.github.io/tests");
        indexPage.login("epam", "1234");
        indexPage.checkUserIsLoggedIn();
        indexPage.checkHomepageInterface();
        indexPage.checkHeaderServiceMenu(ServiceMenuItemsEnum.values());
        indexPage.checkLeftServiceMenu(ServiceMenuItemsEnum.values());
        indexPage.openDifferentElementPage();
        indexPage.checkServicePageInterface();
        indexPage.selectWaterWindCheckboxes();
        indexPage.selectRadio();
        indexPage.selectDropdown();
        indexPage.checkLog(0, "Colors", "Yellow");
        indexPage.checkLog(1, "metal", "Selen");
        indexPage.checkLog(2, "Wind", true);
        indexPage.checkLog(3, "Water", true);
        indexPage.removeWaterWindSelection();
        indexPage.checkLog(0, "Wind", false);
        indexPage.checkLog(1, "Water", false);
    }
}