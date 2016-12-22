package serenitylabs.tutorials;

import serenitylabs.tutorials.interfaces.ConversationalTime;

import java.util.HashMap;
import java.util.Map;

public enum TransformToConversationalTime implements ConversationalTime {

    HALF_PAST{
        @Override
        public String conversation(Integer hour, Integer minutes){
            return "It is half past "+  convertConversationalTwelveToSimple(HOUR.get(ModuloOf(hour)));

        }
    },


    DEFAULT{
        @Override
        public String conversation(Integer hour, Integer minutes) {
            return "It is "+ ((hour==12 && minutes==00)? conversationalHourOClock(hour) :convertConversationalTwelveToSimple(conversationalHourOClock(ModuloOf(hour))));
        }

        private String conversationalHourOClock(Integer hour) {
            return HOUR_O_CLOCKS.get(hour);
        }
    },

    JUST_AFTER{
        @Override
        public String conversation(Integer hour, Integer minutes) {
            return "It is just after "+  convertConversationalTwelveToSimple(HOUR_O_CLOCKS.get(ModuloOf(hour)));
        }
    },

    QUARTER_PAST{
        @Override
        public String conversation(Integer hour, Integer minutes) {
            return "It is quarter past "+ convertConversationalTwelveToSimple(HOUR.get(ModuloOf(hour)));
        }
    },

    QUARTER_TO{
        @Override
        public String conversation(Integer hour, Integer minutes) {
            return "It is quarter to "+  convertConversationalTwelveToSimple(HOUR.get(ModuloOf(hour)+1));
        }
    },

    ALMOST{
        @Override
        public String conversation(Integer hour, Integer minutes) {
            return "It is almost "+  convertConversationalTwelveToSimple(HOUR_O_CLOCKS.get(ModuloOf(hour)+1));
        }
    }, PAST{
        @Override
        public String conversation(Integer hour, Integer minutes) {
            return "It is "+ MINUTES.get(minutes)+" past " +convertConversationalTwelveToSimple(HOUR.get(ModuloOf(hour)));
        }
    }, TO{
        @Override
        public String conversation(Integer hour, Integer minutes) {
            return "It is "+ MINUTES.get(lessThirtyMinutes(minutes))+" to " +convertConversationalTwelveToSimple(HOUR.get(ModuloOf(hour)+1));
        }
    };

    private static int lessThirtyMinutes(Integer minutes) {
        return 60-minutes;
    }

    private static String convertConversationalTwelveToSimple(String timeText) {
        return timeText.contains("midnight")||timeText.contains("noon")?"twelve":timeText;
    }

    private static int ModuloOf(Integer hour) {
        return hour%12;
    }

    private static Map<Integer,String> HOUR_O_CLOCKS=new HashMap<>();
    static{
        HOUR_O_CLOCKS.put(0,"midnight");
        HOUR_O_CLOCKS.put(1,"one o'clock");
        HOUR_O_CLOCKS.put(2,"two o'clock");
        HOUR_O_CLOCKS.put(3,"three o'clock");
        HOUR_O_CLOCKS.put(4,"four o'clock");
        HOUR_O_CLOCKS.put(5,"five o'clock");
        HOUR_O_CLOCKS.put(6,"six o'clock");
        HOUR_O_CLOCKS.put(7,"seven o'clock");
        HOUR_O_CLOCKS.put(8,"eight o'clock");
        HOUR_O_CLOCKS.put(9,"nine o'clock");
        HOUR_O_CLOCKS.put(10,"ten o'clock");
        HOUR_O_CLOCKS.put(11,"eleven o'clock");
        HOUR_O_CLOCKS.put(12,"noon");
    }

    private static Map<Integer,String> HOUR=new HashMap<>();
    static{
        HOUR.put(0,"midnight");
        HOUR.put(1,"one");
        HOUR.put(2,"two");
        HOUR.put(3,"three");
        HOUR.put(4,"four");
        HOUR.put(5,"five");
        HOUR.put(6,"six");
        HOUR.put(7,"seven");
        HOUR.put(8,"eight");
        HOUR.put(9,"nine");
        HOUR.put(10,"ten");
        HOUR.put(11,"eleven");
        HOUR.put(12,"noon");


    }

    private static Map<Integer,String> MINUTES=new HashMap<>();
    static {
        MINUTES.put(1, "one");
        MINUTES.put(2, "two");
        MINUTES.put(3, "three");
        MINUTES.put(4, "four");
        MINUTES.put(5, "five");
        MINUTES.put(6, "six");
        MINUTES.put(7, "seven");
        MINUTES.put(8, "eight");
        MINUTES.put(9, "nine");
        MINUTES.put(10, "ten");
        MINUTES.put(11, "eleven");
        MINUTES.put(12, "twelve");
        MINUTES.put(13, "thirteen");
        MINUTES.put(14, "fourteen");
        MINUTES.put(15, "fifteen");
        MINUTES.put(16, "sixteen");
        MINUTES.put(17, "seventeen");
        MINUTES.put(18, "eighteen");
        MINUTES.put(19, "nineteen");
        MINUTES.put(20, "twenty");
        MINUTES.put(21, "twenty one");
        MINUTES.put(22, "twenty two");
        MINUTES.put(23, "twenty three");
        MINUTES.put(24, "twenty four");
        MINUTES.put(25, "twenty five");
        MINUTES.put(26, "twenty six");
        MINUTES.put(27, "twenty seven");
        MINUTES.put(28, "twenty eight");
        MINUTES.put(29, "twenty nine");
    }


}
