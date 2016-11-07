package com.crazydude.indoortracker.views;

import android.net.wifi.ScanResult;

import java.util.List;

/**
 * Created by Crazy on 27.10.2016.
 */
public class WifiPoint {

    private float x;
    private float y;
    private List<ScanResult> scanResults;

    public WifiPoint(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public List<ScanResult> getScanResults() {
        return scanResults;
    }

    public void setScanResults(List<ScanResult> scanResults) {
        this.scanResults = scanResults;
    }
}
