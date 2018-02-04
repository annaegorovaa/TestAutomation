package enums;

public enum MetalsEnum {
    GOLD("Gold"),
    SILVER("Silver"),
    BRONZE("Bronze"),
    SELEN("Selen");

    public String metal;

    MetalsEnum(String metal) {
        this.metal = metal;
    }

    @Override
    public String toString() {
        return metal;
    }
}