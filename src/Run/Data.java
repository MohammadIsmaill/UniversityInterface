package Run;

import java.util.ArrayList;

import DataStructures.BST;
import DataStructures.PQ;
import DataStructures.Stack;
import DataStructures.Queue;


public class Data{
	ArrayList<Student> students  = new ArrayList<Student>();
	ArrayList<Doctor> doctors = new ArrayList<Doctor>();
	ArrayList<Admin> admins = new ArrayList<Admin>();
	
	
	
	BST<Student> student = new BST<Student>();
	BST<Doctor> doctor = new BST<Doctor>();
	BST<Admin> admin = new BST<Admin>();
	

	
	
	Queue<Student> fees = new Queue<Student>();
	
	Queue<Doctor> salary = new Queue<Doctor>();
	
	PQ<String> pq = new PQ<String>();

	CourseSchedule CMPS = new CourseSchedule("Computer Science","Science");
	CourseSchedule MATH = new CourseSchedule("Math","Science");
	CourseSchedule PHYSICS = new CourseSchedule("Physics","Science");
	CourseSchedule CHEMISTRY = new CourseSchedule("Chemistry","Science");
	
	Data(){
		
		Admin a = new Admin("admin1","34","admin@gmail.com","123");
		admin.insert(a,a.getKey());
		
		Course CHEM241 = new Course("Principles of Chemistry");
		Course CHEM241L = new Course("Principles of Chemistry Laborator");
		Course PHYS241 = new Course("Principles of Physics");
		Course PHYS241L = new Course("Principles of Physics Laboratory");
		Course MATH241 = new Course("Calculus and Analytical Geometry");
		Course CMPS241 = new Course("Introduction to Programming");
		
		
		
		Course CMPS242 = new Course("Object Oriented Programming");
		Course CMPS244 = new Course("Digital Circuits");
		Course CMPS246 = new Course("Web Programming");
		Course CMPS248 = new Course("Discrete Structures I");
		Course CMPS347 = new Course("Data Structures");
		Course CMPS343 = new Course("Computer Organization & Architecture");
		Course CMPS345 = new Course("Discrete Structures II");
		Course CMPS342 = new Course("Database Systems");
		Course CMPS344 = new Course("Software Engineering");
		Course CMPS346 = new Course("Theory of Computation");
		Course CMPS441 = new Course("Fundamentals of Algorithms");
		Course CMPS445 = new Course("Concepts of Programming Languages");
		Course CMPS447 = new Course("Computer Networks");
		Course CMPS443 = new Course("Senior Project I");
		Course CMPS442 = new Course("Operating System");
		Course CMPS444 = new Course("Senior Project II");
		
		
		
		
		Course MATH242 = new Course("Probability and Statistics");
		Course MATH244 = new Course("Ordinary Differential Equations");
		Course MATH246 = new Course("Real Analysis I");
		Course MATH248 = new Course("Multivariable Calculus");
		Course MATH341 = new Course("Linear Algebra");
		Course MATH342 = new Course("Vector Calculus");
		Course MATH343 = new Course("Special Functions");
		Course MATH344 = new Course("Real Analysis II");
		Course MATH345 = new Course("Discrete Mathematics");
		Course MATH346 = new Course("Abstract Algebra I");
		Course MATH348 = new Course("Numerical Methods");
		Course MATH441 = new Course("Introduction to Complex Analysis");
		Course MATH442 = new Course("Abstract Algebra II");
		Course MATH443 = new Course("Topology");
		Course MATH444 = new Course("Senior Project");
		Course MATH446 = new Course("Fourier Series and Applications");
		
		
		
		
		Course CHEM242 = new Course("Analytical Chemistry");
		Course CHEM242L = new Course("Analytical Chemistry Laboratory");
		Course CHEM248 = new Course("Physical Chemistry I");
		Course CHEM244 = new Course("Organic Chemistry I");
		Course CHEM341 = new Course("Organic Chemistry II");
		Course CHEM341L = new Course("Organic Chemistry Laboratory");;
		Course CHEM343 = new Course("Chemical Kinetics");
		Course CHEM349 = new Course("Physical Chemistry II");
		Course CHEM349L = new Course("Physical Chemistry Laboratory");
		Course CHEM345 = new Course("Inorganic Chemistry I");
		Course CHEM342 = new Course("Instrumental Analysis");
		Course CHEM342L = new Course("Instrumental Analysis Laboratory");
		Course CHEM346 = new Course("Bioorganic Chemistry");
		Course CHEM348 = new Course("Inorganic Chemistry II");
		Course CHEM348L = new Course("Inorganic Chemistry Laboratory");
		Course CHEM441 = new Course("Electrochemistry and Applications");
		Course CHEM441L = new Course("Electrochemistry and Applications Laboratory");
		Course CHEM442 = new Course("Spectroscopic Identification of Chemical Compounds");
		Course CHEM442L = new Course("Spectroscopic Identification of Chemical Compounds Laboratory");
		Course CHEM444 = new Course("Senior Project");
		
		
		CHEMISTRY.addPrerequisite(CHEM242, CHEM241);
		CHEMISTRY.addPrerequisite(CHEM242, CHEM241L);
		CHEMISTRY.addPrerequisite(CHEM248, CHEM241);
		CHEMISTRY.addPrerequisite(CHEM242L,CHEM241L);
		CHEMISTRY.addPrerequisite(CHEM341,CHEM244);
		CHEMISTRY.addPrerequisite(CHEM341L,CHEM244);
		CHEMISTRY.addPrerequisite(CHEM343, CHEM248);
		CHEMISTRY.addPrerequisite(CHEM349, CHEM248);
		CHEMISTRY.addPrerequisite(CHEM349L, CHEM248);
		CHEMISTRY.addPrerequisite(CHEM345, CHEM241);
		CHEMISTRY.addPrerequisite(CHEM342,CHEM242);
		CHEMISTRY.addPrerequisite(CHEM342L, CHEM242);
		CHEMISTRY.addPrerequisite(CHEM346, CHEM341);
		CHEMISTRY.addPrerequisite(CHEM348, CHEM345);
		CHEMISTRY.addPrerequisite(CHEM348L, CHEM348);
		CHEMISTRY.addPrerequisite(CHEM442, CHEM341);
		CHEMISTRY.addPrerequisite(CHEM442L,CHEM442);
		
		
		CMPS.addPrerequisite(CMPS242, CMPS241);
		CMPS.addPrerequisite(CMPS248,CMPS241);
		CMPS.addPrerequisite(CMPS246,CMPS241);
		CMPS.addPrerequisite(CMPS347,CMPS242);
		CMPS.addPrerequisite(CMPS343,CMPS244);
		CMPS.addPrerequisite(CMPS345,CMPS248);
		CMPS.addPrerequisite(CMPS342,CMPS242);
		CMPS.addPrerequisite(CMPS344,CMPS242);
		CMPS.addPrerequisite(CMPS346,CMPS248);
		CMPS.addPrerequisite(CMPS441,CMPS347);
		CMPS.addPrerequisite(CMPS441,CMPS345);
		CMPS.addPrerequisite(CMPS445,CMPS347);
		CMPS.addPrerequisite(CMPS447,CMPS347);
		CMPS.addPrerequisite(CMPS443,CMPS441);
		CMPS.addPrerequisite(CMPS442,CMPS347);
		CMPS.addPrerequisite(CMPS444,CMPS443);
		
		
		MATH.addPrerequisite(MATH244, MATH241);
		MATH.addPrerequisite(MATH246, MATH241);
		MATH.addPrerequisite(MATH248, MATH241);
		MATH.addPrerequisite(MATH343,MATH244);
		MATH.addPrerequisite(MATH342, MATH241);
		MATH.addPrerequisite(MATH344,MATH246);
		MATH.addPrerequisite(MATH346, MATH345);
		MATH.addPrerequisite(MATH348, MATH241);
		MATH.addPrerequisite(MATH441,MATH241);
		MATH.addPrerequisite(MATH443, MATH246);
		MATH.addPrerequisite(MATH442, MATH346);
		MATH.addPrerequisite(MATH446, MATH246);
		
//		CMPS.printAllCourses();
	}

	

}