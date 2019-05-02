import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;
import java.util.LinkedList;

public class Scheduler {
	private int numberOfProcesses;
	private int timeSlice;
	private int countProcesses;
	private ArrayList<Process> processesList;
	private Queue<Process> processesQueue;
	
	public Scheduler(String numberOfProcesses, String timeSlice) {
		processesList = new ArrayList<Process>();
		processesQueue = new LinkedList<Process>();
		
		this.numberOfProcesses = Integer.parseInt(numberOfProcesses);
		this.timeSlice = Integer.parseInt(timeSlice);
	}
	
	public int getNumberOfProcesses() {
		return this.numberOfProcesses;
	}
	
	public int getTimeSlice() {
		return this.timeSlice;
	}
	
	public int getCountProcesses() {
		return this.countProcesses;
	}
	
	public void incrementCountProcesses() {
		this.countProcesses += 1;
	}
	
	public void addProcess(Process p) {
		processesList.add(p);
		incrementCountProcesses();
	}
	
	public Process getProcess(int id) {
		return this.processesList.get(id);
	}
	
	public void listProcesses() {
		Collections.sort(this.processesList);
		
		for (int i = 0; i < this.processesList.size(); i++) {
			this.processesList.get(i);
		}
	}
	
	public ArrayList<Process> getProcessesList() {
		Collections.sort(this.processesList);
		return this.processesList;
	}
	
	public Queue<Process> getProcessesQueue() {
		return this.processesQueue;
	}
	
	public ArrayList<Integer> arrivalList() {
		ArrayList<Integer> arrivals = new ArrayList<Integer>();
		
		for (int i = 0; i < processesList.size(); i++) {
			arrivals.add(processesList.get(i).getArrivalTime());
		}
		
		return arrivals;
	}
	
	public int calcSumTime() {
		int count = 0;
		
		for (int i = 0; i < this.countProcesses; i++) {
			count += this.processesList.get(i).getExecutionTime();
		}
		
		return count;
	}
}
