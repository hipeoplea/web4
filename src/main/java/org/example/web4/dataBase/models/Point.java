package org.example.web4.dataBase.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "user_points")
public class Point {

    private String userId;
    private float x;
    private float y;
    private float r;
    private boolean ishit;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getR() {
        return r;
    }

    public void setR(float r) {
        this.r = r;
    }

    public boolean isIshit() {
        return ishit;
    }

    public void setIshit(boolean ishit) {
        this.ishit = ishit;
    }
}
