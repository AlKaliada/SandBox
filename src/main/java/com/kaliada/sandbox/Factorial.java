package com.kaliada.sandbox;

public class Factorial {

    public static int countFactorial(int number){
        if (number == 0){
            return 1;
        }
         return number * countFactorial(number - 1);
    }
}
