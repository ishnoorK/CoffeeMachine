package domain;

public enum Beverage {
    HOT_TEA("hot tea"),
    HOT_COFFEE("hot coffee"),
    BLACK_TEA("black tea"),
    GREEN_TEA("green tea");

    private String displayName;

    Beverage(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}