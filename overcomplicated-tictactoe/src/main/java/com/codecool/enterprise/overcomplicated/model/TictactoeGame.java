package com.codecool.enterprise.overcomplicated.model;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class TictactoeGame {

    private boolean won;
    private List<Integer> moveList = new ArrayList<>();

    public boolean isWon() {
        return won;
    }

    public void setWon(boolean won) {
        this.won = won;
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

        if (moveList.containsAll(case1) || moveList.containsAll(case2) ||
                moveList.containsAll(case3) || moveList.containsAll(case4) ||
                moveList.containsAll(case5) || moveList.containsAll(case6) ||
                moveList.containsAll(case7) || moveList.containsAll(case8)) {
            setWon(true);
            System.out.println("Game won by player");
            moveList.clear();
            return won;
        }
        return won;
    }

    public void collectMoves(int move) {
        moveList.add(move);
        System.out.println(moveList);
    }
}
