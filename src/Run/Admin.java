package Run;
import java.util.Scanner;

import DataStructures.Stack;
public class Admin{
	Scanner input = new Scanner(System.in);
//	public static final String password = null;
	
	private String name;
	private String age;
	private String email;
	private String password;
	private String username;
	private int key;
	private static int counter = 0;
	
	Stack<String> notifications = new Stack<String>();
	
	Admin(String name, String age, String email, String password){
		this.name = name;
		this.age = age;
		this.email = email;
		this.password = password;
		this.username = "2023" + (counter++);
		key = Integer.parseInt(username);
	}
	public void displayInfo() {
		System.out.println("This is your info");
		System.out.println("Username: " + username);
		System.out.println("Name: " + name);
		System.out.println("Age: " + age);
		System.out.println("Email: " + email);
		System.out.println("Password: " + password);
		
		
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
	public String getName() {
		return name;
	}
	public String getAge() {
		return age;
	}
	public String getEmail() {
		return email;
	}
	public String getPassword() {
		return password;
	}
	public String getUsername() {
		return username;
	}
	public int getKey(){
		return key;
	}
	

}
