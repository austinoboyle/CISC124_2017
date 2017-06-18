package extraProjectsWeek4;

public class Odometer {
    
    private double mileage; //miles
    private double fuelEfficiency; //miles per gallon
    
    public void resetOdometer()
    {
        this.mileage = 0;
    }
    
    public void changeEfficiency(double newEfficiency)
    {
        this.fuelEfficiency = newEfficiency;
    }
    public double fuelConsumed()
    {
        return this.mileage / this.fuelEfficiency;
    }
    public void newTrip(double mileage)
    {
        this.mileage += mileage;
    }
    
    public static void main(String[] args)
    {
        Odometer odometer = new Odometer();
        odometer.resetOdometer();
        odometer.changeEfficiency(10);
        odometer.newTrip(20);
        System.out.printf("%.3f\n", odometer.fuelConsumed());
        odometer.changeEfficiency(8);
        odometer.resetOdometer();
        odometer.newTrip(142.2);
        System.out.printf("%.3f\n",odometer.fuelConsumed());
        
    }
    
}
