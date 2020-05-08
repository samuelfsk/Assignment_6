/*
 * @author Samuel Hailemcichal
 * may 8th 2020
 */
public abstract class Ticket {
	private enum type {IMAX, THREED, NONE};
	private String name;
	private int time;
	private int day;
	private String rating;
	protected String feature;
	protected final double TAX =0.096; 

	/**
	 * non_arg constructor
	 */
	public Ticket() {
		name="";
		time=0;
		day=0;
		rating="";
		setFeature("");
	}
	/**
	 * parameterized constructor
	 * @param name the name
	 * @param rating  the ratings
	 * @param day the day
	 * @param time the time
	 * @param feature the feature
	 */
	public Ticket(String name,String rating, int day, int time, String feature) {
		this.name=name;
		this.setFeature(feature);
		this.time=time;
		this.day=day;
		this.rating=rating;
	
	}
	/**
	 * an abstract method 
	 * @return return the price of the ticket
	 */
	public abstract double calculateTicketPrice();
	/**
	 * an abstract method
	 * @return id
	 */
	public abstract int getId();
	
	/**
	 * sets the name
	 * @param name
	 */
	public void setName(String name) {
		this.name=name;
	}
	
	/**
	 * sets the rating of the ticket
	 * @param rating
	 */
	public void setRating(String rating) {
		this.rating=rating;
	}
	
	/**
	 * sets the day 
	 * @param day
	 */
	public void setDay(int day) {
		this.day=day;
	}
	
	/**
	 * sets the time
	 * @param time
	 */
	public void setTime(int time) {
		this.time=time;
	}
	/**
	 * returns the name
	 * @return String value equivalent to the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * returns the rating
	 * @return String value equivalent to the rating
	 */
	public String getRating() {
		return rating;
	}
	
	
	/**
	 * returns the day
	 * @return int value equivalent to the day
	 */
	public int getDay() {
		return day;
	}
	
	
	/**
	 * returns the time
	 * @return int value equivalent to the time
	 */
	public int getTime() {
		return time;
	}
	
	/**
	 * returns the feature
	 * @return String value equivalent to the feature
	 */
	public String getFeature() {
		return feature;
	}
	
    /**
     * sets the feature
     * @param feature
     */
	public void setFeature(String feature) {
		this.feature = feature;
	}
	
	/**
	 * returns type
	 * @return String value equivalent to the type of the ticket
	 */
	public String getType() {
		return "";
	}
	
	/**
	 * returns a String value which describes the ticket
	 */
	public String toString() {
		return "Movie: "+name+" Rating: "+rating+" Day: "+day+" Time: "+time+" Price: "+calculateTicketPrice();
	}
	
	
	
	
	
	
	
	
	
	

}
