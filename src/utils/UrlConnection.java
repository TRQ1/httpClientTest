package utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.Base64;


public class UrlConnection {

    public String getUrl(String theUrl) throws IOException {
        StringBuilder content = new StringBuilder();
        final String charSet = "UTF-8";

        try
        {
            URL url = new URL(theUrl);
            URLConnection urlConnection = url.openConnection();
            urlConnection.setUseCaches(false);
            urlConnection.setRequestProperty("Accept-Charset", charSet);

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

            String line;
            while ((line = bufferedReader.readLine()) != null)
            {
                content.append(line + "\n");
            }
            bufferedReader.close();
        } catch (IOException e) {
            System.out.println(e);
        }
        return content.toString();
    }

    public String postUrl(HttpServletRequest request, HttpServletResponse response, String theUrl) throws IOException {

        final String charSet = "UTF-8";
        StringBuilder content = new StringBuilder();
        DataOutputStream out = null;
        String param = null;

        if(request != null) {
            String id = request.getParameter("userId");
            String passwd = request.getParameter("userPasswd");
            param = "userId=" + id +
            "&password=" + passwd;
        }

        try {
            URL url = new URL(theUrl + "?" + param );
            URLConnection urlConnection = url.openConnection();
            urlConnection.setDoOutput(true); // Triggers POST.
            urlConnection.setRequestProperty("Accept-Charset", charSet);
            urlConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=" + charSet);

            try {
                out = new DataOutputStream(urlConnection.getOutputStream());
                out.writeBytes(param);
                out.flush();
            } finally {
                if (out != null) {
                out.close();
                }
            }

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

            String line;
            while ((line = bufferedReader.readLine()) != null)
            {
                content.append(line + "\n");
            }
            bufferedReader.close();

        } catch (Exception e){
            PrintWriter outPrint = response.getWriter();
            outPrint.print(e);
            outPrint.close();
        }
        return content.toString();
    }

    public void httpBasicAuth(){
        try {
            URL url = new URL ("http://ip:port/login");
            String encoding = Base64.getEncoder().encodeToString(("test1:test1").getBytes());

            URLConnection connection = (URLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setRequestProperty  ("Authorization", "Basic " + encoding);
            InputStream content = (InputStream)connection.getInputStream();
            BufferedReader in   =
                    new BufferedReader (new InputStreamReader (content));
            String line;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }
        } catch(Exception e) {
            e.printStackTrace();
        } finally {

        }
    }

}
