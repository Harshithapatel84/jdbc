
    package com.xworkz.train.checked;

    public class TrainCreator {

        public void registerTrain(String trainName) throws Exception {

            System.out.println("Entered registerTrain method");

            if (trainName == null || trainName.trim().length() < 4) {

                System.err.println("Train name validation failed");

                throw new Exception("Invalid train name");
            }

            System.out.println("Validation completed");
            System.out.println("Train registered successfully");
        }
    }

