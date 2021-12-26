package com.kaliada.sandbox;

public class Sort {

    public static void bubbleSort(int[] array){
        boolean sorted = false;
        while (!sorted){
            sorted = true;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i + 1] < array[i]){
                    int a = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = a;
                    sorted = false;
                }
            }
        }
    }

    public static void selectionSort(int[] array){
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]){
                    minIndex = j;
                }
            }
            if (minIndex != i){
                int a = array[i];
                array[i] = array[minIndex];
                array[minIndex] = a;
            }
        }
    }

    public static void insertionSort(int[] array){
        for (int i = 1; i < array.length; i++) {
            int current = array[i];
            int k = i;
            while (k > 0 && array[k - 1] > current){
                array[k] = array[k - 1];
                k--;
            }
            array[k] = current;
        }
    }

    public static void shellSort(int[] array){

    }
}