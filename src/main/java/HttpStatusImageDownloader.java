import org.apache.commons.io.FileUtils;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;

import java.io.File;
import java.io.IOException;


public class HttpStatusImageDownloader {
    void downloadStatusImage(int code) {
        HttpStatusChecker statusChecker = new HttpStatusChecker();
        try {
            String url = statusChecker.getStatusImage(code);
            Response response = Jsoup.connect(url).ignoreContentType(true).execute();
            byte[] imageBytes = response.bodyAsBytes();
            String path = "src/main/resources/images/" + code + ".jpg";
            File file = new File(path);
            FileUtils.writeByteArrayToFile
                    (file, imageBytes);
        } catch (NullPointerException | IOException ex) {
            ex.printStackTrace();
        }
    }
}


