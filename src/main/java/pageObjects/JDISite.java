package pageObjects;

import com.epam.commons.DataClass;
import com.epam.jdi.uitests.web.selenium.elements.common.Label;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebSite;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JFindBy;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JSite;
import entities.MetalsColorsData;
import entities.User;
import enums.HeaderMenuItemsEnum;
import pageObjects.pages.HomePage;
import pageObjects.pages.MetalsColorsPage;
import pageObjects.sections.HeaderMenu;
import pageObjects.sections.LoginForm;
import ru.yandex.qatools.allure.annotations.Step;

@JSite("https://epam.github.io/JDI")
public class JDISite extends WebSite {

    public static HomePage homePage;
    public static MetalsColorsPage metalsColorsPage;

    public static LoginForm loginForm;

    @JFindBy(css = ".m-l8")
    public static HeaderMenu headerMenu;

    @JFindBy(css = ".profile-photo")
    public static Label profilePhoto;

    @Step
    public static void login(User user) {
        profilePhoto.click();
        loginForm.loginAs(user);
        homePage.checkUserName(user);
    }

    @Step
    public static void openPage(Enum page) {
        headerMenu.select(page.toString());
        metalsColorsPage.checkOpened();
    }

    @Step
    public static void fillMetalsColorsForm(){
        metalsColorsPage.metalsColorsForm.fill(new MetalsColorsData());
    }
}