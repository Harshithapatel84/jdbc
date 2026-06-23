package com.xworkz.inbuilt.checked;

public class SingleCatch {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("ClassNotFoundException handled");
        }
    }
}
