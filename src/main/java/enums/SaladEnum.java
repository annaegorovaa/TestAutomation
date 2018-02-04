package enums;

public enum SaladEnum {
    CUCUMBER("Cucumber"),
    TOMATO("Tomato"),
    SALAD("Salad"),
    ONION("Onion");

    public String salad;

    SaladEnum(String salad) {
        this.salad = salad;
    }
}
