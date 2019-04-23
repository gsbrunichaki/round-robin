import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class App {
	
	public static void main(String[] args) {
		try {
		      FileReader txtFile = new FileReader("processes.txt");
		      BufferedReader readFile = new BufferedReader(txtFile);
		      Scheduler scheduler = new Scheduler(Integer.parseInt(readFile.readLine()), Integer.parseInt(readFile.readLine()));
		      String line = readFile.readLine();
		      
		      while (line != null) {
		    	  // split da linha aqui
		    	  line = readFile.readLine();
		      }
		      
		      scheduler.addProcess(new Process("P" + (scheduler.getCountProcesses() + 1), 2, 3));
		      
		      txtFile.close();
		    } catch (IOException e) {
		        System.err.printf("Erro na abertura do arquivo: %s.\n",
		          e.getMessage());
		    }
	}
	
}
