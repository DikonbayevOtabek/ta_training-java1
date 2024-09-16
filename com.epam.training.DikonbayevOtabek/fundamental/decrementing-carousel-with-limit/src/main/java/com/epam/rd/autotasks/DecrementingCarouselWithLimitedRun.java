package com.epam.rd.autotasks;

public class DecrementingCarouselWithLimitedRun extends DecrementingCarousel{
    final int actionLimit;
    public DecrementingCarouselWithLimitedRun(final int capacity, final int actionLimit) {
        super(capacity);
        this.actionLimit = actionLimit;
    }
    @Override
    public CarouselRun run(){
        if (getFlag() == 1){
            return null;
        }
        setFlag(1);
        return new CarouselRun(getArr(), 1, actionLimit);
    }
}
