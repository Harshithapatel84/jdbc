package com.xworkz.inbuilt.unchecked;

public class Single {
    public static void main(String[] args) {
        try {
                int value = 4/0;
                System.out.println(value);

            } catch (ArithmeticException e) {
                System.out.println("ArithmeticException handled");
            }
        }
    }

