package serenitylabs.tutorials;

import java.time.LocalTime;

public class ConversationalClock {

    private TimeTextualiser timeTextualiser;

    public ConversationalClock() {
       timeTextualiser = new TimeTextualiser();
    }

    public String tellTheTimeFor(int hour,int min) {
        return timeTextualiser.textualise(LocalTime.of(hour, min));
    }
}
