import java.util.ArrayList;

public class Assistant
{
	private String staffMemberId;
	private String name;
	
	public Assistant(String id)
	{
		this.staffMemberId = id;
		this.name = null;
	}
	
	public String getID()
	{
		return this.staffMemberId;
	}
	
	public String getName(ArrayList<Staff> staff)
	{
		for(int i = 0; i < staff.size(); i++)
		{
			if(this.staffMemberId == staff.get(i).getId())
			{
				this.name = (staff.get(i).getName().getFName() + " " + staff.get(i).getName().getLName());
			}
		}
		return this.name;
	}
}
