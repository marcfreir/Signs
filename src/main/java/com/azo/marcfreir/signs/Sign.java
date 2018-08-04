package com.azo.marcfreir.signs;

import java.io.Serializable;

public class Sign implements Serializable {
    private int dayfirst;
    private int daylast;
    private int monthfirst;
    private int monthlast;
    private String name;
    private String image;

    //EMPTY CONSTRUCTOR METHOD
    public Sign() {

    }
    //CONSTRUCTOR METHOD
    public Sign(int dayfirst, int monthfirst, int daylast, int monthlast, String name, String image) {
        this.dayfirst = dayfirst;
        this.daylast = daylast;
        this.monthfirst = monthfirst;
        this.monthlast = monthlast;
        this.name = name;
        this.image = image;
    }

    //GET METHODS
    public int getDayfirst() {
        return dayfirst;
    }
    public int getDaylast() {
        return daylast;
    }
    public  int getMonthfirst() {
        return monthfirst;
    }
    public int getMonthlast() {
        return monthlast;
    }
    public String getName() {
        return name;
    }
    public String getImage() {
        return image;
    }
}
