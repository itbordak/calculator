package com.javamentor.courses.calculator.model;

import com.javamentor.courses.calculator.interfaces.MatchsAction;

public class Maths implements MatchsAction {
    private int numberOne;
    private int numberTwo;

    public Maths(int numberOne, int numberTwo) {
        this.numberOne = numberOne;
        this.numberTwo = numberTwo;
    }

    public int getNumberOne() {
        return numberOne;
    }

    public int getNumberTwo() {
        return numberTwo;
    }

    @Override
    public int additions() {
        return this.getNumberOne() + this.getNumberTwo();
    }

    @Override
    public int subtraction() {
        return this.getNumberOne() - this.getNumberTwo();
    }

    @Override
    public int multiplications() {
        return this.getNumberOne() * this.getNumberTwo();
    }

    @Override
    public int units() {
        return this.getNumberOne() / this.getNumberTwo();
    }
}
