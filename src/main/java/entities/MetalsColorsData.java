package entities;

import com.epam.commons.DataClass;
import enums.ColorsEnum;
import enums.ElementsEnum;
import enums.MetalsEnum;
import enums.SaladEnum;

public class MetalsColorsData extends DataClass {

    public int odd = 3;
    public int even = 8;

    public String elements = ElementsEnum.WATER.element + ", " + ElementsEnum.FIRE.element;

    public String colors = ColorsEnum.RED.color;

    public MetalsEnum metals = MetalsEnum.SELEN;

    public String[] salad = {SaladEnum.CUCUMBER.salad, SaladEnum.TOMATO.salad};
}
