package com.epam.rd.autotasks.segments;



class Segment {
    double x1, x2, y1, y2;
    public Segment(Point start, Point end) {
        this.x1 = start.getX();
        this.y1 = start.getY();
        this.x2 = end.getX();
        this.y2 = end.getY();
        if (x1 == x2 && y1 == y2) {
            throw new IllegalArgumentException();
        }
    }

    double length() {
        return Math.sqrt(Math.pow((x1-x2), 2) + Math.pow((y1- y2), 2));
    }

    Point middle() {
        return new Point((x1 + x2) / 2, (y1 + y2) /2);
    }

    Point intersection(Segment another) {
        double k1 = (y2 - y1) / (x2 - x1);
        double k2 = (another.y2 - another.y1) / (another.x2 - another.x1);
        double b1 = y1 - x1 * k1;
        double b2 = another.y1 - another.x1 * k2;
        if (y1 < another.y1 && y1 < another.y2 && y2 < another.y1 && y2 < another.y2){
            return null;
        }else if (y1 > another.y1 && y1 > another.y2 && y2 > another.y1 && y2 > another.y2){
            return null;
        }else if (x1 > another.x1 && x1 > another.x2 && x2 > another.x1 && x2 > another.x2){
            return null;
        }else if (x1 < another.x1 && x1 < another.x2 && x2 < another.x1 && x2 < another.x2){
            return null;
        }

        if (k1 == k2){
            return null;
        }else {
            double x = (b2 - b1) / (k1 - k2);
            double y = k1 * x + b1;
            if ((x > x1 && x > x2) || (x > another.x1 && x > another.x2)){
                return null;
            }else if (x < x1 && x < x2 && x < another.x1 && x < another.x2){
                return null;
            }else if (y > y1 && y > y2 && y > another.y1 && y > another.y2){
                return null;
            }else if (y < y1 && y < y2 && y < another.y1 && y < another.y2){
                return null;
            }
            return new Point(x, y);
        }

    }

}
