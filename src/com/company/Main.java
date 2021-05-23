package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try {
            do {
                String[] romanNumerals = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
                String[] arabicNumerals = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};

                List<String> listOfArabic = Arrays.asList(arabicNumerals);
                List<String> listOfRoman = Arrays.asList(romanNumerals);

                Scanner sc = new Scanner(System.in);
                String s1 = sc.nextLine();

                RomanNumerals roman = new RomanNumerals(s1);
                ArabicNumerals arabic = new ArabicNumerals(s1);


                String firstNumberForTesting = "";
                String secondNumberForTesting = "";
                if (s1.contains("+")) {
                    firstNumberForTesting = s1.substring(0, s1.indexOf("+"));
                    secondNumberForTesting = s1.substring(s1.indexOf("+") + 1);
                }
                if (s1.contains("-")) {
                    firstNumberForTesting = s1.substring(0, s1.indexOf("-"));
                    secondNumberForTesting = s1.substring(s1.indexOf("-") + 1);
                }
                if (s1.contains("*")) {
                    firstNumberForTesting = s1.substring(0, s1.indexOf("*"));
                    secondNumberForTesting = s1.substring(s1.indexOf("*") + 1);
                }
                if (s1.contains("/")) {
                    firstNumberForTesting = s1.substring(0, s1.indexOf("/"));
                    secondNumberForTesting = s1.substring(s1.indexOf("/") + 1);
                }
                List<String> firstAddition = new ArrayList<>();
                firstAddition.add(firstNumberForTesting);

                List<String> secondAddition = new ArrayList<>();
                secondAddition.add(secondNumberForTesting);


                if (listOfArabic.containsAll(firstAddition) && listOfArabic.containsAll(secondAddition)) {
                    System.out.println("Output");
                    arabic.parsing();
                } else if (listOfRoman.containsAll(firstAddition) && listOfRoman.containsAll(secondAddition)) {
                    System.out.println("Output");
                    roman.romanToInt();
                } else {
                    throw new MyException("You have entered a wrong operation\n" +
                            "You probably entered following syntax which are considered as a wrong operation: " +
                            "3+V or vise versa, 3++3 and etc.\n" +
                            "The syntax has to be like: 2+3 V*III only!");
                }
            } while (true) ;
        }
        catch(MyException e){
            e.printStackTrace();
        }
    }
}
