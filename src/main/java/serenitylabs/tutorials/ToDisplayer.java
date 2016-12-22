package serenitylabs.tutorials;

import serenitylabs.tutorials.Converter;
import serenitylabs.tutorials.TimeTellerInEnglish;

/**
 * Created by Home on 22-Dec-16.
 */
public class ToDisplayer implements Converter {
    @Override
    public String timeConverter(int hr, int min) {

        if(min< 30) {
            int toMinutes = (60 - min);
            int hourPlusOne = hr + 1;
            return "It's " + HoursMinutesMaps.MIN_MAP.get(toMinutes) + " to " + HoursMinutesMaps.HOUR_MAP.get(hourPlusOne);
        }
        return null;
    }
}
