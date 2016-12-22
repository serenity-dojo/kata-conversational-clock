package serenitylabs.tutorials;

import com.googlecode.zohhak.api.Coercion;
import com.googlecode.zohhak.api.TestWith;
import com.googlecode.zohhak.api.runners.ZohhakRunner;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;


@RunWith(ZohhakRunner.class)
public class ConversationalClockTest {

    private TimeTellerInEnglish clock = new TimeTellerInEnglish();

    @TestWith(
            { "1, 00, It's one o'clock"}
    )
    public void clock_should_display_the_time_in_hours(int hr, int min, String convertedTime) throws Exception{

        assertThat(clock.converter(hr, min), is(convertedTime));
    }

    @TestWith(
            {
                "12, 00, It's noon",
                    "00, 00, It's midnight"
            }
    )

    public void clock_should_display_the_time_for_noon_and_midnight(int hr, int min, String convertedTime) throws Exception{

        assertThat(clock.converter(hr, min), is(convertedTime));
    }

    @TestWith(
            {
                    "2, 30, It's half past two",
                    "3, 15, It's quarter past three",
                    "4, 40, It's twenty to five",
                    "4, 45, It's quarter to five"
            }
    )

    public void clock_should_display_the_time_for_past_to_quarter(int hr, int min, String convertedTime) throws Exception{

        assertThat(clock.converter(hr, min), is(convertedTime));
    }
}
