package com.xworkz.inbuilt.unchecked;

public class Multiple {
    public static void main(String[] args) {

                try {
                    String[] satellites = {"aryabhata", "chandrayan"};
                    System.out.println(satellites[5]);
                    int result=8/0;
                    System.out.println(result);

                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("ArrayIndexOutOfBoundsException handled");

                } catch (ArithmeticException e) {
                    System.out.println("ArithmeticException handled");

                } catch (Exception e) {
                    System.out.println("Exception Occurred");
                }


            }
        }


