package nittyan.rakuten.book.magazine;

import nittyan.rakuten.book.CommonCondition;
import nittyan.rakuten.book.Sort;

public class MagazineCondition extends CommonCondition {
    public int availability = 0;
    public String booksGenreId;
    public int carrier = 0;
    public int chirayomiFlag = 0;
    public String elements = "";
    public int genreInformationFlag;
    public int limitedFlag = 0;
    public long jan = Long.MIN_VALUE;
    public int hits = 30;
    public int outOfStockFlag = 0;
    public int page = 1;
    public String publisherName;
    public Sort sort = Sort.STANDARD;
    public String title;
}
