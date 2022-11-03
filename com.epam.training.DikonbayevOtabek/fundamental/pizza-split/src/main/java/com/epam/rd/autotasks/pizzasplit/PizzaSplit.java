package com.epam.rd.autotasks.pizzasplit;

import java.util.Scanner;

public class PizzaSplit {
    public static void main(String[] args) {
        //Write a program, reading number of people and number of pieces per pizza and then
        //printing minimum number of pizzas to order to split all the pizzas equally and with no remainder
        Scanner scan = new Scanner(System.in);
        int numOfPeople = scan.nextInt();
        int numOfPieces = scan.nextInt();
        int slices = numOfPieces;
        int ekuk = 1;
        if (numOfPeople >= numOfPieces){
            for (int i = 2; i <= numOfPieces; ++i){
                if (numOfPeople % i == 0 && numOfPieces % i == 0){
                    ekuk *= i;
                    numOfPeople /= i;
                    numOfPieces /= i;
                    --i;
                }else if (numOfPeople % i == 0){
                    ekuk *= i;
                    numOfPeople /= i;
                    --i;
                }else if (numOfPieces % i == 0){
                    ekuk *= i;
                    numOfPieces /= i;
                    --i;
                }
            }
        }else{
            for (int i = 2; i <= numOfPeople; ++i){
                if (numOfPeople % i == 0 && numOfPieces % i == 0){
                    ekuk *= i;
                    numOfPeople /= i;
                    numOfPieces /= i;
                    --i;
                }else if (numOfPeople % i == 0){
                    ekuk *= i;
                    numOfPeople /= i;
                    --i;
                }else if (numOfPieces % i == 0){
                    ekuk *= i;
                    numOfPieces /= i;
                    --i;

                }
            }

        }

        ekuk = ekuk * numOfPieces * numOfPeople;
        System.out.println(ekuk / slices);

    }
}
