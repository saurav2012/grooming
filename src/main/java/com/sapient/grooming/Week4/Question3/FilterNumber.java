package com.sapient.grooming.Week4.Question3;

import org.springframework.data.mongodb.core.aggregation.ArrayOperators;

import java.util.concurrent.RecursiveTask;

public class FilterNumber extends RecursiveTask<Integer> {

    private int target;
    private int startRange;
    private int endRange;
    private int limit = 100;

    public FilterNumber(int target, int startRange, int endRange, int limit) {
        this.target = target;
        this.startRange = startRange;
        this.endRange = endRange;
        this.limit = limit;
    }

    @Override
    protected Integer compute() {
        if(endRange-startRange == limit){
            return filterNumber();
        }
        for (int i=startRange; i <= endRange; i=i+limit){
            FilterNumber filterNumber = new FilterNumber(target,startRange,endRange-limit,limit);
            filterNumber.fork();
            return filterNumber.join() + filterNumber();
        }
        return 0;
    }

    private int filterNumber(){
        int cnt = 0;
        for(int itr = startRange; itr<=endRange; itr++){
            if(Integer.toString(itr).contains(Integer.toString(target))) {
                cnt++;
            }
        }
        return cnt;
    }
}
