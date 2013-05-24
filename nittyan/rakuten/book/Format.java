package nittyan.rakuten.book;

public enum Format {
    JSON("json"),
    XML("xml"),
    JSONP("jsonp");

    private String name;

    private Format(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }

}
