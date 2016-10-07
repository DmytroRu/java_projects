public class PaintFacadeMaterial extends FacadeMaterial
{
    public PaintFacadeMaterial(String covBrand, double coverage, double prcUnit)
    {
        super(covBrand, coverage, prcUnit);
    }
    @Override
    public String toString()
    {
        return "Item: " + getCoveringBrand( ) + " " + "Cost: " + getPricePerSqrFt() + " perSqFt" + "\n";
    }
}