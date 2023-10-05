package org.example;

public class MyLychrelException extends RuntimeException{
    public MyLychrelException(double Lychrel, int i, int j) {
        super("Lychrel number found:" + Lychrel + ", position (" + i + ", " + j + ")");
    }
}
