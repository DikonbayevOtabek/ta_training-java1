package com.epam.rd.autotasks;


public class CompleteByRequestTask implements Task {
    int flag = 0;
    public CompleteByRequestTask() {
    }

    @Override
    public boolean execute() {
        if (flag == 1){
            flag = 2;
            return true;
        } else if (flag == 2) {
            return false;
        } else{
            return true;
        }
    }

    @Override
    public boolean isFinished() {
        return flag == 2;
    }

    public void complete() {
        flag = 1;
    }

    public static void main(String[] args) {
        CompleteByRequestTask task =new CompleteByRequestTask();
        System.out.println(task.execute());
        task.complete();
        System.out.println(task.isFinished());
        System.out.println(task.execute());
        System.out.println(task.execute());
        System.out.println(task.isFinished());


    }
}
