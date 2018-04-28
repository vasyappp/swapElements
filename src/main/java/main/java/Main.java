package main.java;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[] myArray = new int[20];
        Random myRandom = new Random();

        myArray[0] = myRandom.nextInt(20) - 10;
        int maxMinusElement = -11;
        int maxMinusIndex = -1;
        int minPlusElement = 11;
        int minPlusIndex = -1;

        System.out.println("Generated numbers:");

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

        if ((maxMinusIndex == -1) || (minPlusIndex == -1)) {
            System.out.println("Ooops! Cannot swap elements");
            if (maxMinusIndex == -1)
                System.out.println("No elements < 0");
            if (minPlusIndex == -1)
                System.out.println("No elements > 0");
            return;
        }

        int temp = myArray[maxMinusIndex];
        myArray[maxMinusIndex] = myArray[minPlusIndex];
        myArray[minPlusIndex] = temp;

        System.out.println("\nNew array:");

        for (int i = 0; i < 20; i++)
            System.out.print(myArray[i] + " ");

        System.out.println();

        System.out.println("\nSuccessfully swapped:");
        System.out.println("Element №" + maxMinusIndex + " = " + maxMinusElement + " & " +
                "element №" + minPlusIndex + " = " + minPlusElement);
    }
}
