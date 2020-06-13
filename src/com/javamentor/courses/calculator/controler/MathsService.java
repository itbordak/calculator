package com.javamentor.courses.calculator.controler;

import com.javamentor.courses.calculator.exceptions.DataEntryError;
import com.javamentor.courses.calculator.model.Maths;

import java.util.Scanner;

public class MathsService {
    static private Maths maths;

    static public String[] splitUpString(String line) throws DataEntryError{
        String[] strings = line.split(" ");

        if(strings.length != 3) {
            throw new DataEntryError("You entered an invalid string");
        }

        return strings;
    }

    static public boolean numberСheck(int number) {
        boolean flag = false;

        if(number > 0 && number < 11 && number % 1 == 0) {
            flag = true;
        }

        return flag;
    }

    static public int[] numericalEducationCheck(String[] line) throws DataEntryError{
        int[] numbers = new int[2];

        if(prov(line[0]) > 0 && prov(line[2]) > 0 && prov(line[0]) < 11 && prov(line[2]) < 11) {
            numbers[0] = prov(line[0]);
            numbers[1] = prov(line[2]);
        } else {
            try {
                numbers[0] = Integer.parseInt(line[0]);
                numbers[1] = Integer.parseInt(line[2]);
            }catch (Exception e) {
                throw new DataEntryError("You entered an invalid string.");
            }
        }

        return numbers;
    }

    static public int prov(String line) throws DataEntryError{
        int result = -1;

        if(line.equals("I")) {
            result = 1;
        }else if(line.equals("II")) {
            result = 2;
        }else if(line.equals("III")) {
            result = 3;
        }else if(line.equals("IV")) {
            result = 4;
        }else if(line.equals("V")) {
            result = 5;
        }else if(line.equals("VI")) {
            result = 6;
        }else if(line.equals("VII")) {
            result = 7;
        }else if(line.equals("VIII")) {
            result = 8;
        }else if(line.equals("IX")) {
            result = 9;
        }else if(line.equals("X")) {
            result = 10;
        }

        return result;
    }

    static public String[] readLine() throws DataEntryError{
        String line = null;
        String[] lines = null;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the arithmetic operation");
        line = scanner.nextLine();
        lines = splitUpString(line);

        return lines;
    }

    static public int jobWithLine(String[] lines) throws DataEntryError{
        int result = 0;
        int[] numbers;

        numbers = numericalEducationCheck(lines);

        if (numberСheck(numbers[0]) && numberСheck(numbers[1])) {
            maths = new Maths(numbers[0], numbers[1]);
        } else {
            throw new DataEntryError("You entered an invalid string.");
        }

        result = workWithNumbers(lines[1]);

        return result;
    }

    static private int workWithNumbers(String line) throws DataEntryError {
        int result = 0;

        switch (line){
            case "+" : {
                result = maths.additions();
            } break;
            case "-" : {
                result = maths.subtraction();
            } break;
            case "*" : {
                result = maths.multiplications();
            } break;
            case "/" : {
                result = maths.units();
            } break;
            default: {
                throw new DataEntryError("You entered an invalid string.");
            }
        }

        return result;
    }
}
