import java.text.DecimalFormat;

public class ConstructedWall
{
    private DecimalFormat df = new DecimalFormat("0.00$");
    private String newLine = "\n";

    private double area;
    private Material base;
    private Material insulation;
    private Material facade;

    public ConstructedWall(double area, Material base, Material insulation, Material facade)
    {
        this.area = area;
        this.base = base;
        this.insulation = insulation;
        this.facade = facade;
    }

    private double getArea()
    {
        return area;
    }
    //-----------------------------Get Labor and Material Cost----------------------------------------------------------
    private double baseMaterialCost()
    {
        return base.materialCost(getArea());
    }

    private double insulationMaterialCost()
    {
        return insulation.materialCost(getArea());
    }

    private double facadeMaterialCost()
    {
        return facade.materialCost(getArea());
    }

    private double baseLaborCost()
    {
        return base.laborCost(getArea());
    }

    private double insulationLaborCost()
    {
        return insulation.laborCost(getArea());
    }

    private double facadeLaborCost()
    {
        return facade.laborCost(getArea());
    }

    //-------------------------------Get Total Cost---------------------------------------------------------------------
    public double totalMaterialCost()
    {
       return baseMaterialCost() + insulationMaterialCost() + facadeMaterialCost();
    }

    public double totalLaborCost()
    {
        return baseLaborCost() + insulationLaborCost() + facadeLaborCost();
    }

    public double totalCost()
    {
        return totalLaborCost() + totalMaterialCost();
    }
    //------------------------------------------------------------------------------------------------------------------

    public String finishedWallString()
    {
        return base.getCoveringBrand() + ": Total base material cost is " + df.format(baseMaterialCost()) +
                                                ", Total base labor cost is " + df.format(baseLaborCost()) + newLine +

                insulation.getCoveringBrand() + ": Total insulation material cost is " + df.format(insulationMaterialCost()) +
                                            ", Total insulation labor cost is " + df.format(insulationLaborCost()) + newLine +

                facade.getCoveringBrand() + ": Total facade material cost is " + df.format(facadeMaterialCost()) +
                                                ", Total facade labor cost is " + df.format(facadeLaborCost()) + newLine +

                "Total cost for materials: " + df.format(totalMaterialCost()) + ", Total cost for Labor: " +
                df.format(totalLaborCost()) + ", Material and Labor cost is: " + df.format(totalCost());
    }
}//end Class