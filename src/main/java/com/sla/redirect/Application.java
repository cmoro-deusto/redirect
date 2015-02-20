package com.sla.redirect;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class Application {

    private static Logger log = LoggerFactory.getLogger(Application.class);
    private static String baseUrl = "http://sisinfo.preventiva.com";
    private static String loginPath = baseUrl + "/PrincipalWebPre/login/ExternalLogin";


    public static void main(String[] args) {

        log.info("Redirect example\n");
        log.info("Preparing Request to " + loginPath);


        CookieStore cookieStore = new BasicCookieStore();
        HttpClient client = HttpClients.custom().setDefaultCookieStore(cookieStore).build();
        HttpPost req = new HttpPost(loginPath);

        // TODO: add HMAC Required Params
//        List<NameValuePair> values = new ArrayList<NameValuePair>();
//        values.add(new BasicNameValuePair("IDToken1", "username"));
//        req.setEntity(new UrlEncodedFormEntity(values, StandardCharsets.UTF_8));


        try {
            log.info("Calling " + loginPath + "\n");

            HttpResponse res = client.execute(req);
            HttpEntity entity = res.getEntity();
            String location = res.getFirstHeader("Location").toString();

            log.info("Response received");
            log.info("HTTP Error Code: " + res.getStatusLine());

            Header[] headers = res.getAllHeaders();
            for (int i = 0; i < headers.length; i++) {
                Header header = headers[i];
                log.info(header.toString());
            }

            log.info("Body: \n\n" + EntityUtils.toString(entity));

            if (res.getStatusLine().getStatusCode() == 302 || res.getStatusLine().getStatusCode() == 301) {

                if (location.contains("ExternalLogin")) {

                    log.error("Bad Login Received");
                    log.info("Redirect to: " + location);

                    // TODO: send a response to client with an Error on the authentication process

                } else {

                    log.info("Logged in");
                    log.info("Redirect to: " + location);

                    Header[] setCookies = res.getHeaders("Set-Cookie");
                    for (Header cookie : setCookies) {
                        log.info(cookie.toString());
                    }

                    // TODO: send a sendRedirect() to client using location or baseUrl + location value using Set-Cookie values

                }

            } else {
                log.info("Not a Redirect...");
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
