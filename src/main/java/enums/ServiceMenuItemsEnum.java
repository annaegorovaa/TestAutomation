package enums;

public enum ServiceMenuItemsEnum {
    ITEM_1("Support"),
    ITEM_2("Dates"),
    ITEM_3("Complex Table"),
    ITEM_4("Simple Table"),
    ITEM_5("Table With Pages"),
    ITEM_6("Different Elements");

    public String item;

    ServiceMenuItemsEnum(String item) {
        this.item = item;
    }
}
