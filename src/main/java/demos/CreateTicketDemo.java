package demos;

import java.time.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import dbo.Servers;
import dbo.Ticket;

public class CreateTicketDemo {

	public static void main(String[] args) {
		//Create Session Factory
		 SessionFactory factory = new Configuration()
				 .configure("hibernate.cfg.xml")
				 .addAnnotatedClass(Ticket.class)
				 .addAnnotatedClass(Servers.class)
				 .buildSessionFactory();
		 
		//Create new Server
		 Session session = factory.getCurrentSession();
		 try {
			
			 //new Server classes
			 Servers serve = new Servers("Hannah", "Dilly");
			 Servers serve2 = new Servers("Matt", "Rumplestilskin");
			 //open transaction
			 session.beginTransaction();
			 
			 //save the objects
			 System.out.println("Saving servers");
			 session.save(serve);
			 session.save(serve2);
			 
			 System.out.println("Saved servers");
			 //Commit to database
			 session.getTransaction().commit();
			 
			 //close the session
			 session.close();
		 }
		 catch(Exception ex)
		 {
			 ex.printStackTrace();
		 }
		 
		
		
		 
		 try {
			 //Create new Ticket
			 //use the session object to save java object
			 LocalDateTime a = LocalDateTime.of(2012, 6,5,8,7);
			 //create object
			 System.out.println("Creating a new student object...");
			 Ticket tempTicket = new Ticket(1, 1, a,a);
			 
			 
			 //save the object
			 System.out.println("Saving tempTicket");
			 session.save(tempTicket);
			 System.out.println("Saved tempTicket");
			 
			 //commit to database
			 session.getTransaction().commit();
			 
			 System.out.println("Done!");
		 }
		 finally {
			 factory.close();
		 }
	}

}
