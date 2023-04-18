package com.sapient.grooming.weekWork.week2;

import java.util.Arrays;

public class GenericQuestion {

    public static < T extends Comparable<T> > void bubbleSort(T[] array){
        int n = array.length;
        T temp;

        for(int i=0; i<n; i++){
            for (int j=1; j<(n-i); j++){
                if(array[j-1].compareTo(array[j]) > 0){
                    temp =  array[j-1];
                    array[j-1] = array[j];
                    array[j] = temp;
                }
            }
        }
    }
    public static < T > void printArray( T[] inputArray ) {
        for(T element : inputArray) {
            System.out.println(element);
        }
    }

    public static void main(String[] args) {
        Integer[] intArray = { 5, 2, 3, 1, 4 };
        Double[] doubleArray = { 1.1, 2.2, 3.3, 4.4 };
        Character[] charArray = { 'H', 'E', 'L', 'L', 'O' };
        System.out.println("Array after sorting contains: ");
        bubbleSort(charArray);
        System.out.println(Arrays.toString(charArray));
    }
}
