package com.company.controller;

import com.company.model.Board;
import com.company.model.Position;
import com.company.view.BoardView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class GameController {

    private Position position=new Position();
    private Board board = new Board();
    private int gameMode;
    private int boardSizeGame;
    private int gameChance;
    public void initialize() throws IOException {
        System.out.println("Choose type game mode: ");
        System.out.println("Easy - 1");
        System.out.println("Hard - 2");
        Scanner scanner=new Scanner(System.in);
        gameMode=scanner.nextInt();
        if(gameMode==1){
           boardSizeGame= board.setBoardSize(4);
            gameChance=8;
            System.out.println("You have 8 Life");
            BoardView.printBoard(board);
        }else{
            boardSizeGame=board.setBoardSize(8);
            gameChance=12;
            System.out.println("You have 12 life");
            BoardView.printBoard(board);
        }
        FileController fileController=new FileController();
//        List words = Arrays.asList("slowo1", "slowo2", "slowo3", "slowo4", "slowo5", "slowo6","slowo7", "slowo8");
        board.randomizeCards(fileController.readFile());

    }

        
        public void userMove () {
        String firstWord = null;
        int firstMoveRow = 0;
        int firstMoveColumn = 0;
        while ((gameMode>0))
        for (int i = 0; i < 2; i++) {
            position.userChoice();
            board.getCard(position.getRow(), position.getColumn()).setHidden(false);
            BoardView.printBoard(board);
            if (i == 0) {
                firstWord = board.getCard(position.getRow(), position.getColumn()).getWord();
                firstMoveRow = position.getRow();
                firstMoveColumn = position.getColumn();
            }
        }
        String secondWord = board.getCard(position.getRow(), position.getColumn()).getWord();
        if (firstWord != secondWord) {
            board.getCard(position.getRow(), position.getColumn()).setHidden(true);
            board.getCard(firstMoveRow, firstMoveColumn).setHidden(true);
            System.out.println("Differences detected");
            BoardView.printBoard(board);
        }
        //sprawdza czy wszystkie odkryte i jeśli takk to kończy gre i wyświetla iloć szans, które mu zostały
    }
}
