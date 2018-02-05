package homework7;

import org.testng.annotations.Test;

import static pageObjects.JDISite.*;

public class MetalColorFormSubmitTest extends TestInit {

    // TODO you should not make a wrapper for the whole actions... without any reason
    // TODO I cant execute this, you have a dependency problems, i guess (JDI vs. Selenid)
    @Test
    public void metalColorSelectionTest() {

        //1 Login on JDI site as User
        homePage.open();
        // TODO this method should be parametrized by User instance,
        // TODO in is not make a sense to make a wrapper
        login();
        homePage.checkOpened();

        //2 Open Metals & Colors page by Header menu
        // TODO nope, you should elaborate method that can be used for opening any page !
        openMetalsColorsPage();

        //3 Fill form Metals & Colors by data below:
        //Summary: 3, 8
        //Elements: Water, Fire
        //Colors: Red
        //Metals: Selen
        //Vegetables: Cucumber,Tomato
        //Submit form Metals & Colors
        // TODO the same as 14-15
        // TODO for the example: Site.page.form.submit(entity)
        fillMetalsColorsForm();
    }
}
