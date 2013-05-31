package nittyan.rakuten.book.magazine;

import nittyan.rakuten.book.CommonResult;
import nittyan.rakuten.book.Keys;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MagazineSearchResult extends CommonResult {

    private static final String TAG = "MagazineSearchResult";
    public List<MagazineItem> items;

    public MagazineSearchResult(String json) {
        try {
            JSONObject root = new JSONObject(json);
            super.parseRoot(root);
            this.items = new ArrayList<MagazineItem>();
            if (0 < super.count) {
                JSONArray items = root.getJSONArray(Keys.ITEMS);
                this.parseItem(items);
            }
        } catch(Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void parseItem(JSONArray items) throws JSONException {
        for (int i = 0; i < items.length(); i++) {
            JSONObject item = (JSONObject)items.get(i);
            JSONObject content = item.getJSONObject(Keys.ITEM);
            this.items.add(new MagazineItem(content));
        }
    }

}
