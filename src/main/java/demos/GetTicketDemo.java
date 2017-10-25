package demos;

import java.time.LocalDateTime;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import dbo.Servers;
import dbo.Ticket;

public class GetTicketDemo {
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
			 //begin transaction
			session.beginTransaction();
			//Create new Ticket
			 //use the session object to save java object
			 LocalDateTime a = LocalDateTime.now();
			 //create object
			 System.out.println("Creating a new student object...");
			 Ticket tempTicket = new Ticket(2, 2, a,a.plusMinutes(20));
			 
			 
			 //save the object
			 System.out.println("Saving tempTicket: "+ tempTicket);
			 session.save(tempTicket);
			 System.out.println("Saved tempTicket");
			 
			//commit to database
			 session.getTransaction().commit();
			 System.out.println("Saved student. Generated id: " + tempTicket.getTicket_ID());
			 
			 //get new session start transaction
			 session = factory.getCurrentSession();
			 session.beginTransaction();
			 System.out.println("\nGetting student with id: "+ tempTicket.getTicket_ID());
			 
			 Ticket myticket = session.get(Ticket.class, tempTicket.getTicket_ID());
			 
			 System.out.println("Get complete: " + myticket);
			 
			 //commit transaction
			 session.getTransaction().commit();
			 System.out.println("Done");
		 }
		 finally
		 {
			 factory.close();
		 }
	}
	
}
