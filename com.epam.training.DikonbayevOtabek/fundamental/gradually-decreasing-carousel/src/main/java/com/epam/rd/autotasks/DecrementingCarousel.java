package com.epam.rd.autotasks;

public class DecrementingCarousel {
    int capacity, i = 0, run = 0;
    int [] arr;
    public DecrementingCarousel(int capacity) {
        this.capacity = capacity;
        arr = new int[capacity];
    }

    public int getFlag(){
        return run;
    }
    public int [] getArr(){
        int [] result = new int[i];
        if (capacity > 0){
            for (int j = 0; j < arr.length; ++j){
                if (arr[j] > 0){
                    result[j] = arr[j];
                }
            }
        }
        return result;
    }
    public void setFlag(int number){
        run = number;
    }

    public boolean addElement(int element){
        if (element <= 0){
            return false;
        }else if (i >= arr.length){
            return false;
        }else if (run == 1){
            return false;
        }else{
            arr[i] = element;
            ++i;
            return true;
        }
    }

    public CarouselRun run(){
        if (run == 0){
            int [] result = new int[i];
            run = 1;
            if (capacity > 0){
                for (int j = 0; j < arr.length; ++j){
                    if (arr[j] > 0){
                        result[j] = arr[j];
                    }
                }
            }
            return new CarouselRun(result);
        }else{
            return null;
        }

    }

}
