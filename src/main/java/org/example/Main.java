package org.example;

public class Main {
    public static void main(String[] args) {
        String[][] array = {
                {"191.123", "81", "96", "101"},
                {"45", "39", "50", "30"},
                {"61", "83", "74", "12"},
                {"1495", "91", "66", "981"}
        };
        try {
            double result = func(array);
            System.out.println("Sum of the array: " + result);
        } catch (MyArraySizeException | MyArrayDataException | MyLychrelException e) {
            e.printStackTrace();
        }
    }

    private static double func(String[][] array) {
        double sum = 0;
        MyLychrelException[] lychrelExceptions = new MyLychrelException[array.length * array[0].length];
        int lychrelCount = 0;

        try {
            // Проверка размера массива
            if (array.length != 4 || array[0].length != 4) {
                throw new MyArraySizeException();
            }

            // Проверка корректности данных массива и чисел Лихлера
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array[i].length; j++) {
                    try {
                        String cleanedValue = array[i][j]; // Удаляем точку
                        double doubleValue = Double.parseDouble(cleanedValue);
                        sum += doubleValue;
                        if (isLychrel(doubleValue) && doubleValue < 1000) {
                            lychrelExceptions[lychrelCount] = new MyLychrelException(doubleValue, i, j);
                            lychrelCount++;
                        }
                    } catch (NumberFormatException e) {
                        // Бросаем MyArrayDataException с информацией о некорректных данных
                        throw new MyArrayDataException(array[i][j], i, j);
                    }
                }
            }

            // Если есть числа Лихлера, бросаем исключения
            if (lychrelCount > 0) {
                for (int i = 0; i < lychrelCount; i++) {
                    lychrelExceptions[i].printStackTrace();
                }
            }

        } catch (MyArraySizeException e) {
            e.printStackTrace();
        } catch (MyArrayDataException e) {
            e.printStackTrace();
        } catch (MyLychrelException e) {
            e.printStackTrace();
        }

        return sum;
    }

    private static double reverseNumber(double num) {
        double reversed = 0;
        int originalNum = (int) num;

        while (originalNum != 0) {
            int digit = originalNum % 10;
            reversed = reversed * 10 + digit;
            originalNum /= 10;
        }

        return reversed;
    }

    private static boolean isPalindrome(int num) {
        int originalNum = num;
        int reversed = 0;

        while (num != 0) {
            int digit = num % 10;
            reversed = reversed * 10 + digit;
            num /= 10;
        }

        return originalNum == reversed;
    }

    private static boolean isLychrel(double num) {
        int maxIterations = 20; // Максимальное количество итераций для проверки

        for (int i = 0; i < maxIterations; i++) {
            num += reverseNumber(num);

            if (isPalindrome((int) num)) {
                return false;
            }
        }

        return true;
    }
}