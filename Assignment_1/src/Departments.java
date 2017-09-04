import java.util.ArrayList;

public class Departments
{
	private String longName;
	private String prefix;
	private ArrayList<Courses> courses;
	private ArrayList<String> coursesNames;
	
	
	public Departments (String longName_, String prefix_, ArrayList<Courses> courses_)
	{
		this.longName= longName_;
		this.prefix = prefix_;
		this.courses = courses_;
	}
	
	public ArrayList<String> getCoursesNames()
	{
		coursesNames = new ArrayList<String>();
		for(int i = 0; i < courses.size(); i++)
		{
			String temp = prefix + " " + courses.get(i).getNumber() + " " + courses.get(i).getTerm() + " " 
					+ courses.get(i).getYear();
			coursesNames.add(temp);
		}
		return coursesNames;
	}

	public String getLongName()
	{
		return this.longName;
	}
	public String getPrefix()
	{
		return this.prefix;
	}
	public String getFullName()
	{
		return(this.longName + " (" + this.prefix + ")");
	}
	public ArrayList<Courses> getCourses()
	{
		return this.courses;
	}
}

//long name
//prefix
//COURSES