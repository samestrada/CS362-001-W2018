package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  CalDay class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;


import org.junit.Test;

import static org.junit.Assert.*;

public class CalDayTest {


	@Test
	public void CalDay()
	{
		CalDay nonInit = new CalDay();
		assertEquals(false, nonInit.isValid());

		GregorianCalendar testDay = new GregorianCalendar();
		CalDay day = new CalDay(testDay);

		assertEquals(testDay.get(testDay.DAY_OF_MONTH), day.day);
		assertEquals(true, day.isValid());

	}

	@Test
	public void testIterator(){
		CalDay cal = new CalDay();
		assertNull(cal.iterator());
		GregorianCalendar today = new GregorianCalendar(2017,3,5);
		Appt a = new Appt(4,30,5,3,2017,"Movies", "Go see movie");
		CalDay cal2 = new CalDay(today);
		cal2.addAppt(a);
		java.util.Iterator<Appt> itr = cal2.appts.iterator();
		Appt b = itr.next();
		assertEquals(b, a);
	}


	@Test
	public void testAdd()  {
		GregorianCalendar day = new GregorianCalendar(2017,3,13);
		CalDay test = new CalDay(day);
		Appt a1 = new Appt(0, 30, 13, 3, 2017, "Anniversary", "Anniversary reminder.");
		Appt a2 = new Appt(12, 0, 13, 3, 2017, "Lunch date", "Des.");
		Appt a3 = new Appt(8, 30, 13, 3, 2017, "Class", "Early class!");
		Appt a4 = new Appt(-2, 100, 13, 3, 2017, "Dumb appt", "This shouldn't exist.");

		test.addAppt(a3);
		test.addAppt(a2);
		test.addAppt(a1);
		test.addAppt(a4);

		java.util.Iterator itr = test.iterator();


		assertEquals(3, test.getSizeAppts());
		assertEquals("Anniversary", test.getAppts().get(0).getTitle());
		assertEquals("Class", test.getAppts().get(1).getTitle());
		assertEquals("Lunch date", test.getAppts().get(2).getTitle());

		int current;
		int previous = 0;
		while(itr.hasNext()){
			Appt o = (Appt) itr.next();
			current = o.getStartHour();
			assertTrue(current >= previous);
			previous = current;
		}
		assertEquals("\t --- 3/13/2017 --- \n --- -------- Appointments ------------ --- \n\t3/13/2017 at 12:30am ,Anniversary, Anniversary reminder.\n \t3/13/2017 at 8:30am ,Class, Early class!\n \t3/13/2017 at 12:0pm ,Lunch date, Des.\n \n", test.toString());
	}

}