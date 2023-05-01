package com.sapient.grooming.Week4;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

class CompletableFutureSumExample{
    public Integer sumFromRange(int start, int end){
        try{
            CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(()->{
                int sum=0;
                for (int itr=start; itr<=end; itr++){
                    sum=sum+itr;
                }
                System.out.println("Thread name - " + Thread.currentThread().getName());
                return sum;
            });
            return completableFuture.get();

        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        return 0;
    }

}

public class Question2 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFutureSumExample completableFutureSumExample = new CompletableFutureSumExample();

        Integer sum1to10 = completableFutureSumExample.sumFromRange(1,10);
        Integer sum11to20 = completableFutureSumExample.sumFromRange(11,20);
        Integer summ21to20 = completableFutureSumExample.sumFromRange(21,30);

        System.out.println(sum1to10 + sum11to20 + summ21to20);
    }
}

