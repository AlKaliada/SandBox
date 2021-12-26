package com.kaliada.sandbox;

public class RaceCondition {
    public static void main(String[] args) {
        //cooking scrambled eggs
        new Thread(()-> {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("take eggs");
        }).start();
        new Thread(()-> {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("broke eggs");
        }).start();
        new Thread(()-> {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("cook eggs");
        }).start();
        new Thread(()-> {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("eat eggs");
        }).start();
    }
}
