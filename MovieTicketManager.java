import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class MovieTicketManager implements MovieTicketManagerInterface {
	private ArrayList<String> Lists = new ArrayList<String>();
	private ArrayList<Ticket> ticketLists = new ArrayList<Ticket>();
	
	Ticket x = new Adult();
	private double total=0;
	
	/**
	 * this method will sort all the tickets in the arrayLists by their day
	 * @param t
	 */
	private void sortByDay(ArrayList<Ticket> t) {
		Ticket temporary;
		for (int i=1; i<t.size(); i++) {
			for(int j=i; j>0; j--) {
				if (t.get(j).getDay()<t.get(j-1).getDay()) {
					temporary=t.get(j);
					t.set(j, t.get(j-1));
					t.set(j-1, temporary);
				}
			}
		}
	
	}
	
	/**
	 * this method will sort all the tickets in the arrayLists by their id
	 * @param t
	 */
	private void sortById(ArrayList<Ticket> t) {
		Ticket temporary;
		for (int i=1; i<t.size(); i++) {
			for(int j=i; j>0; j--) {
				if (t.get(j).getId()<t.get(j-1).getId()) {
					temporary=t.get(j);
					t.set(j, t.get(j-1));
					t.set(j-1, temporary);
				}
			}
		}	
		
	}
	/**
	 * Returns the number of times this person has visited the theater this month
	 * @param id of the patron
	 * @return the number of times this patron has visited the theater this month
	 */
	@Override
	public int numVisits(int id) {
		int numVisit=0;
		for(String Lists : Lists) {
		
			String x = String.valueOf(id);
			if(Lists.contains(x)) {
				numVisit++;
			}
		}
		return numVisit;
	}
	
	
	/**
	 * Returns the number of times the person has seen this movie
	 * @param id the id of the patron
	 * @param movie name of the movie
	 */
	@Override
	public int numThisMovie(int id, String movie) {
		int numVisitM=0;
		for(String Lists : Lists) {
			//String temp[]=Lists.split(":");
			String x = String.valueOf(id);
			if(Lists.contains(x) && Lists.contains(movie)) {
				numVisitM++;
			}
		}
		return numVisitM;
	}
    
	
	/**
	 * Checks to see if this person already saw a movie today
	 * @param id id of patron
	 * @param date current date
	 * @return number of movies the patron has seen today
	 */
	@Override
	public int numMoviesToday(int id, int date) {
		int numMoviToday=0;
		for(String Lists : Lists) {
			String temp[]=Lists.split(":");
			String x = String.valueOf(id);
			String y = String.valueOf(date);
			if(Lists.contains(x) && Lists.contains(" "+y+" ")) {
				numMoviToday++;
			}
		}
		return numMoviToday;
	}
    
	
	
	/**
	 * Adds a Ticket to the list and returns the ticket price
	 * @param m movie to be watched
	 * @param rating movie rating
	 * @param d date
	 * @param t time
	 * @param f feature
	 * @param type type of patron
	 * @param id id of the patron
	 * @return the price of the ticket. Returns -1 if type is invalid
	 */
	@Override
	public double addTicket(String movieN, String rating, int d, int t, String f, String type, int id) {
		double  price=0; 
		if (type.equals("Adult")) {
			Ticket temp = new Adult(movieN,rating,d,t,f);
			price=temp.calculateTicketPrice();
			Lists.add(temp.toString());
			ticketLists.add(temp);
		}
		else if (type.equals("Child")) {
			Ticket temp = new Child(movieN,rating,d,t,f);
			price=temp.calculateTicketPrice();
			Lists.add(temp.toString());
			ticketLists.add(temp);
		}
		else if (type.equals("Employee")) {
			int x =numVisits(id);
			Ticket temp = new Employee(movieN,rating,d,t,f,id,x);
			price=temp.calculateTicketPrice();
			Lists.add(temp.toString());
			ticketLists.add(temp);
		}
		else if (type.equals("MoviePass")) {
			int a = numVisits(id);
			int b = numThisMovie(id,movieN);
			int c = numMoviesToday(id,d);
			Ticket temp = new MoviePass(movieN,rating,d,t,f,id,a,c,b);
			price=temp.calculateTicketPrice();
			Lists.add(temp.toString());
			ticketLists.add(temp);
		}
	    total +=price;
		return price;
	}
     
	
	/**
	 * Returns the sales for the entire month
	 * @return a double value equivalent to total sales month
	 */
	@Override
	public double totalSalesMonth() {
		double total=0;
		for(String Lists : Lists) {
				String[] temp = Lists.split(":");
				total +=Double.parseDouble(temp[temp.length-1]);
			}
		return total;
		}

	
	/**
	 * returns a a monthly report of the tickets
	 */
	@Override
	public String monthlySalesReport() {
		String x="         Monthly Sales Report";
		double adultPrice=0;
		double childPrice=0;
		double employeePrice=0;
		double moviepassPrice=0;
		int adultnum=0;
		int childnum=0;
		int emplnum=0;
		int movnum=0;
		// adult price
		for(String Lists : Lists) {
			
			if(Lists.contains("ADULT")) {
				String[] temp = Lists.split(":");
				adultPrice +=Double.parseDouble(temp[temp.length-1]);
				adultnum++;
			}
		}
		//child price
        for(String Lists : Lists) {
			
			if(Lists.contains("CHILD")) {
				String[] temp = Lists.split(":");
				childPrice +=Double.parseDouble(temp[temp.length-1]);
				childnum++;
			}
		}
        //employye price
        for(String Lists : Lists) {
			
			if(Lists.contains("EMPLOYEE")) {
				String[] temp = Lists.split(":");
				employeePrice +=Double.parseDouble(temp[temp.length-1]);
				emplnum++;
			}
		}
        //moviepass price
        for(String Lists : Lists) {
			
			if(Lists.contains("MOVIEPASS")) {
				String[] temp = Lists.split(":");
				moviepassPrice +=Double.parseDouble(temp[temp.length-1]);
				movnum++;
			}
		}
        DecimalFormat df = new DecimalFormat("0.00");
        x +="\n"+"\n";
        x +="            Sales     Number  \n";
        x +="ADULT         $"+df.format(adultPrice)+"      "+adultnum+"   \n";
        x +="CHILD         $"+df.format(childPrice)+"      "+childnum+"   \n";
        x +="EMPLOYEE      $"+df.format(employeePrice)+"       "+emplnum+"   \n";
        x +="MOVIEPASS     $"+df.format(moviepassPrice)+"      "+movnum+"   \n\n";
        x +="Total monthly sales: $"+df.format(totalSalesMonth());
		
		return x;
	}

	
	/**
	 * Returns an arraylists of strings that represent 3D tickets sorted by Day
	 * @return an arraylists of strings that represent 3D tickets sorted by day
	 */
	@Override
	public ArrayList<String> get3DTickets() {
		sortByDay(ticketLists);
		ArrayList<String> x = new ArrayList<String>();
		for(Ticket ticketLists : ticketLists) {
			if(ticketLists.getFeature().equals("3D")) {
				x.add(ticketLists.toString());
			}
		}
		return x;
	}

	
	/**
	 * Returns an arrayList of strings which represent tickets, in chronological order
	 * @return an arrayList of strings which represent tickets, in chronological order
	 */
	@Override
	public ArrayList<String> getAllTickets() {
	   sortByDay(ticketLists);
	   ArrayList<String> Lists = new ArrayList<String>();
	   for ( Ticket ticketLists: ticketLists) {
		   Lists.add(ticketLists.toString());
	   }
		return Lists;
	}

	/**
	 * Returns an Arraylist of string representation of MoviePass tickets sorted by id
	 * @return an Arraylist of string representation of MoviePass tickets sorted by id
	 */
	@Override
	public ArrayList<String> getMoviePassTickets() {
		sortById(ticketLists);
		ArrayList<String> x = new ArrayList<String>();
		for(Ticket ticketLists : ticketLists) {
			if(ticketLists.getType().equals("MOVIEPASS")) {
				x.add(ticketLists.toString());
			}
		}
		return x;
	}
  
	
	/**
	 * Reads from a file and populates an arraylists of Ticket objects in this class
	 * @param file file to be read from
	 * @throws FileNotFoundException when file is not found
	 */
	@Override
	public void readFile(File file) throws FileNotFoundException {
		Scanner input = new Scanner(file);
		int lineCount=0;
		while (input.hasNextLine()) {
			lineCount++;
			input.nextLine();
		}
		input.close();
		Scanner input1 = new Scanner(file);
		   for(int i=0; i<lineCount; i++){
			   String temp = input1.nextLine();
			String[] x =temp.split(":");
			String movieN=x[0];
			String rating=x[1];
			int day = Integer.parseInt(x[2]);
			int time = Integer.parseInt(x[3]);
			String feature = x[4];
			String type= x[5];
			int id = Integer.parseInt(x[6]);
			addTicket(movieN,rating,day,time,feature,type,id);
		}
		
	}

}
