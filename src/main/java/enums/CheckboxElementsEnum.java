package enums;

public enum CheckboxElementsEnum {
    WATER("Water"),
    EARTH("Earth"),
    WIND("Wind"),
    FIRE("Fire");

    public String element;

    CheckboxElementsEnum(String element) {
        this.element = element;
    }
}