package pageObjects;

import com.codeborne.selenide.SelenideElement;
import ru.yandex.qatools.allure.annotations.Step;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.actions;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.testng.Assert.assertEquals;

public class SelenideIndexPage2 {

    @Step
    public void openURL() {
        open("https://jdi-framework.github.io/tests");
    }

    @Step
    public void login(String name, String password) {
        $(".uui-profile-menu .dropdown-toggle").click();
        $("#Login").sendKeys(name);
        $("#Password").sendKeys(password);
        $(".form-horizontal [type='submit']").click();
    }

    @Step
    public void checkUserIsLoggedIn() {
        $(".uui-profile-menu span").shouldHave(text("PITER CHAILOVSKII"));
    }

    @Step
    public void selectDatesPage() {
        $(".dropdown a[href^='page1']").click();
        $("a[href^='page4']").click();
        assertEquals(getWebDriver().getTitle(), "Dates");
    }

    @Step
    public void selectMaxSliderRange(int left, int right) {
        SelenideElement slider = $(".uui-slider");
        SelenideElement leftSlider = slider.find("a:nth-child(1)");
        SelenideElement rightSlider = slider.find("a:last-child");
        actions().dragAndDropBy(leftSlider, -300, 0).build().perform();
        actions().dragAndDropBy(rightSlider, -300, 0).build().perform();
        actions().dragAndDropBy(rightSlider, (int) (274.167 / 100 * right - 1.5), 0).build().perform();
        actions().dragAndDropBy(leftSlider, (int) (274.167 / 100 * left - 1.5), 0).build().perform();
        leftSlider.shouldHave(exactText(String.valueOf(left)));
        rightSlider.shouldHave(exactText(String.valueOf(right)));
    }
}