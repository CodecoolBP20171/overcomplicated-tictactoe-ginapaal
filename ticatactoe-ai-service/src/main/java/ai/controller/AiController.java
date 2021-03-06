package ai.controller;

import ai.model.AiModel;
import ai.service.RemoteURLReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class AiController {

    @Autowired
    private RemoteURLReader remoteURLReader;

    @GetMapping("/ai")
    public AiModel getAiMoves(@ModelAttribute("gameState") String gameState) throws IOException {
        String uri = "http://tttapi.herokuapp.com/api/v1/" + gameState + "/X";
        int move = remoteURLReader.getMove(uri);
        return new AiModel(move);
    }
}
