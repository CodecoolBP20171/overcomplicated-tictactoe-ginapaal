package comics.controlles;


import comics.model.ComicsModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class ComicsController {

    @GetMapping("/comics")
    public ComicsModel getComics() {
        Random random = new Random();
        int rand = random.nextInt(1929);
        String uri = "https://xkcd.com/" + rand + "/info.0.json";
        return new ComicsModel(uri, rand);
    }
}
