
public class Employee extends Ticket{
	private int Id;
	private int timeSeen;
	
	
	
	/**
	 * non-arg constructor
	 */
	public Employee() {
		super();
		Id=0;
		timeSeen=0;
	}
	
	/**
	 * parameterized constructor
	 * @param name
	 * @param rating
	 * @param day
	 * @param time
	 * @param feature
	 * @param Id
	 * @param timeSeen
	 */
	public Employee(String name,String rating, int day, int time, String feature, int Id, int timeSeen) {
		super(name,rating,day,time,feature);
		this.Id=Id;
		this.timeSeen=timeSeen;
	}
	/**
	 * returns the time seen of an employee
	 * @param id
	 * @return timeSeen
	 */
	public int numVisist(int id) {
		return timeSeen;
	}
     /**
      * this method will calculate the price of  the ticket for an employee
      */
	@Override
	public double calculateTicketPrice() {
		double price=0;
         if (timeSeen>=2) {
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
        	 
        	 price = (price)/2;
        	 price = price+(price*TAX);
         }
		return price;
	}
    
	
	/**
	 * returns the number of time an employee have seen the movie
	 * @return
	 */
	public int getTimeSeen() {
		return timeSeen;
	}
	/**
	 * sets the number of time an employee have seen a movie
	 * @param timeSeen
	 */
	public void setTimeSeen(int timeSeen) {
		this.timeSeen=timeSeen;
	}
	
	/**
	 * returns the id of the employee
	 */
	@Override
	public int getId() {
		return Id;
	}
	
	/**
	 * returns a string value which contains the information of the ticket
	 */
	public String toString() {
		if(getFeature().equals("NONE")) {
			return "EMPLOYEE-"+Id+" "+super.toString();
		}
		else if(getFeature().equals("3D")) {
			return "EMPLOYEE-"+Id+" 3D "+super.toString();
		}
		else if(getFeature().equals("IMAX")) {
			return "EMPLOYEE-"+Id+" IMAX "+super.toString();
		}
		else {
			return null;
		}
	}

}
