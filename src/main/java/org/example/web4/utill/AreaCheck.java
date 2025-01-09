package org.example.web4.utill;
import java.io.Serializable;


public class AreaCheck implements Serializable {

    public static boolean isInArea(float x, float y, float r){
        return checkSquare(x, y, r) || checkCircle(x, y, r) || checkTriangle(x, y, r);
    }

    private static boolean checkSquare(float x, float y, float r){
        return (y>=0 && y<=r && x <= 0 && x >= -r/2);
    }

    private static boolean checkCircle(float x, float y, float r){
        return (x * r >= 0 && y * r >= 0 && Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2)) <= r);
    }

    private static boolean checkTriangle(float x, float y, float r){
        boolean withinXBounds = (0 <= x) && (x <= r);
        boolean withinYBounds = (y >= r) && (y <= 0);
        boolean aboveHypotenuse = (y >= 0.5 * x + r / 2);

        return withinXBounds && withinYBounds && aboveHypotenuse;
    }
}
