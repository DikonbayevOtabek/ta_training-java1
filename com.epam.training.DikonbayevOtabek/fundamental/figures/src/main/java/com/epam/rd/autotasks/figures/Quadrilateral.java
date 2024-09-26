package com.epam.rd.autotasks.figures;

class Quadrilateral extends Figure{
    Point point1, point2, point3, point4;

    Quadrilateral(Point point1, Point point2, Point point3, Point point4){
        this.point1 = point1;
        this.point2 = point2;
        this.point3 = point3;
        this.point4 = point4;
    }
    @Override
    public double area() {
        double a = Math.sqrt(Math.pow(point1.getX() - point2.getX(), 2) +  Math.pow(point1.getY() - point2.getY(),2));
        double b = Math.sqrt(Math.pow(point2.getX() - point3.getX(), 2) +  Math.pow(point2.getY() - point3.getY(),2));
        double diaganal = Math.sqrt(Math.pow(point1.getX() - point3.getX(), 2) +  Math.pow(point1.getY() - point3.getY(),2));

        double c = Math.sqrt(Math.pow(point1.getX() - point4.getX(), 2) +  Math.pow(point1.getY() - point4.getY(),2));
        double d = Math.sqrt(Math.pow(point3.getX() - point4.getX(), 2) +  Math.pow(point3.getY() - point4.getY(),2));
        double p = (a + b + diaganal) / 2;
        double area1 = Math.sqrt(p * (p -a) * (p - b) * (p - diaganal));
        double per = (c + d + diaganal) / 2;
        double area2 = Math.sqrt(per * (per -c) * (per - d) * (per - diaganal));
        return area1 + area2;
    }

    @Override
    public String pointsToString() {
            return "(" + point1.getX() + "," + point1.getY() +")" +
        "(" + point2.getX() + "," + point2.getY() +")" +
        "(" + point3.getX() + "," + point3.getY() +")" +
        "(" + point4.getX() + "," + point4.getY() +")";
    }

    @Override
    public Point leftmostPoint() {
        double leftX = Math.min(Math.min(Math.min(point1.getX(), point2.getX()), point3.getX()), point4.getX());
        if (leftX == point1.getX()){
            return point1;
        } else if (leftX == point2.getX()) {
            return point2;
        } else if (leftX == point3.getX()) {
            return point3;
        } else {
            return point4;
        }
    }
}
