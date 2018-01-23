package enums;

public enum MetalRadiosEnum {
    GOLD("Gold"),
    SILVER("Silver"),
    BRONZE("Bronze"),
    SELEN("Selen");

    public String metal;

    MetalRadiosEnum(String metal) {
        this.metal = metal;
    }
}