package com.alexeymiroshnikov.springweb.spring_max_letter.model;

public class ResponseFormat {

    private char letter;
    private int count;

    public ResponseFormat(char letter, int count) {
        this.letter = letter;
        this.count = count;
    }

    public char getLetter() {
        return letter;
    }

    public void setLetter(char letter) {
        this.letter = letter;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
