package pageObjects.sections;

import com.epam.jdi.uitests.web.selenium.elements.common.TextField;
import com.epam.jdi.uitests.web.selenium.elements.complex.CheckList;
import com.epam.jdi.uitests.web.selenium.elements.complex.DropList;
import com.epam.jdi.uitests.web.selenium.elements.complex.Dropdown;
import com.epam.jdi.uitests.web.selenium.elements.complex.RadioButtons;
import com.epam.jdi.uitests.web.selenium.elements.composite.Form;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JFindBy;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.objects.JDropList;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.objects.JDropdown;
import entities.MetalsColorsData;
import enums.ColorsEnum;
import enums.ElementsEnum;
import enums.SaladEnum;

public class MetalsColorsForm extends Form<MetalsColorsData> {

    @JFindBy(css = "#odds-selector .radio")
    public RadioButtons odd;

    @JFindBy(css = "#even-selector .radio")
    public RadioButtons even;

    @JFindBy(css = "#elements-checklist .checkbox")
    public CheckList<ElementsEnum> elements;

    @JDropdown(
            jroot = @JFindBy(css = ".colors"),
            jexpand = @JFindBy(title = "Colors"),
            jlist = @JFindBy(tagName = "li"))
    public Dropdown<ColorsEnum> colors;

    @JFindBy(css = ".metals input")
    private TextField metals;

    @JDropList(
            jroot = @JFindBy(id = "salad-dropdown"),
            jvalue = @JFindBy(tagName = "button"),
            jlist = @JFindBy(tagName = "li"))
    public DropList<SaladEnum> salad;
}
