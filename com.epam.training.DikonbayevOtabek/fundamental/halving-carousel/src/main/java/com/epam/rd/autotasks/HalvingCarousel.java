package com.epam.rd.autotasks;

public class HalvingCarousel extends DecrementingCarousel {

    int run = 0;
    public HalvingCarousel(final int capacity) {
        super(capacity);

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
        if (getFlagRun() == 1) {
            return null;
        }
        setFlagRun((byte) 1);
        run = 1;
        return new CarouselRun(getContainer(), 1);
    }

    public static void main(String[] args) {

    }
}
