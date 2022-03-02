package DataStructures;
import java.util.*;

import Run.Course;


public class Graph<T>
{
	
	private HashMap<T,ArrayList<T>> mp = new HashMap<>();
	
	private T temp;
	public Graph(){}
	
	public void addNewVertex(T vertex)
	{
		mp.put(vertex,new ArrayList<T>());
	}
	public void addEdge(T source, T destination)
	{
		addNewVertex(source);
		mp.get(source).add(destination);
		
	}
	
	
	//print all except vertex v
	public ArrayList<Course> DFS(T v)
	{
		HashMap<T,Boolean> visited = new HashMap<T,Boolean>();	
		ArrayList<Course> arr = new ArrayList<Course>();
		temp = v;
		DFSUtil(v,visited,arr);
		return arr;
	
	}
	
	public void DFSUtil(T k, HashMap<T,Boolean> visited,ArrayList<Course> arr)
	{
		
		visited.put(k,true);
		if(temp != k)
//			System.out.println(k.toString() + " ");
			arr.add((Course) k);
		
		
		ArrayList<T> arrTemp = mp.get(k);
		if(arrTemp != null){
			Iterator<T> i = arrTemp.listIterator();
			while(i.hasNext()){
				T n = i.next();
				if(visited.get(n) == null)
					DFSUtil(n,visited,arr);
			}	
		}
	}
	
	
}