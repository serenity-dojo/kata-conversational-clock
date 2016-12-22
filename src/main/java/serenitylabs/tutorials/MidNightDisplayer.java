package serenitylabs.tutorials;

import serenitylabs.tutorials.Converter;

/**
 * Created by Home on 22-Dec-16.
 */
public class MidNightDisplayer implements Converter {
    @Override
    public String timeConverter(int hr, int min) {
        if(hr == 00 && min == 00)
        return "It's midnight";
        return null;
    }
}
