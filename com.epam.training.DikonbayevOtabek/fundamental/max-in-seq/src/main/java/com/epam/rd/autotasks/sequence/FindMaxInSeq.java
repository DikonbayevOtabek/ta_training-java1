package com.epam.rd.autotasks.sequence;
import java.util.Scanner;

public class FindMaxInSeq {
    public static int max() {

        Scanner scan = new Scanner(System.in);
        int number = -1, maxNum = -1;
        int i = 0;
        while(number != 0){
            i++;
            number = scan.nextInt();
            if (i == 1){
                maxNum = number;
            }else if (maxNum < number && number != 0){
                maxNum = number;
            }
        }
        return maxNum;
    }

    public static void main(String[] args) {





        System.out.println(max());
    }
}
