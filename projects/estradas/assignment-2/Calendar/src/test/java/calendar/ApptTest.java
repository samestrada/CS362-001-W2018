package calendar;
import jdk.internal.jline.internal.TestAccessible;
import org.junit.Test;

import static org.junit.Assert.*;

public class ApptTest {
    @Test
    public void testValid(){
    Appt a = new Appt(1, 30, 3, 2, 2017, "Doctor", "Go to the doctor");
    assertTrue(a.getValid());
    Appt b = new Appt(27, 30, 3, 2, 2017, "Doctor", "Go to the doctor");
    assertFalse(b.getValid());
    }
    @Test
    public void testSetRecur(){
        Appt a = new Appt(1, 30, 3, 2, 2017, "Doctor", "Go to the doctor");
        int recurDays [] = {3,4,5};
        a.setRecurrence( recurDays, 1, 4, Appt.RECUR_NUMBER_FOREVER);
        assertArrayEquals(recurDays, a.getRecurDays());
        assertTrue(a.isRecurring());
        assertEquals(1, a.getRecurBy());
    }

    @Test
    public void testToString(){
        Appt a = new Appt(13, 30, 3, 2, 2017, "Doctor", "Go to the doctor");
        //Should be the appt "1:30pm, Feb.3 2017"
        assertNotNull(a.toString());
    }

    @Test
    public void testCompareTo(){
        int something;
        Appt a = new Appt(4, 00, 3, 2, 2017, "Doctor", "Go to the doctor");
        Appt b = new Appt(3,00,5,1,2017,"Title", "Des");
        int asum = 4 + 3 + 2 + 2017;
        int bsum = 3 + 5 + 1 + 2017;
        int expectedRet = asum - bsum;
        assertEquals(expectedRet, a.compareTo(b));
    }

}

