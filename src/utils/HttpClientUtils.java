package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;

public class HttpClientUtils {

    public String getContentUrl(String url) throws IOException {

        HttpClient client = HttpClientBuilder.create().build();
        HttpGet get = new HttpGet(url);
        HttpResponse response = client.execute(get);

        try {
            System.out.println("Test httpclient-before execute");
            int statusCode = response.getStatusLine().getStatusCode();
            System.out.println("Response httpclient execute status=" + statusCode);

            if (statusCode != HttpStatus.SC_OK) {
                System.err.println("Method failed: " + response.getStatusLine());
            }

            BufferedReader rd = new BufferedReader(
            new InputStreamReader(response.getEntity().getContent()));

            StringBuffer result = new StringBuffer();
            String line = "";
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }

            return result.toString();

        } catch (IOException e) {
            System.err.println("Fatal transport error: " + e.getMessage());
            e.printStackTrace();
        } finally {
            get.releaseConnection();
        }
        return "";
    }

    public String postContentUrl(String url) throws IOException {

        HttpClient client = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost(url);

        List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
        urlParameters.add(new BasicNameValuePair("id", "2"));
        urlParameters.add(new BasicNameValuePair("pg", "3"));

        post.setEntity(new UrlEncodedFormEntity(urlParameters));
        HttpResponse response = client.execute(post);

        try{
            System.out.println("test httpclient-before execute");
            int statusCode = response.getStatusLine().getStatusCode();
            System.out.println("\nSending 'POST' request to URL : " + url);
            System.out.println("Response httpclient status=" + statusCode);

            if (statusCode != HttpStatus.SC_OK) {
                System.err.println("Method failed: " + response.getStatusLine());
            }

            BufferedReader rd = new BufferedReader(
            new InputStreamReader(response.getEntity().getContent()));

            StringBuffer result = new StringBuffer();
            String line = "";
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }

            return result.toString();
        } catch (IOException e) {
            System.err.println("Fatal transport error: " + e.getMessage());
            e.printStackTrace();
        } finally {
            post.releaseConnection();
        }
        return "";
    }

    public void httpBasicAuth() {


    }

}
