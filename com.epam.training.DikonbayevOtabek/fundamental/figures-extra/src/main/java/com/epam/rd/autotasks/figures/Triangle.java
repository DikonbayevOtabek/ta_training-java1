package com.epam.rd.autotasks.figures;

class Triangle extends Figure{
    Point point1, point2, point3;

    @Override
    public double radius() {
        return 0;
    }

    public Triangle(Point point1, Point point2, Point point3) {
        this.point1 = point1;
        this.point2 = point2;
        this.point3 = point3;
        if (point1 == null) throw new IllegalArgumentException();
        if (point2 == null) throw new IllegalArgumentException();
        if (point3 == null) throw new IllegalArgumentException();
        if(!isTriangle()) throw new IllegalArgumentException();
    }

    public Point getPoint1() {
        return point1;
    }

    public Point getPoint2() {
        return point2;
    }

    public Point getPoint3() {
        return point3;
    }

    @Override
    public Point getPoint4() {
        return null;
    }

    @Override
    public Point centroid() {
        return new Point((point1.getX() + point2.getX() + point3.getX()) / 3, (point1.getY() + point2.getY() + point3.getY()) / 3);
    }

    @Override
    public boolean isTheSame(Figure figure) {
        int count = 0;
        if (figure.getClass().getSimpleName() == "Triangle"){
            if (figure.getPoint1().getX() == point1.getX() && figure.getPoint1().getY() == point1.getY()) ++count;
            if (figure.getPoint2().getX() == point2.getX() && figure.getPoint2().getY() == point2.getY()) ++count;
            if (figure.getPoint3().getX() == point3.getX() && figure.getPoint3().getY() == point3.getY()) ++count;
        }
        return count == 3;
    }

    public boolean isTriangle(){
        double a = Math.sqrt(Math.pow(point1.getX() - point2.getX(), 2) + Math.pow(point1.getY() - point2.getY(), 2));
        double b = Math.sqrt(Math.pow(point1.getX() - point3.getX(), 2) + Math.pow(point1.getY() - point3.getY(), 2));
        double c = Math.sqrt(Math.pow(point3.getX() - point2.getX(), 2) + Math.pow(point3.getY() - point2.getY(), 2));
        return Math.round((a + b) * 1000000000) > Math.round(c * 1000000000) && Math.round((a + c) * 1000000000)  > Math.round(b * 1000000000) && Math.round((b + c) * 1000000000) > Math.round(a * 1000000000);
    }
    double area() {
        return Math.abs((point2.getX()-point1.getX()) * (point3.getY()-point1.getY()) - (point3.getX()-point1.getX()) * (point2.getY()-point1.getY()))/2;
    }




}
