package domain;

public enum Ingredient {
    HOT_WATER ("hot water"),
    HOT_MILK("hot milk"),
    GINGER_SYRUP("ginger syrup"),
    SUGAR_SYRUP("sugar syrup"),
    TEA_LEAVES_SYRUP("tea leaves syrup"),
    GREEN_MIXTURE("green mixture");

    private String displayName;

    Ingredient(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
