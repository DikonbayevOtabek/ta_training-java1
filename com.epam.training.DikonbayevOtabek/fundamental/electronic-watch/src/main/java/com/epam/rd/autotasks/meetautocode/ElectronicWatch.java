package com.epam.rd.autotasks.meetautocode;

import java.util.Scanner;

public class ElectronicWatch {
    public static void main(String[] args) {
        int hour = 0, minut = 0, second = 0;
        int intSeconds = 0;
        Scanner scan = new Scanner(System.in);
        intSeconds = scan.nextInt();
        second = intSeconds % 60;
        int second1 = second / 10;
        int second2 = second % 10;
        intSeconds = intSeconds - second;
        minut = intSeconds / 60;
        hour = intSeconds / 3600;
        minut = minut - hour * 60;
        int minut1 = minut / 10;
        int minut2 = minut % 10;
        System.out.println((hour % 24) + ":" + minut1 + minut2 + ":" + second1 + second2);


    }
}
