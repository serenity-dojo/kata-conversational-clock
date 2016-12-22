package serenitylabs.tutorials;

import java.sql.Time;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Home on 21-Dec-16.
 */
public class TimeTellerInEnglish {

    private static Map<Integer, Integer> TIME = new HashMap<>();
    private static Map<Map<Integer, Integer>, Converter> Time_Displayer_Strategy = new HashMap();

    static{
        TIME.put(00, 00);
        TIME.put(12, 00);
        TIME.put(01, 30);
        TIME.put(02, 15);
        TIME.put(02, 20);
        TIME.put(03, 35);
        TIME.put(03, 45);
        TIME.put(04, 50);
        TIME.put(01, 00);
        TIME.put(02, 00);
        TIME.put(23, 00);
        Time_Displayer_Strategy.put(TIME, new MidNightDisplayer());
        Time_Displayer_Strategy.put(TIME, new NoonDisplayer());
        Time_Displayer_Strategy.put(TIME, new PastDisplayer());
        Time_Displayer_Strategy.put(TIME, new ToDisplayer());
        Time_Displayer_Strategy.put(TIME, new OClockDisplayer());
    }

    public String converter(int hr, int min){
        return Time_Displayer_Strategy.get(TIME.get(hr)).timeConverter(hr, min);
    }
}
