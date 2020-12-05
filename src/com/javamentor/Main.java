package com.javamentor;

import com.javamentor.calculator.Calculator;
import com.javamentor.calculator.Util;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String operation = sc.nextLine();
        String[] operationArgs = operation.split(" ");

        if (Util.isCorrectArgs(operationArgs)) {
            new Calculator(operationArgs);
        }

    }
}
