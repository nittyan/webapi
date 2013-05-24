package nittyan.rakuten.book;

import android.util.Log;
import nittyan.rakuten.HttpRequest;
import nittyan.search.Searcher;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class RakutenSearcher implements Searcher<BookSearchResult, Condition> {

    private static final String TAG = "RakutenSearcher";
    private static final String URL = "https://app.rakuten.co.jp/services/api/BooksBook/Search/20121128?";

    private HttpRequest request;

    public RakutenSearcher() {
        this.request = new HttpRequest();
    }

    public BookSearchResult search(Condition condition) {
        String url = this.createRequestUrl(condition);
        String response = this.request.doGet(url);

        BookSearchResult result = new BookSearchResult(response);
//        Log.e(TAG, "result: " + result.count);
//        for (Item item: result.items) {
//            Log.e(TAG, item.title);
//        }

        return result;
    }

    private String createRequestUrl(Condition condition) {
        StringBuilder builder = new StringBuilder();
        this.appendCommonParameter(builder, condition);
        this.appendUniqueParameter(builder, condition);

        Log.i(TAG, "before encode = " + builder.toString());
        return URL + builder.toString();
    }

    private StringBuilder appendCommonParameter(StringBuilder builder, Condition condition) {
        if (this.isNull(condition.applicationId)) {
            throw new RuntimeException("No applicationId");
        }
        this.appendParameter(builder, Keys.APPLICATION_ID, condition.applicationId);
        if(!this.isNull(condition.affiliateId)) {
            this.appendParameter(builder, Keys.AFFILIATE_ID, condition.affiliateId);
        }
        if (!this.isNull(condition.format)) {
            this.appendParameter(builder, Keys.FORMAT, condition.format.toString());
        }
        if(!this.isNull(condition.callback)) {
            this.appendParameter(builder, Keys.CALLBACK, condition.callback);
        }
        return builder;
    }

    private StringBuilder appendUniqueParameter(StringBuilder builder, Condition condition) {
        if (!this.isNull(condition.availability)) {
            this.appendParameter(builder, Keys.AVAILABILITY, condition.availability);
        }
        if (!this.isNull(condition.author)) {
            this.appendParameter(builder, Keys.AUTHOR, condition.author);
        }
        if (!this.isNull(condition.booksGenreId)) {
            this.appendParameter(builder, Keys.BOOKS_GENRE_ID, condition.booksGenreId);
        }
        if (!this.isNull(condition.carrier)) {
            this.appendParameter(builder, Keys.CARRIER, condition.carrier);
        }
        if (!this.isNull(condition.chirayomiFlag)) {
            this.appendParameter(builder, Keys.CHIRAYOMI_FLAG, condition.chirayomiFlag);
        }
        if (!this.isNull(condition.elements)) {
            this.appendParameter(builder, Keys.ELEMENTS, condition.elements);
        }
        if (!this.isNull(condition.hits)) {
            this.appendParameter(builder, Keys.HITS, condition.hits);
        }
        if (!this.isNull(condition.isbn)) {
            this.appendParameter(builder, Keys.ISBN, condition.isbn);
        }
        if (!this.isNull(condition.limitedFlag)) {
            this.appendParameter(builder, Keys.LIMITED_FLAG, condition.limitedFlag);
        }
        if (!this.isNull(condition.outOfStockFlag)) {
            this.appendParameter(builder, Keys.OUT_OF_STOCK_FLAG, condition.outOfStockFlag);
        }
        if (!this.isNull(condition.page)) {
            this.appendParameter(builder, Keys.PAGE, condition.page);
        }
        if (!this.isNull(condition.publisherName)) {
            this.appendParameter(builder, Keys.PUBLISHER_NAME, condition.publisherName);
        }
        if (!this.isNull(condition.size)) {
            this.appendParameter(builder, Keys.SIZE, condition.size.toString());
        }
        if (!this.isNull(condition.sort)) {
            this.appendParameter(builder, Keys.SORT, condition.sort.toString());
        }
        if (!this.isNull(condition.title)) {
            this.appendParameter(builder, Keys.TITLE, condition.title);
        }
        return builder;
    }

    private StringBuilder appendParameter(StringBuilder builder, String key, String value) {
        builder.append(key);
        builder.append("=");
        builder.append(this.urlEncode(value));
        builder.append("&");
        return  builder;
    }

    private StringBuilder appendParameter(StringBuilder builder, String key, int value) {
        builder.append(key);
        builder.append("=");
        builder.append(value);
        builder.append("&");
        return  builder;
    }

    private boolean isNull(String str) {
        if (null == str) return true;
        if (str.length() == 0) return true;
        return false;
    }

    private boolean isNull(int n) {
        return Integer.MIN_VALUE == n;
    }

    private boolean isNull(Enum n) {
        return null == n;
    }

    private String urlEncode(String parameter) {
        String encoded = "";
        try {
            encoded = URLEncoder.encode(parameter, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            Log.e(TAG, e.getMessage());
            return "";
        }
        return encoded;
    }

}
