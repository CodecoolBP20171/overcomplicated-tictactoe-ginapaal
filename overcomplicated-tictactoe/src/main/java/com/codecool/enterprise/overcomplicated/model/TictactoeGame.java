package com.codecool.enterprise.overcomplicated.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class TictactoeGame {

    @Autowired
    private Player player;

    private boolean won;
    private boolean validMove = true;
    private String winner;

    private List<Integer> playerMoveList = new ArrayList<>();
    private List<Integer> computerMoveList = new ArrayList<>();
    private List<Integer> availableFields = new ArrayList<>();


    public List<Integer> getComputerMoveList() {
        return computerMoveList;
    }

    public boolean isWon() {
        return won;
    }

    public void setWon(boolean won) {
        this.won = won;
    }

    public boolean isValidMove() {
        return validMove;
    }

    public void setValidMove(boolean validMove) {
        this.validMove = validMove;
    }

    public List<Integer> getPlayerMoveList() {
        return playerMoveList;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }


    public boolean checkWin() {
        List<Integer> case1 = Arrays.asList(0, 1, 2); //row 1
        List<Integer> case2 = Arrays.asList(3, 4, 5); //row 2
        List<Integer> case3 = Arrays.asList(6, 7, 8); //row 3
        List<Integer> case4 = Arrays.asList(0, 4, 8); //diagonal 1
        List<Integer> case5 = Arrays.asList(2, 4, 6); //diagonal 2
        List<Integer> case6 = Arrays.asList(0, 3, 6); //column 1
        List<Integer> case7 = Arrays.asList(1, 4, 7); //column 2
        List<Integer> case8 = Arrays.asList(2, 5, 8); //column 3

        if (playerMoveList.containsAll(case1) || playerMoveList.containsAll(case2) ||
                playerMoveList.containsAll(case3) || playerMoveList.containsAll(case4) ||
                playerMoveList.containsAll(case5) || playerMoveList.containsAll(case6) ||
                playerMoveList.containsAll(case7) || playerMoveList.containsAll(case8)) {
            setWon(true);
            setWinner(player.getUserName());
            System.out.println("Game won by " + winner);
            clearLists();
            return won;
        } else if (computerMoveList.containsAll(case1) || computerMoveList.containsAll(case2) ||
                computerMoveList.containsAll(case3) || computerMoveList.containsAll(case4) ||
                computerMoveList.containsAll(case5) || computerMoveList.containsAll(case6) ||
                computerMoveList.containsAll(case7) || computerMoveList.containsAll(case8)) {
            setWon(true);
            setWinner("Computer");
            System.out.println("Game won by computer");
            clearLists();
        }
        return won;
    }


    public void populateAvailableFields() {
        for (int i = 0; i < 9; i++) {
            availableFields.add(i);
        }
    }

    private void move(int move, List<Integer> listToAddMove) {
        if (checkIfMoveIsValid(move)) {
                listToAddMove.add(move);
                availableFields.remove(availableFields.indexOf(move));
                checkWin();
        } else {
            System.out.println("move not valid");
        }
    }

    public void playerMove (int move) {
        move(move, playerMoveList);
        System.out.println(player.userName + "moved " + move);
    }

    public void computerMove() {
        Random random = new Random();
        int index = random.nextInt(availableFields.size());
        int move = availableFields.get(index);
        move(move, computerMoveList);
        System.out.println("Computer moved " + move);
    }


   private boolean checkIfMoveIsValid(int move) {
        if (playerMoveList.contains(move) || computerMoveList.contains(move)) {
            setValidMove(false);
            return validMove;
        }
        setValidMove(true);
        return validMove;
    }

    private void clearLists() {
        playerMoveList.clear();
        computerMoveList.clear();
    }
}
