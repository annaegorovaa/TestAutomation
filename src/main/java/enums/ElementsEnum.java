package enums;

public enum ElementsEnum {
    WATER("Water"),
    EARTH("Earth"),
    WIND("Wind"),
    FIRE("Fire");

    public String element;

    ElementsEnum(String element) {
        this.element = element;
    }
}