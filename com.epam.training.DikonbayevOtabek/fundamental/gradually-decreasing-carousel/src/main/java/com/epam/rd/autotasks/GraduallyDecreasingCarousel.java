package com.epam.rd.autotasks;

public class GraduallyDecreasingCarousel extends DecrementingCarousel{

    public GraduallyDecreasingCarousel(final int capacity) {
        super(capacity);
    }

    public CarouselRun run(){
        if (getFlag() == 1){
            return null;
        }
        setFlag(1);
        return new CarouselRun(getArr(), 1);
    }


    public static void main(String[] args) {

        GraduallyDecreasingCarousel carousel = new GraduallyDecreasingCarousel(4);

        carousel.addElement(3);
        carousel.addElement(8);
        carousel.addElement(9);

        CarouselRun run = carousel.run();

        System.out.println(run.next());
        System.out.println(run.next());
        System.out.println(run.next());
        System.out.println(run.next());
        System.out.println(run.next());
        System.out.println(run.next());
        System.out.println(run.next());
        System.out.println(run.isFinished());
        System.out.println(run.next());
        System.out.println(run.next());
        System.out.println(run.next());
        System.out.println(run.isFinished());
        System.out.println(run.next());
        System.out.println(run.isFinished());
    }
}
