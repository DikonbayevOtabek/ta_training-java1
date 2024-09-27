package com.epam.rd.autotasks.figures;

import java.util.Scanner;

import static java.lang.Math.sqrt;

class Circle extends Figure{

    Point center;
    double radius;

    @Override
    public Point getPoint1() {
        return center;
    }

    @Override
    public double radius() {
        return radius;
    }


    @Override
    public Point getPoint2() {
        return null;
    }

    @Override
    public Point getPoint3() {
        return null;
    }

    @Override
    public Point getPoint4() {
        return null;
    }

    public Circle(Point center, double radius) {
        this.center = center;
        this.radius = radius;
        if (center == null) throw new IllegalArgumentException();
        if (radius <= 0)  throw new IllegalArgumentException();
    }

    @Override
    public Point centroid() {
        return center;
    }

    @Override
    public boolean isTheSame(Figure figure) {
        if (figure.getClass().getSimpleName().equals("Circle")){
            if (Math.round(figure.getPoint1().getX() * 1000) == Math.round(center.getX() * 1000) && Math.round(figure.getPoint1().getY() * 1000) == Math.round(center.getY() * 1000) && Math.round(radius * 1000) == Math.round(figure.radius() * 1000)){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {


    }
}
