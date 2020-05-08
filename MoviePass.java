
public class MoviePass extends Ticket{
	private int Id;
	private int moviePerDay;
	private int movieSeen;
	private int timeSeen;
	
	
	/**
	 * non-arg constructor
	 */
	public MoviePass() {
		super();
		Id=0;
		moviePerDay=0;
		movieSeen=0;
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
	 * @param moviePerDay
	 * @param movieSeen
	 */
	public MoviePass(String name,String rating, int day, int time, String feature, int Id, int timeSeen, int moviePerDay, int movieSeen) {
		super(name,rating,day,time,feature);
		this.Id=Id;
        this.moviePerDay=moviePerDay;
        this.movieSeen=movieSeen;
        this.timeSeen=timeSeen;
	}
	
    /**
     * this method returns the ticket price for a movie pass used
     */
	@Override
	public double calculateTicketPrice() {
		double price=0;
		
		if(moviePerDay>0 || movieSeen>0 || feature.equalsIgnoreCase("IMAX")|| feature.equalsIgnoreCase("3D")) {
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
		}
		else if (timeSeen==0) {
			price=9.99;
		}
		    return price;
		
	}

	/**
	 * returns the id of the movie pass
	 */
	@Override
	public int getId() {

		return Id;
	}
	 
	public String getType() {
		return "MOVIEPASS";
	}
	
	/**
	 * returns a string value which contains information about the ticket
	 */
	public String toString() {
		if(getFeature().equals("NONE")) {
			return "MOVIEPASS-"+Id+" "+super.toString();
		}
		else if(getFeature().equals("3D")) {
			return "MOVIEPASS-"+Id+" 3D "+super.toString();
		}
		else if(getFeature().equals("IMAX")) {
			return "MOVIEPASS-"+Id+" IMAX "+super.toString();
		}
		else {
			return null;
		}
	}

}
