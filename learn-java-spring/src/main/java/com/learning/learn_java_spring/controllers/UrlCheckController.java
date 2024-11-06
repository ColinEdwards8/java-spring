package main.java.com.learning.learn_java_spring;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UrlCheckController {
    private final String SITE_UP = "site is up!";
    private final String SITE_DOWN = "site is down!";
    private final String INCORRECT_URL = "url is incorrect!";

    @GetMapping("/check")
    public String getUrlStatusMessage(@RequestParam String url) {
        String returnMessage = "";
        try {
            URL urlObj = new URL(url);
            HttpURLConnection conn = (HttpURLConnection) urlObj.openConnection();
            conn.setRequestMethod("GET");
        } catch (MalformedURLException e) {
            reurnMessage = INCORRECT_URL;
        }

        return returnMessage;
    }

}
