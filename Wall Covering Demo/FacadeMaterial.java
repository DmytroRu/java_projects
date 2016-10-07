public class FacadeMaterial extends Material
{
    public FacadeMaterial(String covBrand, double coverage, double prcUnit)
    {
        super(covBrand, coverage, prcUnit);
    }
    @Override
    public String toString( )
    {
        return "Facade " + super.toString();
    }
}
