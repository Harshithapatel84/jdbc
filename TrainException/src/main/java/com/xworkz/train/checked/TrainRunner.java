package com.xworkz.train.checked;

public class TrainRunner {
    public static void main(String[] args) {


                System.out.println("Application started");

                TrainCreator creator = new TrainCreator();

                System.out.println("Train object created");

                try {
                    System.out.println("Trying to register train");
                    creator.registerTrain("Onde bharath");
                    System.out.println("Train registration process completed");

                } catch (Exception e) {

                    System.err.println("Exception handled in main method");
                }

                System.out.println("Continuing execution");
                System.out.println("Displaying train details");

            }
        }
