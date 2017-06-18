
package ExtraProjects.ExtraProjectsWeek8;

public abstract class EstimatePi {

    double piEstimate;
    public EstimatePi() {
        this.piEstimate = getPiEstimate();
    }
    
    public abstract double getPiEstimate();

}
