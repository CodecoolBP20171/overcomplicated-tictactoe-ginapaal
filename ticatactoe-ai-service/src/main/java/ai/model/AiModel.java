package ai.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AiModel {

    String gameState;
    String uri;

    public AiModel() {

    }

    public AiModel(String gameState, String uri) {
        this.gameState = gameState;
        this.uri = uri;
    }

    public String getGameState() {
        return gameState;
    }

    public void setGameState(String gameState) {
        this.gameState = gameState;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }
}
