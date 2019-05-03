import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/*
 * Ler de um arquivo as seguintes informações, nesta ordem: número de processos, tamanho de fatia de tempo, e 
 * para cada processo, tempo de chegada, tempo de execução, e tempos de acesso a operações de E/S (tempo 
 * correspondente à sua execução, ou seja, após ele executar x unidades de tempo ele faz E/S).
 * 
 * - Round Robin (sem prioridade)
 * 
 * Imprimir um gráfico (texto) mostrando como os processo foram executados.
 * Considerar uma unidade de tempo para troca de contexto (representar como C).
 * Tempo começa em 1. Processos podem iniciar logo após haver a troca de contexto, ou seja, se o 
 * processo chega no tempo x, ele pode começar a executar no tempo x+1, se não houver processo executando. 
 * Desempate é feito pela ordem de chegada.
 * 
 * Tempo que leva para fazer uma operação de entrada e saída: valor constante igual a 3. 
 *
 * Date                  02/05/2019
 * 
 * Author                Gabriel Brunichaki, Paulo Aranha
 */

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
			scheduler.getProcess(id - 1).addIoTime(s[i]);
		}
	}
	
}
