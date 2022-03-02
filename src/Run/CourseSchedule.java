package Run;
import java.util.ArrayList;

import DataStructures.Graph;
import DataStructures.HashMap;


public class CourseSchedule extends Graph<Course> {
	String major;
	String faculty;
	HashMap<Course,Boolean> isAdded = new HashMap<Course,Boolean>();
	public ArrayList<Course> courses = new ArrayList<Course>();
	public CourseSchedule(String major,String faculty){
		this.major = major;
		this.faculty = faculty;
	}
	public void addPrerequisite(Course c1, Course c2){
		addEdge(c1,c2);
		
		if(isAdded.get(c1) == null){
			courses.add(c1);
			isAdded.put(c1, true);
		}
		if(isAdded.get(c2) == null){
			courses.add(c2);
			isAdded.put(c2, true);
		}
		
	}
	
	public ArrayList<Course> getAllCourses(){
		return courses;
	}
	void printPrerequisites(Course c1){
		System.out.println("The prerequisites for " + c1.toString());
		ArrayList<Course> arr = DFS(c1);
		for(int i = 0; i < arr.size() ; i++){
			System.out.println(arr.get(i).toString());
		}
		
	}
	public ArrayList<Course> canTakeCourse(Course c1,ArrayList<Course> arr){
		ArrayList<Course> prerequisiteCourses = DFS(c1);
		ArrayList<Course> coursesNotTaken = new ArrayList<Course>();
		for(int i = 0 ; i < prerequisiteCourses.size(); i++){
			
			//if student courses do not complete all prerequisite cousres
			if(!arr.contains(prerequisiteCourses.get(i))){
				coursesNotTaken.add(prerequisiteCourses.get(i));
				
			}
		}
		return coursesNotTaken;
	}
	public void printAllCourses(){
		for(int i =0  ; i < courses.size(); i++){
			System.out.println(courses.get(i));
		}
	}

}
