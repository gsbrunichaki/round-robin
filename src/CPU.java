import java.util.ArrayList;

public class CPU {
	private int totalTime;
	private int usedTime;
	private int currentTime;
	private boolean contextSwitch;
	private Scheduler scheduler;
	private Process process;
	private ArrayList<Process> arrivalsList;
	private ArrayList<Process> ioList;
	
	public CPU(Scheduler scheduler) {
		this.totalTime = scheduler.calcSumTime();
		this.usedTime = 0;
		this.currentTime = 1;
		this.contextSwitch = false;
		this.scheduler = scheduler;
		this.process = null;
		this.arrivalsList = scheduler.getProcessesList();
		this.ioList = new ArrayList<Process>();
	}
	
	public void run() {		
		while (usedTime < totalTime) {			
			while (!this.arrivalsList.isEmpty() && this.currentTime == this.arrivalsList.get(0).getArrivalTime()) {					
				this.scheduler.getProcessesQueue().add(this.arrivalsList.get(0));
				this.arrivalsList.remove(0);
				this.contextSwitch = (this.process == null);
			}
			
			if (!this.ioList.isEmpty()) {
				Process processIo = this.ioList.get(0);
				
				processIo.increaseDoingIo();
				
				if (processIo.getDoingIo() == 3) {
					processIo.setDoingIo(0);
					this.scheduler.getProcessesQueue().add(processIo);
					this.ioList.remove(0);
					
					this.contextSwitch = (this.process == null);
				}
			}
			
			if (contextSwitch) {
				System.out.print("C");
				
				if (!this.scheduler.getProcessesQueue().isEmpty()) {
					this.process = this.scheduler.getProcessesQueue().poll();
				}
				
				contextSwitch = false;
			} else if (this.process != null) {
				this.process.execute();
				this.usedTime++;
				
				System.out.print(this.process.getId());
				
				boolean ioExecution = (this.process.hasIo()) && (this.process.getCountToIo() == this.process.getHeadIo());
				boolean sliceEnded = (this.process.getCurrentSlice() % this.scheduler.getTimeSlice() == 0);
				boolean processEnded = (this.process.getAlreadyExecuted() == this.process.getExecutionTime());
				
				if (ioExecution || sliceEnded || processEnded) {
					if (ioExecution) {
						this.process.getIoTimes().remove(0);
						this.process.setCountToIo(0);
						this.ioList.add(this.process);
					}
					
					if (!processEnded && !ioExecution) {
						this.scheduler.getProcessesQueue().add(this.process);
					}

					this.process = null;
					this.contextSwitch = true;
				}
			} else {
				System.out.print("-");
			}
			
			System.out.print(" ");
			this.currentTime++;
		}
	}
}