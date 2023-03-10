package org.example.utils;


import java.util.Scanner;

public class RepeatInput {
    public static void go(String value, String message, Operation func, Scanner scanner, Printer printer) {
        while (func.execute(value)) {
            printer.outPrintln(message);
            value = scanner.nextLine();
        }
    }
}