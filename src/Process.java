import java.util.ArrayList;

public class Process implements Comparable<Process> {
	private int id;
	private int arrivalTime;
	private int executionTime;
	private int alreadyExecuted;
	private int currentSlice;
	private int countToIo;
	private int ioExecutionTime;
	private int doingIo;
	private ArrayList<Integer> ioTimes;
	
	public Process(int id, String arrivalTime, String executionTime) {
		ioTimes = new ArrayList<Integer>();
		this.id = id;
		this.arrivalTime = Integer.parseInt(arrivalTime);
		this.executionTime = Integer.parseInt(executionTime);
		this.alreadyExecuted = 0;
		this.currentSlice = 0;
		this.countToIo = 0;
		this.ioExecutionTime = 0;
		this.doingIo = 0;
	}
	
	public int getDoingIo() {
		return this.doingIo;
	}
	
	public void setDoingIo(int doingIo) {
		this.doingIo = doingIo;
	}
	
	public void increaseDoingIo() {
		this.doingIo++;
	}
	
	public int getIoExecutionTime() {
		return this.ioExecutionTime;
	}
	
	public void setIoExecutionTime(int ioExecutionTime) {
		this.ioExecutionTime = ioExecutionTime;
	}
	
	public int getId() {
		return this.id;
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
	
	public int getCountToIo() {
		return this.countToIo;
	}
	
	public void setCountToIo(int countToIo) {
		this.countToIo = countToIo;
	}
	
	public void execute() {
		this.currentSlice++;
		this.alreadyExecuted++;
		this.countToIo++;
	}
	
	public int getCurrentSlice() {
		return this.currentSlice;
	}
	
	public void setCurrentSlice(int currentSlice) {
		this.currentSlice = currentSlice;
	}
	
	public ArrayList<Integer> getIoTimes() {
		return this.ioTimes;
	}
	
	public int getHeadIo() {
		return this.ioTimes.get(0);
	}
	
	public void addAccessTime(String accessTime) {
		this.ioTimes.add(Integer.parseInt(accessTime));
	}
	
	public boolean hasIo() {
		return this.ioTimes.size() > 0;
	}

	/*@Override
	public String toString() {
		return "Processo " + this.name + ":\n" +
			   "Chegada: " + this.arrivalTime + "\n" + 
			   "Tempo de Execução: " + this.executionTime + "\n" +
			   "E/S: " + this.ioTimes;
	}*/
	
	@Override
	public String toString() {
		return "Process [name=" + id + ", arrivalTime=" + arrivalTime + ", executionTime=" + executionTime + ", ioTimes=" + ioTimes + "]";
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
