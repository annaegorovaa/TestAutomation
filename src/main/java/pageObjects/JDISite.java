package pageObjects;

import com.epam.jdi.uitests.web.selenium.elements.common.Label;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebSite;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JFindBy;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JSite;
import entities.User;
import enums.HeaderMenuItemsEnum;
import pageObjects.pages.HomePage;
import pageObjects.sections.HeaderMenu;
import pageObjects.sections.LoginForm;
import ru.yandex.qatools.allure.annotations.Step;

@JSite(domain = "https://epam.github.io/JDI")
public class JDISite extends WebSite {

    public static HomePage homePage;

    public static LoginForm loginForm;

    @JFindBy(css = "")
    public static HeaderMenu headerMenu;

    @JFindBy(css = ".profile-photo")
    public static Label profilePhoto;

    @Step
    public static void login() {
        profilePhoto.click();
        loginForm.loginAs(new User());
        homePage.checkUserName();
    }

    @Step
    public static void openMetalsColorsPage() {
        headerMenu.select(HeaderMenuItemsEnum.METALS_COLORS.item);
    }
}