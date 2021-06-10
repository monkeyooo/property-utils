package model;

import com.google.gson.Gson;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.TimerTask;

public class JobTask extends TimerTask {
    private static final Logger logger = LogManager.getLogger(JobTask.class);
    static final Gson gson = new Gson();
    static String propertiesUrl;
    @Override
    public void run() {
        try {
            URL url = new URL(propertiesUrl);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestProperty("Content-Type", "application/json; utf-8");
            con.setRequestMethod("GET");
            con.getInputStream();
            try(BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), StandardCharsets.UTF_8))) {
                StringBuilder response = new StringBuilder();
                String responseLine;
                while ((responseLine = br.readLine()) != null) {
                    response.append(responseLine.trim()).append("\n");
                }
                Map<String, String> map = gson.fromJson(response.toString(), Map.class);
                logger.info("Properties : " + response.toString());
                map.forEach(System::setProperty);
                logger.info("Properties set success ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setPropertiesUrl(String url) {
        propertiesUrl = url;
    }
}
