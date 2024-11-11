package com.example.iot;

import com.google.gson.annotations.SerializedName;

public class DataCuaca {
    @SerializedName("id")
    private int id;

    @SerializedName("suhu")
    private double suhu;

    @SerializedName("humid")
    private double humid;

    @SerializedName("lux")
    private double lux;

    @SerializedName("ts")
    private String ts; // Bulan dan tahun dalam bentuk String

    // Getter methods
    public int getId() {
        return id;
    }

    public double getSuhu() {
        return suhu;
    }

    public double getHumid() {
        return humid;
    }

    public double getLux() {
        return lux;
    }

    public String getTs() {
        return ts;
    }
}
