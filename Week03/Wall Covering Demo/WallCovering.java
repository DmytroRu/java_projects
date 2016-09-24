/* 
   This is simplified base class for the wall covering materials.  Notice the
   use of the accessibility modifier "protected" for the accessor methods. So,
   only the subclasses of WallCovering will have access to these methods.
*/

class WallCovering
{
   private String coveringType;
   private String coveringBrand;
   
   public WallCovering()
   {
      this("undefined type", "undefined brand");
   }
   
   public WallCovering(String covType, String covBrand)
   {
      coveringType = covType;
      coveringBrand = covBrand;   
   }

   @Override  // this will check the override the toString method of the Object class
   public String toString( )
   {
      return "Item: " + coveringType + " " + coveringBrand;
   }
   
   protected String getCoveringType( )
   {
      return coveringType;
   }
   
   protected String getCoveringBrand( )
   {
      return coveringBrand;
   }                    
}     
   
   
   
      