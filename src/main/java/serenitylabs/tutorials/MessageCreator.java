package serenitylabs.tutorials;

import java.time.LocalTime;

import static serenitylabs.tutorials.ConversationalTimeConstants.*;

/**
 * Created by Vikrant Dheer on 22/12/2016.
 */
public class MessageCreator {

    public static String createNoonMessage() {
        return "it's " + NOON;
    }

    public static String createMidnightMessage() {
        return "it's " + MIDNIGHT;
    }

    public static String createAlmostJustAfterMessage(LocalTime time) {
        if (time.getMinute() <= 4){
            return createMessage(textForJustAfter(time),JUST_AFTER);
        }
        else {
            return createMessage(textForAlmost(time), ALMOST);
        }
    }

    public static String createMessage(String hours, String almostORJustAfter) {
        return String.format("it's %s %s o'clock", almostORJustAfter, hours);
    }

    public static String createPastOrToMessage(String minutes, String pastOrTo, String hour) {
        return String.format("it's %s %s %s", minutes, pastOrTo, hour);
    }

    public static String createOClockMessage(LocalTime time) {
        return "it's " + textForHour(time.getHour()) + OCLOCK;
    }

    public static String createPastHourMessage(LocalTime time) {

        return createPastOrToMessage(
                textForMinute(time.getMinute()),
                PAST,
                textForHour(time.getHour()));
    }

    public static String createToHourMessage(LocalTime time) {
        return createPastOrToMessage(
                textForMinute(getNextMinutes(time.getMinute())),
                TO,
                textForHour(getNextHour(time.getHour())));
    }

    public static int getNextHour(int hour) {
        return hour + 1;
    }

    public static int getNextMinutes(int minute) {
        return 60-minute;
    }
}
