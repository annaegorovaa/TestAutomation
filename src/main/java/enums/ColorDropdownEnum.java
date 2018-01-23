package enums;

public enum ColorDropdownEnum {
    RED("Red"),
    GREEN("Green"),
    BLUE("Blue"),
    YELLOW("Yellow");

    public String color;

    ColorDropdownEnum(String color) {
        this.color = color;
    }
}