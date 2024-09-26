package com.epam.rd.autotasks;

public class CarouselRun {

    int [] arr;
    int i = 0, flag = 0, scope = 1;
    public CarouselRun(int [] arr){
        this.arr = arr;
    }
    public CarouselRun(int [] arr, int flag){
        this.arr = arr;
        this.flag = flag;
    }

    public int next() {
        if(isFinished()){
            return -1;
        }

        if (i == arr.length){
            i = 0;
            ++scope;
        }
        while(arr[i] <= 0){
            i++;
            if (i == arr.length){
                i = 0;
                ++scope;
            }
        }
        if (flag == 0){
            return arr[i++]--;
        }else{
            int result = arr[i];
            arr[i] = arr[i] - scope;
            i++;
            return result;
        }
    }
    public boolean isFinished() {
        if (arr.length == 0) {
            return true;
        }else if (flag == 1) {
            for (int num : arr){
                if(num > 0)
                    return false;
            }
            return true;
        }else {
            int count = 0;
            for (int elem : arr){
                if (elem <= 0){
                    ++count;
                }
            }
            return count == arr.length;
        }
    }

}
