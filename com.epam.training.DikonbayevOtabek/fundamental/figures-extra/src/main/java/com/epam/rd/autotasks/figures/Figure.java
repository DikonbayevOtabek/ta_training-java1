package com.epam.rd.autotasks.figures;

abstract class Figure{

    public abstract Point centroid();
    public abstract Point getPoint1();
    public abstract Point getPoint2();
    public abstract Point getPoint3();
    public abstract Point getPoint4();
    public abstract double radius();
    public abstract boolean isTheSame(Figure figure);
}
