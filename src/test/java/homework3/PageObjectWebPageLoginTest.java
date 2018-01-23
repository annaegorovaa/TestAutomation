package homework3;

import enums.IndexPageTextsEnum;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.HW3IndexPage;

public class PageObjectWebPageLoginTest {

    private WebDriver driver;
    private HW3IndexPage indexPage;

    //Prepare Webdriver
    @BeforeClass
    public void setUpPages() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        indexPage = PageFactory.initElements(driver, HW3IndexPage.class);
    }

    // Close Browser
    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.close();
    }

    //Create a new test in a new Java class, specify test name in accordance with checking functionality
    @Test
    public void testWebPageLogin() {
        //1 Open test site by URL
        indexPage.open(driver);

        //2 Assert Browser title
        indexPage.checkPageTitle(driver);

        //3 Perform login
        indexPage.login("epam", "1234");

        //4 Assert User name in the left-top side of screen that user is loggined
        indexPage.checkUserIsLoggedIn();

        //5 Assert Browser title
        indexPage.checkPageTitle(driver);

        //6 Assert that there are 4 images on the Home Page and they are displayed
        indexPage.check4ImagesDisplayed();

        //7 Assert that there are 4 texts on the Home Page and check them by getting texts
        indexPage.checkTextsUnderImages(IndexPageTextsEnum.values());

        //8 Assert that there are the main header and the text below it on the Home Page
        indexPage.checkHomePageHeaderDisplayed();
        indexPage.checkHomePageMainTextDisplayed();
    }
}