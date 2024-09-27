package com.epam.rd.autotasks.matrices;
import java.util.Arrays;

public class MultiplyMatrix {
    public static int[][] multiply(int[][] matrix1, int[][] matrix2) {
        /*
            a = { {0,  12145},
                  {4509,    0},
                  {3,      567} }
            b = { {653, 0, 25353},
                  {0,   61,    6} }
        */



        int [][] result = new int[matrix1.length][matrix2[0].length];
        for (int i = 0; i < matrix1.length; ++i){
            int a = 0;
            while(a < matrix2[0].length) {
                int  sum = 0;
                for (int j = 0; j < matrix2.length; ++j) {
                    sum += matrix1[i][j] * matrix2[j][a];

                }

                result[i][a] = sum;
                ++a;
            }
        }

        return result;
    }

    public static void main(String[] args) {

        System.out.println("Test your code here!\n");

        // Get a result of your code

        int[][] a = { {0, 12145}, {4509, 0}, {3, 567} };

        int[][] b = { {653, 0, 25353}, {0, 61, 6} };

        int[][] result = multiply(a, b);
        System.out.println(Arrays.deepToString(result).replace("],", "]\n"));
    }
}
