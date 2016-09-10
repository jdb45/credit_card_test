package com.jeremy;

import java.util.Scanner;

public class CreditCard {

    static Scanner stringScanner = new Scanner(System.in);

    public static void main(String[] args) {

        //Ask user for credit card number. store number as a String.
        System.out.println("Please enter the credit card number, digits only:");
        String ccNumber = stringScanner.nextLine();
        boolean isValid = isValidCreditCard(ccNumber);

        //if statement to let the user know if the card number is valid or not
        if (isValid) {
            System.out.println("This seems to be a valid credit card number");
        } else {
            System.out.println("This is **not** a valid credit card number.");
        }

        stringScanner.close();
    }

    //creating the method to check if the credit card is valid or not
    public static boolean isValidCreditCard(String cc) {

        //splitting the user input string into each a single value and assigning it to an array
        String[] stringArray = cc.split("");
        //using the user input to get the length on the int array
        int[] convertedArray = new int[cc.length()];
        //initializing the variables
        int singleNumber = 0;
        int doubleNumber = 0;
        int totalEven = 0;


        //for loop to count the length, and assign a value to each entry on the array
        for (int numbers = 0; numbers < stringArray.length; numbers++) {

            //assigning the values to the final array and converting the string array values to int values
            convertedArray[numbers] = Integer.parseInt(stringArray[numbers]);
        }
        //if statement to check if the first number of the card is a 4 or not
        if(convertedArray[0] == 4) {

            //the first for loop will check all the odd values on the card and add them together
            for (int oddNumbers = 1; oddNumbers < convertedArray.length; oddNumbers = oddNumbers + 2) {
                singleNumber = +singleNumber + convertedArray[oddNumbers];
            }
            //the second for loop will check all the values of the evenNumbers times them by 2 and add them together
            for (int evenNumbers = 0; evenNumbers < convertedArray.length; evenNumbers = evenNumbers + 2) {
                doubleNumber = +(convertedArray[evenNumbers] * 2);
                /*if statement will check if the value is over 10, if the value is, it will divide the number by 10 to
                get a remainder and next will divide  by 10 without checking for a remainder and add both totals
                */
                if (doubleNumber >= 10) {
                    int ramDivideNumber = doubleNumber % 10;
                    int divideNumber = doubleNumber / 10;
                    int totalNum = ramDivideNumber + divideNumber;
                    totalEven = + totalEven + totalNum;
                } else {
                    totalEven = + totalEven + doubleNumber;

                }
            }
        }
        //will return false if the first number is not 4
        else{ return false;
        }
        //getting the total number and dividing without a remainder
        int numberReturn = (totalEven + singleNumber) % 10;
        //final if boolean to check if the value is 0 or not
        if(numberReturn == 0){
            return true;}
        else{
            return false;
        }


    }


}
