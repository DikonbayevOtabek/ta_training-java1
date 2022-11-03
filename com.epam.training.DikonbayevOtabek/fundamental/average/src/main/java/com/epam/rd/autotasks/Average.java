package com.epam.rd.autotasks;

import java.util.Scanner;

public class Average {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Use Scanner methods to read input
        int number = -1, i = 0, summNums = 0;
        while(number != 0){
            number = scanner.nextInt();
            summNums += number;
            ++i;
        }
        System.out.println(summNums / (i - 1));


    }

}