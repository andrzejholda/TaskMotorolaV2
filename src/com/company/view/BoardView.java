package com.company.view;

import com.company.model.Board;
import com.company.model.Card;

public class BoardView {
    public static void printBoard(Board board) {

        for (int i = 1; i <= board.getBoardSize(); i++) {
            System.out.print(" " + i);
        }
        System.out.println();

        for (int i = 0; i < 2; i++) {
            if (i == 0) System.out.print("A ");
            if (i == 1) System.out.print("B ");

            for (int j = 0; j < board.getBoardSize(); j++) {
                Card card = board.getCard(i, j);

                if (card.isHidden())
                    System.out.print("X ");
                else
                    System.out.print(card.getWord() + " ");
            }

            System.out.println();
        }
    }
}
//rodziel to jescze trochę, najlepiej stwórz klasę Cards która będzie zawierać listę card-ów. i wtedy przekażesz w linii 19 Cards.
