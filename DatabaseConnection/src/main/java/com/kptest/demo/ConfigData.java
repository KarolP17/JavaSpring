package com.kptest.demo;

import org.springframework.stereotype.Component;

public class ConfigData {
    private int range;
    private int start;
    private int end;
    public ConfigData(int range, int start, int end){
        this.range = range;
        this.start = start;
        this.end = end;
    }



    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }
}
