package apacheHttpClient;

import org.apache.http.*;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class HttpClientTest {
    public static void main(String[] args) throws IOException, URISyntaxException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        URIBuilder uriBuilder = new URIBuilder();
        uriBuilder.setScheme("Http");
        uriBuilder.setHost("localhost");
        uriBuilder.setPort(8080);
        uriBuilder.setPath("/home/index/100");
        uriBuilder.setParameter("name","will");
        uriBuilder.setParameter("age","23");
        HttpGet httpGet = new HttpGet(uriBuilder.build());
        httpGet.addHeader("user-agent","java");
        httpGet.addHeader("X-AUTH-TOKEN","100");

        CloseableHttpResponse getResponse = httpClient.execute(httpGet);
        Header[] allHeaders = getResponse.getAllHeaders();
        for(Header header : allHeaders) {
//            HeaderElement[] elements = header.getElements();
//            for(HeaderElement headerElement : elements) {
//                System.out.println(headerElement.getName());
//            }
            System.out.println(header.getName() + "====>" + header.getValue());
        }
        HttpEntity entity = getResponse.getEntity();
        StatusLine statusLine = getResponse.getStatusLine();
        ProtocolVersion protocolVersion = getResponse.getProtocolVersion();
        Locale locale = getResponse.getLocale();

        HttpPost httpPost = new HttpPost("http://localhost:8080/home/simplePost");
        List<NameValuePair> nameValuePairs = new ArrayList<>();
        nameValuePairs.add(new BasicNameValuePair("name","will"));
        nameValuePairs.add(new BasicNameValuePair("age","22"));
        httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
        CloseableHttpResponse postResponse = httpClient.execute(httpPost);
        HttpEntity entity1 = postResponse.getEntity();


        HttpPost httpPost1 = new HttpPost("http://localhost:8080/home/simplePostBody");
        httpPost1.setHeader("Content-Type","application/json");
        httpPost1.setEntity(new StringEntity("'{\"name\":\"will\",\"age\":\"33\"}'", ContentType.APPLICATION_JSON));
        CloseableHttpResponse postResponse1 = httpClient.execute(httpPost1);
        HttpEntity entity2 = postResponse.getEntity();


    }
}
