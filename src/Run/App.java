package Run;
import java.util.Scanner;
public class App extends Services {
	Scanner input = new Scanner(System.in);
	App(){
		super();
		while(true){
			String userType = EnterUserType();
			Authentication(userType);
			
		}
	}
	public String EnterUserType(){
		System.out.println("Enter one of the following choices");
		System.out.println("(1) Student");
		System.out.println("(2) Doctor");
		System.out.println("(3) Admin");
		
		int n = input.nextInt();
		
		switch(n){
		case 1:
			return "student";	
		case 2:
			return "doctor";
		case 3:
			return "admin";
		
		default:
			return "";
		}
	}
	
	public void Authentication(String type){
		if(type.equals("student")){
			System.out.println("You are now logging as a student");
			System.out.println("Enter one of the following choices: ");
			System.out.println("(1) Login");
			System.out.println("(2) Signup");
			int n = input.nextInt();
			if(n == 1){
				Student s = loginStudent();
				if(s!=null)run(s);
				
			}
			if(n == 2){
				Student s =signupStudent();
				if(s!=null)run(s);
				
			}
		}
		else if(type.equals("doctor")){
			System.out.println("You are now logging as a doctor");
			System.out.println("Enter one of the following choices: ");
			System.out.println("(1) Login");
			System.out.println("(2) Signup");
			int n = input.nextInt();
			if(n == 1){
				Doctor d =loginDoctor();
				if(d!=null)run(d);
			}
			if(n == 2){
				Doctor d = signupDoctor();
				if(d!=null)run(d);
			}
		}
		else if(type.equals("admin")){
			System.out.println("You are now logging as an admin");	
			Admin a = loginAdmin();
			if(a != null) run(a);
		}
	}
	public void run(Student s){
		System.out.println("Enter one of the following choices: ");
		System.out.println("(1) Register Course");
		
		System.out.println("(2) Check my profile");
		System.out.println("(3) Pay Fees");
		System.out.println("(4) Use Lab for doing researches");
		System.out.println("(5) Check Notifications");
		System.out.println("(6) Courses Registered");
		System.out.println("(7) Logout");
		
		int n = input.nextInt();
		if(n == 1){

			registerCourse(s);
			
		}else if(n == 2){
			s.displayInfo();
		}else if(n == 3){
			payFees(s);
		}
		
		else if(n == 4){
			useLab(s);
			
		}else if(n == 5){
//			System.out.println("Check notifications");
			printNotifications(s);
		}else if(n == 6){
			printRegisteredCourses(s);
		}
		else if (n == 7){

			String userType = EnterUserType();
			Authentication(userType);
			return;
		}
		run(s);
	}
	public void run(Doctor d){
		System.out.println("Enter one of the following choices: ");
		System.out.println("(1) Check my profile");
		System.out.println("(2) Recieve Salary");
		System.out.println("(3) Use Lab for doing researches");
		System.out.println("(4) Check Notifications");
		System.out.println("(5) Logout");
		
		int n = input.nextInt();
		if(n == 1){
			d.displayInfo();	
		}else if(n == 2){
			recieveSalary(d);
		}else if(n == 3){
			useLab(d);
		}
		
		else if(n == 4){
			printNotifications(d);
		}else if(n == 5){

			String userType = EnterUserType();
			Authentication(userType);
			return;
		}
		run(d);
	}
	public void run(Admin a){
		System.out.println("Enter one of the following choices: ");
		System.out.println("(1) Display Info");
		System.out.println("(2) Check all Students Registered");
		System.out.println("(3) Check all Doctors");
		System.out.println("(4) Check Notifications");
		System.out.println("(5) Check Lab Queue");
		System.out.println("(6) Check Fees Queue");
		System.out.println("(7)Check Salary Queue");
		System.out.println("(8) Receive fee from student");
		System.out.println("(9) Allow person to enter lab for researches");
		System.out.println("(10) Give Salary to Doctor");
		System.out.println("(11) Remove a Student");
		System.out.println("(12) Remove a Doctor");
		System.out.println("(13) Logout");
		int n = input.nextInt();
		
		switch(n){
		case 1:
			a.displayInfo();
			break;
		case 2:
			printAllStudents();
			break;
		case 3:
			printAllDoctors();
			break;
		case 4:
			a.printNotifications();
			break;
		case 5:
			System.out.println("This is the lab Queue");
			printLabPQ();
			break;
		case 6:
			System.out.println("This is the fee queue");
			printFeeQueue();
			break;
		case 7:
			System.out.println("This is the salary queue");
			printSalaryQueue();
			break;
		case 8:
			Student s = dequeueFee();
			if(s == null) break;
			a.notifications.push("You received fee from student " + s.getName());
			System.out.println("This is the fee queue");
			printFeeQueue();
			break;
		case 9:
			
			String p = dequeueLabPQ();
			if(p == null){
				System.out.println("No one in queue for entering the lab");
				return;
			}
			System.out.println("You allowed " + p + " to enter the lab");
			System.out.println("This is now the current queue");
			printLabPQ();
			
			a.notifications.push("You allowed " + p + " to enter the lab");
			
			
			break;
		case 10:
			
			
			Doctor d = dequeueSalary();
			if(d == null){
				System.out.println("Everyone recieved his salary");
				break;
			}
			a.notifications.push("You gave salary to " + d.getName());
			System.out.println("This is now the current salary queue");
			printSalaryQueue();
			
			break;
			
	
			
		case 11:
			printAllStudents();
			System.out.println("Enter student id you want to remove: ");
			int id = input.nextInt();
			
			deleteStudent(id);
			
			
			break;
		case 12:
			
			printAllDoctors();
			System.out.println("Enter doctor id you want to remove: ");
			id = input.nextInt();
			deleteDoctor(id);
			break;
			
		case 13:
			String userType = EnterUserType();
			Authentication(userType);
			return;
		}
		
		
			
		run(a);
			
	}
	public static void main(String[] args){
		new App();
	}
}
