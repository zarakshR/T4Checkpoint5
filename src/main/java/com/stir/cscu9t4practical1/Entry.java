// This class holds information about a single training session
package com.stir.cscu9t4practical1;

import java.time.ZonedDateTime;
import java.util.TimeZone;

public class Entry {

    private final String name;
    private final ZonedDateTime dateAndTime;
    private final double distance;

    public Entry(String n, ZonedDateTime zonedDateTime, double dist) {
        name = n;
        dateAndTime = zonedDateTime;
        distance = dist;
    } //constructor

    public Entry(String n, int d, int m, int y, int h, int min, int s, double dist) {
        this(n, ZonedDateTime.of(y,m,d,h,min,s,0, TimeZone.getDefault().toZoneId()), dist);
    } //constructor

    public String getName() {
        return name;
    } //getName

    public int getDay() {
        return dateAndTime.getDayOfMonth();
    } //getDay

    public int getMonth() {
        return dateAndTime.getMonthValue();
    } //getMonth

    public int getYear() {
        return dateAndTime.getYear();
    } //getYear

    public int getHour() {
        return dateAndTime.getHour();
    } //getHour

    public int getMin() {
        return dateAndTime.getMinute();
    } //getMin

    public int getSec() {
        return dateAndTime.getSecond();
    } //getSec

    public double getDistance() {
        return distance;
    } //getYear

    protected String formattedTime() {
        return getHour() + ":" + getMin() + ":" + getSec();
    }

    protected String formattedDate() {
        return getDay() + "/" + getMonth() + "/" + getYear();
    }

    protected String formattedDistance() {
        return getDistance() + " km";
    }

    public String formattedEntry() {
        return getName() + " had a training session, achieving distance " + formattedDistance() + " in " + formattedTime() + " " +
                "on " + formattedDate() + "\n";
    }
} // Entry
