import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

public class Parser
{
	
	
	
	private static void printOptions(ArrayList<String> options, String currentLevel1, String previousLevel)
	{
		if(currentLevel1 != null)
		{
			System.out.println(currentLevel1);
		}
		int i;
		for(i = 1; i <= options.size(); i++)
		{
			System.out.println(i + ") " + options.get(i-1));
		}
		System.out.println("	" + (i) + ") Go to " + previousLevel + " menu");
		System.out.println("	" + (i+1) + ") Exit");
		System.out.println("What would you like to do?");
	}
	
	
	
	
	public static void main (String [] args)
	{
		boolean quit = false;
		Scanner scan = new Scanner(System.in);
		String file;
		int input;
		boolean parsed = true;
		while(!quit)
		{
			System.out.println("What is the name of the input file?");
			//file = scan.nextLine();
			file = "test.json";
			System.out.println("");
			Data data;
			try
			{
				JsonReader reader = new JsonReader(new FileReader(file));
				Gson gson = new Gson();
				data = gson.fromJson(reader, Data.class);
			}
			catch (FileNotFoundException fnfe)
			{
				System.out.println("That file could not be found.");
				continue;
			}
			ArrayList<School> schools = new ArrayList<School>(data.getSchools());
			if(data.getSchools() == null)
			{
				parsed = false;
			}
			else
			{
				for(int a = 0; a < schools.size(); a++)
				{
					School currSchool = schools.get(a);
					if(currSchool.getDepartments() == null || currSchool.getName() == null)
					{
						parsed = false;
						break;
					}
					else
					{
						for(int b = 0; b < currSchool.getDepartments().size(); b++)
						{
							Departments currDepartment = currSchool.getDepartments().get(b);
							if(currDepartment.getCourses() == null || parsed == false || currDepartment.getLongName() == null
									|| currDepartment.getPrefix() == null)
							{
								parsed = false;
								break;
							}
							else
							{
								for(int c = 0; c < currDepartment.getCourses().size(); c++)
								{
									Courses currCourse = currDepartment.getCourses().get(c);
									if(currCourse.getStaff() == null || currCourse.getMeetings() == null || parsed == false
											|| currCourse.getNumber() == null || currCourse.getTerm() == null 
											|| currCourse.getYear() == null)
									{
										parsed = false;
										break;
									}
									else
									{
										for(int d = 0; d < currCourse.getMeetings().size(); d++)
										{
											Meetings currMeeting = currCourse.getMeetings().get(d);
											if(currMeeting.getType() == null || currMeeting.getSection() == null)
											{
												parsed = false;
												break;
											}
										}
										
										for(int e = 0; e < currCourse.getStaff().size(); e++)
										{
											Staff currStaff = currCourse.getStaff().get(e);
											if(currStaff.getId() == null || currStaff.getType() == null || currStaff.getName() == null)
											{
												parsed = false;
												break;
											}
										}
									}
								}
							}
						}
					}
				}
			}
			
			//if not correct file format
			if(!parsed)
			{
				System.out.println("That file is not a well-formed JSON file.");
				continue;
			}

			//if correct
			while (!quit)
			{
				System.out.println("	1) Display schools");
				System.out.println("	2) Exit");
				System.out.println("What would you like to do?");
				input = scan.nextInt();
				if(input > 2 || input < 1)
				{
					System.out.println("That is not a valid option.");
					continue;
				}
				//exit
				else if (input == 2)
				{
					quit = true;
					break;
				}
				//display schools
				else if (input == 1)
				{
					while(!quit)
					{
						printOptions(data.getSchoolsNames(), "Schools", "main");
						input = scan.nextInt();
						if(input > data.getSchoolsNames().size()+2 || input < 1)
						{
							System.out.println("That is not a valid option.");
							continue;
						}
						//exit
						else if (input == data.getSchoolsNames().size()+2)
						{
							quit = true;
							break;
						}
						//go to main menu
						else if (input == data.getSchoolsNames().size()+1)
						{
							break;
						}
						//select a school
						else
						{
							School currSchool = schools.get(input - 1);
							while(!quit)
							{
								printOptions(currSchool.getStringsDepartments(), "Departments", "Schools");
								input = scan.nextInt();
								if(input > currSchool.getDepartments().size()+2 || input < 1)
								{
									System.out.println("That is not a valid option.");
									continue;
								}
								//exit
								else if (input == currSchool.getDepartments().size()+2)
								{
									quit = true;
									break;
								}
								//go to departments menu
								else if (input == currSchool.getDepartments().size()+1)
								{
									break;
								}
								else
								{
									Departments currDepartment = currSchool.getDepartments().get(input - 1);
									while(!quit)
									{
										printOptions(currDepartment.getCoursesNames(), currDepartment.getPrefix() + " courses", "Departments");
										input = scan.nextInt();
										if(input > currDepartment.getCourses().size()+2 || input < 1)
										{
											System.out.println("That is not a valid option.");
											continue;
										}
										//exit
										else if (input == currDepartment.getCourses().size()+2)
										{
											quit = true;
											break;
										}
										//go to departments menu
										else if (input == currDepartment.getCourses().size()+1)
										{
											break;
										}
										else
										{
											String currCourseName = currDepartment.getCoursesNames().get(input - 1);
											Courses currCourse = currDepartment.getCourses().get(input - 1);
											while(!quit)
											{
												System.out.println(currCourseName);
												System.out.println("	1) View course staff");
												System.out.println("	2) View meeting information");
												System.out.println("	3) Go to " + currDepartment.getPrefix() +" Courses menu");
												System.out.println("	4) Exit");
												input = scan.nextInt();
												if(input > 4 || input < 1)
												{
													System.out.println("That is not a valid option.");
													continue;
												}
												else if (input == 4)
												{
													quit = true;
													break;
												}
												else if(input == 1)
												{
													//staff
													while(!quit)
													{	
														System.out.println(currCourseName);
														System.out.println("Course Staff");
														System.out.println("	1) View Instructors");
														System.out.println("	2)  View TAs");
														System.out.println("	3) View CPs");
														System.out.println("	4) View Graders");
														System.out.println("	5) Go to " + currCourseName + " menu");
														System.out.println("	6) Exit");
														input = scan.nextInt();
														if(input > 6 || input < 1)
														{
															System.out.println("That is not a valid option.");
															continue;
														}
														else if (input == 6)
														{
															quit = true;
															break;
														}
														else if(input == 1)
														{
															System.out.println(currCourseName);
															System.out.println("Instructor");
															for(int i = 0; i < currCourse.getStaff().size(); i++)
															{
																Staff currStaff = currCourse.getStaff().get(i);
																if(currStaff.getType().equals("instructor"))
																{
																	currStaff.printInfo();
																}
															}
														}
														else if(input == 2)
														{
															System.out.println(currCourseName);
															System.out.println("Ta");
															for(int i = 0; i < currCourse.getStaff().size(); i++)
															{
																Staff currStaff = currCourse.getStaff().get(i);
																if(currStaff.getType().equals("ta"))
																{
																	currStaff.printInfo();
																}
															}
														}
														else if(input == 3)
														{
															System.out.println(currCourseName);
															System.out.println("Cp");
															for(int i = 0; i < currCourse.getStaff().size(); i++)
															{
																Staff currStaff = currCourse.getStaff().get(i);
																if(currStaff.getType().equals("cp"))
																{
																	currStaff.printInfo();
																}
															}
														}
														else if(input == 4)
														{
															System.out.println(currCourseName);
															System.out.println("Grader");
															for(int i = 0; i < currCourse.getStaff().size(); i++)
															{
																Staff currStaff = currCourse.getStaff().get(i);
																if(currStaff.getType().equals("grader"))
																{
																	currStaff.printInfo();
																}
															}
														}
														else
														{
															break;
														}
													}
												}
												else if(input == 2)
												{
													//meetings
													while(!quit)
													{
														System.out.println(currCourseName);
														System.out.println("Meeting Information");
														System.out.println("	1) Lecture");
														System.out.println("	2)  Lab");
														System.out.println("	3) Quiz");
														System.out.println("	4) Go to " + currCourseName + " menu");
														System.out.println("	5) Exit");
														input = scan.nextInt();
														if(input > 5 || input < 1)
														{
															System.out.println("That is not a valid option.");
															continue;
														}
														else if (input == 5)
														{
															quit = true;
															break;
														}
														else if(input == 1)
														{
															System.out.println(currCourseName);
															System.out.println("Lecture Meeting Information");
															for(int i = 0; i < currCourse.getMeetings().size(); i++)
															{
																Meetings currMeeting = currCourse.getMeetings().get(i);
																if(currMeeting.getType().equals("lecture"))
																{
																	currMeeting.printData(currCourse.getStaff());
																}
															}
														}
														else if(input == 2)
														{
															System.out.println(currCourseName);
															System.out.println("Lab Meeting Information");
															for(int i = 0; i < currCourse.getMeetings().size(); i++)
															{
																Meetings currMeeting = currCourse.getMeetings().get(i);
																if(currMeeting.getType().equals("lab"))
																{
																	currMeeting.printData(currCourse.getStaff());
																}
															}
														}
														else if(input == 3)
														{
															System.out.println(currCourseName);
															System.out.println("Quiz Meeting Information");
															for(int i = 0; i < currCourse.getMeetings().size(); i++)
															{
																Meetings currMeeting = currCourse.getMeetings().get(i);
																if(currMeeting.getType().equals("quiz"))
																{
																	currMeeting.printData(currCourse.getStaff());
																}
															}
														}
														else
														{
															break;
														}
													}
												}
												else
												{
													break;
												}
											}
											
										}
									}
								}
							}
							
						}
					}
			
				}	
			}
		}
		
	}
}
