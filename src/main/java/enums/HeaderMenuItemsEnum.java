package enums;

public enum HeaderMenuItemsEnum {
    HOME("Home"),
    CONTACT_FORM("Contact form"),
    SERVICE("Service"),
    METALS_COLORS("Metals & Colors");

    public String item;

    HeaderMenuItemsEnum(String item){
        this.item = item;
    }

    @Override
    public String toString() {
        return item;
    }
}
