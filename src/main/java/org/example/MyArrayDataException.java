package org.example;

// Пользовательское исключение для некорректных данных в массиве
public class MyArrayDataException extends RuntimeException {
    public MyArrayDataException(String value, int i, int j) {
        super("Invalid data:" + value + " at position (" + i + ", " + j + ")");
    }
}
