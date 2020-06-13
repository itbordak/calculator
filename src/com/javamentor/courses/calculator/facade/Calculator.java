package com.javamentor.courses.calculator.facade;

import com.javamentor.courses.calculator.controler.MathsService;
import com.javamentor.courses.calculator.exceptions.DataEntryError;

public class Calculator {
    MathsService mathsService;

    public Calculator() {
    }

    public void run() throws DataEntryError{
        String[] line = mathsService.readLine();
        long result = mathsService.jobWithLine(line);
        System.out.println("result " + result);
    }
}
