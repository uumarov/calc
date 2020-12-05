package com.javamentor.calculator;

import java.util.List;

public class Util {
    public static boolean isCorrectArgs(String[] args) {

        if (args.length != 3) {
            System.out.println("Программа должна принимать три аргумента");
            return false;
        }

        if (!isCorrectOperator(args[1])) {
            System.out.println("Введён недопустимый оператор. Допустимые операторы: +, -, /, *");
            return false;
        }

        return true;

    }

    private static boolean isCorrectOperator(String operator) {
        return List.of("+", "-", "/", "*").contains(operator);
    }

    public static int romanToArabic(String input) {
        String romanNumeral = input.toUpperCase();
        int result = 0;

        List<RomanNumeral> romanNumerals = RomanNumeral.getReverseSortedValues();

        int i = 0;

        while ((romanNumeral.length() > 0) && (i < romanNumerals.size())) {
            RomanNumeral symbol = romanNumerals.get(i);
            if (romanNumeral.startsWith(symbol.name())) {
                result += symbol.getValue();
                romanNumeral = romanNumeral.substring(symbol.name().length());
            } else {
                i++;
            }
        }

        if (romanNumeral.length() > 0) {
            throw new IllegalArgumentException(input + " невозможно преобразовать в арабские цифры");
        }

        return result;
    }

    public static String arabicToRoman(int number) {
        if ((number <= 0) || (number > 4000)) {
            throw new IllegalArgumentException(number + " не в диапазоне от 1 до 4000");
        }

        List<RomanNumeral> romanNumerals = RomanNumeral.getReverseSortedValues();

        int i = 0;
        StringBuilder sb = new StringBuilder();

        while ((number > 0) && (i < romanNumerals.size())) {
            RomanNumeral currentSymbol = romanNumerals.get(i);
            if (currentSymbol.getValue() <= number) {
                sb.append(currentSymbol.name());
                number -= currentSymbol.getValue();
            } else {
                i++;
            }
        }

        return sb.toString();
    }


}
