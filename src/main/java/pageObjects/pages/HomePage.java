package pageObjects.pages;

import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JPage;
import entities.User;
import org.openqa.selenium.support.FindBy;

import static org.testng.Assert.assertTrue;

@JPage(url = "/index.html", title = "Home Page")
public class HomePage extends WebPage {

    @FindBy(css = ".profile-photo span")
    public Button profile;

    public void checkUserName(User user) {
        assertTrue(profile.getText().equalsIgnoreCase(user.name));
    }
}