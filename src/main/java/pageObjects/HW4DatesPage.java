package pageObjects;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.actions;

public class HW4DatesPage {

    @FindBy(css = ".uui-slider a:nth-child(1)")
    private SelenideElement leftSlider;

    @FindBy(css = ".uui-slider a:last-child")
    private SelenideElement rightSlider;

    @Step
    public void selectMaxSliderRange(int left, int right) {
        actions().dragAndDropBy(leftSlider, -300, 0).build().perform();
        actions().dragAndDropBy(rightSlider, -300, 0).build().perform();
        actions().dragAndDropBy(rightSlider, (int) (274.167 / 100 * right - 1.5), 0).build().perform();
        actions().dragAndDropBy(leftSlider, (int) (274.167 / 100 * left - 1.5), 0).build().perform();
        leftSlider.shouldHave(exactText(String.valueOf(left)));
        rightSlider.shouldHave(exactText(String.valueOf(right)));
    }
}