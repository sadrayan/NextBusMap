package com.nextbus.model;

import com.nextbus.service.xml.PredictionHandler;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by sonic on 3/25/16.
 */
public class Direction {
    public String tag;
    public String title;
    public String name;

    public List<String> directionStopList = new ArrayList<>();

    public List <Stop> stopList = new ArrayList<>();
    public List<PredictionHandler.Prediction> predictionList;

    @Override
    public String toString() {
        return "Direction{" +
                "tag='" + tag + '\'' +
                ", title='" + title + '\'' +
                ", name='" + name + '\'' +
                ", directionStopList=" + directionStopList +
                ", stopList=" + stopList +
                '}';
    }
}