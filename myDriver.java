import java.util.ArrayList;
import java.util.Scanner;

public class myDriver {

	public static void main(String[] args) {
//		MovieTicketManager x = new MovieTicketManager();
//		System.out.println(x.addTicket("deadpool","PG", 1, 15, "NONE", "Adult", 0));
//		System.out.println(x.addTicket("deadpool","PG", 1, 15, "NONE", "Adult", 0));
//		System.out.println(x.addTicket("deadpool","PG", 1, 15, "NONE", "Adult", 0));
//		System.out.println(x.totalSalesMonth());
        MovieTicketManager ticketList = new MovieTicketManager();
		
		//add adults
		System.out.println(ticketList.addTicket("Infinity Wars", "PG13", 4,19,"NONE","Adult",0));
		System.out.println(ticketList.addTicket("A Quiet Place", "PG13", 2,12,"NONE","Adult",0));
		System.out.println(ticketList.addTicket("Black Panther", "PG13", 3,14,"3D","Adult",0));
		
		//add children
		System.out.println(ticketList.addTicket("Little Mermaid", "G", 5,19,"NONE","Child",0));
		System.out.println(ticketList.addTicket("Little Mermaid", "G", 2,12,"NONE","Child",0));
		System.out.println(ticketList.addTicket("Show Dogs", "PG", 2,14,"3D","Child",0));
		
		//add employees
		System.out.println(ticketList.addTicket("Deadpool", "NR", 5,19,"NONE","Employee",12345));
		System.out.println(ticketList.addTicket("Action Point", "NR", 2,12,"NONE","Employee",23456));
		System.out.println(ticketList.addTicket("Book Club", "PG13", 1,13,"IMAX","Employee",45678));
		
		//add MoviePass members
		System.out.println(ticketList.addTicket("Deadpool", "NR", 5,19,"NONE","MoviePass",22222));
		System.out.println(ticketList.addTicket("Deadpool", "G", 1,13,"IMAX","MoviePass",55555));
		System.out.println(ticketList.addTicket("Solo", "PG13", 2,12,"NONE","MoviePass",33333));
		System.out.println(ticketList.addTicket("Solo", "PG13", 2,12,"NONE","MoviePass",33333));
		
		
			
		
		System.out.println( ticketList.monthlySalesReport());
		}
       

	
	


}
