import java.text.DecimalFormat;

class Material implements Comparable<Material>
{
   public static String MAT = "Material";
   private String covBrand;
   private Labor labor;

   private DecimalFormat df = new DecimalFormat("0.00$");
   private double coverageSqrFt;
   private double pricePerUnit;
   public double pricePerSqrFt;
   
   public Material(String covBrand, double coverage, double prcUnit)
   {
      covBrand = covBrand;
      pricePerUnit = prcUnit;
      coverageSqrFt = coverage;
      pricePerSqrFt = pricePerUnit/coverageSqrFt;
   }

   public String getCoveringBrand( )
   {
      return covBrand;
   }

   public double getPricePerSqrFt()
   {
      return pricePerSqrFt;
   }

   public void setLabor(Labor x)
   {
      this.labor = x;
   }
   
   public int compareTo(Material wc)  // compares items based on the price per square foot
   {
         int comparisonResult;

         if (this.pricePerSqrFt == wc.getPricePerSqrFt())
            comparisonResult = 0;
         else if (this.pricePerSqrFt > wc.getPricePerSqrFt())
            comparisonResult = 1;
         else
            comparisonResult = -1;
         return comparisonResult;
      }
   @Override
   public String toString( )
   {
      return MAT + super.toString();
   }

   public static boolean isA(String x)
   {
      return MAT.equals(x);
   }
}