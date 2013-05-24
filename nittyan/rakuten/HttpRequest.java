package nittyan.rakuten;

import android.util.Log;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.SingleClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;

public class HttpRequest {

    private static final String TAG = "HttpRequest";

    public HttpRequest() {
    }

    public String doGet(String urlString) {
        DefaultHttpClient client = null;
        try {
            SchemeRegistry registry = new SchemeRegistry();
            registry.register(new Scheme("https", SSLSocketFactory.getSocketFactory(), 443));

            HttpParams params = new BasicHttpParams();
            HttpConnectionParams.setSoTimeout(params, 3 * 1000);
            SingleClientConnManager manager = new SingleClientConnManager(params, registry);
            client = new DefaultHttpClient(manager, params);
            HttpGet httpGet = new HttpGet(urlString);
            HttpResponse response = client.execute(httpGet);

            int status = response.getStatusLine().getStatusCode();
            if (status == HttpStatus.SC_OK) {
                return EntityUtils.toString(response.getEntity(), "UTF-8");
            } else {
                Log.e(TAG, "status: " + status);
                throw new Exception("HTTPS error");
            }

        } catch (Exception e) {
            e.printStackTrace();
            return "";
        } finally {
            if (null != client) {
                client.getConnectionManager().shutdown();
            }
        }
    }
}
