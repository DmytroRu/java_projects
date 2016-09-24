import java.io*;
import java.util.*;

class Materials{
   public static void main(String[] args)
   {
      try
      {
         // an ArrayList is a very powerful class that has as it's underlying data structure
         // an array.  An array list is optimized for fast access to the data in the List.
         // The ArrayList is part of the Java Collections Framework (JCF).  If one required the
         // a system that is optimized for fast addtion and removal of data from the structure, 
         // one could choose a LinkedList instead.  ArrayList and LinkedList have a common
         // interface.  They both implement the interface List.
         
         ArrayList<WallCoveringPrice> theData = loadData("WallCoveringCostData.csv");
         
         // With JCF objects that implement Comparable interface, one can sorth the data with 
         // the following easy statement:
         
         Collections.sort(theData);
         System.out.println(theData);
      }   
      catch (IOException e)
      {
         System.out.print("   ERROR: Problem with the file " + e.getMessage());
         System.exit(0);
      }
      catch (Exception e)
      {
         System.out.println("   ERROR: " + e.getMessage());
         System.exit(0);         
      }   
   }
   
   // The JCF classes, like ArrayList and LinkedList, are "generic."  That is to say, they can work with
   // myriad classes.  One stipulation, however, is that the data stored in the JCF classes are
   // reference data types.  This makes storing primitives in and ArrayList or LinkedList an interesting
   // affair -- one must use "wrapper classes" to contain the primitive data.   
   private static ArrayList<WallCoveringPrice> loadData(String inputFileName) throws Exception
   {
      ArrayList<WallCoveringPrice> theCoveringData = new ArrayList<>();
            
      Scanner myScanner = new Scanner(new File(inputFileName)); // this creates an anonymous File object
      String lineOfInput;
      String fields[];
      
      myScanner.nextLine();  // discard the first line in the data file
  
      while (myScanner.hasNext())       
      {
         lineOfInput = myScanner.nextLine();
         fields = lineOfInput.split(",");
         if (fields[0].equals("Materials"))
         {
            WallCoveringPrice inputRow = new WallCoveringPrice(fields[1], fields[2], Double.parseDouble(fields[5]));
            theCoveringData.add(inputRow);
            inputRow = null;  // get rid of the now unneeded WallCoveringPrice object.
                              // (perhaps this step is not needed, but maybe it is)
         }
      }
      return theCoveringData; // returns an object of theCoveringData
   }            
}