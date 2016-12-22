package serenitylabs.tutorials;

import com.googlecode.zohhak.api.TestWith;
import com.googlecode.zohhak.api.runners.ZohhakRunner;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.runner.RunWith;

import java.time.LocalTime;

@RunWith(ZohhakRunner.class)
public class WhenSeeingTimeInConversationalClock {

    ConversationalClock conversationalClock;
    String conversationalTime;

    @TestWith({
            "01,00, It is one o'clock",
    })
    public void shouldDisplayNormalTime(int hour, int minutes, String expectedTime) throws Exception {
        checkAgainstExpectedTime(hour,minutes,expectedTime);
    }


    @TestWith(
            {
                "12,00, It is noon"
            }
    )

    public void shouldDisplayNoonInConversationalTime(int hour,int minutes,String expectedTime)throws Exception{
        checkAgainstExpectedTime(hour,minutes,expectedTime);
    }

    private void checkAgainstExpectedTime(int hour, int minutes, String expectedTime) {
        conversationalTimeFor(hour, minutes);
        MatcherAssert.assertThat(conversationalTime, CoreMatchers.is(expectedTime));
    }

    private void conversationalTimeFor(int hour, int minutes) {
        conversationalClock = new ConversationalClock(()-> LocalTime.of(hour,minutes));
        conversationalTime = conversationalClock.conversationalTime();
    }

    @TestWith(
            {
                "12,30, It is half past twelve",
                    "1,30, It is half past one"
            }
    )

    public void shouldDisplayHalfPastInConversationalTime(int hour,int minutes,String expectedTime)throws Exception{
        checkAgainstExpectedTime(hour,minutes,expectedTime);
    }



    @TestWith(
            {
                "11,58, It is almost twelve"
            }
    )

    public void shouldDisplayAlmostInConversationalTime(int hour,int minutes,String expectedTime)throws Exception{

        checkAgainstExpectedTime(hour,minutes,expectedTime);

    }



    @TestWith(
            {
                    "14,01, It is just after two o'clock"
            }
    )

    public void shouldDisplayJustAfterInConversationalTime(int hour,int minutes,String expectedTime)throws Exception{

        checkAgainstExpectedTime(hour,minutes,expectedTime);

    }


    @TestWith(
            {
                    "12,15, It is quarter past twelve",
                    "15,15, It is quarter past three"
            }
    )

    public void shouldDisplayQuarterPastInConversationalTime(int hour,int minutes,String expectedTime)throws Exception{
        checkAgainstExpectedTime(hour,minutes,expectedTime);
    }

    @TestWith(
            {
                    "09,45, It is quarter to ten",
                    "17,45, It is quarter to six"
            }
    )

    public void shouldDisplayQuarterToInConversationalTime(int hour,int minutes,String expectedTime)throws Exception{
        checkAgainstExpectedTime(hour,minutes,expectedTime);
    }

    @TestWith(
            {
                    "09,10, It is ten past nine",
                    "12,19, It is nineteen past twelve"
            }
    )

    public void shouldDisplayTillFirstTwentyNineMinutesExcludingFifteenAndThirtyMinutesInConversationalTime(int hour,int minutes,String expectedTime)throws Exception{
        checkAgainstExpectedTime(hour,minutes,expectedTime);
    }

    @TestWith(
            {
                    "09,50, It is ten to ten",
                    "12,49, It is eleven to one"
            }
    )

    public void shouldDisplayTillLastTwentyNineMinutesExcludingThirtyAndFortyFiveMinutesInConversationalTime(int hour,int minutes,String expectedTime)throws Exception{
        checkAgainstExpectedTime(hour,minutes,expectedTime);
    }
}
