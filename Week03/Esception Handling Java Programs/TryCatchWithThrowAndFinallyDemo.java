// Here is a demonstration of a "throw" statment which permits one to 
// define conditions for exceptions.  Also, "finally" is shown in use.

import java.util.*;
class TryCatchWithThrowAndFinallyDemo
{
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args)
	{
		System.out.print("Please enter the fee as a positive number: ");
		double fee = getFee();
		System.out.println("You entered: " + fee);
   }

	public static double getFee()
	{
		double fee = 0.0;
		String inputStr = "";
		while (true) // loops until good input is entered
		{
         try
			{
            inputStr = sc.next();
            fee = Double.parseDouble(inputStr);

            if (fee < 0)
               throw new Exception(" Negative fee: bad! ");
            return fee;    
         } 
			catch (NumberFormatException e)  // number format error
			{
			   System.out.print("Enter numbers only!  Try again: ");
			}
         catch (Exception e) // generic error
			{
            System.out.print("Error:" + e.getMessage() + "Try again: ");
			}
         finally
         {
            System.out.println("Have a nice day!");
         }   
		}
	}		  
}