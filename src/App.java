import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class App {
	
	public static void main(String[] args) {
		try {
		      FileReader txtFile = new FileReader("processes.txt");
		      BufferedReader readFile = new BufferedReader(txtFile);
		      Scheduler scheduler = new Scheduler(readFile.readLine(), readFile.readLine());
		      String line = readFile.readLine();
		      int id = 1;
		      
		      while (line != null) {
		    	  lineToProcess(scheduler, id, line);
		    	  
		    	  line = readFile.readLine();
		    	  id++;
		      }
		      
		      scheduler.listProcesses();
		      txtFile.close();
		} catch (IOException e) {
			System.err.printf("Erro na abertura do arquivo: %s.\n", e.getMessage());
		} finally {
			System.exit(0);
		}
		
		System.out.println("Continua...");
	}
	
	public static void lineToProcess(Scheduler scheduler, int id, String line) {
		String s[] = line.split(" ");
		
		scheduler.addProcess(new Process("P" + id, s[0], s[1]));
		
		for (int i = 2; i < s.length; i++) {
			scheduler.getProcess(id - 1).addAccessTime(s[i]);
		}
	}
	
}
