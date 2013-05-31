package nittyan.rakuten.book.book;

import android.util.Log;
import nittyan.rakuten.HttpRequest;
import nittyan.rakuten.book.Keys;
import nittyan.rakuten.book.RakutenSearcher;

/**
 * 書籍検索用
 */
public class BookSearcher extends RakutenSearcher<BookSearchResult, BookCondition> {

    private static final String TAG = "BookSearcher";
    private static final String URL = "https://app.rakuten.co.jp/services/api/BooksBook/Search/20121128?";

    private HttpRequest request;

    public BookSearcher() {
        this.request = new HttpRequest();
    }

    public BookSearchResult search(BookCondition condition) {
        String url = this.createRequestUrl(condition);
        String response = this.request.doGet(url);

        BookSearchResult result = new BookSearchResult(response);
//        Log.e(TAG, "result: " + result.count);
//        for (BookItem item: result.bookItems) {
//            Log.e(TAG, item.title);
//        }

        return result;
    }

    private String createRequestUrl(BookCondition condition) {
        StringBuilder builder = new StringBuilder();
        super.appendCommonParameter(builder, condition);
        this.appendUniqueParameter(builder, condition);

        Log.i(TAG, "before encode = " + builder.toString());
        return URL + builder.toString();
    }

    private StringBuilder appendUniqueParameter(StringBuilder builder, BookCondition condition) {
        if (!super.isNull(condition.availability)) {
            super.appendParameter(builder, Keys.AVAILABILITY, condition.availability);
        }
        if (!super.isNull(condition.author)) {
            super.appendParameter(builder, Keys.AUTHOR, condition.author);
        }
        if (!super.isNull(condition.booksGenreId)) {
            super.appendParameter(builder, Keys.BOOKS_GENRE_ID, condition.booksGenreId);
        }
        if (!super.isNull(condition.carrier)) {
            super.appendParameter(builder, Keys.CARRIER, condition.carrier);
        }
        if (!super.isNull(condition.chirayomiFlag)) {
            super.appendParameter(builder, Keys.CHIRAYOMI_FLAG, condition.chirayomiFlag);
        }
        if (!super.isNull(condition.elements)) {
            super.appendParameter(builder, Keys.ELEMENTS, condition.elements);
        }
        if (!super.isNull(condition.hits)) {
            super.appendParameter(builder, Keys.HITS, condition.hits);
        }
        if (!super.isNull(condition.isbn)) {
            super.appendParameter(builder, Keys.ISBN, condition.isbn);
        }
        if (!super.isNull(condition.limitedFlag)) {
            super.appendParameter(builder, Keys.LIMITED_FLAG, condition.limitedFlag);
        }
        if (!super.isNull(condition.outOfStockFlag)) {
            super.appendParameter(builder, Keys.OUT_OF_STOCK_FLAG, condition.outOfStockFlag);
        }
        if (!super.isNull(condition.page)) {
            super.appendParameter(builder, Keys.PAGE, condition.page);
        }
        if (!super.isNull(condition.publisherName)) {
            super.appendParameter(builder, Keys.PUBLISHER_NAME, condition.publisherName);
        }
        if (!super.isNull(condition.size)) {
            super.appendParameter(builder, Keys.SIZE, condition.size.getName());
        }
        if (!super.isNull(condition.sort)) {
            super.appendParameter(builder, Keys.SORT, condition.sort.getName());
        }
        if (!super.isNull(condition.title)) {
            super.appendParameter(builder, Keys.TITLE, condition.title);
        }
        return builder;
    }

}
