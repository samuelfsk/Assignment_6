
public class Child extends Ticket {
	
	/**
	 * non-arg constructor
	 */
	public Child() {
		super();
	}
	
	/**
	 * parameterized constructor
	 * @param name
	 * @param rating
	 * @param day
	 * @param time
	 * @param feature
	 */
	public Child(String name,String rating, int day, int time, String feature) {
		super(name,rating,day,time,feature);
	}
    /**
     * this method will calculate the price of tickets for the children
     */
	@Override
	public double calculateTicketPrice() {
		double price =0;
		if (getTime()<18) {
			if(getFeature().equals("NONE")) {
				price = 5.75;
			}
			else if(getFeature().equals("3D")) {
				price = 5.75+1.5;
			}
			else if(getFeature().equals("IMAX")){
				price = 5.75+2;
			}
			
		}
		else {
			if(getFeature().equals("NONE")){
				price = 10.75;
			}
			else if(getFeature().equals("3D")) {
				price = 10.75+1.5;
			}
			else if(getFeature().equals("IMAX")) {
				price = 10.75+2;
			}
			
		}
		price = price +(price*TAX);
		
		return price;
	}
    /**
     * returns -1 because child donesn't have id
     */
	@Override
	public int getId() {
		return -1;
	}
	
	
	/**
	 * returns a String with the information of the ticket
	 */
	public String toString() {
		if(getFeature().equals("NONE")) {
			return "CHILD "+super.toString();
		}
		else if(getFeature().equals("3D")) {
			return "CHILD 3D "+super.toString();
		}
		else if(getFeature().equals("IMAX")) {
			return "CHILD IMAX "+super.toString();
		}
		else {
			return null;
		}
		
		
	}

}
