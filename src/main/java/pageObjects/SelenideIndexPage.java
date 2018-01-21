package pageObjects;

import com.codeborne.selenide.SelenideElement;
import enums.ServiceMenuItemsEnum;

import java.util.List;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SelenideIndexPage {

    public void login(String name, String password) {
        $(".uui-profile-menu .dropdown-toggle").click();
        $("#Login").sendKeys(name);
        $("#Password").sendKeys(password);
        $(".form-horizontal [type='submit']").click();
    }

    public void checkUserIsLoggedIn() {
        $(".uui-profile-menu span").shouldHave(text("PITER CHAILOVSKII"));
    }

    public void checkHomepageInterface() {
        $$(".benefit-icon").shouldHaveSize(4);
        $$(".benefit-txt").shouldHaveSize(4);
        $("div .main-title").shouldBe(visible);
        $("div .main-txt").shouldBe(visible);
    }

    public void checkHeaderServiceMenu(ServiceMenuItemsEnum[] items) {
        $(".dropdown a[href^='page1']").click();
        List<SelenideElement> menuItems = $$(".dropdown-menu>li").shouldHaveSize(items.length);
        for (int i = 0; i < items.length; i++) {
            menuItems.get(i).shouldHave(text(items[i].item.toUpperCase()));
        }
    }

    public void checkLeftServiceMenu(ServiceMenuItemsEnum[] items) {
        $(".sidebar-menu .sub-menu").click();
        List<SelenideElement> menuItems = $$(".sub>li").shouldHaveSize(items.length);
        for (int i = 0; i < items.length; i++) {
            menuItems.get(i).shouldHave(text(items[i].item));
        }
    }

    public void openDifferentElementPage() {
        $(".sub-menu a[href^='page8']").click();
    }

    public void checkServicePageInterface() {
        $$(".label-checkbox").shouldHaveSize(4);
        $$(".label-radio").shouldHaveSize(4);
        $$("[value~='Button']").shouldHaveSize(2);
        $(".uui-pagination a[href^='page7']").shouldBe(visible);
        $(".uui-pagination a[href^='page2']").shouldBe(visible);
    }

    public void selectWaterWindCheckboxes() {
        SelenideElement waterCheckbox = findCheckbox(0, "Water");
        waterCheckbox.find("input").click();
        waterCheckbox.find("input").shouldBe(checked);

        SelenideElement windCheckbox = findCheckbox(2, "Wind");
        windCheckbox.find("input").click();
        windCheckbox.find("input").shouldBe(checked);
    }

    public void selectRadio() {
        SelenideElement radio = $$(".label-radio").get(3);
        radio.shouldHave(text("Selen"));
        radio.find("input").click();
        radio.find("input").shouldBe(checked);
    }

    public void selectDropdown() {
        SelenideElement dropdown = $(".colors");
        dropdown.click();
        $$(".colors option").get(3).click();
        dropdown.shouldHave(text("Yellow"));
    }

    public void checkLog(int index, String property, String value) {
        checkLog(index, property + ": value changed to " + value);
    }

    public void checkLog(int index, String property, boolean value) {
        checkLog(index, property + ": condition changed to " + value);
    }

    private void checkLog(int index, String str) {
        List<SelenideElement> logEntries = $$(".info-panel-body-log li");
        logEntries.get(index).shouldHave(text(str));
    }

    public void removeWaterWindSelection() {
        SelenideElement waterCheckbox = findCheckbox(0, "Water");
        waterCheckbox.find("input").click();
        waterCheckbox.find("input").shouldNotBe(checked);

        SelenideElement windCheckbox = findCheckbox(2, "Wind");
        windCheckbox.find("input").click();
        windCheckbox.find("input").shouldNotBe(checked);
    }

    private SelenideElement findCheckbox(int index, String name) {
        SelenideElement checkbox = $$(".label-checkbox").get(index);
        checkbox.shouldHave(text(name));
        return checkbox;
    }
}