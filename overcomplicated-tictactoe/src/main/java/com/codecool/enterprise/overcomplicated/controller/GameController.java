package com.codecool.enterprise.overcomplicated.controller;

import com.codecool.enterprise.overcomplicated.model.Player;
import com.codecool.enterprise.overcomplicated.model.TictactoeGame;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.boot.json.JsonParser;
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
        model.addAttribute("moveList", moveList);
        model.addAttribute("computerMoves", computerMoves);
        return "game";
    }

    @GetMapping(value = "/game-move")
    public String gameMove(@ModelAttribute("player") Player player, @ModelAttribute("move") int move) {
        tictactoeGame.playerMove(move);
        tictactoeGame.computerMove();
        tictactoeGame.gameState();
        return "redirect:/game";
    }

    @ModelAttribute("funfact")
    public String funFact() {
        try {
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:60000/funfact", String.class);
            JsonParser jsonParser = new JacksonJsonParser();
            return (String) jsonParser.parseMap(response.getBody()).get("funfact");
        } catch (ResourceAccessException e) {
            System.out.println("Exception catched, " + e.getMessage());
            return "It's a fun fact, isn't it?";
        }
    }

    @ModelAttribute("avatar_uri")
    public String getAvatarUri(@ModelAttribute Player player) {
        try {
            RestTemplate restTemplate = new RestTemplate();
            System.out.println(getPlayer().getUserName());
            ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:60001/avatar?avatarString=" + player.getUserName(), String.class);
            JsonParser jsonParser = new JacksonJsonParser();
            System.out.println(response);
            return (String) jsonParser.parseMap(response.getBody()).get("uri");
        } catch (ResourceAccessException e) {
            e.getMessage();
            return "https://robohash.org/sly";
        }
    }

    @ModelAttribute("comic_uri")
    public String getComic() {
        try {
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:60002/comics", String.class);
            JsonParser jsonParser = new JacksonJsonParser();
            System.out.println(response);
            return (String) jsonParser.parseMap(response.getBody()).get("uri");
        } catch (Exception e) {
            return "https://xkcd.com/1794";
        }
    }
    
}
