package serenitylabs.tutorials;

import com.google.common.collect.Range;
import com.google.common.collect.RangeMap;
import com.google.common.collect.TreeRangeMap;
import serenitylabs.tutorials.interfaces.ConversationalTime;
import serenitylabs.tutorials.interfaces.ProvideTime;

public class ConversationalClock {
    private final ProvideTime timeProvider;

    public ConversationalClock(ProvideTime timeProvider){this.timeProvider=timeProvider;}

    private static RangeMap<Integer,ConversationalTime> TIME_FORMAT_STRATEGY= TreeRangeMap.create();
    static{
        TIME_FORMAT_STRATEGY.put(Range.closed(15,15),TransformToConversationalTime.QUARTER_PAST);
        TIME_FORMAT_STRATEGY.put(Range.closed(30,30),TransformToConversationalTime.HALF_PAST);
        TIME_FORMAT_STRATEGY.put(Range.closed(45,45),TransformToConversationalTime.QUARTER_TO);
        TIME_FORMAT_STRATEGY.put(Range.closed(00,00),TransformToConversationalTime.DEFAULT);
        TIME_FORMAT_STRATEGY.put(Range.closed(56,59),TransformToConversationalTime.ALMOST);
        TIME_FORMAT_STRATEGY.put(Range.closed(01,04),TransformToConversationalTime.JUST_AFTER);
        TIME_FORMAT_STRATEGY.put(Range.closed(05,14),TransformToConversationalTime.PAST);
        TIME_FORMAT_STRATEGY.put(Range.closed(16,29),TransformToConversationalTime.PAST);
        TIME_FORMAT_STRATEGY.put(Range.closed(31,44),TransformToConversationalTime.TO);
        TIME_FORMAT_STRATEGY.put(Range.closed(46,55),TransformToConversationalTime.TO);

    }


    public String conversationalTime(){
        Integer localTimeHour=timeProvider.getLocalTime().getHour();
        Integer localTimeMinute=timeProvider.getLocalTime().getMinute();
        return conversationalTimeFor(localTimeHour,localTimeMinute);
    }

    private String conversationalTimeFor(Integer localTimeHour, Integer localTimeMinute){
        return TIME_FORMAT_STRATEGY.get(localTimeMinute).conversation(localTimeHour,localTimeMinute);
    }
}
