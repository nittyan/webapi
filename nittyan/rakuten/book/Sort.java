package nittyan.rakuten.book;

public enum Sort {
    STANDARD("standard"),
    SALES("sales"),
    PLUS_RELEASE_DATE("+releaseDate"),
    MINOUS_RELEASE_DATE("-releaseDate"),
    PLUS_ITEM_PRICE("+itemPrice"),
    MINOUS_ITEM_PRICE("-itemPrice"),
    REVIEW_COUNT("reviewCount"),
    REVIEW_AVERAGE("reviewAverage");

    private String name;

    private Sort(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
