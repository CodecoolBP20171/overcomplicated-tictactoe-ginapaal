package com.codecool.enterprise.overcomplicated.controller;

import com.codecool.enterprise.overcomplicated.model.Player;
import com.codecool.enterprise.overcomplicated.model.TictactoeGame;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Controller
@SessionAttributes({"player", "game"})
public class GameController {

    @Autowired
    TictactoeGame tictactoeGame;

    @ModelAttribute("player")
    public Player getPlayer() {
        return new Player();
    }

    @ModelAttribute("game")
    public TictactoeGame getGame() {
        return new TictactoeGame();
    }

    @ModelAttribute("avatar_uri")
    public String getAvatarUri() {
        return "https://robohash.org/codecool";
    }

    @GetMapping(value = "/")
    public String welcomeView(@ModelAttribute Player player) {
        return "welcome";
    }

    @PostMapping(value="/changeplayerusername")
    public String changPlayerUserName(@ModelAttribute Player player) {
        return "redirect:/game";
    }

    @GetMapping(value = "/game")
    public String gameView(@ModelAttribute("player") Player player, Model model) {
        List<Integer> moveList = tictactoeGame.getPlayerMoveList();
        List<Integer> computerMoves = tictactoeGame.getComputerMoveList();
        model.addAttribute("funfact", "&quot;Chuck Norris knows the last digit of pi.&quot;");
        model.addAttribute("comic_uri", "https://imgs.xkcd.com/comics/bad_code.png");
        model.addAttribute("moveList", moveList);
        model.addAttribute("computerMoves", computerMoves);
        return "game";
    }

    @GetMapping(value = "/game-move")
    public String gameMove(@ModelAttribute("player") Player player, @ModelAttribute("move") int move) {
        tictactoeGame.playerMove(move);
        tictactoeGame.computerMove();
//        List<Integer> moveList = tictactoeGame.getPlayerMoveList();
//        List<Integer> computerMoves = tictactoeGame.getComputerMoveList();
//        System.out.println(moveList);
//        System.out.println(computerMoves);
        return "redirect:/game";
    }

    @ModelAttribute("funfact")
    public String getFunfact() {
        try {
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<String> response =
                    restTemplate.getForEntity("http://localhost:60000/funfact", String.class);
            JacksonJsonParser jacksonJsonParser = new JacksonJsonParser();
            return (String) jacksonJsonParser.parseMap(response.getBody()).get("funfact");
        } catch (ResourceAccessException e) {
            System.out.println("FunFact Service is unavailable: " + e);
            return "Chuck Norris knows the last digit of pi.";
        }
    }
}
