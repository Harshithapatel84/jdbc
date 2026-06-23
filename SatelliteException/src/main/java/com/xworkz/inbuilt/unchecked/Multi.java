package com.xworkz.inbuilt.unchecked;

public class Multi {
    public static void main(String[] args) {

            try {
                String[] satellites = {"moon", "jupitor"};
                System.out.println(satellites[5]);
                int result=8/0;
                System.out.println(result);

            } catch (ArithmeticException|ArrayIndexOutOfBoundsException e) {
                System.out.println("Exception handled");

            }
        }
    }

