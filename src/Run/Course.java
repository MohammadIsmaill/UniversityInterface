package Run;
import java.util.ArrayList;
public class Course{
	private String name;
	private Doctor doctor = null;
	public Course(String name)
	{
		this.name = name;
	}
	
	public String getName(){
		return name;
	}
	public Doctor getDoctor(){
		return doctor;
	}
	
	
	public void setDoctor(Doctor d){
		this.doctor = d;
	}
	
}
