import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;

import java.io.IOException;

public class HttpStatusChecker {

    public String getStatusImage(int code) {
        String url = "https://http.cat/" + code + ".jpg";

        try {
            Response response = Jsoup.connect(url).ignoreContentType(true).execute();
            int statusCode = response.statusCode();
            if (statusCode >= 100 && statusCode < 400) {
                return url;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        throw new RuntimeException("There is not image for HTTP status " + code);
    }
}