package ai.service;

import org.json.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;


@Service
@Component
public class RemoteURLReader {

    public int getMove(String url) throws IOException {
//        System.setProperty("http.agent", "Chrome");
        StringBuilder stringBuilder = new StringBuilder();
        URL uri = new URL(url);
        URLConnection conn = uri.openConnection();
        BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line;
        while((line = reader.readLine()) != null) {
            stringBuilder.append(line);
        }
        JSONObject jsonObject = new JSONObject(stringBuilder.toString());
        System.out.println(stringBuilder.toString());
        int move = (Integer) jsonObject.get("recommendation");
        System.out.println(move);
        reader.close();
        return move;
    }
}