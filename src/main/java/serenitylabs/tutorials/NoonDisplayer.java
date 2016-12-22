package serenitylabs.tutorials;

import serenitylabs.tutorials.Converter;

/**
 * Created by Home on 22-Dec-16.
 */
public class NoonDisplayer implements Converter{
    @Override
    public String timeConverter(int hr, int min) {
        if(hr == 12 && min == 00)
            return "It's noon";
    return null;
    }
}
