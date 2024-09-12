package com.epam.rd.autotasks.intersection;

public class Line {
    int k, b;

    public Line(int k, int b) {
        this.k = k;
        this.b = b;
    }

    public Point intersection(Line other) {
        // k * x - k1 * x = b1 - b
        // x = (b1 - b) / (k -k1)
        // y = k * x + b
        if (k == other.k){
            return null;
        }else {
            int x = (other.b - b) / (k - other.k);
            int y = k * x + b;
            return new Point(x ,y);
        }
    }

}
