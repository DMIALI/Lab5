package org.example.utils;


import java.util.Scanner;

public class RepeatInput {
    public static String go(String value, String message, String errMessage, Operation func, Scanner scanner, Printer printer) {
        while (!func.execute(value)) {
            printer.errPrintln(errMessage);
            printer.outPrint(message);
            value = scanner.nextLine();
        }
        return value;
    }
}