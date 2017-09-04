import java.util.ArrayList;

public class Meetings
{
	private String type;
	private String section;
	private String room;
	private ArrayList<Assistant> assistants;
	private ArrayList<Meeting_Periods> meetingPeriods;
	
	public Meetings (String type_, String section_, String room_, ArrayList<Assistant> assistants_)
	{
		this.type = type_;
		this.section = section_;
		this.room = room_;
		this.assistants = assistants_;
	}
	
	public String getType()
	{
		return this.type;
	}
	public String getSection()
	{
		return this.section;
	}
	public String getRoom()
	{
		return this.room;
	}
	public ArrayList<Assistant> getAssitant()
	{
		return this.assistants;
	}
	
	public void printData(ArrayList<Staff> staff)
	{
		System.out.println("Scetion: " + section);
		System.out.println("Room: " + room);
		System.out.println("Meetings: ");
		for(int i = 0; i < meetingPeriods.size(); i++)
		{
			Meeting_Periods currMeetingPeriod = meetingPeriods.get(i);
		 	System.out.print(currMeetingPeriod.getDay() + " ");
		 	System.out.print(currMeetingPeriod.getTime().getStart() + "-" + currMeetingPeriod.getTime().getEnd());
		 	if(i != meetingPeriods.size())
		 	{
		 		System.out.print(", ");
		 	}
		}
		System.out.println("Assistants: ");
		for(int i = 0; i < assistants.size(); i++)
		{
			Assistant currAssistant = assistants.get(i);
		 	System.out.print(currAssistant.getName(staff));
		 	if(i != assistants.size())
		 	{
		 		System.out.print(", ");
		 	}
		}
	}
}


//type
//section
//room
//MEETING PERIODS
//assistants