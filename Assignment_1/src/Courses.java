import java.util.ArrayList;

public class Courses
{
	private String number;
	private String term;
	private String year;
	private ArrayList<Staff> staffMembers;
	private ArrayList<Meetings> meetings;

	public Courses (String number_, String term_, String year_, ArrayList<Staff> staff_, ArrayList<Meetings> meetings_)
	{
		this.number = number_;
		this.term = term_;
		this.year = year_;
		this.staffMembers = staff_;
		this.meetings = meetings_;
	}
	
	public String getNumber()
	{
		return this.number;
	}
	public String getTerm()
	{
		return this.term;
	}
	public String getYear()
	{
		return this.year;
	}
	public ArrayList<Staff> getStaff()
	{
		return this.staffMembers;
	}
	public ArrayList<Meetings> getMeetings()
	{
		return this.meetings;
	}
	
}


//number
//term
//year
//STAFF