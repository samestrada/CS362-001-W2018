
package finalprojectB;

import junit.framework.TestCase;

//You can use this as a skeleton for your 3 different test approach
//It is an optional to use this file, you can generate your own test file(s) to test the target function!
// Again, it is up to you to use this file or not!





public class UrlValidatorTest extends TestCase {


    public UrlValidatorTest(String testName) {
        super(testName);
    }


    public void testManualTest() {
//You can use this function to implement your manual testing
        String pass1 = "ftp://www.google.com";
        String pass2 = "http://www.google.com/stuff";
        String fail1 = "htp://www.google.com";
        String fail2 = "http:/www.google.com";
        String fail3 = "http://ww.google.com";
        String fail4 = "http://www.google.com.stuff";
        String pass3 = "http://www.ggle.com";
        String fail5 = "http://www.g:oogle.com";

        //String[] schemes = {"http", "ftp"};

        UrlValidator u = new UrlValidator( 1L);
        u.isValid(pass1);
        assertTrue(u.isValid(pass2));
        assertTrue(u.isValid(pass3));

        assertFalse(u.isValid(fail1));
        assertFalse(u.isValid(fail2));
        assertFalse(u.isValid(fail3));
        assertFalse(u.isValid(fail4));
        assertFalse(u.isValid(fail5));
    }

    public void testManualTestOptions() {
//You can use this function to implement your manual testing
        String pass1 = "ftp://www.google.com";
        String pass2 = "http://www.google.com/stuff";
        String fail1 = "htp://www.google.com";
        String fail2 = "http:/www.google.com";
        String fail3 = "http://ww.google.com";
        String fail4 = "http://www.google.com.stuff";
        String pass3 = "http://www.ggle.com";
        String fail5 = "http://www.g:oogle.com";
        String[] schemes = {"http", "ftp"};

        UrlValidator u = new UrlValidator(schemes, 0);
        assertTrue(u.isValid(pass1));
        assertTrue(u.isValid(pass2));
        assertTrue(u.isValid(pass3));

        assertFalse(u.isValid(fail1));
        assertFalse(u.isValid(fail2));
        assertFalse(u.isValid(fail3));
        assertFalse(u.isValid(fail4));
        assertFalse(u.isValid(fail5));
    }


   public void testPartition1()
   {
       String pass1 = "http://www.google.com:80/test1?action=view"; //scheme,authority,port,path,and query all valid

       UrlValidator u = new UrlValidator();
       assertTrue(u.isValid(pass1));

	 //You can use this function to implement your First Partition testing

   }

   public void testPartition2(){
       String fail1 = "http:/go.com:80/t123"; //incorrect scheme, all other components correct
       UrlValidator u = new UrlValidator();
       assertFalse(u.isValid(fail1));
       //You can use this function to implement your Second Partition testing

   }
   //You need to create more test cases for your Partitions if you need to

    public void testPartition3(){
        String fail1 = "http://1.2.3.4.5:80/t123"; //incorrect authority
        UrlValidator u = new UrlValidator();
        assertFalse(u.isValid(fail1));
    }

    public void testPartition4(){
        String fail1 = "http://google.com:-1/t123"; //incorrect port
        UrlValidator u = new UrlValidator();
        assertFalse(u.isValid(fail1));
    }

    public void testPartition5(){
        String fail1 = "http://go.com:80/../"; //incorrect path
        UrlValidator u = new UrlValidator();
        assertFalse(u.isValid(fail1));
    }

   public void testIsValid() {
       int code;
       String so;
       boolean ex, ac, pass;
       UrlValidator u = new UrlValidator();

       String test;
       String[] scheme = {"http://", "ftp://", "poop/", "http/:"};
       String[] authority = {"www.google.com", "255.255.255.255", "moo.poop", "255.com"};
       String[] port = {"", ":8008", ":-1", ":asci"};
       String[] path = {"", "/moo", "/.", "/#"};

       pass = true;

       for (int i = 0; i < 4; i++) {
           for (int j = 0; j < 4; j++) {
               for (int k = 0; k < 4; k++) {
                   for (int l = 0; l < 4; l++) {
                       test = scheme[i] + authority[j] + port[k] + path[l];
                       if (i > 1 || j > 1 || k > 1 || l > 1) {
                           ex = false;
                       } else {
                           ex = true;
                       }
                       ac = u.isValid(test);
                       if (ex != ac) {
                           pass = false;
                           code = i * 1000 + j * 100 + k * 10 + l;
                           so = Integer.toString(code);
                           for (int m = so.length(); m < 4; m++) {
                               so = '0' + so;
                           }
                           so = so + " expected " + String.valueOf(ex);
                           System.out.println(so);
                       }
                   }
               }
           }
       }
   }
}
