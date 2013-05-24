package nittyan.rakuten.book;

import android.util.Log;
import nittyan.search.Result;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class BookSearchResult implements Result {
    public int count;
    public int page;
    public int first;
    public int last;
    public int hits;
    public int carrier;
    public int pageCount;
    public List<Item> items;

    public BookSearchResult(String json) {
        try {
            JSONObject root = new JSONObject(json);
            this.parseRoot(root);
            this.items = new ArrayList<Item>();
            if (this.count > 0) {
                JSONArray items = root.getJSONArray(Keys.ITEMS);
                this.parseItems(items);
            }
        } catch(JSONException e) {
            throw new RuntimeException(e);
        }
    }

    private void parseRoot(JSONObject root) throws JSONException {
        this.count = root.getInt(Keys.COUNT);
        this.page = root.getInt(Keys.PAGE);
        this.first = root.getInt(Keys.FIRST);
        this.last = root.getInt(Keys.LAST);
        this.hits = root.getInt(Keys.HITS);
        this.carrier = root.getInt(Keys.CARRIER);
        this.pageCount = root.getInt(Keys.PAGE_COUNT);
    }

    private void parseItems(JSONArray items) throws JSONException {
        for(int i = 0; i < items.length(); i++) {
            JSONObject item = (JSONObject)items.get(i);
            JSONObject content = item.getJSONObject(Keys.ITEM);
            this.items.add(new Item(content));
        }
    }

}
