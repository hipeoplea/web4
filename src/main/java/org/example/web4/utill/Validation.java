package org.example.web4.utill;

import java.io.Serializable;


public class Validation implements Serializable {
    public static boolean validate(float x, float y, float r) {
        return (validateX(x) && validateY(y) && validateR(r));
    }

    private static boolean validateX(float x) {
        return x>=-5 && x<=3;
    }

    private static boolean validateY(float y) {
        return y >= -3 && y <= 3;
    }

    private static boolean validateR(float r) {
        return r >= 0 && r <= 3;
    }

}