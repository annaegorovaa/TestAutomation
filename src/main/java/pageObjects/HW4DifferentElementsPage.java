package pageObjects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import enums.CheckboxElementsEnum;
import enums.ColorDropdownEnum;
import enums.MetalRadiosEnum;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

import static com.codeborne.selenide.Condition.*;

public class HW4DifferentElementsPage {

    @FindBy(css = ".label-checkbox")
    private ElementsCollection checkboxes;

    @FindBy(css = ".label-radio")
    private ElementsCollection radios;

    @FindBy(css = "[value~='Button']")
    private ElementsCollection buttons;

    @FindBy(css = ".uui-pagination a[href^='page7']")
    private SelenideElement leftSection;

    @FindBy(css = ".uui-pagination a[href^='page2']")
    private SelenideElement rightSection;

    @FindBy(css = ".colors")
    private SelenideElement dropdown;

    @FindBy(css = ".colors option")
    private ElementsCollection colors;

    @FindBy(css = ".info-panel-body-log li")
    private List<SelenideElement> logEntries;

    @Step
    public void checkServicePageInterface() {
        checkboxes.shouldHaveSize(4);
        radios.shouldHaveSize(4);
        buttons.shouldHaveSize(2);
        leftSection.shouldBe(visible);
        rightSection.shouldBe(visible);
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
        SelenideElement selenRadio = radios.get(3);
        selenRadio.shouldHave(text(MetalRadiosEnum.SELEN.metal));
        selenRadio.find("input").click();
        selenRadio.find("input").shouldBe(checked);
    }

    @Step
    public void selectDropdown() {
        dropdown.click();
        colors.get(3).click();
        dropdown.shouldHave(text(ColorDropdownEnum.YELLOW.color));
    }

    @Step
    public void checkLog(int index, String property, String value) {
        logEntries.get(index).shouldHave(text(property));
        logEntries.get(index).shouldHave(text(value));
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
        SelenideElement checkbox = checkboxes.get(index);
        checkbox.shouldHave(text(element.element));
        return checkbox;
    }
}
