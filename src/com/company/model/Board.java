package com.company.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Board {
    private final Card[][] cards;
    private  int boardSize;

    public int setBoardSize(int boardSize) {
        this.boardSize = boardSize;
        return boardSize;
    }

    public Card getCard(int i, int j) {
        return cards[i][j];
    }

    public int getBoardSize() {
        return boardSize;
    }
    //było też tak  i działało tylko że musiałem przypisać na początku wartosć w controlerze
    // public Board(int boardSize){
    // this.boardSize=boardSize;
    //this.card=new Card[2][boardsize];

//tutaj sobie już tworzę tablicę cadrów i one są
    public Board() {
        this.boardSize = boardSize;
        this.cards = new Card[2][boardSize];
    }

    public void randomizeCards(List<String> words) {
        // jeśli kilka rozgrywek jest podczas 1 odpalenia gry to pasuje zapewnić by  przy życiu była  jedną istancja a nie powoływac nowej.
        // najlepiej jak tutaj iste i odpali się 1 raz i będzie trwać przez całą grę do domentu zakończenia jej.
        List<String> randomWords = new ArrayList<>(words);
        Collections.shuffle(randomWords);

        List<Integer> indexes = IntStream.range(0, this.boardSize * 2).boxed().collect(Collectors.toList());
        Collections.shuffle(indexes);

        int wordCounter = 0;

        for (int i = 0; i < indexes.size(); i += 1) {
            String word = randomWords.get(wordCounter);
            int index = indexes.get(i);
            this.cards[index / boardSize][index % boardSize] = new Card(word);

            if (i % 2 == 1)
                wordCounter++;
        }
    }

}
