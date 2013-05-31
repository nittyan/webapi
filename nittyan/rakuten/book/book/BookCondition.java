package nittyan.rakuten.book.book;

import nittyan.rakuten.book.CommonCondition;
import nittyan.rakuten.book.Size;
import nittyan.rakuten.book.Sort;

public class BookCondition extends CommonCondition {
    public int availability = 0;
    public String author;
    public String booksGenreId;
    public int carrier = 0;
    public int chirayomiFlag = 0;
//    public String elements = "ALL";
    public String elements = "";
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
