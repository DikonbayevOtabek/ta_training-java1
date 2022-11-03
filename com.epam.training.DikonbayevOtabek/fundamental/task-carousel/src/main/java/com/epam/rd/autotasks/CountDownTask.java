package com.epam.rd.autotasks;

public class CountDownTask implements Task{

    int countdown;
    public CountDownTask(int value) {
        if (value < 0){
            countdown = 0;
        }else{
            countdown = value;
        }
    }

    public int getValue() {
        return countdown;
    }


    @Override
    public boolean execute() {
        if (countdown == 0){
            return false;
        }else{
            --countdown;
            return true;
        }
    }

    @Override
    public boolean isFinished() {
        return countdown == 0;
    }
}
