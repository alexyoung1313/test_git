import java.util.ArrayList;

public class School 
{
	private String name;
	private ArrayList<Departments> departments;
	private ArrayList<String> departmentNames;
	
	public School (String name_, ArrayList<Departments> departments_)
	{
		this.name = name_;
		this.departments = departments_;
		
	}
	
	public String getName()
	{
		return this.name;
	}
	public ArrayList<Departments> getDepartments ()
	{
		return this.departments;
	}
	public ArrayList<String> getStringsDepartments()
	{
		departmentNames = new ArrayList<String>();
		for(int i = 0; i < departments.size(); i++)
		{
			departmentNames.add(departments.get(i).getFullName());
		}
		return this.departmentNames;
	}
}


//name
//DEPARTMENTS