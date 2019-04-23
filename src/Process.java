import java.util.ArrayList;

public class Process {
	private String name;
	private int arrivalTime;
	private int executionTime;
	private ArrayList<Integer> accessTime;
	
	public Process(String name, int arrivalTime, int executionTime) {
		this.name = name;
		this.arrivalTime = arrivalTime;
		this.executionTime = executionTime;
		accessTime = new ArrayList<Integer>();
	}
}
