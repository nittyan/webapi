package nittyan.rakuten.book;

public enum Size {
    ALL("0"),
    INDEPENDENT("1"),
    PAPERBACK("2"),
    NEW("3"),
    COLLECTED("4"),
    DICTIONARY("5"),
    PICTORIAL("6"),
    PICTURE_STORY("7"),
    CD("8"),
    COMIC("9"),
    OTHER("10");

    private String size;
    private Size(String size) {
        this.size = size;
    }

    public String getName() {
        return this.size;
    }
}
