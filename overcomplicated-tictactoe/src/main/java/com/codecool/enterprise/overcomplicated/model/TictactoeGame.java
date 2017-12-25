package com.codecool.enterprise.overcomplicated.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class TictactoeGame {

    @Autowired
    private Player player;

    private boolean won;
    private int moveCounter = 1;
    private boolean validMove = true;
    private String winner;
    private List<Integer> playerMoveList = new ArrayList<>();
    private List<Integer> computerMoveList = new ArrayList<>();

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

    public int getMoveCounter() {
        return moveCounter;
    }

    public void setMoveCounter(int moveCounter) {
        this.moveCounter = moveCounter;
    }

    public boolean checkWin() {
        List<Integer> case1 = Arrays.asList(0,1,2); //row 1
        List<Integer> case2 = Arrays.asList(3,4,5); //row 2
        List<Integer> case3 = Arrays.asList(6,7,8); //row 3
        List<Integer> case4 = Arrays.asList(0,4,8); //diagonal 1
        List<Integer> case5 = Arrays.asList(2,4,6); //diagonal 2
        List<Integer> case6 = Arrays.asList(0,3,6); //column 1
        List<Integer> case7 = Arrays.asList(1,4,7); //column 2
        List<Integer> case8 = Arrays.asList(2,5,8); //column 3

        if (playerMoveList.containsAll(case1) || playerMoveList.containsAll(case2) ||
                playerMoveList.containsAll(case3) || playerMoveList.containsAll(case4) ||
                playerMoveList.containsAll(case5) || playerMoveList.containsAll(case6) ||
                playerMoveList.containsAll(case7) || playerMoveList.containsAll(case8)) {
            setWon(true);
            setWinner(player.getUserName());
            System.out.println("Game won by player");
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

    public void move(int move) {
        if(checkIfMoveIsValid(move)) {
            if(moveCounter % 2 == 1) {
                doTheMove(playerMoveList, move);
            } else {
                doTheMove(computerMoveList, move);
            }

        } else {
            System.out.println("move not valid");
        }
    }

    public boolean checkIfMoveIsValid(int move) {
        if (playerMoveList.contains(move) || computerMoveList.contains(move)) {
            setValidMove(false);
            return validMove;
        }
        setValidMove(true);
        return validMove;
    }

    public void clearLists() {
        playerMoveList.clear();
        computerMoveList.clear();
    }

    public void doTheMove(List<Integer> listOfMove, int move) {
        listOfMove.add(move);
        checkWin();
        moveCounter++;
    }
}
