package comics.model;

import java.util.Random;

public class ComicsModel {

    private String uri;

    private int randomNum;

    public ComicsModel() {
    }

    public ComicsModel(String uri, int randomNum) {
        this.uri = uri;
        this.randomNum = randomNum;
    }

    public String getUri() {
        return uri;
    }

    public int getRandomNum() {
        return randomNum;
    }
}
