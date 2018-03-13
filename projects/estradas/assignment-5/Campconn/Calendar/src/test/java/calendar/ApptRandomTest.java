package calendar;

import java.util.Calendar;
import java.util.Random;

import jdk.vm.ci.meta.Value;
import org.junit.Test;



import static org.junit.Assert.*;



/**
 * Random Test Generator  for Appt class.
 */

public class ApptRandomTest {
	private static final long TestTimeout = 20 * 500 * 1; /* Timeout at 30 seconds */
	private static final int NUM_TESTS = 100;

	/**
	 * Return a randomly selected method to be tests !.
	 */
	public static String RandomSelectMethod(Random random) {
		String[] methodArray = new String[]{"setTitle", "setRecurrence"};// The list of the of methods to be tested in the Appt class

		int n = random.nextInt(methodArray.length);// get a random number between 0 (inclusive) and  methodArray.length (exclusive)

		return methodArray[n]; // return the method name
	}

	/**
	 * Return a randomly selected appointments to recur Weekly,Monthly, or Yearly !.
	 */
	public static int RandomSelectRecur(Random random) {
		int[] RecurArray = new int[]{Appt.RECUR_BY_WEEKLY, Appt.RECUR_BY_MONTHLY, Appt.RECUR_BY_YEARLY};// The list of the of setting appointments to recur Weekly,Monthly, or Yearly

		int n = random.nextInt(RecurArray.length);// get a random number between 0 (inclusive) and  RecurArray.length (exclusive)
		return RecurArray[n]; // return the value of the  appointments to recur
	}

	/**
	 * Return a randomly selected appointments to recur forever or Never recur  !.
	 */
	public static int RandomSelectRecurForEverNever(Random random) {
		int[] RecurArray = new int[]{Appt.RECUR_NUMBER_FOREVER, Appt.RECUR_NUMBER_NEVER};// The list of the of setting appointments to recur RECUR_NUMBER_FOREVER, or RECUR_NUMBER_NEVER

		int n = random.nextInt(RecurArray.length);// get a random number between 0 (inclusive) and  RecurArray.length (exclusive)
		return RecurArray[n]; // return appointments to recur forever or Never recur
	}

	/**
	 * Generate Random Tests that tests Appt Class.
	 */
	@Test
	public void radnomtest() throws Throwable {

		long startTime = Calendar.getInstance().getTimeInMillis();
		long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;


		System.out.println("Start testing randomTest...");
		//int DM[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		try {
			for (int iteration = 0; elapsed < TestTimeout; iteration++) {
				long randomseed = System.currentTimeMillis(); //10
				//			System.out.println(" Seed:"+randomseed );
				Random random = new Random(randomseed);
				int startHour = ValuesGenerator.RandInt(random);
				int startMinute = ValuesGenerator.RandInt(random);
				int startDay = ValuesGenerator.RandInt(random);
				int startMonth = ValuesGenerator.getRandomIntBetween(random, 0, 13);
				int startYear = ValuesGenerator.RandInt(random);
				String title = "Birthday Party";
				String description = "This is my birthday party.";
				//Construct a new Appointment object with the initial data
				//System.out.printf("Month is: %d\n", startMonth);
				Appt appt = new Appt(startHour,
						startMinute,
						startDay,
						startMonth,
						startYear,
						title,
						description);
				//assertEquals(DM[startMonth], CalendarUtil.NumDaysInMonth(startYear,startMonth-1));
				if (!appt.getValid()) continue;
				for (int i = 0; i < NUM_TESTS; i++) {
					String methodName = ApptRandomTest.RandomSelectMethod(random);
					if (methodName.equals("setTitle")) {
						String newTitle = (String) ValuesGenerator.getString(random);
						appt.setTitle(newTitle);
					} else if (methodName.equals("setRecurrence")) {
						int sizeArray = ValuesGenerator.getRandomIntBetween(random, 0, 8);
						int[] recurDays = ValuesGenerator.generateRandomArray(random, sizeArray);
						int recur = ApptRandomTest.RandomSelectRecur(random);
						int recurIncrement = ValuesGenerator.RandInt(random);
						int recurNumber = ApptRandomTest.RandomSelectRecurForEverNever(random);
						appt.setRecurrence(recurDays, recur, recurIncrement, recurNumber);
					}
				}

				elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
				//if((iteration%10000)==0 && iteration!=0 )
				//System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);

			}
		} catch (NullPointerException e) {

		}

