package com.epam.rd.autotasks;

import java.util.Optional;

public enum Direction {
    N(0), NE(45), E(90), SE(135), S(180), SW(225), W(270), NW(315);

    Direction(final int degrees) {
        this.degrees = degrees;
    }

    private int degrees;

    private static Direction getName(int degree) {
        degree = (degree + 360) % 360;
        if(degree == 0){
            return Direction.N;
        } else if (degree == 45) {
            return Direction.NE;
        } else if (degree == 90) {
            return Direction.E;
        } else if (degree == 135) {
            return Direction.SE;
        } else if (degree == 180) {
            return Direction.S;
        } else if (degree == 225) {
            return Direction.SW;
        } else if (degree == 270) {
            return Direction.W;
        }else if (degree == 315){
            return Direction.NW;
        }else {
            return null;
        }
    }


    public static Direction ofDegrees(int degrees) {
        return getName(degrees);
    }



    public static Direction closestToDegrees(int degrees) {
        degrees = (degrees + 360) % 360;
        if (degrees % 45 == 0){
            return getName(degrees);
        } else if (degrees % 45 > 0 && degrees % 45 < 23) {
            degrees = degrees - (degrees % 45);
            return getName(degrees);
        }else{
            degrees = degrees - (degrees % 45) + 45;
            return getName(degrees);
        }
    }

    public Direction opposite() {
        this.degrees = this.degrees + 180;
        return closestToDegrees(degrees);
    }

    public int differenceDegreesTo(Direction direction) {
        int result = (this.degrees - direction.degrees + 360) % 360;
        if(result > 180) {
            return 360 - result;
        }else {
            return result;
        }
    }
}
