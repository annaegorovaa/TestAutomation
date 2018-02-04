package pageObjects.pages;

import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JFindBy;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JPage;
import pageObjects.sections.MetalsColorsForm;

@JPage(url = "/metals-colors.html")
public class MetalsColorsPage extends WebPage {

    @JFindBy(css = ".form")
    public MetalsColorsForm metalsColorsForm;
}
