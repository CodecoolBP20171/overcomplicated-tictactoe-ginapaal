package comics.controlles;


import comics.model.ComicsModel;
import comics.service.RemoteURLReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Random;

@RestController
public class ComicsController {

    @Autowired
    private RemoteURLReader remoteURLReader;

    @GetMapping("/comics")
    public ComicsModel getComics() throws IOException {
        Random random = new Random();
        int rand = random.nextInt(1929);
        String uri = "https://xkcd.com/" + rand + "/info.0.json";
        String parsedURL = remoteURLReader.getHTML(uri);
        return new ComicsModel(parsedURL, rand);
    }
}
