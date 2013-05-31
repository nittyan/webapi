package nittyan.rakuten.book.book;

import nittyan.rakuten.book.CommonResult;
import nittyan.rakuten.book.Keys;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class BookSearchResult extends CommonResult {

    public List<BookItem> bookItems;

    public BookSearchResult(String json) {
        try {
            JSONObject root = new JSONObject(json);
            super.parseRoot(root);
            this.bookItems = new ArrayList<BookItem>();
            if (0 < super.count) {
                JSONArray items = root.getJSONArray(Keys.ITEMS);
                this.parseItems(items);
            }
        } catch(JSONException e) {
            throw new RuntimeException(e);
        }
    }

    private void parseItems(JSONArray items) throws JSONException {
        for(int i = 0; i < items.length(); i++) {
            JSONObject item = (JSONObject)items.get(i);
            JSONObject content = item.getJSONObject(Keys.ITEM);
            this.bookItems.add(new BookItem(content));
        }
    }

}
