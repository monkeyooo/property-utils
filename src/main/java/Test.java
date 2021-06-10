import model.JobTask;
import service.PropertyUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Timer;

public class Test {
    public static void main(String[] args) throws IOException {
//        PropertyUtil.setPropertyParams();
//        PropertyUtil.setPeriodTime(1);
//        PropertyUtil.setStartupTime(1);
        System.out.println(PropertyUtil.setPropertyParams());
    }
}
