package com.epam.rd.autotasks;

import java.util.Arrays;

class CycleSwap {
    static void cycleSwap(int[] array) {
        if (array.length != 0){
            int [] copyArray = new int[array.length];
            System.arraycopy(array, 0, copyArray, 1, array.length - 1);
            copyArray[0] = array[array.length - 1];
            System.arraycopy(copyArray, 0, array, 0, array.length);
        }
    }

    static void cycleSwap(int[] array, int shift) {
        if (array.length != 0){
            int [] copyArray = new int[array.length];
            shift = shift % array.length;
            System.arraycopy(array, 0, copyArray, shift, array.length - shift);
            System.arraycopy(array, array.length - shift, copyArray, 0, shift);
            System.arraycopy(copyArray, 0, array, 0, array.length);
        }
    }




}
