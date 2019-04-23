import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class App {
	
	public static void main(String[] args) {
		try {
		      FileReader txtFile = new FileReader("processes.txt");
		      BufferedReader readFile = new BufferedReader(txtFile);
		      Scheduler scheduler = new Scheduler(Integer.parseInt(readFile.readLine()), Integer.parseInt(readFile.readLine()));
		      
		      System.out.println(scheduler.getNumberOfProcesses());
		      System.out.println(scheduler.getTimeSlice());
		      
		      txtFile.close();
		    } catch (IOException e) {
		        System.err.printf("Erro na abertura do arquivo: %s.\n",
		          e.getMessage());
		    }
	}
	
}
