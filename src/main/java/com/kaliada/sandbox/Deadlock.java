package com.kaliada.sandbox;

public class Deadlock {
    private String name;

    public Deadlock(String name) {
        this.name = name;
    }

    public synchronized void sayHello(Deadlock deadlock){
        System.out.println(name + " says hello to " + deadlock.name);
        deadlock.sayBye();
    }

    public synchronized void sayBye(){
        System.out.println(name + " says bye");
    }

    public static void main(String[] args) {
        Deadlock deadlockOne = new Deadlock("One");
        Deadlock deadlockTwo = new Deadlock("Two");
        new Thread(()->deadlockOne.sayHello(deadlockTwo)).start();
        new Thread(()->deadlockTwo.sayHello(deadlockOne)).start();
    }
}
