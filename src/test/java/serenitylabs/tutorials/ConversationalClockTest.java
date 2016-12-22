package serenitylabs.tutorials;

import com.googlecode.zohhak.api.TestWith;
import com.googlecode.zohhak.api.runners.ZohhakRunner;
import org.junit.Before;
import org.junit.runner.RunWith;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@RunWith(ZohhakRunner.class)
public class ConversationalClockTest {

    private ConversationalClock clock;

    @Before
    public void setup() {
        clock = new ConversationalClock();
    }

    @TestWith({
            // O' Clock
            "01, 00, it's one o'clock",
            "02, 00, it's two o'clock"
    })
    public void should_tell_the_time_for_O_Clock(int hour, int min, String expectedTime) throws Exception {
        assertThat(clock.tellTheTimeFor(hour, min), is(expectedTime));
    }

    @TestWith({
            // noon, midnight
            "12, 00, it's noon",
            "00, 00, it's midnight"
    })
    public void should_tell_the_time_for_noon_midnight(int hour, int min, String expectedTime) throws Exception {
        assertThat(clock.tellTheTimeFor(hour, min), is(expectedTime));
    }

    @TestWith({
            // past, to
            "02, 30, it's half past two",
            "14, 50, it's ten to three",
            "02, 45, it's a quarter to three"
    })
    public void should_tell_the_time_for_past_to(int hour, int min, String expectedTime) throws Exception {
        assertThat(clock.tellTheTimeFor(hour, min), is(expectedTime));
    }

    @TestWith({
            // almost, just after
            "13, 58, it's almost two o'clock",
            "14, 02, it's just after two o'clock"
    })
    public void should_tell_the_time_for_almost_justAfter(int hour, int min, String expectedTime) throws Exception {
        assertThat(clock.tellTheTimeFor(hour, min), is(expectedTime));
    }
}
