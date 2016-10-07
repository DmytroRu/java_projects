class Labor
{
    private double unit_per_hour, wage_per_hour;

    Labor(double unit_per_hour, double wage_per_hour)
    {
        this.unit_per_hour = unit_per_hour;
        this.wage_per_hour = wage_per_hour;
    }
    //Given area returns dollars per hour
    double getPrice(double area)
    {
        return area * unit_per_hour * wage_per_hour;
    }
}