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
}
