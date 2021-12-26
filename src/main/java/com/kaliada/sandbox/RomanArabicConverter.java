package com.kaliada.sandbox;

import java.util.LinkedHashMap;
import java.util.Map;

public class RomanArabicConverter {
    static Map<String, Integer> map = new LinkedHashMap<>();
    static {
        map.put("M", 1000);
        map.put("D", 500);
        map.put("C", 100);
        map.put("L", 50);
        map.put("X", 10);
        map.put("V", 5);
        map.put("I", 1);
    }

    public static void main(String[] args) {
        System.out.println(toRoman(5));
        System.out.println(fromRoman("MCMXC"));
    }

    public static String toRoman(int n) {
        StringBuilder builder = new StringBuilder();
        while(n > 0) {
            String previous = null;
            String fifth = null;
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                if (entry.getKey().equals("D") || entry.getKey().equals("L") || entry.getKey().equals("V")){
                    fifth = entry.getKey();
                    continue;
                }
                int a = n / entry.getValue();
                if (a == 9 && previous != null) {
                    builder.append(entry.getKey()).append(previous);
                    n = n - map.get(previous) + entry.getValue();
                }else if (a <= 8 && a >= 5 && fifth != null){
                    builder.append(fifth);
                    n -= map.get(fifth);
                    for (int i = 0; i < (a - 5); i++) {
                        builder.append(entry.getKey());
                        n -= entry.getValue();
                    }
                }else if (a == 4 && fifth != null){
                    builder.append(entry.getKey()).append(fifth);
                    n = n - map.get(fifth) + entry.getValue();
                }else if (a > 0){
                    for (int i = 0; i < a; i++) {
                        builder.append(entry.getKey());
                        n -= entry.getValue();
                    }
                }
                previous = entry.getKey();
            }
        }
        return builder.toString();
    }

    public static int fromRoman(String romanNumeral) {
        String[] numbers = romanNumeral.split("");
        int result = numbers.length > 0 ? map.get(numbers[numbers.length - 1]) : 0;
        for(int i = numbers.length - 2; i >= 0; i--){
            int a = map.get(numbers[i]) >= map.get(numbers[i + 1]) ? map.get(numbers[i]) : -map.get(numbers[i]);
            result += a;
        }
        return result;
    }
}
