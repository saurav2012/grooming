package com.sapient.grooming.TopicBased;

public class MultiThreading{
    public static void main(String[] args) throws InterruptedException {
//        MultiThreadingExample threadingExample = new MultiThreadingExample(1);
//        MultiThreadingExample threadingExample2 = new MultiThreadingExample(2);
//        threadingExample.start(); // it will create a new thread
//        threadingExample2.start();
//        threadingExample.run();  // it will run with single thread only
//        threadingExample2.run();

//        for runnable
        MultiThreadingWithRunnable multiThreadingWithRunnable = new MultiThreadingWithRunnable(0);
        MultiThreadingWithRunnable multiThreadingWithRunnable2 = new MultiThreadingWithRunnable(1);
        Thread myThread = new Thread(multiThreadingWithRunnable);
        Thread myThread2 = new Thread(multiThreadingWithRunnable2);
        myThread.start();
//        myThread.join(); // it will wait till one thread die
//        System.out.println(myThread.isAlive());
        myThread2.start();


        // session


    }
}


class MultiThreadingExample extends Thread{

    private int rem;
    public MultiThreadingExample(int rem){
        this.rem = rem;
    }

    @Override
    public void run() {
        for(int i=1; i<=5; i++){
            System.out.println(i+" from thread " + rem);
//            if(thredNum == 2) throw new RuntimeException("Error occur at thread 2");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class MultiThreadingWithRunnable implements Runnable{

    private int rem;
    public MultiThreadingWithRunnable(int rem){
        this.rem = rem;
    }

    @Override
    public void run() {

            for (int i = 1; i <= 20; i++) {
                if (i % 2 == rem) {
                    System.out.println(i + " from thread " + rem);
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
    }
}

