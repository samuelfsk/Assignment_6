
public class Adult extends Ticket{
	
	
	/**
	 * non_arg constructor
	 */
	public Adult() {
		super();
	}
	
	/**
	 * parameterized constructor
	 * @param name the name
	 * @param rating  the ratings
	 * @param day the day
	 * @param time the time
	 * @param feature the feature
	 */
	public Adult(String name,String rating, int day, int time, String feature) {
		super(name,rating,day,time,feature);
	}
    /**
     * this method calculates the ticket price for the adult
     */
	@Override
	public double calculateTicketPrice() {
		double price =0;
		if (getTime()<18) {
			if(getFeature().equals("NONE")) {
				price = 10.5;
			}
			else if(getFeature().equals("3D")) {
				price = 10.5+2.5;
			}
			else if(getFeature().equals("IMAX")) {
				price = 10.5+3;
			}
			
		}
		else {
			if(getFeature().equals("NONE")) {
				price = 13.5;
			}
			else if(getFeature().equals("3D")) {
				price = 13.5+2.5;
			}
			else if(getFeature().equals("IMAX")) {
				price = 13.5+3;
			}
			
		}
		price = price +(price*TAX);
		
		return price;
	}
    
	/**
	 * returns -1 because adult customers don't have company id
	 */
	@Override
	public int getId() {
		return -1;
	}
	
	/**
	 * returns a string value which contain the information about the ticket
	 */
	public String toString() {
		if(getFeature().equals("NONE")) {
			return "ADULT "+super.toString();
		}
		else if(getFeature().equals("3D")) {
			return "ADULT 3D "+super.toString();
		}
		else if(getFeature().equals("IMAX")) {
			return "ADULT IMAX "+super.toString();
		}
		else {
			return null;
		}
	}

}
