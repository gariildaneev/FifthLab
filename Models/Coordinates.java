package com.company.Models;

import com.company.Printer;

public  class Coordinates {
    /**
     * x
     */
    private float x;
    /**
     * y
     * max 229
     */
    private double y; //Максимальное значение поля: 229

    /**
     * override
     * toString
     * return String
     */
    @Override
    public String toString() {
        return "Coordinates{\r\n\t\t" +
                "x=" + x +
                ",\r\n\t\ty=" + y +
                "\r\n\t}";
    }

    /**
     * constructor Coordinates
     * set x,y
     */
    public Coordinates(float x, double y) {
        setX(x);
        setY(y);
    }

    /**
     * getX
     */
    public float getX() {
        return x;
    }

    /**
     * setX
     */
    public void setX(float x) {
        this.x = x;
    }

    /**
     * getY
     */
    public double getY() {
        return y;
    }

    /**
     * setY
     */
    public void setY(double y) {
        if(y > 229){
            y = 229;
            Printer.getInstance().WriteLine("слишком большой y. Он изменен на 229");
        }
        this.y = y;
    }

}