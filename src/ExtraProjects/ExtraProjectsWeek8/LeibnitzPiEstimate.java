package ExtraProjects.ExtraProjectsWeek8;

public class LeibnitzPiEstimate extends EstimatePi{

    public LeibnitzPiEstimate() {
        super();
    }

    public double getPiEstimate(){
        super.piEstimate = 0;
        for (int i = 0; i<10000000; i++){
            super.piEstimate += 4*Math.pow(-1, i) / (2*i + 1);
        }
        
        return super.piEstimate;
    }
    
    public static void main (String[] args){
        EstimatePi piEstimate1 = new LeibnitzPiEstimate();
        double piEstimateValue = piEstimate1.getPiEstimate();
        System.out.println(piEstimateValue);
    }
}

