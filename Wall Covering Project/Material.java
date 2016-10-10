import java.text.DecimalFormat;

class Material implements Comparable<Material>
{
   protected String type = null;
   private String covBrand;
   private Labor labor;

   private DecimalFormat df = new DecimalFormat("0.00$");
   private double coverageSqrFt;
   private double pricePerUnit;
   private double pricePerSqrFt;
   
   public Material(String covBrand, double coverage, double prcUnit)
   {
      this.covBrand = covBrand;
      this.pricePerUnit = prcUnit;
      this.coverageSqrFt = coverage;
      pricePerSqrFt = pricePerUnit/coverageSqrFt;
   }

   public void setType(String coveringType) {
      this.type = coveringType;
   }

   public String getType()
   {
      return type;
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

   public double materialCost(double area)
   {
      return pricePerSqrFt * area;
   }

   public double laborCost(double area)
   {
      return area/(labor.getPricePerUnit() * coverageSqrFt);
   }
   
   public int compareTo(Material wc)  // compares items based on the price per square foot
   {
      int result = this.getType().compareToIgnoreCase(wc.getType());
      if(result != 0)
      {
         return result;
      }
      else
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
   }

   public String toString()
   {
      String rv = "Material" + ", " + "Brand Name: " + this.covBrand + " " + "Cost: $" + df.format(this.getPricePerSqrFt())
               + " perSqFt. " + "Labor Cost per Unit of material: " + df.format(labor.getPricePerUnit()) + '\n';
      return rv;
   }

   public boolean isA(String x)
   {
      return x.equals(getType());
   }
}