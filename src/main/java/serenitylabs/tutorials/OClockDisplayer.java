package serenitylabs.tutorials;

import serenitylabs.tutorials.Converter;
import serenitylabs.tutorials.TimeTellerInEnglish;

import java.time.LocalTime;

/**
 * Created by Home on 22-Dec-16.
 */
public class OClockDisplayer implements Converter {
    @Override
    public String timeConverter(int hr, int min) {

        //LocalTime time = LocalTime.of(hr, min);

        if (min == 00 && hr != 12 && hr != 00)

            return "It's " + HoursMinutesMaps.HOUR_MAP.get(hr) + " o'clock";

        return null;
    }
}