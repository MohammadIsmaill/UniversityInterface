package Run;


import java.util.ArrayList;

import DataStructures.Stack;


public class Student {
	private String name;
	private String age;
	private String email;
	private String password;
	private String username;
	private static int counter = 0;
	
	CourseSchedule crses;
	
	public int key;
	
	Stack<String> notifications = new Stack<String>();
	ArrayList<Course> coursesTaken = new ArrayList<Course>();
	
	public Student(String name,String age,String email,String password){
		this.name = name;
		this.age = age;
		this.email = email;
		this.password = password;
		generateUsername();
		key = Integer.parseInt(username);
		
	}
	public void setCrsSchedule(CourseSchedule c){
		crses = c;
	}
	public void registerCourse(Course c1){
		
		ArrayList<Course> coursesNotTaken = crses.canTakeCourse(c1, coursesTaken);
		if(coursesNotTaken.size() == 0 && !coursesTaken.contains(c1)){
			coursesTaken.add(c1);
			notifications.push("You registered the following course: " + c1.getName());
		}
		else{
			notifications.push("Failed attempt to register for the course " + c1.getName());
			System.out.println("You cannot register course");
			System.out.println("These are the courses you not registered");
			for(int i = 0 ; i < coursesNotTaken.size() ;i++){
				System.out.println(coursesNotTaken.get(i).getName());
			}
		}
		
	}
	
	public ArrayList<String> coursesRegistered(){
		ArrayList<String> arr = new ArrayList<String>();
		
		for(int i = 0 ; i < coursesTaken.size() ; i++){
			arr.add(coursesTaken.get(i).getName());
		}
		return arr;
	}
	public void generateUsername(){
		this.username = "2021" + (counter++);
		
	}
	public void printNotifications(){
		Stack<String> temp = new Stack<String>();
		
		while(!notifications.isEmpty()){
			String a = notifications.pop();
			System.out.println("-" + a);
			temp.push(a);
			
		}
		while(!temp.isEmpty()){
			notifications.push(temp.pop());
		}
	}
	public void displayInfo(){
		System.out.println("Username: " + username);
		System.out.println("Name: " + name);
		System.out.println("Age: " + age);
		System.out.println("Email: " + email);
		System.out.println("Password: " + password);
		
	}
	public int getKey(){
		return key;
	}
	public String getName(){
		return name;
	}
	public String getAge(){
		return age;
	}
	public String getPassword(){
		return password;
	}
	
	public String username(){
		return username;
	}
	
	
}
