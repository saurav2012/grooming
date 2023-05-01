package com.sapient.grooming.Week4.Question3;

public class Main {
    public static void main(String[] args) {
        FilterNumber filterNumber = new FilterNumber(9,1,100,100);
        int count = filterNumber.compute();
        System.out.println(count);
    }
}
