package demos;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import dbo.Servers;
import dbo.Ticket;

public class QueryTicketDemo {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory = new Configuration()
				 .configure("hibernate.cfg.xml")
				 .addAnnotatedClass(Ticket.class)
				 .addAnnotatedClass(Servers.class)
				 .buildSessionFactory();
		
		
		Session session = factory.getCurrentSession();
		try {
			//start transaction
			session.beginTransaction();
			System.out.println("Querying tickets");
			//Query tickets
			List<Ticket> theTickets = session
					.createQuery("from Ticket") //make sure to have the class object exactly not the table name
					.getResultList();
			
			System.out.println("Displaying tickets");
			//display tickets
			for(Ticket tempticket: theTickets)
			{
				System.out.println(tempticket);
			}
			
			System.out.println("Querying again");
			//query tickets by tablenum = 2
			theTickets = session.createQuery("from Ticket t where t.tablenum=2")
					.getResultList();
			
			//display results
			//display tickets
			for(Ticket tempticket: theTickets)
			{
				System.out.println(tempticket);
			}
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done");
			
		}
		finally {
			factory.close();
		}
	}

}
