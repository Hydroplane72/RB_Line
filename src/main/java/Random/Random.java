/**
 * This class is used to hold random stuff that I need to remember to do mostly. 
 */
package Random;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import dbo.Food;
import dbo.Servers;
import dbo.Station_Ticket;
import dbo.Ticket;
import dbo.overall;

/**
 * @author MatthewsLaptop
 *This class is used to hold random stuff that I need to remember to do mostly. 
 */
public class Random {

	/**
	 * @param args
	 */
	@SuppressWarnings("unused")
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
	}

}
