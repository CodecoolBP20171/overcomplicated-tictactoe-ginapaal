package ai.controller;

import ai.model.AiModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AiController {

    @GetMapping("/ai")
    public AiModel getAiMoves(@ModelAttribute("gameState") String gameState) {
        String uri = "http://tttapi.herokuapp.com/api/v1/" + gameState + "/X";
        return new AiModel(gameState, uri);
    }
}
