package nittyan.rakuten.book.magazine;

import android.util.Log;
import nittyan.rakuten.HttpRequest;
import nittyan.rakuten.book.Keys;
import nittyan.rakuten.book.RakutenSearcher;

/**
 * 雑誌検索用
 */
public class MagazineSearcher extends RakutenSearcher<MagazineSearchResult, MagazineCondition> {

    private static final String TAG = "MagazineSearcher";
    private static final String URL = "https://app.rakuten.co.jp/services/api/BooksMagazine/Search/20130522?";

    private HttpRequest request;

    public MagazineSearcher() {
        this.request = new HttpRequest();
    }

    public MagazineSearchResult search(MagazineCondition condition) {
        String url = this.createRequestParameter(condition);
        String response = this.request.doGet(url);
        Log.e(TAG, "response: " + response);
        MagazineSearchResult result = new MagazineSearchResult(response);

        return result;
    }

    public String createRequestParameter(MagazineCondition condition) {
        StringBuilder builder = new StringBuilder();
        super.appendCommonParameter(builder, condition);
        this.appendUniqueParameter(builder, condition);

        Log.i(TAG, "request parameter : " + builder.toString());
        return URL + builder.toString();
    }

    private StringBuilder appendUniqueParameter(StringBuilder builder, MagazineCondition condition) {
        if (!super.isNull(condition.title)) {
            super.appendParameter(builder, Keys.TITLE, condition.title);
        }
        if (!super.isNull(condition.publisherName)) {
            super.appendParameter(builder, Keys.PUBLISHER_NAME, condition.publisherName);
        }
        if (!super.isNull(condition.jan)) {
            super.appendParameter(builder, Keys.JAN, condition.jan);
        }
        if (!super.isNull(condition.booksGenreId)) {
            Log.e(TAG, "aaaaaaaaaaaaaaaaaaaaaaaaaaaa " + condition.booksGenreId);
            super.appendParameter(builder, Keys.BOOKS_GENRE_ID, condition.booksGenreId);
        }
        if (!super.isNull(condition.hits)) {
            super.appendParameter(builder, Keys.HITS, condition.hits);
        }
        if (!super.isNull(condition.page)) {
            super.appendParameter(builder, Keys.PAGE, condition.page);
        }
        if (!super.isNull(condition.availability)) {
            super.appendParameter(builder, Keys.AVAILABILITY, condition.availability);
        }
        if (!super.isNull(condition.outOfStockFlag)) {
            super.appendParameter(builder, Keys.OUT_OF_STOCK_FLAG, condition.outOfStockFlag);
        }
        if (!super.isNull(condition.chirayomiFlag)) {
            super.appendParameter(builder, Keys.CHIRAYOMI_FLAG, condition.chirayomiFlag);
        }
        if (!super.isNull(condition.sort)) {
            super.appendParameter(builder, Keys.SORT, condition.sort.getName());
        }
        if (!super.isNull(condition.limitedFlag)) {
            super.appendParameter(builder, Keys.LIMITED_FLAG, condition.limitedFlag);
        }
        if (!super.isNull(condition.carrier)) {
            super.appendParameter(builder, Keys.CARRIER, condition.carrier);
        }
        if (!super.isNull(condition.elements)) {
            super.appendParameter(builder, Keys.ELEMENTS, condition.elements);
        }
        if (!super.isNull(condition.genreInformationFlag)) {
            super.appendParameter(builder, Keys.GANRE_INFORMATION_FLAG, condition.genreInformationFlag);
        }
        return builder;
    }
}
