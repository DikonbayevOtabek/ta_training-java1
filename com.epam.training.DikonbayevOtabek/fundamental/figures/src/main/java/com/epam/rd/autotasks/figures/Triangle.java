package com.epam.rd.autotasks.figures;

class Triangle extends Figure{
    Point point1, point2, point3;
    public Triangle(Point point1, Point point2, Point point3) {
        this.point1 = point1;
        this.point2 = point2;
        this.point3 = point3;
    }

    @Override
    public double area() {
        double a = Math.sqrt(Math.pow(point1.getX() - point2.getX(), 2) +  Math.pow(point1.getY() - point2.getY(),2));
        double b = Math.sqrt(Math.pow(point1.getX() - point3.getX(), 2) +  Math.pow(point1.getY() - point3.getY(),2));
        double c = Math.sqrt(Math.pow(point2.getX() - point3.getX(), 2) +  Math.pow(point2.getY() - point3.getY(),2));
        double p = (a + b + c) / 2;
        return Math.sqrt(p * (p -a) * (p - b) * (p - c));
    }

    @Override
    public String pointsToString() {
        return "(" + point1.getX() + "," + point1.getY() +")" +
                "(" + point2.getX() + "," + point2.getY() +")" +
                "(" + point3.getX() + "," + point3.getY() +")";
    }

    @Override
    public Point leftmostPoint() {
        double leftX = Math.min(Math.min(point1.getX(), point2.getX()), point3.getX());
        if (leftX == point1.getX()){
            return point1;
        } else if (leftX == point2.getX()) {
            return point2;
        } else {
            return point3;
        }
    }
}
