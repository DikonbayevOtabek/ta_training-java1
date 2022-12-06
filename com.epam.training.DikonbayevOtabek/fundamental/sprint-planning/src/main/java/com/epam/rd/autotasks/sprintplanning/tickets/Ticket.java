package com.epam.rd.autotasks.sprintplanning.tickets;

public class Ticket {
    int id, estimate;
    String name;
    boolean complete;

    public Ticket(int id, String name, int estimate) {
        this.id = id;
        this.name = name;
        this.estimate =estimate;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    public int getEstimate() {
        return estimate;
    }

    public boolean isCompleted() {
        return complete;
    }

    public void complete() {
        if (!complete){
            complete = true;
        }
    }
    public void setComplete(boolean complete){
        this.complete =complete;
    }

}
