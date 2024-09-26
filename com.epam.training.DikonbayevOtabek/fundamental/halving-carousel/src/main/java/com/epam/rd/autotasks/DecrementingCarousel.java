package com.epam.rd.autotasks;

public class DecrementingCarousel {
    int capacity, i = 0, run = 0;
    int [] arr;
    private byte flagRun = 0;
    public DecrementingCarousel(int capacity) {
        this.capacity = capacity;
        arr = new int[capacity];
    }
    public byte getFlagRun() {
        return flagRun;
    }

    public void setFlagRun(byte flagRun) {
        this.flagRun = flagRun;
    }

    public int[] getContainer() {
        return arr;
    }

    public int getI() {
        return i;
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
