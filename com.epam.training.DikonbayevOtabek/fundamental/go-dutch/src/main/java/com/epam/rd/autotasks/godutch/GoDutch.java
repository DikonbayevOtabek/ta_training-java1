package com.epam.rd.autotasks.godutch;

import java.util.Scanner;

public class GoDutch {

    public static void main(String[] args) {
        //Write code here
        int totalBill, numberOfFriends;
        Scanner scan = new Scanner(System.in);
        totalBill = scan.nextInt();
        numberOfFriends = scan.nextInt();

        if (totalBill < 0){
            System.out.println("Bill total amount cannot be negative");
        }else {
            if (numberOfFriends <= 0){
                System.out.println("Number of friends cannot be negative or zero");
            }
            else{
                System.out.println((totalBill  + totalBill / 10) / numberOfFriends);
            }
        }

    }
}
