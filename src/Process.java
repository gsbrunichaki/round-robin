import java.util.LinkedList;
import java.util.Queue;

public class Process {
	private String name;
	private int arrivalTime;
	private int executionTime;
	private Queue<Integer> accessTime;
	
	public Process(String name, String arrivalTime, String executionTime) {
		this.name = name;
		this.arrivalTime = Integer.parseInt(arrivalTime);
		this.executionTime = Integer.parseInt(executionTime);
		accessTime = new LinkedList<Integer>();
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getArrivalTime() {
		return this.arrivalTime;
	}
	
	public int getExecutionTime() {
		return this.executionTime;
	}
	
	public void addAccessTime(String accessTime) {
		this.accessTime.add(Integer.parseInt(accessTime));
	}
}
