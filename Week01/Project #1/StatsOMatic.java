import java.util.*;
/** BeanMachine
  * This class will calculate a five number summary. The user inputs the amount of numbers
  wished to calculate, and the program will generate an array of random doubles 
  * @author Dmytro Rudenkyy
  * Date: 09/08/2016
  * 
  */  
class StatsOMatic{
   /** Data field
       paths - Left-Right sequence that a dropping bean follows
     */  
   private String paths = "";

   /** Data field
       histogram - graphical representation of binned beans
     */  
   private String histogram = "";
   
   /** Construct default BeanMachine 
       Will initialize data fields to zero
     */  
   public BeanMachine( )
   {
      this(0, 0);  // activate the constructor below...
   }

   /** Construct a BeanMachine with specified
       number of slots and number of beans, and
       then process the beans in the machine.
       @param nSlots the number of slots in machine
       @param nBeans the number of beans to process 
     */  
   public BeanMachine(int nSlots, int nBeans)
   {
      int nLevels = nSlots - 1;        // the number of rows of pegs
      int[ ] slots = new int[nSlots];  // array representing the bins
      int binIndex;                    // index for slots array
      for(int i = 1; i <= nBeans; i++) // process each bean
      {
         binIndex = 0;
         paths =  paths + "bean " + i + " path: \t";
         for(int j = 0; j < nLevels; j++)
         {
            if(((int)(Math.random( ) * 10.0)) <= 4) // random value 0 to 4 means fall Right
            {
               paths = paths + "R";
               binIndex++;
            }
            else                                    // random value 5 to 9 means fall Left
            {
               paths = paths + "L";
            }   
         }
         paths = paths + "\n";
         slots[binIndex]++;  
      }     
      histogram(slots);     
   }  
   
   /** return the histogram
       @return histogram
     */  
   public String getHistogram( )
   {
      return histogram;
   }
   
   /** return the paths the beans took
       @return paths
     */  
   public String getPaths( )
   {
      return paths;
   }      
   /** create the histogram data member showing
     * the distribution of the beans in the bins
     */
   private void histogram(int[ ] data)
   {  
      histogram = "\n";    
      for(int i = 0; i < data.length; i++)
      {
         histogram = histogram + (" " + data[i] + "\t");
         for(int j = 0; j < data[i]; j++)
            histogram = histogram + ("o");
         histogram = histogram + "\n";   
      }
   }
}         