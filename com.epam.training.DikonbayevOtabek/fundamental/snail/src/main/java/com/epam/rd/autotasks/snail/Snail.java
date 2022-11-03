package com.epam.rd.autotasks.snail;

import java.util.Scanner;

public class Snail
{
    public static void main(String[] args)
    {
        //Write a program that reads a,b and h (line by lyne in this order) and prints
        //the number of days for which the snail reach the top of the tree.
        //a - feet that snail travels up each day, b - feet that slides down each night, h - height of the tree
        String A, B, H;
        Scanner scan = new Scanner(System.in);
        A = scan.nextLine();
        B = scan.nextLine();
        H = scan.nextLine();
        int a = Integer.parseInt(A);
        int b = Integer.parseInt(B);
        int h = Integer.parseInt(H);
        if (a >= b){
            if (a == b && a < h)
                System.out.println("Impossible");
            else if (a == b && a >= h){
                System.out.println(1);
            }
            else{
                int  i = 1;
                while(i * (a - b)  + a <= h){
                    i++;
                }
                System.out.println(i);
            }
        }else if (a >= h && a < b){
            System.out.println(1);
        }else {
            System.out.println("Impossible");
        }


    }
}
