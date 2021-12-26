package com.kaliada.sandbox;

import java.util.ArrayList;
import java.util.List;

public class OutOfMemoryErrorGenerator {
    public static void main(String[] args) {
        List<Object> list = new ArrayList<>();
        while (true){
            list.add(new byte[65535]);
        }
    }
}
