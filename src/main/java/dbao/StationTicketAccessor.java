/**
 * 
 */
package dbao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import dbo.Station_Ticket;

/**
 * @author MatthewsLaptop
 *
 */
public class StationTicketAccessor extends DatabaseAccessor<Object>{
	 
	
	
	/**
	 * @param factory
	 * @param session
	 */
	public StationTicketAccessor(SessionFactory factory, Session session) {
		setFactory(factory);
		setSession(session);
	}

	//create, delete, query
	/**
	 * 
	 * @param st
	 * @param sessionIn
	 * @return
	 */
	public boolean AddStationTicket(Station_Ticket st, Session sessionIn)
	{
		
		return super.AddNewRecord(st, sessionIn, st.IsNotNull(), InsertValid(st));
	}
	
	private boolean InsertValid(Station_Ticket st) {
		if(st.IsNotNull())
		{
			if(st.getEnd_time() == null)
			{
				return false;
			}
			if(st.getExcludes() == null)
			{
				return false;
			}
			if(st.getFood_id() <=0)
			{
				return false;
			}
			if(st.getIncludes() == null)
			{
				return false;
			}
			if(st.getStart_time() == null)
			{
				return false;
			}
			if(st.getTicket_id() <=0)
			{
				return false;
			}
		}
		return true;
	}

	public boolean DeleteStationTicket(Station_Ticket st, Session sessionIn)
	{
		
		try {
			session = sessionIn;
			session.beginTransaction();

			// get Food
			Station_Ticket myTicket = session.get(Station_Ticket.class, st.getStt_id());

			// Delete food
			session.delete(myTicket);

			// commit to database
			session.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
		return true;
		
	}
	public List<Station_Ticket> getStationTicket(Station_Ticket st, Session sessionIn)
	{
		String query = createStationQuery(st);
		
		try {
			session = sessionIn;
			session.beginTransaction();
			@SuppressWarnings("unchecked")
			List<Station_Ticket> theTickets = session.createQuery(query) // make sure to have the class object exactly not													// the table name
					.getResultList();
			return theTickets;
			
		}catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}

	private String createStationQuery(Station_Ticket st) {
		StringBuilder query = new StringBuilder();
		query.append("from Station_Ticket st");// Beginning of query
		// used to determine if there is a variable already in query
		Boolean second = false;
		
		if(st.IsNotNull())
		{
			query.append(" WHERE ");
			if(st.getTicket_id() != 0)
			{
				query.append(" ticket_id = " + st.getTicket_id() + " ");
				second = true;
			}
			if(st.getStt_id() != 0)
			{
				if(second)
				{
					query.append(" AND ");
				}
				query.append(" stt_id = " + st.getStt_id() + " ");
				second = true;
			}
			if(st.getFood_id() != 0)
			{
				if(second)
				{
					query.append(" AND ");
				}
				query.append(" food_id = " + st.getFood_id() + " ");
				second = true;
			}
			if(st.getStart_time() != null)
			{
				if(second)
				{
					query.append(" AND ");
				}
				query.append(" start_time = " + st.getStart_time() + " ");
				second = true;
			}
			if(st.getEnd_time() != null)
			{
				if(second)
				{
					query.append(" AND ");
				}
				query.append(" end_time = " + st.getEnd_time() + " ");
				second = true;
			}
			if(st.getExcludes()!= null)
			{
				if(second)
				{
					query.append(" AND ");
				}
				query.append(" Excludes = " + st.getExcludes() + " ");
				second = true;
			}
			if(st.getIncludes()!= null)
			{
				if(second)
				{
					query.append(" AND ");
				}
				query.append(" Includes = " + st.getIncludes() + " ");
			}
		}
		return query.toString();
	}
}
