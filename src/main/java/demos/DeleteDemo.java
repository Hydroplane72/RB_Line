package demos;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import dbo.Food;
import dbo.Servers;
import dbo.Station_Ticket;
import dbo.Ticket;
import dbo.overall;

public class DeleteDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
				SessionFactory factory = new Configuration()
						 .configure("hibernate.cfg.xml")
						 .addAnnotatedClass(Ticket.class)
						 .addAnnotatedClass(Servers.class)
						 .addAnnotatedClass(Food.class)
						 .addAnnotatedClass(Station_Ticket.class)
						 .addAnnotatedClass(overall.class)
						 .buildSessionFactory();
				
				
				Session session = factory.getCurrentSession();
				try {
					int ticketID = 21;
					session= factory.getCurrentSession();
					session.beginTransaction();
					
					System.out.println("\nGetting ticket with id: "+ ticketID);
					//get ticket object based on ticketID
					Ticket myticket = session.get(Ticket.class, ticketID);
					
					//delete the ticket
					System.out.println("Deleting ticket: " + myticket);
					session.delete(myticket);
					
					//commit to database
					session.getTransaction().commit();
					
					System.out.println("Done");
					
				}
				finally {
					factory.close();
				}

	}

}
