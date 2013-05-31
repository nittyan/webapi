package nittyan.rakuten.book.book;

import nittyan.rakuten.book.Keys;
import org.json.JSONObject;

public class BookItem {

    public String affiliateUrl;
    public String author;
    public String authorKana;
    public int availability;
    public String booksGenreId;
    public String chirayomiUrl;
    public String contents;
    public int discountPrice;
    public int discountRate;
    public String isbn;
    public String itemCaption;
    public int itemPrice;
    public String itemUrl;
    public int postageFlag;
    public String publisherName;
    public String largeImageUrl;
    public int limitedFlag;
    public int listPrice;
    public String mediumImageUrl;
    public String reviewAverage;
    public int reviewCount;
    public String salesDate;
    public String seriesName;
    public String seriesNameKana;
    public String size = "";
    public String smallImageUrl;
    public String subTitle;
    public String subTitleKana;
    public String title;
    public String titleKana;
    // 0 is not sending information to server
    public int send = 0;

    public BookItem() {
    }

    public BookItem(JSONObject json) {
        try {
            this.parseJSONOjbect(json);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(json.toString());
        }
    }

    private void parseJSONOjbect(JSONObject object) throws Exception {
        this.affiliateUrl = object.getString(Keys.AFFILIATE_URL);
        this.author = object.getString(Keys.AUTHOR);
        this.authorKana = object.getString(Keys.AUTHOR_KANA);
        this.availability = object.getInt(Keys.AVAILABILITY);
        this.booksGenreId = object.getString(Keys.BOOKS_GENRE_ID);
        this.chirayomiUrl = object.getString(Keys.CHIRAYOMI_URL);
        this.contents = object.getString(Keys.CONTENTS);
        this.discountPrice = object.getInt(Keys.DISCOUNT_PRICE);
        this.discountRate = object.getInt(Keys.DISCOUNT_RATE);
        this.isbn = object.getString(Keys.ISBN);
        this.itemCaption = object.getString(Keys.ITEM_CAPTION);
        this.itemPrice = object.getInt(Keys.ITEM_PRICE);
        this.itemUrl = object.getString(Keys.ITEM_URL);
        this.postageFlag = object.getInt(Keys.POSTAGE_FLAG);
        this.publisherName = object.getString(Keys.PUBLISHER_NAME);
        this.largeImageUrl = object.getString(Keys.LARGE_IMAGE_URL);
        this.limitedFlag = object.getInt(Keys.LIMITED_FLAG);
        this.listPrice = object.getInt(Keys.LIST_PRICE);
        this.mediumImageUrl = object.getString(Keys.MEDIUM_IMAGE_URL);
        this.reviewAverage = object.getString(Keys.REVIEW_AVERAGE);
        this.reviewCount = object.getInt(Keys.REVIEW_COUNT);
        this.salesDate = object.getString(Keys.SALES_DATE);
        this.seriesName = object.getString(Keys.SERIES_NAME);
        this.seriesNameKana = object.getString(Keys.SERIES_NAME_KANA);
        this.size = object.getString(Keys.SIZE);
        this.smallImageUrl = object.getString(Keys.SMALL_IMAGE_URL);
        this.subTitle = object.getString(Keys.SUB_TITLE);
        this.subTitleKana = object.getString(Keys.SUB_TITLE_KANA);
        this.title = object.getString(Keys.TITLE);
        this.titleKana = object.getString(Keys.TITLE_KANA);
    }
}
