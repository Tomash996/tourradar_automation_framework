package constantVariables;

public enum SortingCategories {

    TOTAL_PRICE_L("Total price: Lowest first"),
    TOTAL_PRICE_H("Total price: Highest first"),
    DURATION_S("Duration: Shortest first"),
    DURATION_L("Duration: Longest first"),
    REVIEWS("Reviews: Most reviewed"),
    DEALS("Biggest Deals: Highest savings"),
    POPULARITY("Popularity: Most popular first"),
    PRICE_PER_DAY_L("Price/day: Lowest first"),
    PRICE_PER_DAY_H("Price/day: Highest first");

    public String categoryName;

    SortingCategories(String category) {
        this.categoryName = category;
    }
}
