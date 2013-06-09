package nittyan.search;

import android.util.Log;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

public class HttpRequest {

    private static final String TAG = "HttpRequest";

    public String doGet(String url) {
        DefaultHttpClient client = null;
        try {
            HttpGet get = new HttpGet(url);
            client = new DefaultHttpClient();
            HttpResponse response = client.execute(get);
            int status = response.getStatusLine().getStatusCode();
            if (HttpStatus.SC_OK != status) {
                throw new Exception("Http Error");
            }

            return EntityUtils.toString(response.getEntity());
        } catch (Exception e) {
            Log.e(TAG, e.getMessage());
            return "";
        } finally {
            if (null != client) {
                client.getConnectionManager().shutdown();
            }
        }
    }
}
