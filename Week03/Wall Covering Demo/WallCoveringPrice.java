/* 
   This implements a subclass of the class, WallCovering.  It adds the field pricePerUnit.
   
   This program demonstrates implementation of the Comparable interface's only method, 
   compareTo( ).  With this, the objects of the class can be compared based on the price 
   of the material.  Then, for instance, one is able to utilize the Collections class 
   "sort" method.  The compareTo( ) method informs on how to compare and sort the objects.
     
*/

class WallCoveringPrice extends WallCovering implements Comparable<WallCoveringPrice>
{
   private double pricePerUnit;
   
   public WallCoveringPrice()
   {
      this("undefined type", "undefined brand", 0.0);
   }
   
   public WallCoveringPrice(String covType, String covBrand, double prcUnit)
   {
      super(covType, covBrand); // explicitly activate the constructor of the super class  
      pricePerUnit = prcUnit;
   }
   
   public double getPricePerUnit() // accessor method needed to implement compareTo( )
   {
      return pricePerUnit;
   }   
   
   public int compareTo(WallCoveringPrice wc)  // compares items based on the price per unit
   {
      int comparisonResult;
      if (this.pricePerUnit == wc.getPricePerUnit())
         comparisonResult = 0;
      else if (this.pricePerUnit > wc.getPricePerUnit())    
         comparisonResult = 1;
      else
         comparisonResult = -1;
      return comparisonResult;
   }
   
   @Override // this overrides the toString method of the parent class.
   public String toString( )
   {
      return "Item: " + super.getCoveringType( ) + " " + super.getCoveringBrand( ) + " " + pricePerUnit;
   }            
}     
   
   
   
      