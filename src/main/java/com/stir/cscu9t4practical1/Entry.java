// This class holds information about a single training session
package com.stir.cscu9t4practical1;

import java.time.ZonedDateTime;
import java.util.Objects;

public class Entry {

    private final String name;
    private final ZonedDateTime dateAndTime;
    private final double distance;

    public Entry(String n, ZonedDateTime zonedDateTime, double dist) {
        name = n;
        dateAndTime = zonedDateTime;
        distance = dist;
    }

    public String getName() {
        return name;
    }

    public int getDay() {
        return dateAndTime.getDayOfMonth();
    }

    public int getMonth() {
        return dateAndTime.getMonthValue();
    }

    public int getYear() {
        return dateAndTime.getYear();
    }

    public int getHour() {
        return dateAndTime.getHour();
    }

    public int getMin() {
        return dateAndTime.getMinute();
    }

    public int getSec() {
        return dateAndTime.getSecond();
    }

    public double getDistance() {
        return distance;
    }

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
        return getName() + " ran " + formattedDistance() + " in " + formattedTime() + " " +
                "on " + formattedDate() + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Entry entry = (Entry) o;

        // two Entrys are considered equal if the training session occurred at the same time and by the same person
        if (!Objects.equals(name, entry.name)) return false;
        return Objects.equals(dateAndTime, entry.dateAndTime);
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        return 31 * result + (dateAndTime != null ? dateAndTime.hashCode() : 0);
    }
}
