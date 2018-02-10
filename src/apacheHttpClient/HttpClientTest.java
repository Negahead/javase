package apacheHttpClient;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.ProtocolVersion;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.Locale;

public class HttpClientTest {
    public static void main(String[] args) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet("http://localhost:8080/home/index/12");
        httpGet.addHeader("user-agent","java");
        httpGet.addHeader("X-AUTH-TOKEN","100");

        CloseableHttpResponse getResponse = httpClient.execute(httpGet);
        Header[] allHeaders = getResponse.getAllHeaders();
        HttpEntity entity = getResponse.getEntity();
        StatusLine statusLine = getResponse.getStatusLine();
        ProtocolVersion protocolVersion = getResponse.getProtocolVersion();
        Locale locale = getResponse.getLocale();

    }
}
