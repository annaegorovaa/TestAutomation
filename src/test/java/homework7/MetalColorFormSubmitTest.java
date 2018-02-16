package homework7;

import entities.User;
import enums.HeaderMenuItemsEnum;
import org.testng.annotations.Test;

import static pageObjects.JDISite.*;

public class MetalColorFormSubmitTest extends TestInit {

    @Test
    public void metalColorSelectionTest() {

        //1 Login on JDI site as User
        homePage.open();
        login(new User());
        homePage.checkOpened();

        //2 Open Metals & Colors page by Header menu
//        openMetalsColorsPage();
        openPage(HeaderMenuItemsEnum.METALS_COLORS);

        //3 Fill form Metals & Colors by data below:
        //Summary: 3, 8
        //Elements: Water, Fire
        //Colors: Red
        //Metals: Selen
        //Vegetables: Cucumber,Tomato
        //Submit form Metals & Colors
        fillMetalsColorsForm();
    }
}
