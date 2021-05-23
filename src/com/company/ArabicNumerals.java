package com.company;

public class ArabicNumerals {
    private String opr = "";

    public ArabicNumerals(String opr) {
        this.opr = opr;
    }
    /*
    Here we are separating the first and the second numbers from the input of String type, then we are parsing them into
     arabic numerals, then there are happening operation with relevant operator
     */
    public void parsing() {
        String operator = "";
        if (opr.contains("+")) {
            operator += "+";
        } else if (opr.contains("*")) {
            operator += "*";
        } else if (opr.contains("-")) {
            operator += "-";
        } else if (opr.contains("/")) {
            operator += "/";
        }
        switch (operator) {
            case "+" -> {
                int firstAddition = Integer.parseInt(opr.substring(0, opr.indexOf("+")));
                int senconAddition = Integer.parseInt(opr.substring(opr.indexOf("+") + 1));
                System.out.println(firstAddition + senconAddition);
            }
            case "-" -> {
                int firstSubstraction = Integer.parseInt(opr.substring(0, opr.indexOf("-")));
                int senconSubstraction = Integer.parseInt(opr.substring(opr.indexOf("-") + 1));
                System.out.println(firstSubstraction - senconSubstraction);
            }
            case "*" -> {
                int firstMultiplicaton = Integer.parseInt(opr.substring(0, opr.indexOf("*")));
                int senconMulstiplicaton = Integer.parseInt(opr.substring(opr.indexOf("*") + 1));
                System.out.println(firstMultiplicaton * senconMulstiplicaton);
            }
            case "/" -> {
                int firstDivision = Integer.parseInt(opr.substring(0, opr.indexOf("/")));
                int senconDivision = Integer.parseInt(opr.substring(opr.indexOf("/") + 1));
                System.out.println(firstDivision / senconDivision);
            }
            default -> System.out.println("Wrong operation!");
        }
    }
}
