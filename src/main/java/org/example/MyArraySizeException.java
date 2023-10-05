package org.example;

// Пользовательское исключение для неправильного размера массива
public class MyArraySizeException extends RuntimeException {
    public MyArraySizeException() {
        super("Invalid array size");
    }
}