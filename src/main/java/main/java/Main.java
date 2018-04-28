package main.java;

import java.util.Random;

/**
 *
 * Генерация массива из 20 случайных чисел от -10 до 10.
 * Поиск максимального отрицательного и минимального положительного числа в массиве.
 * Если оба числа существуют - меняются местами, в обратном случае - выводится ошибка.
 *
 * @author Natalia Litvinova
 */

public class Main {
    public static void main(String[] args) {
        //Объявление переменных
        int[] myArray = new int[20];
        Random myRandom = new Random();

        //Задание начальных значений искомых элементов и их индексов
        int maxMinusElement = -11;
        int maxMinusIndex = -1;
        int minPlusElement = 11;
        int minPlusIndex = -1;

        System.out.println("Generated numbers:");

        //Генерация массива и поиск требуемых элементов
        for (int i = 0; i < 20; i++) {
            myArray[i] = myRandom.nextInt(20) - 10;
            System.out.print(myArray[i] + " ");
            if ((myArray[i] < 0) && (myArray[i] > maxMinusElement)) {
                maxMinusElement = myArray[i];
                maxMinusIndex = i;
            }
            if ((myArray[i] > 0) && (myArray[i] < minPlusElement)) {
                minPlusElement = myArray[i];
                minPlusIndex = i;
            }
        }

        System.out.println();

        //Вывод ошибки, если один из элементов в массиве не найден
        if ((maxMinusIndex == -1) || (minPlusIndex == -1)) {
            System.out.println("Ooops! Cannot swap elements");
            if (maxMinusIndex == -1)
                //Ошибка - в массиве нет отрицательных элементов
                System.out.println("No elements < 0");
            if (minPlusIndex == -1)
                //Ошибка - в массиве нет положительных элементов
                System.out.println("No elements > 0");
            return;
        }

        //Перестановка элементов
        int temp = myArray[maxMinusIndex];
        myArray[maxMinusIndex] = myArray[minPlusIndex];
        myArray[minPlusIndex] = temp;

        System.out.println("\nNew array:");

        //Вывод массива после перестановки элементов
        for (int i = 0; i < 20; i++)
            System.out.print(myArray[i] + " ");

        System.out.println();

        //Вывод информации об элементах, которые поменялись местами
        System.out.println("\nSuccessfully swapped:");
        System.out.println("Element №" + maxMinusIndex + " = " + maxMinusElement + " & " +
                "element №" + minPlusIndex + " = " + minPlusElement);
    }
}
