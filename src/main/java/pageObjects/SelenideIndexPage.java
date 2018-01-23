package pageObjects;

import com.codeborne.selenide.SelenideElement;
import enums.CheckboxElementsEnum;
import enums.ColorDropdownEnum;
import enums.MetalRadiosEnum;
import enums.ServiceMenuItemsEnum;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class SelenideIndexPage {

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
    public void checkHomepageInterface() {
        $$(".benefit-icon").shouldHaveSize(4);
        $$(".benefit-txt").shouldHaveSize(4);
        $("div .main-title").shouldBe(visible);
        $("div .main-txt").shouldBe(visible);
    }

    @Step
    public void checkHeaderServiceMenu(ServiceMenuItemsEnum[] items) {
        $(".dropdown a[href^='page1']").click();
        List<SelenideElement> menuItems = $$(".dropdown-menu>li").shouldHaveSize(items.length);
        for (int i = 0; i < items.length; i++) {
            menuItems.get(i).shouldHave(text(items[i].item.toUpperCase()));
        }
    }

    @Step
    public void checkLeftServiceMenu(ServiceMenuItemsEnum[] items) {
        $(".sidebar-menu .sub-menu").click();
        List<SelenideElement> menuItems = $$(".sub>li").shouldHaveSize(items.length);
        for (int i = 0; i < items.length; i++) {
            menuItems.get(i).shouldHave(text(items[i].item));
        }
    }

    @Step
    public void openDifferentElementPage() {
        $(".sub-menu a[href^='page8']").click();
    }

    @Step
    public void checkServicePageInterface() {
        $$(".label-checkbox").shouldHaveSize(4);
        $$(".label-radio").shouldHaveSize(4);
        $$("[value~='Button']").shouldHaveSize(2);
        $(".uui-pagination a[href^='page7']").shouldBe(visible);
        $(".uui-pagination a[href^='page2']").shouldBe(visible);
    }

    @Step
    public void selectWaterWindCheckboxes() {
        SelenideElement waterCheckbox = findCheckbox(0, CheckboxElementsEnum.WATER);
        waterCheckbox.find("input").click();
        waterCheckbox.find("input").shouldBe(checked);

        SelenideElement windCheckbox = findCheckbox(2, CheckboxElementsEnum.WIND);
        windCheckbox.find("input").click();
        windCheckbox.find("input").shouldBe(checked);
    }

    @Step
    public void selectRadio() {
        SelenideElement radio = $$(".label-radio").get(3);
        radio.shouldHave(text(MetalRadiosEnum.SELEN.metal));
        radio.find("input").click();
        radio.find("input").shouldBe(checked);
    }

    @Step
    public void selectDropdown() {
        SelenideElement dropdown = $(".colors");
        dropdown.click();
        $$(".colors option").get(3).click();
        dropdown.shouldHave(text(ColorDropdownEnum.YELLOW.color));
    }

    public void checkLog(int index, String property, String value) {
        checkLog(index, property + ": value changed to " + value);
    }

    public void checkLog(int index, String property, boolean value) {
        checkLog(index, property + ": condition changed to " + value);
    }

    @Step
    private void checkLog(int index, String str) {
        List<SelenideElement> logEntries = $$(".info-panel-body-log li");
        logEntries.get(index).shouldHave(text(str));
    }

    @Step
    public void removeWaterWindSelection() {
        SelenideElement waterCheckbox = findCheckbox(0, CheckboxElementsEnum.WATER);
        waterCheckbox.find("input").click();
        waterCheckbox.find("input").shouldNotBe(checked);

        SelenideElement windCheckbox = findCheckbox(2, CheckboxElementsEnum.WIND);
        windCheckbox.find("input").click();
        windCheckbox.find("input").shouldNotBe(checked);
    }

    private SelenideElement findCheckbox(int index, CheckboxElementsEnum element) {
        SelenideElement checkbox = $$(".label-checkbox").get(index);
        checkbox.shouldHave(text(element.element));
        return checkbox;
    }
}