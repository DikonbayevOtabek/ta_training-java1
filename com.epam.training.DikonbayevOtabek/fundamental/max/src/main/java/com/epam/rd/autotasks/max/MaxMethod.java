package com.epam.rd.autotasks.max;

import org.w3c.dom.ls.LSOutput;

public class MaxMethod {
    public static int max(int[] values) {

        int result = -1;
        for (int i = 0; i < values.length; ++i){
            if (i == 0){
                result = values[0];
            }else if (result < values[i]){
                result = values[i];
            }
        }
        return  result;
    }
    public static void main(String[] args) {
        int [] vals = new int[]{12, 3, -1, 23, 0, -3};
        System.out.println(max(vals));
    }
}

