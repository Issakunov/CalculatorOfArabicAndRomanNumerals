package com.company;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class RomanNumerals {
        // The operation which we get like a input
        private String oper = "";

    public RomanNumerals(String oper) {
        this.oper = oper;
    }
        // The map for the "romanToInt" method with roman numerals and arabic numerals
        private static final Map<Character, Integer> map = new HashMap<>(7);

        static {
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
    }
    /*
    In this method we are at first separating first and second roman numbers with relevant operators,then we are overriding the
     roman numerals to arabic numerals then we are parsing those arabic String numerals to int numbers, then we are doing our
     operation(addition, subtraction, division, multiplication), finally we are returning our result like roman numerals.
     */
        public void romanToInt()  {
        String firstOfAdditional = "";
        String secondOfAdditional = "";
        if (oper.contains("+")) {
            firstOfAdditional = oper.substring(0, oper.indexOf("+"));
            secondOfAdditional = oper.substring(oper.indexOf("+") + 1);
        }
        if (oper.contains("-")) {
            firstOfAdditional = oper.substring(0, oper.indexOf("-"));
            secondOfAdditional = oper.substring(oper.indexOf("-") + 1);
        }
        if (oper.contains("*")) {
            firstOfAdditional = oper.substring(0, oper.indexOf("*"));
            secondOfAdditional = oper.substring(oper.indexOf("*") + 1);
        }
        if (oper.contains("/")) {
            firstOfAdditional = oper.substring(0, oper.indexOf("/"));
            secondOfAdditional = oper.substring(oper.indexOf("/") + 1);
        }
        //first arabic number of roman number
        int sum = 0;
        int len = firstOfAdditional.length() - 1;
        for (int i = 0; i < len; i++) {
            if (map.get(firstOfAdditional.charAt(i)) < map.get(firstOfAdditional.charAt(i + 1))) {
                sum -= map.get(firstOfAdditional.charAt(i));
            } else {
                sum += map.get(firstOfAdditional.charAt(i));
            }
        }
        sum += map.get(firstOfAdditional.charAt(len));
        //second arabic number of roman number
        int sum2 = 0;
        int len2 = secondOfAdditional.length() - 1;
        for (int i = 0; i < len2; i++) {
            if (map.get(secondOfAdditional.charAt(i)) < map.get(secondOfAdditional.charAt(i + 1))) {
                sum2 -= map.get(secondOfAdditional.charAt(i));
            } else {
                sum2 += map.get(secondOfAdditional.charAt(i));
            }
        }
        sum2 += map.get(secondOfAdditional.charAt(len2));

        if (oper.contains("+")) {
            int q1 = sum + sum2;
            intToRoman(q1);
        }
        if (oper.contains("-")) {
            int q1 = sum - sum2;
            intToRoman(q1);
        }
        if (oper.contains("*")) {
            int q1 = sum * sum2;
            intToRoman(q1);
        }
        if (oper.contains("/")) {
            int q1 = sum / sum2;
            intToRoman(q1);
        }
    }
        // A map for "intToRoman" with arabic numerals and roman numerals
        private static final TreeMap<Integer, String> map2 = new TreeMap<>(Collections.reverseOrder());
        static {
        map2.put(1000, "M");
        map2.put(900, "CM");
        map2.put(500, "D");
        map2.put(400, "CD");
        map2.put(100, "C");
        map2.put(90, "XC");
        map2.put(50, "L");
        map2.put(40, "XL");
        map2.put(10, "X");
        map2.put(9, "IX");
        map2.put(5, "V");
        map2.put(4, "IV");
        map2.put(1, "I");
    }
        // Overriding the arabic numerals to roman numerals
        public void intToRoman(int num) {
        StringBuilder roman = new StringBuilder("");
        for (Integer i: map2.keySet()) {
            for (int j = 1; j <= num / i; j++) {
                roman.append(map2.get(i));
            }
            num %= i;
        }
        String a = roman.toString();
        System.out.println(a);
    }
}
