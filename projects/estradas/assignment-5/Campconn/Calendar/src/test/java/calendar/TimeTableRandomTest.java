package calendar;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;
import java.util.LinkedList;

import org.junit.Test;


import static org.junit.Assert.*;



/**
 * Random Test Generator  for TimeTable class.
 */

public class TimeTableRandomTest {
	private static final int NUM_TESTS=50;
    long randomseed =System.currentTimeMillis();
    Random random = new Random(randomseed);
	Calendar today = Calendar.getInstance();
	int thisYear = today.get(Calendar.YEAR);

	TimeTable timeTable = new TimeTable();



	/**
	 * Generate Random Tests that tests TimeTable Class.
	 */
	@Test
	public void randomTest()  throws Throwable  {
		try {
			for (int i = 0; i < NUM_TESTS; i++) {
				LinkedList<Appt> appts = new LinkedList<Appt>();
				int thisMonth = 1;
				int thisDay = 1;
				GregorianCalendar day1 = new GregorianCalendar(thisYear, thisMonth, thisDay);

				GregorianCalendar day2 = (GregorianCalendar) day1.clone();
				day2.add(Calendar.DAY_OF_MONTH, (ValuesGenerator.getRandomIntBetween(random, 1, 10)));

				for (int j = 0; j < 50; j++) {
					int startHour = ValuesGenerator.getRandomIntBetween(random, -10, 30);
					int startMinute = ValuesGenerator.getRandomIntBetween(random, -10, 65);
					int startDay = ValuesGenerator.getRandomIntBetween(random, -10, 40);
					int startMonth = 1;
					int startYear = thisYear;
					String title = ValuesGenerator.getString(random);
					String description = ValuesGenerator.getString(random);

					Appt a = new Appt(startHour,
							startMinute,
							startDay,
							startMonth,
							startYear,
							title,
							description);

					appts.add(a);
				}

				timeTable.getApptRange(appts, day1, day2);
				int randNum = ValuesGenerator.RandInt(random);
				while (randNum > appts.size()) {
					randNum = ValuesGenerator.RandInt(random);
				}
				Appt a3 = appts.get(randNum);

				LinkedList<Appt> other = timeTable.deleteAppt(appts, a3);
				for (int k = 0; k < other.size(); k++) {
					assertTrue(other.get(k) != a3);
				}
			}

		}catch(NullPointerException e){}

	}
}
