package serenitylabs.tutorials;

import java.time.LocalTime;

import static serenitylabs.tutorials.MessageCreator.*;

/**
 * Created by Vikrant Dheer on 22/12/2016.
 */
public class TimeTextualiser {

    public String textualise(LocalTime time) {
        if (isItNoon(time)) {
            return createNoonMessage();
        } else if (isItMidnight(time)) {
            return createMidnightMessage();
        } else if (isItOClock(time)) {
            return createOClockMessage(time);
        } else if (itIsPastHour(time)) {
            return createPastHourMessage(time);
        } else if (isItToHour(time)) {
            return createToHourMessage(time);
        } else {
            return createAlmostJustAfterMessage(time);
        }
    }

    private boolean itIsPastHour(LocalTime time) {
        return (time.getMinute() > 5 && time.getMinute() <= 30) ? true : false;
    }

    private boolean isItToHour(LocalTime time) {
        return (time.getMinute() > 30 && time.getMinute() < 56) ? true : false;
    }

    private boolean isItMidnight(LocalTime time) {
        return ((time.getHour() == 00) && time.getMinute() == 00) ? true : false;
    }

    private boolean isItNoon(LocalTime time) {
        return (time.getHour() == 12 && time.getMinute() == 00) ? true : false;
    }

    private boolean isItOClock(LocalTime time) {
        return time.getMinute() == 00 && time.getHour() != 12 ? true : false;
    }
}
