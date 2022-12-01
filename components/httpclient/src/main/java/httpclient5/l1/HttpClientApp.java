package httpclient5.l1;

import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClientBuilder;
import org.apache.hc.core5.http.io.HttpClientResponseHandler;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.io.entity.StringEntity;

public class HttpClientApp {

    public static void main(String[] args) {
        post();
        get();
    }

    public static void post() {
        try (CloseableHttpClient client = HttpClientBuilder.create().build()) {
            HttpPost post = new HttpPost("http://localhost:8080/hello");
            post.setEntity(new StringEntity("hello Alice"));
            String postRespMsg = client.execute(post, (HttpClientResponseHandler<String>) (resp) -> {
                return EntityUtils.toString(resp.getEntity(), 5);
            });
            System.out.println(postRespMsg);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void get() {

        try (
                CloseableHttpClient client = HttpClientBuilder.create()
                        .build();
        ) {
            HttpGet httpGet = new HttpGet("http://localhost:8080/hello");
            httpGet.setEntity(new StringEntity("hello Jack"));

            String responseMsg = client.execute(httpGet, (HttpClientResponseHandler<String>) (response) -> {
                int code = response.getCode();
                System.out.println(code);
                return EntityUtils.toString(response.getEntity());
            });
            System.out.println(responseMsg);


        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
