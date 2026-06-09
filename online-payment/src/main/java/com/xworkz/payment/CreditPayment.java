package com.xworkz.payment;

public class CreditPayment {
    public static void main(String[] args) {
        System.out.println("payment credited");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch(ClassNotFoundException exception)
        {
            throw new RuntimeException(exception);
        }
    }
}
