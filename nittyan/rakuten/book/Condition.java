package nittyan.rakuten.book;

public class Condition implements nittyan.search.Condition {
    public String affiliateId;
    public String applicationId;
    public int availability = 0;
    public String author;
    public String booksGenreId;
    public String callback;
    public int carrier = 0;
    public int chirayomiFlag = 0;
//    public String elements = "ALL";
    public String elements = "";
    public Format format = Format.JSON;
    public int hits = 30;
    public String isbn;
    public int limitedFlag = 0;
    public int outOfStockFlag = 0;
    public int page = 1;
    public String publisherName;
    public Size size = Size.ALL;
    public Sort sort = Sort.STANDARD;
    public String title;
}
