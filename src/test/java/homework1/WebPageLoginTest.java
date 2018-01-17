package homework1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class WebPageLoginTest {

    private WebDriver driver;

    //Prepare Webdriver
    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    // Close Browser
    @AfterMethod
    public void tearDown() {
        driver.close();
    }

    //Create a new test in a new Java class, specify test name in accordance with checking functionality
    @Test
    public void testWebPageLogin() {
        //1 Open test site by URL
        driver.navigate().to("https://jdi-framework.github.io/tests");

        //2 Assert Browser title
        assertEquals(driver.getTitle(), "Index Page");

        //3 Perform login
        driver.findElement(By.xpath("//*[contains(@class, 'profile-menu')]")).click();
        driver.findElement(By.xpath("//*[@id='Login']")).sendKeys("epam");
        driver.findElement(By.xpath("//*[@id='Password']")).sendKeys("1234");
        driver.findElement(By.xpath("//*[contains(@type, 'submit')]")).click();

        //4 Assert User name in the left-top side of screen that user is loggined
        assertEquals(driver.findElement(By.xpath("//div//span[contains(., 'Piter Chailovskii')]")).getText(), "PITER CHAILOVSKII");

        //5 Assert Browser title
        assertEquals(driver.getTitle(), "Index Page");

        //6 Assert that there are 4 images on the Home Page and they are displayed
        List<WebElement> images = driver.findElements(By.xpath("//*[@class='benefit-icon']"));
        assertEquals(images.size(), 4);
        for (WebElement icon : images) {
            assertTrue(icon.isDisplayed());
        }

        //7 Assert that there are 4 texts on the Home Page and check them by getting texts
        List<WebElement> texts = driver.findElements(By.xpath("//*[@class='benefit-txt']"));
        assertEquals(texts.size(), 4);
        for (WebElement text : texts) {
            assertTrue(text.isDisplayed());
        }
        assertEquals(texts.get(0).getText().replaceAll("\n", " "),
                "To include good practices and ideas from successful EPAM projec");
        assertEquals(texts.get(1).getText().replaceAll("\n", " "),
                "To be flexible and customizable");
        assertEquals(texts.get(2).getText().replaceAll("\n", " "),
                "To be multiplatform");
        assertEquals(texts.get(3).getText().replaceAll("\n", " "),
                "Already have good base (about 20 internal and some external projects), wish to get more…");

        //8 Assert that there are the main header and the text below it on the Home Page
        assertTrue(driver.findElement(By.xpath("//h3[contains(@class, 'main-title')]")).isDisplayed());
        assertTrue(driver.findElement(By.xpath("//p[contains(@class, 'main-txt')]")).isDisplayed());
    }
}
