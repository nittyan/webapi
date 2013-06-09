package nittyan.hatena.keyword;

import java.util.HashMap;
import java.util.Map;
import android.util.Log;
import nittyan.hatena.Encoding;
import nittyan.search.HttpRequest;
import nittyan.search.Searcher;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class KeywordSearcher implements Searcher<KeywordResult, KeywordCondition> {

    private static final String TAG = "KeywordSearcher";

    private String url = "http://d.hatena.ne.jp/keyword?word=%s&mode=%s&ie=%s";

    private static Map<Encoding, String> codecs;
    static {
        codecs = new HashMap<Encoding, String>();
        codecs.put(Encoding.EUC_JP, "EUC-JP");
        codecs.put(Encoding.SHIFTJIS, "Shift-JIS");
        codecs.put(Encoding.UTF8, "UTF-8");
    }

    @Override
    public KeywordResult search(KeywordCondition condition) {
        String u = String.format(this.url, this.urlEncode(condition.word, condition.encoding), condition.mode.getName(), condition.encoding.getName());
        HttpRequest request = new HttpRequest();
        String response = request.doGet(u);
        KeywordResult result = new KeywordResult(response);
        KeywordItem item = result.items.get(0);
        return result;
    }

    protected String urlEncode(String parameter, Encoding codec) {
        String encoded = "";
        try {
            encoded = URLEncoder.encode(parameter, codecs.get(codec));
        } catch (UnsupportedEncodingException e) {
            Log.e(TAG, e.getMessage());
            return "";
        }
        return encoded;
    }

}
