import java.util.ArrayList;

public class CPU {
	private int totalTime;
	private int usedTime;
	private int currentTime;
	private Scheduler scheduler;
	private Process process;
	private ArrayList<Process> arrivalsList;
	private ArrayList<Process> ioList;
	
	public CPU(Scheduler scheduler) {
		this.scheduler = scheduler;
		this.arrivalsList = this.scheduler.getProcessesList();
		this.ioList = new ArrayList<Process>();
		this.totalTime = this.scheduler.calcSumTime();
		this.usedTime = 0;
		this.currentTime = 1;
		this.process = null;
	}
	
	public void run() {		
		while (currentTime <= 34) {
		// while (usedTime <= totalTime) {
			boolean ioExecution = false;
			boolean sliceEnded = false;
			boolean processEnded = false;
			
			System.out.print(this.currentTime + " ");
			
			if (this.arrivalsList.size() > 0) {
				Process nextArrival = arrivalsList.get(0);
				
				if (this.currentTime == nextArrival.getArrivalTime()) {
					this.scheduler.getProcessesQueue().add(nextArrival);
					this.arrivalsList.remove(0);
				}
			}
			
			if (!this.ioList.isEmpty()) {
				Process processIo = this.ioList.get(0);
				
				processIo.increaseDoingIo();
				
				if (processIo.getDoingIo() == 3) {
					processIo.setDoingIo(0);
					this.scheduler.getProcessesQueue().add(processIo);
					this.ioList.remove(0);
				}
			}
			
			if (this.process == null && !this.scheduler.getProcessesQueue().isEmpty()) {
				Process headProcess = this.scheduler.getProcessesQueue().poll();
				
				if (headProcess.getDoingIo() < 3)
				this.process = scheduler.getProcessesQueue().poll();
				System.out.print("C");
				
				/*if (this.scheduler.getProcessesQueue().peek().getIoExecutionTime() == 0 || this.scheduler.getProcessesQueue().peek().getIoExecutionTime() + 3 <= this.currentTime) {
					this.scheduler.getProcessesQueue().peek().setIoExecutionTime(0);
					
				} else {
					System.out.print("-");
				}*/
			} else if (this.process == null && !this.ioList.isEmpty()) {
				if (this.ioList.get(0).getDoingIo() < 3) {
					System.out.print("-");
				} else {
					System.out.print("C");
				}
			} else if (this.process != null) {
				this.process.execute();
				this.usedTime++;
				System.out.print(this.process.getName());
				
				ioExecution = (this.process.hasIo()) && (this.process.getCountToIo() % this.process.getHeadIo() == 0);
				sliceEnded = (this.process.getCurrentSlice() % scheduler.getTimeSlice() == 0);
				processEnded = (this.process.getAlreadyExecuted() == this.process.getExecutionTime());
				
				if (ioExecution || sliceEnded || processEnded) {
					if (ioExecution) {
						this.process.getIoTimes().remove(0);
						this.process.setCountToIo(0);
						this.process.setIoExecutionTime(this.currentTime);
						this.ioList.add(this.process);
					}
					
					if (!processEnded && !ioExecution) {
						scheduler.getProcessesQueue().add(this.process);
					}

					this.process = null;
				}
			} else {
				System.out.print("-");
			}
			
			this.currentTime++;
			System.out.println();
		}
	}
}
