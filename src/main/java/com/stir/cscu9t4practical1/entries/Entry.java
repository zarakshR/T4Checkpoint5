// This class holds information about a single training session
package com.stir.cscu9t4practical1.entries;

import java.time.LocalDateTime;
import java.util.Objects;

public abstract class Entry {

    private final String name;
    private final LocalDateTime dateTime;
    private final double distance;

    public Entry(final String name, final LocalDateTime dateTime, final double distance) {
        this.name = name;
        this.dateTime = dateTime;
        this.distance = distance;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getDateTime() { return dateTime; }

    public double getDistance() {
        return distance;
    }

    protected String getFormattedTime() {
        return dateTime.getHour() + ":" + dateTime.getMinute() + ":" + dateTime.getSecond();
    }

    protected String getFormattedDate() {
        return dateTime.getDayOfMonth() + "/" + dateTime.getMonthValue() + "/" + dateTime.getYear();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Entry entry = (Entry) o;

        // two Entrys are considered equal if the training session occurred at the same time and by the same person
        if (!Objects.equals(name, entry.name)) return false;
        return Objects.equals(dateTime, entry.dateTime);
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        return 31 * result + (dateTime != null ? dateTime.hashCode() : 0);
    }
}
