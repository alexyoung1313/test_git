import java.util.ArrayList;

public class Data
{	
	private ArrayList<School> schools;
	private ArrayList<String> schoolNames;

	public Data(ArrayList<School> schools)
	{
		this.schools = schools;
	}

	public ArrayList<School> getSchools()
	{
		return schools;
	}
	public ArrayList<String> getSchoolsNames()
	{
		schoolNames = new ArrayList<String>();
		for(int i = 0; i < schools.size(); i++)
		{
			schoolNames.add(schools.get(i).getName());
		}
		return schoolNames;
	}

	public void setSchools(ArrayList<School> schools)
	{
		this.schools = schools;
	}
	
	
}
