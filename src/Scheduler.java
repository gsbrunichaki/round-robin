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
		
		for (int i = 0; i < processesList.size(); i++) {
			System.out.println("Processo " + processesList.get(i).getName() + ":");
			System.out.println("Chegada: " + processesList.get(i).getArrivalTime());
			System.out.println("Tempo de Execução: " + processesList.get(i).getExecutionTime());
			System.out.print("E/S: ");
			
			if (processesList.get(i).getIoTimes().size() > 0) {
				Queue<Integer> queueAux = processesList.get(i).getIoTimes();
				
				for (int j = 0; j <= queueAux.size(); j++) {
					System.out.print(queueAux.poll() + " ");
				}
			} else {
				System.out.print("- ");
			}
			
			System.out.println("\n");
		}
	}
	
	public ArrayList<Integer> arrivalList() {
		ArrayList<Integer> arrivals = new ArrayList<Integer>();
		
		for (int i = 0; i < processesList.size(); i++) {
			arrivals.add(processesList.get(i).getArrivalTime());
		}
		
		return arrivals;
	}
	
	public void someName() {		
		ArrayList<Integer> arrivals = arrivalList();
		
		/*for (int i = 1; i < 15; i++) {
			if(arrivals.get(0) == i) {
				System.out.print("C");
				arrivals.remove(0);
			} else {
				System.out.print("-");
			}
		}*/
		
		for (int i = 1; i < 20; i++) {
			for (int j = 0; j < this.processesList.size(); j++) {
				if (this.processesList.get(j).getArrivalTime() == i) {
					System.out.print("C");
					break;
				}
			}
			
			System.out.print("-");
		}
	}
}
