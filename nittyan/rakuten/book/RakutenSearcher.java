package nittyan.rakuten.book;

import android.util.Log;
import nittyan.search.Searcher;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public abstract class RakutenSearcher<R extends CommonResult, T extends CommonCondition> implements Searcher<R, T> {

    private static final String TAG = "RakutenSearcher";

    public RakutenSearcher() {
    }

    protected StringBuilder appendCommonParameter(StringBuilder builder, T condition) {
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

    protected StringBuilder appendParameter(StringBuilder builder, String key, String value) {
        builder.append(key);
        builder.append("=");
        builder.append(this.urlEncode(value));
        builder.append("&");
        return  builder;
    }

    protected StringBuilder appendParameter(StringBuilder builder, String key, int value) {
        builder.append(key);
        builder.append("=");
        builder.append(value);
        builder.append("&");
        return  builder;
    }

    protected StringBuilder appendParameter(StringBuilder builder, String key, long value) {
        builder.append(key);
        builder.append("=");
        builder.append(value);
        builder.append("&");
        return  builder;
    }

    protected boolean isNull(String str) {
        if (null == str) return true;
        if (str.length() == 0) return true;
        return false;
    }

    protected boolean isNull(int n) {
        return Integer.MIN_VALUE == n;
    }

    protected boolean isNull(long n) {
        return Long.MIN_VALUE == n;
    }

    protected boolean isNull(Enum n) {
        return null == n;
    }

    protected String urlEncode(String parameter) {
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
