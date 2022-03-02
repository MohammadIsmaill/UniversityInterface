package Run;
import DataStructures.BST;
import DataStructures.PQ;
import DataStructures.Queue;

import java.util.ArrayList;
import java.util.Scanner;
public class Services extends Data{
	
	Scanner input = new Scanner(System.in);
	
	
	
	

	Services(){
		super();
	}
	public Doctor signupDoctor(){
		//String name,String age, String email,String password
		System.out.println("Enter name: ");
		String name = input.nextLine();
		while(name.equals("")){
			name = input.nextLine();
		}
		System.out.println("Enter age: ");
		String age = input.nextLine();
		while(age.equals("")){
			age = input.nextLine();
		}
		System.out.println("Enter email: ");
		String email = input.nextLine();
		while(email.equals("")){
			email = input.nextLine();
		}
		
		System.out.println("Enter password: ");
		String password = input.nextLine();
		while(password.equals("")){
			password = input.nextLine();
		}
		Doctor d = new Doctor(name,age,email,password);
		doctor.insert(d	,d.key );
		
		
		System.out.println("Signup Successfully");
		addDoctor(d);
		d.displayInfo();
		return d;
	}
	
	public Doctor loginDoctor(){
		System.out.println("Please enter username(using only numbers): ");
		int username = 0;
		while(username == 0){
			username = input.nextInt();
		}
		
		
		System.out.println("Please enter password: ");
		String password = input.nextLine();
		while(password.equals("")){
			password = input.nextLine();
		}
		if(doctor.isFound(username)){
//			System.out.println("Login successfully");
			Doctor d = doctor.Search(username);
			if(d.getPassword().equals(password)){
				System.out.println("Login successfully");
				

				return d;
			}
		}
		else{
			System.out.println("Wrong username or password");
		}
		return null;
	}
	public Student loginStudent(){
		System.out.println("Please enter username(using only numbers): ");
		int username = 0;
		while(username == 0){
			username = input.nextInt();
		}
		System.out.println("Please enter password: ");
		String password = input.nextLine();
		while(password == ""){
			password = input.nextLine();
		}
		if(student.isFound(username)){
//			System.out.println("Login successfully");
			Student s = student.Search(username);
			if(s.getPassword().equals(password)){
				System.out.println("Login successfully");
				return s;
			}
		}
		else{
			System.out.println("Wrong username or password");
		}
		return null;
	}
	public Student signupStudent(){
		//String name,String age, String email,String password
		System.out.println("Enter name: ");
		String name = input.nextLine();
		while(name.equals("")){
			name = input.nextLine();
		}
		System.out.println("Enter age: ");
		String age = input.nextLine();
		
		while(age.equals("")){
			age = input.nextLine();
		}
				
		System.out.println("Enter email: ");
		String email = input.nextLine();
		
		while(email.equals("")){
			email = input.nextLine();
		}
				
		System.out.println("Enter password: ");
		String password = input.nextLine();
		while(password.equals("")){
			password = input.nextLine();
		}
		
		
		Student s = new Student(name,age,email,password);
		int n = 0;
		System.out.println("Enter the major: ");
		System.out.println("(1) Math");
		System.out.println("(2) Computer Science");
		System.out.println("(3) Chemistry");
		
		while(n == 0){
			n = input.nextInt();
		}
		
		switch(n){
		case 1:
			s.setCrsSchedule(MATH);
			break;
		case 2:
			s.setCrsSchedule(CMPS);
			break;
		case 3:
			s.setCrsSchedule(CHEMISTRY);
			break;
		}
		student.insert(s,s.key );
		
		
				
		System.out.println("Signup Successfully");
		addStudent(s);			
		s.displayInfo();
		
		return s;
	}
	public Admin loginAdmin(){
		System.out.println("Enter username: ");
		int username = 0;
		while(username == 0){
			username = input.nextInt();
		}
		System.out.println("Enter password: ");
		String password = input.nextLine();
		while(password.equals("")){
			password = input.nextLine();
		}
		
		
		if(admin.isFound(username)){
			Admin a = admin.Search(username);
			if(a.getPassword().equals(password)){
				System.out.println("Login succssfully");
				a.displayInfo();
				return a;
			}
		}
		else{
			System.out.println("Wrong username or password");
			
		}
		return null;
	}
	public void payFees(Student s){
		
		s.notifications.push("You requested for paying fees");
		fees.enqueue(s);
		System.out.println("This is your turn for paying fees");
		printFeeQueue();
	}
	public void recieveSalary(Doctor d){
		
		d.notifications.push("You requsted to receive your salary");
		salary.enqueue(d);
		System.out.println("This is your turn in recieving salary");
		
		printSalaryQueue();
	}
	public void printSalaryQueue(){
		Queue<Doctor> temp = new Queue<Doctor>();
		int i = 1;
		while(!salary.isEmpty()){
			Doctor d = salary.dequeue();
			temp.enqueue(d);
			System.out.println(i + ". " + d.getName());
			i++;
		}
		while(!temp.isEmpty()){
			salary.enqueue(temp.dequeue());
		}
	}
	public void useLab(Student s){
		pq.enqueue(2, "Student: " + s.getName());
		System.out.println("This is your turn in using lab");
		s.notifications.push("You took a turn for using the lab");
		printLabPQ();
	}
	public void useLab(Doctor d){
		d.notifications.push("You took a turn for using the lab");
		pq.enqueue(1,"Doctor: " + d.getName());
		System.out.println("This is your turn in using lab");
		printLabPQ();
	}
	public void printFeeQueue(){
		Queue<Student> temp = new Queue<Student>();
		int i = 1;
		while(!fees.isEmpty()){
			Student a = fees.dequeue();
			temp.enqueue(a);
			System.out.println(i + ". " + a.getName());
			i++;
		}
		while(!temp.isEmpty()){
			fees.enqueue(temp.dequeue());
		}
	}
	
