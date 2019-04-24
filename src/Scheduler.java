import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class Scheduler {
	private int numberOfProcesses;
	private int timeSlice;
	private int countProcesses;
	private ArrayList<Process> listProcesses;
	private Queue<Process> queueProcesses;
	
	public Scheduler(String numberOfProcesses, String timeSlice) {
		listProcesses = new ArrayList<Process>();
		queueProcesses = new LinkedList<Process>();
		
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
		listProcesses.add(p);
		incrementCountProcesses();
	}
	
	public Process getProcess(int id) {
		return this.listProcesses.get(id);
	}
	
	public void listProcesses() {
		for (int i = 0; i < listProcesses.size(); i++) {
			System.out.println("Processo " + listProcesses.get(i).getName() + ":");
			System.out.println("Chegada: " + listProcesses.get(i).getArrivalTime());
			System.out.println("Tempo de Execução: " + listProcesses.get(i).getExecutionTime());
			System.out.println();
			// System.out.print("Próxima Parada E/S: " + listProcesses.get(i).);
		}
	}
}
