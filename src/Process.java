import java.util.LinkedList;
import java.util.Queue;

public class Process implements Comparable<Process> {
	private String name;
	private int arrivalTime;
	private int executionTime;
	private int alreadyExecuted;
	private int currentSlice;
	private Queue<Integer> ioTimes;
	
	public Process(String name, String arrivalTime, String executionTime) {
		ioTimes = new LinkedList<Integer>();
		this.name = name;
		this.arrivalTime = Integer.parseInt(arrivalTime);
		this.executionTime = Integer.parseInt(executionTime);
		this.alreadyExecuted = 0;
		this.currentSlice = 0;
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
	
	public int getAlreadyExecuted() {
		return this.alreadyExecuted;
	}
	
	public void setAlreadyExecuted(int alreadyExecuted) {
		this.alreadyExecuted = alreadyExecuted;
	}
	
	public int getCurrentSlice() {
		return this.currentSlice;
	}
	
	public void setCurrentSlice(int currentSlice) {
		this.currentSlice = currentSlice;
	}
	
	public Queue<Integer> getIoTimes() {
		return this.ioTimes;
	}
	
	public void addAccessTime(String accessTime) {
		this.ioTimes.add(Integer.parseInt(accessTime));
	}

	@Override
	public int compareTo(Process p) {
		if (this.arrivalTime < p.getArrivalTime()) {
			return -1;
		} else if (this.arrivalTime > p.getArrivalTime()) {
			return 1;
		}
		
		return 0;
	}
}
