package dbo;

import java.sql.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="station_ticket")
public class Station_Ticket {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ServerID")
	private int stt_id;
	
	@Column(name="ticket_id")
	private int ticket_id;
	
	@Column(name="food_id")
	private int food_id;
	
	@Column(name="start_time")
	private Date start_time;
	
	@Column(name="end_time")
	private Date end_time;
	
	@Column(name="Excludes")
	private String Excludes;
	
	@Column(name="Includes")
	private String Includes;
	
	public Station_Ticket()
	{
		ticket_id = 0;
		stt_id = 0;
		start_time = null;
		end_time = null;
		Excludes = "";
		Includes = "";
	}
	/**
	 * @param ticket_id-The id of the main ticket
	 * @param food_id - The id of the main Food item
	 * @param start_time - The start time of the ticket
	 * @param end_time - the end time of the ticket to the station
	 * @param excludes - The Food to exclude from the overall Food item
	 * @param includes - The Food to add to the overall Food item
	 */
	public Station_Ticket(int ticket_id, int food_id, Date start_time, Date end_time, String excludes,
			String includes) {
		setTicket_id(ticket_id);
		setFood_id(food_id);
		this.start_time = start_time;
		this.end_time = end_time;
		Excludes = excludes;
		Includes = includes;
	}
	public int getTicket_id() {
		return ticket_id;
	}

	public void setTicket_id(int ticket_id) {
		if(ticket_id>0)
			this.ticket_id = ticket_id;
		else
		{
			this.ticket_id = 0;
		}
	}

	public int getFood_id() {
		return food_id;
	}

	public void setFood_id(int food_id) {
		if(food_id>0)
		this.food_id = food_id;
		else
		{
			this.food_id = 0;
		}
	}

	public Date getStart_time() {
		return start_time;
	}

	public void setStart_time(Date start_time) {
		this.start_time = start_time;
	}

	public Date getEnd_time() {
		return end_time;
	}

	public void setEnd_time(Date end_time) {
		this.end_time = end_time;
	}

	public String getExcludes() {
		return Excludes;
	}

	public void setExcludes(String excludes) {
		Excludes = excludes;
	}

	public String getIncludes() {
		return Includes;
	}

	public void setIncludes(String includes) {
		Includes = includes;
	}

	public void setStt_id(int stt_id) {
		if(stt_id>0)
			this.stt_id = stt_id;
		else 
		{
			this.stt_id = 0;
		}
	}
	public int getStt_id() {
		return stt_id;
	}

	public boolean IsNotNull()
	{
		if(end_time!= null)
		{
			return true;
		}
		if(Excludes != "")
		{
			return true;
		}
		if(Includes != "")
		{
			return true;
		}
		if(start_time != null)
			return true;
		if(stt_id != 0)
		{
			return true;
		}
		if(ticket_id != 0)
		{
			return true;
		}
		if(food_id !=0)
			return true;
		return false;
	}
	
	
}
