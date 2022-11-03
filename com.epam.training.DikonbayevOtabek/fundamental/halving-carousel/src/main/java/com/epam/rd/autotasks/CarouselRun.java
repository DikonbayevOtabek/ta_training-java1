package com.epam.rd.autotasks;

public class CarouselRun {

    int [] arr;
    int i = 0;
    private final int flagHalving;
    public CarouselRun(int [] arr){
        this.arr = arr;
        flagHalving = 0;
    }
    public CarouselRun(int [] arr, int flag){
        this.arr = arr;
        flagHalving =flag;
    }

    public int next() {

        if (i == arr.length){
            i = 0;
        }
        if (arr.length > 0){
            while(arr[i] == 0){
                i++;

                if (i == arr.length){
                    i = 0;
                }
                int number = 0;
                for (int k : arr) {
                    if (k == 0) {
                        ++number;
                    }
                    if (number == arr.length) {
                        return -1;
                    }
                }
            }
            if (flagHalving == 0){
                return arr[i++]--;
            }else{
                int result = arr[i];
                arr[i] = arr[i] / 2;
                i++;
                return result;
            }
        }else{
            return -1;
        }
    }

    public boolean isFinished() {
        if (arr.length == 0) {
            return true;
        } else {
            int count = 0;
            for (int elem : arr){
                if (elem == 0){
                    ++count;
                }
            }
            return count == arr.length;
        }
    }
}
