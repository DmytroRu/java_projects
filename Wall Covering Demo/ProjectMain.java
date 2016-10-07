import java.io.*;
import java.util.*;

class ProjectMain
{
   public static void main(String[] args)
   {
      try
      {
         ArrayList<Material> theData = loadData("WallCoveringCostData.csv");

         // With JCF objects that implement Comparable interface, one can sort the data with
         // the following easy statement:

         //Collections.sort(theData);
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

      //---------------Input/Calculating Data---------------------------------------------------------------------------
      double length, width;
      int amtOfWindows, amtOfDoors;
      String coveringType, quality;
      //Start User input
      Scanner scanner = new Scanner(System.in);

      System.out.print("Hello Customer!" + '\n' + '\n');
      System.out.println("What is the size of the room you wish to cover?");
      System.out.print("Enter length in feet: ");
      length = scanner.nextDouble();
      System.out.print("Enter width in feet: ");
      width = scanner.nextDouble();
      System.out.print("Enter the amount of doors in room: ");
      amtOfDoors = scanner.nextInt();
      System.out.print("Enter the amount of windows in room: ");
      amtOfWindows = scanner.nextInt();

      Wall wall = new Wall(length, width, amtOfDoors, amtOfWindows);

      System.out.println("The area of the wall needed to be covered is :" + wall.getWallArea() + '\n');

      System.out.println("These are the available wall covering options: Paint, Panel, Plank, Plaster, Tile or Wallpaper");
      System.out.print("Please type which one you prefer: ");
      coveringType = scanner.next();
   }
   
   // The JCF classes, like ArrayList and LinkedList, are "generic."  That is to say, they can work with
   // myriad classes.  One stipulation, however, is that the data stored in the JCF classes are
   // reference data types.  This makes storing primitives in and ArrayList or LinkedList an interesting
   // affair -- one must use "wrapper classes" to contain the primitive data.   
   private static ArrayList<Material> loadData(String inputFileName) throws Exception
   {
      ArrayList<Material> theCoveringData = new ArrayList<>();
            
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
            if(ConcreteBoardBaseMaterial.isA(fields[0]))    { theCoveringData.add(new ConcreteBoardBaseMaterial(fields[2], Double.parseDouble(fields[4]), Double.parseDouble(fields[5]))); }
            else if(GypsumBoardBaseMaterial.isA(fields[0])) { theCoveringData.add(new GypsumBoardBaseMaterial  (fields[2], Double.parseDouble(fields[4]), Double.parseDouble(fields[5]))); }
            else if(InsulationMaterial.isA(fields[0]))      { theCoveringData.add(new InsulationMaterial       (fields[2], Double.parseDouble(fields[4]), Double.parseDouble(fields[5]))); }
            else if(PaintFacadeMaterial.isA(fields[0]))     { theCoveringData.add(new PaintFacadeMaterial      (fields[2], Double.parseDouble(fields[4]), Double.parseDouble(fields[5]))); }
            else if(PanelFacadeMaterial.isA(fields[0]))     { theCoveringData.add(new PanelFacadeMaterial      (fields[2], Double.parseDouble(fields[4]), Double.parseDouble(fields[5]))); }
            else if(PlankFacadeMaterial.isA(fields[0]))     { theCoveringData.add(new PlankFacadeMaterial      (fields[2], Double.parseDouble(fields[4]), Double.parseDouble(fields[5]))); }
            else if(PlasterFacadeMaterial.isA(fields[0]))   { theCoveringData.add(new PlasterFacadeMaterial    (fields[2], Double.parseDouble(fields[4]), Double.parseDouble(fields[5]))); }
            else if(TileFacadeMaterial.isA(fields[0]))      { theCoveringData.add(new TileFacadeMaterial       (fields[2], Double.parseDouble(fields[4]), Double.parseDouble(fields[5]))); }
            else if(WallpaperFacadeMaterial.isA(fields[0])) { theCoveringData.add(new WallpaperFacadeMaterial  (fields[2], Double.parseDouble(fields[4]), Double.parseDouble(fields[5]))); }
         }
         //A for loop used with an iterator to give each material its proper units per hour and wage per hour
         else if(fields[0].equals("Labor"))
         {
            for(Material x : theCoveringData)
            {
               if (x.isA(fields[1]))
               {
                  x.setLabor(new Labor(Double.parseDouble(fields[6]), Double.parseDouble(fields[7])));
               }
            }
         }
      }
      return theCoveringData; // returns an object of theCoveringData
   }
}//End Class