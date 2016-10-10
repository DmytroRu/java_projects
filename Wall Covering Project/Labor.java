class Labor
{
    private double unitsPerHour, wagePerHour;

    Labor(double unitsPerHour, double wagePerHour)
    {
        this.unitsPerHour = unitsPerHour;
        this.wagePerHour = wagePerHour;
    }

    public double getPricePerUnit()
    {
        return unitsPerHour /  wagePerHour;
    }
}