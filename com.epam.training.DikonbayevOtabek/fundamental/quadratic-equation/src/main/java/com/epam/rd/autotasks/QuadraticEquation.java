package com.epam.rd.autotasks;

import java.util.Locale;
import java.util.Scanner;

import static java.lang.Math.sqrt;

public class QuadraticEquation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();
        double Diskriminant = Math.sqrt(b * b - 4 * a * c);
        double x1, x2;
        if (Diskriminant > 0){
            x1 = (-b + Diskriminant) / (2 * a);
            x2 = (-b - Diskriminant) / (2 * a);
            System.out.println(x1 + " " + x2);
        }else if (Diskriminant ==0){
            x1 = -b / (2 * a);
            System.out.println(x1);
        }else{
            System.out.println("no roots");
        }



    }

}