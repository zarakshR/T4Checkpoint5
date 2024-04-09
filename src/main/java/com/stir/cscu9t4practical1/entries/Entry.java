// This class holds information about a single training session
package com.stir.cscu9t4practical1.entries;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Objects;
import java.util.TimeZone;

public abstract class Entry {

    private final String name;
    private final ZonedDateTime dateAndTime;
    private final double distance;

    public Entry(final String name, final LocalDateTime dateTime, final double distance) {
        this.name = name;
        this.dateAndTime = ZonedDateTime.of(dateTime, TimeZone.getDefault().toZoneId());
        this.distance = distance;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getDateTime() { return dateAndTime.toLocalDateTime(); }

    public double getDistance() {
        return distance;
    }

    protected String getFormattedTime() {
        return dateAndTime.getHour() + ":" + dateAndTime.getMinute() + ":" + dateAndTime.getSecond();
    }

    protected String getFormattedDate() {
        return dateAndTime.getDayOfMonth() + "/" + dateAndTime.getMonthValue() + "/" + dateAndTime.getYear();
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
