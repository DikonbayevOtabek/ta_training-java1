package com.epam.rd.autotasks;

public class CarouselRun {

    int [] arr;
    int i = 0, actionLimit = -1, counter = 0, flag = 0;
    public CarouselRun(int [] arr){
        this.arr = arr;
    }
    public CarouselRun(int [] arr, int flag, int actionLimit){
        this.arr = arr;
        this.flag =flag;
        this.actionLimit =actionLimit;
    }

    public int next() {
        if(isFinished()){
            return -1;
        }
        if (i == arr.length){
            i = 0;
        }
        while (arr[i] <= 0){
            ++i;
            if(i == arr.length){
                i = 0;
            }
        }
        if(flag == 0){
            return arr[i++]--;
        }else{
            ++counter;
            return arr[i++]--;
        }
    }

    public boolean isFinished() {
        if (arr.length == 0) {
            return true;
        }
        if (flag == 1 && counter == actionLimit){
           return true;
        }
        int count = 0;
        for (int elem : arr){
            if(elem == 0){
                ++count;
            }
        }
        return count == arr.length;
    }

    public static void main(String[] args) {
        DecrementingCarousel carousel = new DecrementingCarouselWithLimitedRun(15, 10);
        //5, 7, 5, 8, 2, 3, 3, 1, 1, 6, 10, 10, 4,
        carousel.addElement(5);
        carousel.addElement(7);
        carousel.addElement(5);
        carousel.addElement(8);
        carousel.addElement(2);
        carousel.addElement(3);
        carousel.addElement(3);
        carousel.addElement(1);
        carousel.addElement(1);
        carousel.addElement(6);
        carousel.addElement(10);
        carousel.addElement(10);
        carousel.addElement(4);
        CarouselRun run = carousel.run();
        int son = 1;
        while (son <= 11){
            ++son;
            System.out.println(run.next());
        }
    }
}
