// Demonstration of bad deta entry using scanner.

import java.util.*;
class TryCatchWithInputMismatchException
{
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args)
	{
		System.out.print("Please enter an integer: ");
		int i = GetInteger();
		System.out.println("You entered: " + i);
   }

	public static int GetInteger()
	{
		while (true) //loops until good input is entered
		{
			try
			{
				return sc.nextInt();
			}
			catch (InputMismatchException e)
			{
				sc.next(); // next method -- "clear out the input buffer"
				System.out.print("Bad! Try again: ");
			}
		}
	}
}
