package com.epam.rd.autotasks;

public class CarouselRun {

    int [] arr;
    int i = 0;
    public CarouselRun(int [] arr){
        this.arr = arr;
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
            return arr[i++]--;
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

    public static void main(String[] args) {


        DecrementingCarousel object = new DecrementingCarousel(7);
        object.addElement(1);
        object.addElement(2);

        CarouselRun run = object.run();
        System.out.println(run.next());
        System.out.println(run.next());


        System.out.println(run.next());
        System.out.println(run.next());
        }





    }
