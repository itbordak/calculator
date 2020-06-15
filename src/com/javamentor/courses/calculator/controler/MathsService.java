package com.javamentor.courses.calculator.controler;

import com.javamentor.courses.calculator.exceptions.DataEntryError;
import com.javamentor.courses.calculator.model.Maths;

import java.util.Scanner;

public class MathsService {
    static private int mark = -1;
    static private Maths maths;

    static public String[] splitUpString(String line) throws DataEntryError{
        String[] strings = line.split(" ");

        if(strings.length != 3) {
            throw new DataEntryError("You entered an invalid string");
        }

        return strings;
    }

    public static void setMark(int mark) {
        MathsService.mark = mark;
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

        if(digitTranslation(line[0]) > 0 && digitTranslation(line[2]) > 0 && digitTranslation(line[0]) < 11 && digitTranslation(line[2]) < 11) {
            numbers[0] = digitTranslation(line[0]);
            numbers[1] = digitTranslation(line[2]);
            setMark(1);
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

    static public int digitTranslation(String line) throws DataEntryError{
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

    static public String jobWithLine(String[] lines) throws DataEntryError{
        String result = null;
        int[] numbers;

        numbers = numericalEducationCheck(lines);

        if (numberСheck(numbers[0]) && numberСheck(numbers[1])) {
            maths = new Maths(numbers[0], numbers[1]);
        } else {
            throw new DataEntryError("You entered an invalid string.");
        }

        result = Integer.toString(workWithNumbers(lines[1]));

        if (mark == 1) {
            result = letterTranslation(Integer.parseInt(result));
        }

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

    static public String letterTranslation(int number){
        String line = "";

        switch (number) {
            case 1: {
                line = "I";
            }break;
            case 2: {
                line = "II";
            }break;
            case 3: {
                line = "III";
            }break;
            case 4: {
                line = "IV";
            }break;
            case 5: {
                line = "V";
            }break;
            case 6: {
                line = "VI";
            }break;
            case 7: {
                line = "VII";
            }break;
            case 8: {
                line = "VIII";
            }break;
            case 9: {
                line = "IX";
            }break;
            case 10: {
                line = "X";
            }break;
            case 12: {
                line = "XII";
            }break;
            case 14: {
                line = "XIV";
            }break;
            case 15: {
                line = "XV";
            }break;
            case 16: {
                line = "XVI";
            }break;
            case 18: {
                line = "XVIII";
            }break;
            case 20: {
                line = "XX";
            }break;
            case 21: {
                line = "XXI";
            }break;
            case 24: {
                line = "XXIV";
            }break;
            case 25: {
                line = "XXV";
            }break;
            case 27: {
                line = "XVII";
            }break;
            case 28: {
                line = "XVII";
            }break;
            case 30: {
                line = "XXX";
            }break;
            case 32: {
                line = "XXXII";
            }break;
            case 36: {
                line = "XXXVI";
            }break;
            case 40: {
                line = "XL";
            }break;
            case 42: {
                line = "XLII";
            }break;
            case 45: {
                line = "XLV";
            }break;
            case 48: {
                line = "XLVIII";
            }break;
            case 49: {
                line = "XLIX";
            }break;
            case 50: {
                line = "L";
            }break;
            case 54: {
                line = "LIV";
            }break;
            case 56: {
                line = "LVI";
            }break;
            case 60: {
                line = "LX";
            }break;
            case 63: {
                line = "LXIII";
            }break;
            case 64: {
                line = "LXIV";
            }break;
            case 70: {
                line = "LXX";
            }break;
            case 72: {
                line = "LXXII";
            }break;
            case 80: {
                line = "LXXX";
            }break;
            case 81: {
                line = "LXXXI";
            }break;
            case 90: {
                line = "XC";
            }break;
            case 100: {
                line = "C";
            }break;

        }


        return line;
    }
}
