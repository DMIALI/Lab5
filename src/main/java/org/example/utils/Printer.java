package org.example.utils;

public class Printer {
    public void outPrintln(String out){
        System.out.println(out);
    }
    public void outPrint(String out){
        System.out.print(out);
    }
    public void errPrintln(String out){
        System.err.println(out);
    }
    public void exit(int status){
        System.exit(status);
    }
}
