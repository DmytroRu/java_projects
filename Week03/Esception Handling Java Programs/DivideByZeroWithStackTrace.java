//this is a classic runtime error with "Stack Trace" shown
public class DivideByZeroWithStackTrace
{
    public static void main(String[] args)
    {
       int a = 5;
	    int b = 0;
	    
		 try
       {
          int c = a / b;
       }
       catch (Exception e)
       {
          System.out.println(e.getMessage()); // methods of exception class 
          e.printStackTrace();                // provide more information
       }
    }
}
