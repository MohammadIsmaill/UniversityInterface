package Run;
import java.util.ArrayList;

import DataStructures.Stack;

public class Doctor {
	private String name;
	private String age;
	private String email;
	private String password;
	private String username;
	static int counter = 0;
	
	
	
	
	
	
	public int key;
	
	
	Stack<String> notifications = new Stack<String>();
	
	public Doctor(String name,String age, String email,String password){
		this.name = name;
		this.age = age;
		this.email = email;
		this.password = password;
		this.username = "2022" + (counter++);
		key = Integer.parseInt(username);
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
	public String getName(){
		return name;
	}
	public String getAge(){
		return age;
	}
	public String getEmail(){
		return email;
	}
	public String getPassword(){
		return password;
	}
	public void displayInfo(){
		System.out.println("This is your information: ");
		System.out.println("Username: " + username);
		System.out.println("Name: " + name);
		System.out.println("Age: " + age);
		System.out.println("Password: " + password);
	}
}
