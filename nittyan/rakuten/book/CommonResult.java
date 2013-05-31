package nittyan.rakuten.book;

import nittyan.search.Result;
import org.json.JSONException;
import org.json.JSONObject;

public class CommonResult implements Result {
    public int count;
    public int page;
    public int first;
    public int last;
    public int hits;
    public int carrier;
    public int pageCount;

    protected void parseRoot(JSONObject root) throws JSONException {
        this.count = root.getInt(Keys.COUNT);
        this.page = root.getInt(Keys.PAGE);
        this.first = root.getInt(Keys.FIRST);
        this.last = root.getInt(Keys.LAST);
        this.hits = root.getInt(Keys.HITS);
        this.carrier = root.getInt(Keys.CARRIER);
        this.pageCount = root.getInt(Keys.PAGE_COUNT);
    }
}
