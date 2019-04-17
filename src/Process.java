import java.util.ArrayList;

public class Process {
	private int id;
	private int arrivalTime;
	private int executionTime;
	private ArrayList<Integer> accessTime;
	
	public Process(int id, int arrivalTime, int executionTime) {
		this.id = id;
		this.arrivalTime = arrivalTime;
		this.executionTime = executionTime;
		accessTime = new ArrayList<Integer>();
	}
}
