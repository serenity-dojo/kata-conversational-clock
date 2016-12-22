package serenitylabs.tutorials;

import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

public class ConversationalTimeConstants {

	private static Map<Integer, String> HOUR_DICTIONARY = new HashMap();
	private static Map<Integer, String> MINUTE_DICTIONARY = new HashMap();
	
	public static final String MIDNIGHT = "midnight";
	public static final String NOON = "noon";
	public static final String OCLOCK = " o'clock";
	public static final String PAST = "past";
	public static final String TO = "to";
	public static final String JUST_AFTER = "just after";
	public static final String ALMOST = "almost";
	
	static {
		HOUR_DICTIONARY.put(1, "one");
		HOUR_DICTIONARY.put(2, "two");
		HOUR_DICTIONARY.put(3, "three");
		HOUR_DICTIONARY.put(4, "four");
		HOUR_DICTIONARY.put(5, "five");
		HOUR_DICTIONARY.put(6, "six");
		HOUR_DICTIONARY.put(7, "seven");
		HOUR_DICTIONARY.put(8, "eight");
		HOUR_DICTIONARY.put(9, "nine");
		HOUR_DICTIONARY.put(10, "ten");
		HOUR_DICTIONARY.put(11, "eleven");
		HOUR_DICTIONARY.put(12, "twelve");
		HOUR_DICTIONARY.put(13, "one");
		HOUR_DICTIONARY.put(14, "two");
		HOUR_DICTIONARY.put(0, "midnight");

		MINUTE_DICTIONARY.put(2, "two");
		MINUTE_DICTIONARY.put(5, "five");
		MINUTE_DICTIONARY.put(10, "ten");
		MINUTE_DICTIONARY.put(15, "a quarter");
		MINUTE_DICTIONARY.put(20, "twenty");
		MINUTE_DICTIONARY.put(25, "twenty five");
		MINUTE_DICTIONARY.put(30, "half");
	}
	
	public static String textForHour(int hour) {
		if (hour == 12) {
			return HOUR_DICTIONARY.get(hour);
		} else {
			return HOUR_DICTIONARY.get(hour % 12);
		}
	}
	
	public static String textForMinute(int minute) {
		return MINUTE_DICTIONARY.get(minute);
	}

	public static String textForJustAfter(LocalTime time){
		return HOUR_DICTIONARY.get(time.getHour());
	}

	public static String textForAlmost(LocalTime time){
		return HOUR_DICTIONARY.get(time.getHour() + 1);
	}

}
