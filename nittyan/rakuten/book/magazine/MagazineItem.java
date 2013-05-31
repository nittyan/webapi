package nittyan.rakuten.book.magazine;

import nittyan.rakuten.book.Keys;
import org.json.JSONObject;

public class MagazineItem {
    public int availability;
    public String affiliateUrl;
    public String booksGenreId;
    public String chirayomiUrl;
    public String cycle;
    public int discountPrice;
    public int discountRate;
    public String itemCaption;
    public int itemPrice;
    public String itemUrl;
    public long jan;
    public String largeImageUrl;
    public int limitedFlag;
    public int listPrice;
    public String mediumImageUrl;
    public int postageFlag;
    public String publisherName;
    public String reviewAverage;
    public int reviewCount;
    public String salesDate;
    public String smallImageUrl;
    public String title;
    public String titleKana;

    public MagazineItem() {
    }

    public MagazineItem(JSONObject json) {
        try {
            this.parseJSONObject(json);
        } catch(Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.toString());
        }
    }

    private void parseJSONObject(JSONObject object) throws Exception{
        this.affiliateUrl = object.getString(Keys.AFFILIATE_URL);
        this.availability = object.getInt(Keys.AVAILABILITY);
        this.chirayomiUrl = object.getString(Keys.CHIRAYOMI_URL);
        this.cycle = object.getString(Keys.CYCLE);
        this.discountPrice = object.getInt(Keys.DISCOUNT_PRICE);
        this.discountRate = object.getInt(Keys.DISCOUNT_RATE);
        this.itemCaption = object.getString(Keys.ITEM_CAPTION);
        this.itemPrice = object.getInt(Keys.ITEM_PRICE);
        this.itemUrl = object.getString(Keys.ITEM_URL);
        this.jan = object.getLong(Keys.JAN);
        this.limitedFlag = object.getInt(Keys.LIMITED_FLAG);
        this.listPrice = object.getInt(Keys.LIST_PRICE);
        this.postageFlag = object.getInt(Keys.POSTAGE_FLAG);
        this.publisherName = object.getString(Keys.PUBLISHER_NAME);
        this.largeImageUrl = object.getString(Keys.LARGE_IMAGE_URL);
        this.mediumImageUrl = object.getString(Keys.MEDIUM_IMAGE_URL);
        this.reviewAverage = object.getString(Keys.REVIEW_AVERAGE);
        this.reviewCount = object.getInt(Keys.REVIEW_COUNT);
        this.salesDate = object.getString(Keys.SALES_DATE);
        this.smallImageUrl = object.getString(Keys.SMALL_IMAGE_URL);
        this.title = object.getString(Keys.TITLE);
        this.titleKana = object.getString(Keys.TITLE_KANA);
    }
}
