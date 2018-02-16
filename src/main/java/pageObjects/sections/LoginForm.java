package pageObjects.sections;

import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.common.TextField;
import com.epam.jdi.uitests.web.selenium.elements.composite.Form;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JFindBy;
import entities.User;

public class LoginForm extends Form<User> {

    @JFindBy(id="Login")
    public TextField login;

    @JFindBy(id="Password")
    public TextField password;

    @JFindBy(css="[type=submit]")
    public Button enter;
}