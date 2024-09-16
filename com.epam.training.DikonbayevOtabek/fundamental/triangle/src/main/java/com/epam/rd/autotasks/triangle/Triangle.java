package com.epam.rd.autotasks.triangle;

class Triangle {
    double a1, a2, b1, b2, c1, c2;
    double A, B, C;
    public Triangle(Point a, Point b, Point c) {
        //TODO
        this.a1 = a.getX();
        this.a2 = a.getY();
        this.b1 = b.getX();
        this.b2 = b.getY();
        this.c1 = c.getX();
        this.c2 = c.getY();
        A = Math.sqrt(Math.pow((a1 - b1), 2) + Math.pow((a2 - b2), 2));
        B = Math.sqrt(Math.pow((b1 - c1), 2) + Math.pow((b2 - c2), 2));
        C = Math.sqrt(Math.pow((c1 - a1), 2) + Math.pow((c2 - a2), 2));

        if (A + B <= C || A + C <= B || B + C <= A){
            throw new IllegalArgumentException();
        }
    }


    public double area() {
        //TODO
        double p = (A + B + C) / 2;
        return Math.sqrt(p * (p - A) * (p - B) * (p - C));
    }

    public Point centroid(){
        //TODO
        return new Point((a1 + b1 + c1) / 3, (a2 + b2 + c2) /3);
    }

}
