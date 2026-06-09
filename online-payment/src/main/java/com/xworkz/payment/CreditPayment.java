package com.xworkz.payment;

import in.xworkz.payment.DebitPayment;

public class CreditPayment {
    public static void main(String[] args) {
        System.out.println("payment credited");
        try {
            Class.forName("in.xworkz.payment.DebitPayment");
        }catch(ClassNotFoundException exception)
        {
            throw new RuntimeException(exception);
        }
        System.out.println("credited payment successfully");
        DebitPayment.pay();
    }
}
