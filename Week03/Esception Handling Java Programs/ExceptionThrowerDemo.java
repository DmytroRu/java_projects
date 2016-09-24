// this program has a method that throws exceptions
// the exceptions are "propagated back to a catcher

import java.util.*;
class ExceptionThrowerDemo
{
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args)
	{
		boolean badValue = true;
      while(badValue)
      {  
         System.out.print("Please enter the fee as a number greater than zero: ");
         try
         {
		      double fee = getFee();
		      System.out.println("   You entered: " + fee);
            badValue = false;
         }
         catch (Exception e)
         {
            System.out.println("   Error: " + e.getMessage());
         }
      }           
   }

	public static double getFee() throws Exception  //this is an exception thrower
	{
		double fee = 0.0;

		String inputStr = "";

      inputStr = sc.next();

      fee = Double.parseDouble(inputStr);

      if (fee < 0)
         throw new Exception(" Negative fee: bad!");
         
      if (fee == 0)
         throw new Exception(" Zero fee .. not permitted!");

      return fee;    
   }
}		  
