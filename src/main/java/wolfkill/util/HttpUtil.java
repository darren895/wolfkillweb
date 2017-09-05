package wolfkill.util;

import java.io.IOException;

import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

public class HttpUtil {
	
	public static String get(String url){
		CloseableHttpClient httpClient = null;
		HttpGet httpGet = null;
		try {
			httpClient = HttpClientBuilder.create().build();
			httpGet = new HttpGet(url);
			CloseableHttpResponse response = httpClient.execute(httpGet);
			if(response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
				String body = EntityUtils.toString(response.getEntity(), "utf-8");
				return body;
			}
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(httpGet != null){
				httpGet.releaseConnection();
			}
			if(httpClient != null){
				try {
					httpClient.close();
				} catch (IOException e) {
					
				}
			}
		}
		return null;
	}

}
