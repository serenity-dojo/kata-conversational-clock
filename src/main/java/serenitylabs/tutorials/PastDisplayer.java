package serenitylabs.tutorials;

import serenitylabs.tutorials.Converter;
import serenitylabs.tutorials.TimeTellerInEnglish;

/**
 * Created by Home on 21-Dec-16.
 */
public class PastDisplayer implements Converter{
    @Override
    public String timeConverter(int hr, int min) {
        if(min <=30)
        return "It's " + HoursMinutesMaps.MIN_MAP.get(min) + " past " + HoursMinutesMaps.HOUR_MAP.get(hr);
        return null;
    }
}
