import java.util.ArrayList;

public class Staff
{
	private String type;
	private String id;
	private Name name;
	private String email;
	private String phone;
	private String office;
	private String image;
	private ArrayList<Office_Hours> officeHours;
	
	
	
	Staff(String type_, String id_, Name name_, String email_, String phone_, String office_, 
			ArrayList<Office_Hours> office_hours_, String image_)
	{
		this.type = type_;
		this.id = id_;
		this.email = email_;
		this.phone = phone_;
		this.office = office_;
		this.image = image_;
		this.name = name_;
		this.officeHours = office_hours_;

		
	}
	
	public String getType()
	{
		return this.type;
	}
	public String getemail()
	{
		return this.email;
	}
	public String getimage()
	{
		return this.image;
	}
	public String getPhone()
	{
		return this.phone;
	}
	public String getOffice()
	{
		return this.office;
	}
	public String getId()
	{
		return this.id;
	}
	public Name getName()
	{
		return this.name;
	}
	public ArrayList<Office_Hours> getOfficeHours()
	{
		return this.officeHours;
	}
	
	public void printInfo()
	{
		System.out.println("Name: " + name.getFName() + " " + name.getLName());
		System.out.println("Email: " + email);
		System.out.println("Image: " + image);
		System.out.println("Phone: " + phone);
		System.out.println("Office: " + office);
		System.out.println("Office Hours: " );
		for(int i = 0; i < officeHours.size(); i++)
			{
				Office_Hours currOfficeHour = officeHours.get(i);
				if(currOfficeHour.getDay().equals("By Appointment"))
				{
					System.out.print("By Appointment");
				}
				else
				{
					System.out.print(currOfficeHour.getDay() + " ");
				 	System.out.print(currOfficeHour.getTime().getStart() + "-" + currOfficeHour.getTime().getEnd());
				 	if(i != officeHours.size())
				 	{
				 		System.out.print(", ");
				 	}
				}
			 	
			}
		System.out.println("");
	}

}

//type
//id
//NAME
/*email
 * image
 * phone
 * office
 * OFFICE HOURS
 * MEETINGS
 */
