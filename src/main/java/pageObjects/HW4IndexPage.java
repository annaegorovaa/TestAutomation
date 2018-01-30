package pageObjects;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import enums.ServiceMenuItemsEnum;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static org.testng.Assert.assertEquals;

public class HW4IndexPage {

    @FindBy(css = ".uui-profile-menu .dropdown-toggle")
    private SelenideElement loginFormButton;

    @FindBy(css = "#Login")
    private SelenideElement loginInput;

    @FindBy(css = "#Password")
    private SelenideElement passwordInput;

    @FindBy(css = ".form-horizontal [type='submit']")
    private SelenideElement submitButton;

    @FindBy(css = ".profile-photo span")
    private SelenideElement userName;

    @FindBy(css = ".benefit-icon")
    private List<SelenideElement> benefitIcons;

    @FindBy(css = ".benefit-txt")
    private List<SelenideElement> benefitTexts;

    @FindBy(css = "div .main-title")
    private SelenideElement header;

    @FindBy(css = "div .main-txt")
    private SelenideElement mainText;

    @FindBy(css = ".dropdown a[href^='page1']")
    private SelenideElement headerServiceMenu;

    @FindBy(css = ".dropdown-menu>li")
    private List<SelenideElement> headerServiceMenuItems;

    @FindBy(css = ".sidebar-menu .sub-menu")
    private SelenideElement leftServiceMenu;

    @FindBy(css = ".sub>li")
    private List<SelenideElement> leftServiceMenuItems;

    @FindBy(css = ".sub-menu a[href^='page8']")
    private SelenideElement differentElementsMenuItem;

    @FindBy(css = "a[href^='page4']")
    private SelenideElement datesMenuItem;

    @Step
    public void open() {
        Selenide.open("https://jdi-framework.github.io/tests");
    }

    @Step
    public void login(String name, String password) {
        loginFormButton.click();
        loginInput.sendKeys(name);
        passwordInput.sendKeys(password);
        submitButton.click();
    }

    @Step
    public void checkUserIsLoggedIn() {
        userName.shouldHave(text("PITER CHAILOVSKII"));
    }

    @Step
    public void checkHomepageInterface() {
        assertEquals(benefitIcons.size(), 4);
        assertEquals(benefitTexts.size(), 4);
        header.shouldBe(visible);
        mainText.shouldBe(visible);
    }

    @Step
    public void checkHeaderServiceMenu(ServiceMenuItemsEnum[] items) {
        headerServiceMenu.click();
        assertEquals(headerServiceMenuItems.size(), items.length);
        for (int i = 0; i < items.length; i++) {
            headerServiceMenuItems.get(i).shouldHave(text(items[i].item.toUpperCase()));
        }
    }

    @Step
    public void checkLeftServiceMenu(ServiceMenuItemsEnum[] items) {
        leftServiceMenu.click();
        assertEquals(leftServiceMenuItems.size(), items.length);
        for (int i = 0; i < items.length; i++) {
            leftServiceMenuItems.get(i).shouldHave(text(items[i].item));
        }
    }

    @Step
    public void openDifferentElementPage() {
        differentElementsMenuItem.click();
    }

    @Step
    public void selectDatesPage() {
        headerServiceMenu.click();
        datesMenuItem.click();
    }
}