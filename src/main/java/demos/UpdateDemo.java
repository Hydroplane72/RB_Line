package demos;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import dbo.Servers;
import dbo.Ticket;

public class UpdateDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory = new Configuration()
				 .configure("hibernate.cfg.xml")
				 .addAnnotatedClass(Ticket.class)
				 .addAnnotatedClass(Servers.class)
				 .buildSessionFactory();
		
		
		Session session = factory.getCurrentSession();
		try {
			int ticketID = 6;
			session= factory.getCurrentSession();
			session.beginTransaction();
			
			System.out.println("\nGetting ticket with id: "+ ticketID);
			//get ticket object based on ticketID
			Ticket myticket = session.get(Ticket.class, ticketID);
			
			//update object
			System.out.println("updating student");
			myticket.setTablenum(4);
			
			//commit to database
			session.getTransaction().commit();
			
			System.out.println("Done");
			
		}
		finally {
			factory.close();
		}
	}

}
