package com.example.android.recycleview;

public class Forecast {

    private String dayName;
    private Integer degress;

    public Forecast(String dayName, Integer degress) {
        this.dayName = dayName;
        this.degress = degress;
    }

    public String getDayName() {
        return dayName;
    }

    public void setDayName(String dayName) {
        this.dayName = dayName;
    }

    public Integer getDegress() {
        return degress;
    }

    public void setDegress(Integer degress) {
        this.degress = degress;
    }
}
