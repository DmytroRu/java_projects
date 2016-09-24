import java.util.Scanner;

class RunBeanMachine
{
   public static void main(String[ ] args)
   {
      Scanner myScanner = new Scanner(System.in);
      System.out.print("Enter the number of slots at the bottom of the machine: ");
      int nSlots = myScanner.nextInt( );   
      System.out.print("Enter the number of beans to simulate: ");
      int nBeans = myScanner.nextInt( );
      BeanMachine aBeanMachine = new BeanMachine(nSlots, nBeans);
      
      //This would activate the no argument constructor
      //BeanMachine aBeanMachine = new BeanMachine( );

      System.out.println(aBeanMachine.getPaths());
      System.out.println(aBeanMachine.getHistogram());
   }                      
}