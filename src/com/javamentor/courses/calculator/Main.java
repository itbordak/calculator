package com.javamentor.courses.calculator;

import com.javamentor.courses.calculator.exceptions.DataEntryError;
import com.javamentor.courses.calculator.facade.Calculator;

public class Main {

    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        try {
            do {
                calculator.run();
            }while (true);
        } catch (DataEntryError e) {
            System.out.println(e.getMessage());
        }
    }
}