	public void printLabPQ(){
		pq.display2();
	}
	public void printRegisteredCourses(Student s){
		ArrayList<Course> arr = s.coursesTaken;
		for(int i = 0 ; i <arr.size() ;i++){
			System.out.println(arr.get(i).getName() + " ");
		}
	}
	public void registerCourse(Student s){

		ArrayList<Course> arr = super.CMPS.courses;
		
		System.out.println("Enter the number of the course you want to register: ");
		for(int i =0 ; i < arr.size();i++){
			System.out.println(i + ". " + arr.get(i).getName());
		}
		int n = input.nextInt();
		s.registerCourse(arr.get(n));
	}
	void printNotifications(Student s){
		s.printNotifications();
	}
	void printNotifications(Doctor d){
		d.printNotifications();
	}
	public void printAllStudents(){
		for(int i = 0 ; i < students.size() ; i++){
			students.get(i).displayInfo();
			System.out.println("-------------------------------------------");
		}
	}
	
	public void printAllDoctors(){
		for(int i = 0 ; i < doctors.size(); i++){
			doctors.get(i).displayInfo();
			System.out.println("-------------------------------------------");
		}
	}
	public void printAllAdmins(){
		for(int i = 0 ; i < admins.size() ; i++){
			admins.get(i).displayInfo();
			System.out.println("--------------------------------------------");
		}
	}
	
	public void addStudent(Student s){
		students.add(s);
	}
	public void addDoctor(Doctor d){
		doctors.add(d);
	}
	public void addAdmin(Admin a){
		admins.add(a);
	}
	public Student dequeueFee(){
		Student s = fees.dequeue();
		if(s == null) return null;
		s.notifications.push("You paid fees");
		return s;
	}
	
	public String dequeueLabPQ(){
		return pq.dequeue();
	}
	
	public Doctor dequeueSalary(){
		Doctor d = salary.dequeue();
		if(d==null) return null;
		d.notifications.push("You recieved your salary");
		return d;
	}


	public void deleteStudent(int id){
		
		if(student.search(id) == null){
			System.out.println("No student availalble with this id");
			return;
		}
		Student s = student.Search(id);
		for(int i = 0 ; i < students.size() ;i++){
			if(students.get(i) == s){
				students.remove(i);
			}
		}
		pq.removeStringElement(s.getName());
		fees.removeElement(s);
		
		student.delete(id);;
		if(student.search(id) == null){
			System.out.println("Student is deleted successfully");
		}else{
			System.out.println("Student is not deleted");
		}
	}
	public void deleteDoctor(int id){
		
		if(doctor.search(id) == null){
			System.out.println("No doctor available with this id");
			return;
		}
		Doctor d = doctor.Search(id);
		for(int i = 0 ; i < doctors.size() ;i++){
			if(doctors.get(i) == d){
				doctors.remove(i);
			}
		}
		pq.removeElement(d.getName());
		salary.removeElement(d);
		doctor.delete(id);
		
		if(doctor.search(id) == null){
			System.out.println("Doctor is deleted successfully");
		}else{
			System.out.println("Doctor is not deleted");
		}
	}
}
