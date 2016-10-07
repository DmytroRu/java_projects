public class Wall
{
    private double length, width;
    private static double STDWINDOW = 864;
    private static double  STDDOOR = 2880;
    private int amtOfWindows, amtOfDoors;

    public Wall(double length, double width, int amtOfDoors, int amtOfWindows)
    {
        this.length = length;
        this.width = width;
        this.amtOfDoors = amtOfDoors;
        this.amtOfWindows = amtOfWindows;
    }

    private double getInitialArea()
    {
        return length * width;
    }
    public double getWallArea()
    {
        return getInitialArea() - amtOfDoors*STDDOOR - amtOfWindows*STDWINDOW;
    }

}
