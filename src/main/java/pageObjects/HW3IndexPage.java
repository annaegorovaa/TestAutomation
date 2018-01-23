package pageObjects;

import enums.IndexPageTextsEnum;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class HW3IndexPage {

    @FindBy(css = ".uui-profile-menu .dropdown-toggle")
    private WebElement loginFormButton;

    @FindBy(css = "#Login")
    private WebElement loginInput;

    @FindBy(css = "#Password")
    private WebElement passwordInput;

    @FindBy(css = ".form-horizontal [type='submit']")
    private WebElement submitButton;

    @FindBy(css = ".uui-profile-menu span")
    private WebElement userName;

    @FindBy(css = ".benefit-icon")
    private List<WebElement> benefitIcon;

    @FindBy(css = ".benefit-txt")
    private List<WebElement> benefitText;

    @FindBy(css = "div .main-title")
    private WebElement header;

    @FindBy(css = "div .main-txt")
    private WebElement mainText;

    public void open(WebDriver driver) {
        driver.navigate().to("https://jdi-framework.github.io/tests");
    }

    public void login(String name, String password) {
        loginFormButton.click();

        loginInput.sendKeys(name);
        passwordInput.sendKeys(password);
        submitButton.click();
    }

    public void checkPageTitle(WebDriver driver) {
        assertEquals(driver.getTitle(), "Index Page");
    }

    public void checkUserIsLoggedIn() {
        assertEquals(userName.getText(), "PITER CHAILOVSKII");
    }

    public void check4ImagesDisplayed() {
        assertEquals(benefitIcon.size(), 4);
        for (WebElement icon : benefitIcon) {
            assertTrue(icon.isDisplayed());
        }
    }

    public void checkTextsUnderImages(IndexPageTextsEnum[] texts) {
        assertEquals(benefitText.size(), texts.length);
        for (int i = 0; i < texts.length; i++) {
            assertEquals(benefitText.get(i).getText().replaceAll("\n", " "), texts[i].text);
        }
    }

    public void checkHomePageHeaderDisplayed() {
        assertTrue(header.isDisplayed());
    }

    public void checkHomePageMainTextDisplayed() {
        assertTrue(mainText.isDisplayed());
    }
}