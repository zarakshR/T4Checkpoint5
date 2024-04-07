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

    public String getEntry() {
        String result = getName() + " ran " + getDistance() + " km in "
                + getHour() + ":" + getMin() + ":" + getSec() + " on "
                + getDay() + "/" + getMonth() + "/" + getYear() + "\n";
        return result;
    } //getEntry

} // Entry
