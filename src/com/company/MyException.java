package com.company;

public class MyException extends Exception{
    public MyException(){
    }
    public MyException(String discription) {
        super(discription);
    }
}