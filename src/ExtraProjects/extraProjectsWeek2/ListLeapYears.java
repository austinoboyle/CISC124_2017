package extraProjectsWeek2;

public class ListLeapYears {

	
	public static void getLeapYears(final int startYear, final int endYear){
	    for (int year = startYear; year <= endYear; year++){
	        if (year % 4 == 0){
	            if (year % 100 != 0 || year % 400 == 0)
	                System.out.println(year);
	        }
	            
	    }
	}
	public static void getLeapYearsSwitch(final int startYear, final int endYear){
	    for (int year = startYear; year <= endYear; year++){
	        switch (year % 4){
	        
	        case 0: 
	            switch (year % 100){
	            case 0:
	                switch (year % 400){
	                case 0:
	                    System.out.println(year);
	                    continue;
                    default:
                        continue;
	                }
	            default:
	                System.out.println(year);
	                continue;
	            }    
	        default: continue;
	        }
	    }

	}
	
	public static void main(String[] args){
	    getLeapYearsSwitch (0,400);
	    
	}
	
}
