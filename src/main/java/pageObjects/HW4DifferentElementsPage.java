package pageObjects;

import com.codeborne.selenide.SelenideElement;
import enums.CheckboxElementsEnum;
import enums.ColorDropdownEnum;
import enums.MetalRadiosEnum;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

import static com.codeborne.selenide.Condition.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class HW4DifferentElementsPage {

    @FindBy(css = ".label-checkbox")
    private List<SelenideElement> checkboxes;

    @FindBy(css = ".label-radio")
    private List<SelenideElement> radios;

    @FindBy(css = "[value~='Button']")
    private List<SelenideElement> buttons;

    @FindBy(css = ".uui-pagination a[href^='page7']")
    private SelenideElement leftSection;

    @FindBy(css = ".uui-pagination a[href^='page2']")
    private SelenideElement rightSection;

    @FindBy(css = ".colors")
    private SelenideElement dropdown;

    @FindBy(css = ".colors option")
    private List<SelenideElement> colors;

    @FindBy(css = ".info-panel-body-log li")
    private List<SelenideElement> logEntries;

    @Step
    public void checkServicePageInterface() {
        assertEquals(checkboxes.size(), 4);
        assertEquals(radios.size(), 4);
        assertEquals(buttons.size(), 2);
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
        assertTrue(logEntries.get(index).getText().contains(property));
        assertTrue(logEntries.get(index).getText().contains(value));
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
