package calendar;
import org.junit.Test;

import java.util.GregorianCalendar;
import java.util.Iterator;

import static org.junit.Assert.*;

public class CalDayTest {
    @Test
    public void testAddAppt(){
        GregorianCalendar today = new GregorianCalendar(2017,3,5);
        Appt a = new Appt(4,30,5,3,2017,"Movies", "Go see movie");
        CalDay cal = new CalDay(today);
        assertEquals(cal.getSizeAppts(), 0);
        cal.addAppt(a);
        assertEquals(cal.getSizeAppts(), 1);
        assertEquals(cal.getAppts().get(0), a);
    }
    @Test
    public void testSets(){
        GregorianCalendar today = new GregorianCalendar(2017,3,5);
        CalDay cal = new CalDay(today);
        assertEquals(cal.getDay(), 5);
        assertEquals(cal.getMonth(), 3);
        assertEquals(cal.getYear(), 2017);
    }

    @Test
    public void testToString(){
        GregorianCalendar today = new GregorianCalendar(2017,3,5);
        CalDay cal = new CalDay(today);
        //Date: March 5, 2017
        assertNotNull(cal.toString());
    }
    @Test
    public void testIterator(){
        CalDay cal = new CalDay();
        assertNull(cal.iterator());
        GregorianCalendar today = new GregorianCalendar(2017,3,5);
        Appt a = new Appt(4,30,5,3,2017,"Movies", "Go see movie");
        CalDay cal2 = new CalDay(today);
        cal2.addAppt(a);
        Iterator<Appt> itr = cal2.appts.iterator();
        Appt b = itr.next();
        assertEquals(b, a);
    }
}
