package com.sapient.grooming.Week4;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

class CompletableFutureSumExample{
    CompletableFuture<Integer> completableFuture1 = CompletableFuture.supplyAsync(()->{
        int sum=0;
        for (int itr=1; itr<=10; itr++){
            sum=sum+itr;
        }
        System.out.println("Thread name - " + Thread.currentThread().getName());
        return sum;
    });
    CompletableFuture<Integer> completableFuture2 = CompletableFuture.supplyAsync(()->{
        int sum=0;
        for (int itr=11; itr<=20; itr++){
            sum=sum+itr;
        }
        System.out.println("Thread name - " + Thread.currentThread().getName());
        return sum;
    });
    CompletableFuture<Integer> completableFuture3 = CompletableFuture.supplyAsync(()->{
        int sum=0;
        for (int itr=21; itr<=30; itr++){
            sum=sum+itr;
        }
        System.out.println("Thread name - " + Thread.currentThread().getName());
        return sum;
    });

    CompletableFuture<Integer> overall = completableFuture1.thenCombine(completableFuture2,(a,b) -> a+b)
            .thenCombine(completableFuture3,(a,b) -> a+b);
}

public class Question2 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFutureSumExample completableFutureSumExample = new CompletableFutureSumExample();
        System.out.println("Overall sum " + completableFutureSumExample.overall.get());
    }
}

