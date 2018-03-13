package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  TimeTable class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;


import org.junit.Test;

import static org.junit.Assert.*;

public class TimeTableTest {

	@Test
	public void testAppRange()  throws Throwable  {
		TimeTable t = new TimeTable();
		GregorianCalendar day1 = new GregorianCalendar(2018, 2, 1);
		GregorianCalendar day2 = new GregorianCalendar(2018, 2, 3);

		Appt invalid = new Appt(12, 30, 60, 3, 2018, "something","something");

		CalDay test2 = new CalDay(day1);

		Appt a1 = new Appt(12, 30, 1, 2, 2018, "Doctor", "Go to doctor."); //Invalid appt

		int[] recurArr = {1, 2, 3};
		a1.setRecurrence(recurArr, 1, 1, 3);
		assertEquals(3, a1.getRecurDays().length);
		LinkedList<CalDay> appts;
		test2.addAppt(a1);
		appts = t.getApptRange(test2.getAppts(), day1, day2);
		assertEquals(2, appts.size());

		test2.addAppt(invalid);
		assertEquals(1,test2.getSizeAppts());

	}

}
