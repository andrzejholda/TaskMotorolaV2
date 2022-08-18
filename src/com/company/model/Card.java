package com.company.model;

public class Card {

    private boolean hidden;

    private final String word;

    public Card(String word) {
        this.hidden = true;
        this.word = word;
    }

    public boolean isHidden() {
        return hidden;
    }

    public String getWord() {
        return word;
    }


    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }
}
