import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class Scheduler {
	private int numberOfProcesses;
	private int timeSlice;
	private ArrayList<Process> listProcesses;
	private Queue<Process> queueProcesses;
	
	public Scheduler(int numberOfProcesses, int timeSlice) {
		this.numberOfProcesses = numberOfProcesses;
		this.timeSlice = timeSlice;
		listProcesses = new ArrayList<Process>();
		queueProcesses = new LinkedList<Process>();
	}
	
	public int getNumberOfProcesses() {
		return this.numberOfProcesses;
	}
	
	public int getTimeSlice() {
		return this.timeSlice;
	}
	
	public void addProcess(Process p) {
		listProcesses.add(p);
	}
}
