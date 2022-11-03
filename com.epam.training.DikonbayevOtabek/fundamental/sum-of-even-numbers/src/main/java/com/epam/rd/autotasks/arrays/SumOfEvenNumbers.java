package com.epam.rd.autotasks.arrays;

public class SumOfEvenNumbers {

    public static void main(String[] args) {
        int[] array = new int[]{1, 3, 2, 8, 15, 199};

        System.out.println(sum(array));
    }

    public static int sum(int[] array){

        //put your code here
        int result = 0;
        if (array == null || array.length == 0){
            return result;
        }
        for (int j : array) {
            if (j % 2 == 0) {
                result += j;
            }
        }
        return result;


    }


}
