package myAmaysimTestSuite;

import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.junit.runner.JUnitCore;

public class TestSuiteRunner {
	
   public static void main(String[] args) {
	   
      Result result = JUnitCore.runClasses(MySettingsTestCases.class);
		
      for (Failure failure : result.getFailures()) {
         System.out.println(failure.toString());
      }
		
      System.out.println(result.wasSuccessful());
   }
}  	