		System.out.println("Done testing random test...\n\n\n");
	}
}

//	 @Test
//	public void randomTestIsValid() throws Throwable {
//		 long startTime = Calendar.getInstance().getTimeInMillis();
//		 long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;
//		 System.out.println("Start testing isValid()...");
//try{
//		 for (int i = 0; elapsed < TestTimeout; i++) {
//
//
//			 long randomseed =System.currentTimeMillis(); //10
//			 Random random = new Random(randomseed);
////			 int [] randArray = ValuesGenerator.generateRandomArray(random, 4);
////
////			 StringBuilder yearStr = new StringBuilder();
////			 for (int n : randArray)
////				 yearStr.append(n);
////
////			 long yearL = 0;
////			 long factor = 1;
////			 for (int place = yearStr.length()-1; place >= 0; place--) {
////				 yearL += Character.digit(yearStr.charAt(place), 10) * factor;
////				 factor *= 10;
////			 }
////
////			 int randYear = (int) yearL;
//
//
//			 Appt a = new Appt(5, 5, 5, 5, 5, "test", "test");
//
//			 for (int j = 0; j < NUM_TESTS; j++) {
//				 a.setStartMinute(random.nextInt(80) - 5);
//				 if(!a.getValid())continue;
//				 a.setStartHour(random.nextInt(80) - 5);
//				 if(!a.getValid())continue;
//				 a.setStartDay(random.nextInt(80) - 5);
//				 if(!a.getValid())continue;
//				 a.setStartMonth(random.nextInt(80) - 5);
//				 if(!a.getValid())continue;
////				 a.setStartYear(randYear);
////				 if(!a.getValid())continue;
//			 }
//			 //if(!appt.getValid())continue;
//
//			 elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
//			 if ((i % 10000) == 0 && i != 0)
//				 System.out.println("elapsed time: " + elapsed + " of " + TestTimeout);
//		 }
//		 System.out.println("Done testing isValid()...");
//	 }
//	 catch(IndexOutOfBoundsException ex){System.out.println("Invalid value to set.");}
//
//	 }
//
//	 @Test
//	public void testSetRecur() throws Throwable{
//		 long startTime = Calendar.getInstance().getTimeInMillis();
//		 long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;
//		 System.out.println("Start testing setRecur()...");
//		 for (int i = 0; elapsed < TestTimeout; i++) {
//			 long randomseed =System.currentTimeMillis(); //10
//			 Random random = new Random(randomseed);
//			 Appt ap = new Appt(4,4,4,4,2018,"tester","tester");
//			 int [] randRecurDays = null;
//			 ap.setRecurrence(randRecurDays, ApptRandomTest.RandomSelectRecur(random), ValuesGenerator.RandInt(random), ApptRandomTest.RandomSelectRecurForEverNever(random));
//			 for (int j = 0; j < NUM_TESTS; j++) {
//			 	randRecurDays = ValuesGenerator.generateRandomArray(random,ValuesGenerator.getRandomIntBetween(random, 0, 6));
//				//then test again with some random values
//				 int randRecurBy = ApptRandomTest.RandomSelectRecur(random);
//				 int randRecurInc = ValuesGenerator.RandInt(random);
//				 int randRecurNum = ApptRandomTest.RandomSelectRecurForEverNever(random);
//			 	ap.setRecurrence(randRecurDays, randRecurBy, randRecurInc, randRecurNum);
//				assertArrayEquals(randRecurDays, ap.getRecurDays());
//			  }
//
//			 elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
//			 if ((i % 10000) == 0 && i != 0)
//				 System.out.println("elapsed time: " + elapsed + " of " + TestTimeout);
//		 }
//		 System.out.println("Done testing setRecur()...");
//	 }
//
//
//
//}
