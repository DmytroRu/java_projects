import java.io.*;
import java.util.*;


class ProjectMain
{
   private enum Facade {
   PAINT, PANEL, PLANK, PLASTER, TILE, WALLPAPER}

   private static String selToFacade(int x)
   {
      switch (Facade.values()[x-1]) {
         case PAINT:     return "Paint";
         case PANEL:     return "Panel";
         case PLANK:     return "Plank";
         case PLASTER:   return "Plaster";
         case TILE:      return "Tile";
         case WALLPAPER: return "Wallpaper";
         default:
            System.out.println("Invalid Facade Selected.");
            return "Error";
      }
   }

   public static void main(String[] args)
   {
      ArrayList<Material> materials = new ArrayList<>();
      try
      {
         materials = loadData("WallCoveringCostData.csv");

         // With JCF objects that implement Comparable interface, one can sort the data with
         // the following easy statement:

         Collections.sort(materials);
         //System.out.print(materials);
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
      double length = 10, width = 10;
      double area;
      int amtOfWindows = 0, amtOfDoors = 0;

      //Start User input
      Scanner scanner = new Scanner(System.in);

//      System.out.print("Hello Customer!" + '\n' + '\n');
//      System.out.println("What is the size of the room you wish to cover?");
//      System.out.print("Enter length in feet: ");
//      length = scanner.nextDouble();
//      System.out.print("Enter width in feet: ");
//      width = scanner.nextDouble();
//      System.out.print("Enter the amount of doors in room: ");
//      amtOfDoors = scanner.nextInt();
//      System.out.print("Enter the amount of windows in room: ");
//      amtOfWindows = scanner.nextInt();

      Wall wall = new Wall(length, width, amtOfDoors, amtOfWindows);
      area = wall.getWallArea();

      System.out.println("The area of the wall needed to be covered is :" + area + '\n');

      System.out.println("These are these available wall covering options: 1.Paint, 2.Panel, 3.Plank, 4.Plaster, 5.Tile or 6.Wallpaper");
      System.out.print("Please enter the number that corresponds to desired option: ");
      String facadeSelection = selToFacade(scanner.nextInt());
      ArrayList<Material> facadeMaterials = new ArrayList<>();
      ArrayList<Material> insulMaterials  = new ArrayList<>();
      ArrayList<Material> baseMaterials   = new ArrayList<>();
      for(Material x : materials)
      {
         if( x instanceof FacadeMaterial)
         {
            if(facadeSelection.equals("Paint"))
            {
               if(x instanceof PaintFacadeMaterial)
               {
                  facadeMaterials.add(x);
               }
            }
            else if(facadeSelection.equals("Panel"))
         }
         if( x instanceof InsulationMaterial){
            insulMaterials.add(x);
         }
         if( x instanceof  BaseMaterial) {
            if(facadeSelection.equals("Tile"))
            {
               if(x instanceof ConcreteBoardBaseMaterial)
               {
                  baseMaterials.add(x);
               }
            }
            else
            {
               if(!(x instanceof  ConcreteBoardBaseMaterial))
               {
                  baseMaterials.add(x);
               }
            }

         }
      }

      Collections.sort(insulMaterials);
      Collections.sort(baseMaterials);
      Collections.sort(facadeMaterials);

      int bestBase = baseMaterials.size() -1 ;
      int bestFacade = facadeMaterials.size() -1;

      int betterBase = (baseMaterials.size() -1)/2;
      int betterFacade = (facadeMaterials.size()-1)/2;


      ConstructedWall goodWall = new ConstructedWall(area, baseMaterials.get(0), insulMaterials.get(0), facadeMaterials.get(0));
      ConstructedWall betterWall = new ConstructedWall(area, baseMaterials.get(betterBase), insulMaterials.get(1), facadeMaterials.get(betterFacade));
      ConstructedWall bestWall = new ConstructedWall(area, baseMaterials.get(bestBase), insulMaterials.get(1), facadeMaterials.get(bestFacade));

      System.out.println("A good solution -------------------------------------------------------------------------------"
               + '\n' + goodWall.finishedWallString());
      System.out.println("A better solution -----------------------------------------------------------------------------"
              + '\n' + betterWall.finishedWallString());
      System.out.println("A best solution: ------------------------------------------------------------------------------"
              + '\n' + bestWall.finishedWallString());

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

         //A for loop used with an iterator to give each material its proper units per hour and wage per hour
         if(fields[0].equals("Labor"))
         {
            for(Material x : theCoveringData)
            {
               if (x.isA(fields[1]))
               {
                  x.setLabor(new Labor(Double.parseDouble(fields[6]), Double.parseDouble(fields[7])));
               }
            }
         }
         else if (fields[0].equals("Materials"))
         {
                 if(fields[1].equals("Concrete Board"))  { theCoveringData.add(new ConcreteBoardBaseMaterial(fields[2], Double.parseDouble(fields[4]), Double.parseDouble(fields[5]))); }
            else if(fields[1].equals("Gypsum Board"))    { theCoveringData.add(new GypsumBoardBaseMaterial  (fields[2], Double.parseDouble(fields[4]),     Double.parseDouble(fields[5]))); }
            else if(fields[1].equals("Insulation"))      { theCoveringData.add(new InsulationMaterial       (fields[2], Double.parseDouble(fields[4]),     Double.parseDouble(fields[5]))); }
            else if(fields[1].equals("Paint"))           { theCoveringData.add(new PaintFacadeMaterial      (fields[2], Double.parseDouble(fields[4]),     Double.parseDouble(fields[5]))); }
            else if(fields[1].equals("Panel"))           { theCoveringData.add(new PanelFacadeMaterial      (fields[2], Double.parseDouble(fields[4]),     Double.parseDouble(fields[5]))); }
            else if(fields[1].equals("Plank"))           { theCoveringData.add(new PlankFacadeMaterial      (fields[2], Double.parseDouble(fields[4]),     Double.parseDouble(fields[5]))); }
            else if(fields[1].equals("Plaster"))         { theCoveringData.add(new PlasterFacadeMaterial    (fields[2], Double.parseDouble(fields[4]),     Double.parseDouble(fields[5]))); }
            else if(fields[1].equals("Tile"))            { theCoveringData.add(new TileFacadeMaterial       (fields[2], Double.parseDouble(fields[4]),     Double.parseDouble(fields[5]))); }
            else if(fields[1].equals("Wallpaper"))       { theCoveringData.add(new WallpaperFacadeMaterial  (fields[2], Double.parseDouble(fields[4]),     Double.parseDouble(fields[5]))); }
         }
      }
      return theCoveringData; // returns an object of theCoveringData
   }
}//End Class
/*
for(Material x : facadeMaterials)
        {
        if( x instanceof FacadeMaterial) {
        //if( ... is instance of the facade you selected...)
        facadeMaterials.add(x);
        }
        if( x instanceof InsulationMaterial){
        insulMaterials.add(x);
        }
        if( x instanceof  BaseMaterial) {
        if(facadeSelection.equals("Tile"))
        {
        if(x instanceof ConcreteBoardBaseMaterial)
        {
        baseMaterials.add(x);
        }
        }
        else
        {
        if(!(x instanceof  ConcreteBoardBaseMaterial))
        {
        baseMaterials.add(x);
        }
        }

        }
        }

        Collections.sort(insulMaterials);
        Collections.sort(baseMaterials);
        Collections.sort(facadeMaterials);
        }
*/