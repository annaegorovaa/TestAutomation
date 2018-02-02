package homework7;

import org.testng.annotations.Test;

import static pageObjects.JDISite.homePage;
import static pageObjects.JDISite.login;
import static pageObjects.JDISite.openMetalsColorsPage;

public class MetalColorFormSubmitTest extends TestInit {

    @Test
    public void metalColorSelectionTest() {

        //1 Login on JDI site as User
        homePage.open();
        login();
        homePage.checkOpened();

        //2 Open Metals & Colors page by Header menu
        openMetalsColorsPage();
    }
}
