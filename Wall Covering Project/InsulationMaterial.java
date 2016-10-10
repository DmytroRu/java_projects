public class InsulationMaterial extends Material
{
    private String type = "Insulation";

    public InsulationMaterial(String covBrand, double coverage, double prcUnit)
    {
        super(covBrand, coverage, prcUnit);
    }

    @Override
    public void setType(String coveringType)
    {
        super.setType(coveringType);
    }

    @Override
    public String getType()
    {
        return type;
    }

    public String toString()
    {
        return type + " " + super.toString();
    }
}