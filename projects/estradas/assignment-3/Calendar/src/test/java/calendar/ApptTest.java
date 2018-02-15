package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  Appt class.
 */
import org.junit.Test;

import static org.junit.Assert.*;
public class ApptTest {
    /**
     * Test that the gets methods work as expected.
     */
	 @Test
	  public void test01()  throws Throwable  {
		 int startHour=21;
		 int startMinute=30;
		 int startDay=15;
		 int startMonth=01;
		 int startYear=2018;
		 String title="Birthday Party";
		 String description="This is my birthday party.";
		 //Construct a new Appointment object with the initial data	 
		 Appt appt = new Appt(startHour,
		          startMinute ,
		          startDay ,
		          startMonth ,
		          startYear ,
		          title,
		         description);
	// assertions
		 assertTrue(appt.getValid());
		 assertEquals(21, appt.getStartHour());
		 assertEquals(30, appt.getStartMinute());
		 assertEquals(15, appt.getStartDay());
		 assertEquals(01, appt.getStartMonth());
		 assertEquals(2018, appt.getStartYear());
		 assertEquals("Birthday Party", appt.getTitle());
		 assertEquals("This is my birthday party.", appt.getDescription());         		
	 }

	@Test
	public void testCompareTo(){
		Appt a = new Appt(4, 00, 3, 2, 2017, "Doctor", "Go to the doctor");
		Appt b = new Appt(3,00,5,1,2017,"Title", "Des");
		int asum = a.getStartHour() + a.getStartDay() + a.getStartMonth() + a.getStartYear();
		int bsum = b.getStartHour() + b.getStartDay() + b.getStartMonth() + b.getStartYear();
		int expectedRet = asum - bsum;
		assertEquals(expectedRet, a.compareTo(b));
	}

	 @Test
	  public void testTimeSet() {
		 Appt a = new Appt(13, 10, 10 , 4, 2017, "something", "another thing");

		 a.setStartHour(120);
		 assertFalse(a.getValid());
		 a.setStartMinute(10);
		 a.setStartDay(10);
		 a.setStartMonth(10);
		 a.setStartYear(2017);
		 a.setTitle(null);
		 a.setDescription(null);
		 int recurDays [] = {3,4,5};
		 a.setRecurrence( recurDays, 1, 4, Appt.RECUR_NUMBER_FOREVER);
		 assertArrayEquals(recurDays, a.getRecurDays());
		 assertTrue(a.isRecurring());
		 assertEquals(1, a.getRecurBy());

	 }


//add more unit tests as you needed
	
}
