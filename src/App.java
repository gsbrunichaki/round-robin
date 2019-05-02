import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;

public class App {
	
	public static void main(String[] args) {
		try {
		      FileReader txtFile = new FileReader("processes.txt");
		      BufferedReader readFile = new BufferedReader(txtFile);
		      Scheduler scheduler = new Scheduler(readFile.readLine(), readFile.readLine());
		      String line = readFile.readLine();
		      int id = 1;
		      
		      while (scheduler.getCountProcesses() != scheduler.getNumberOfProcesses()) {
		    	  lineToProcess(scheduler, id, line);
		    	  
		    	  line = readFile.readLine();
		    	  id++;
		      }
		      
		      txtFile.close();
		      
		      scheduler.listProcesses();
		      
		      CPU cpu = new CPU(scheduler);
		      cpu.run();
		} catch (IOException e) {
			System.err.printf("Erro na abertura do arquivo: %s.\n", e.getMessage());
		}
	}
	
	public static void lineToProcess(Scheduler scheduler, int id, String line) {
		String s[] = line.split(" ");
		
		scheduler.addProcess(new Process(id, s[0], s[1]));
		
		for (int i = 2; i < s.length; i++) {
			scheduler.getProcess(id - 1).addAccessTime(s[i]);
		}
	}
	
}
