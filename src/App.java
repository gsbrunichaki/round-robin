import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/*
 * Ler de um arquivo as seguintes informa��es, nesta ordem: n�mero de processos, tamanho de fatia de tempo, e 
 * para cada processo, tempo de chegada, tempo de execu��o, e tempos de acesso a opera��es de E/S (tempo 
 * correspondente � sua execu��o, ou seja, ap�s ele executar x unidades de tempo ele faz E/S).
 * 
 * - Round Robin (sem prioridade)
 * 
 * Imprimir um gr�fico (texto) mostrando como os processo foram executados.
 * Considerar uma unidade de tempo para troca de contexto (representar como C).
 * Tempo come�a em 1. Processos podem iniciar logo ap�s haver a troca de contexto, ou seja, se o 
 * processo chega no tempo x, ele pode come�ar a executar no tempo x+1, se n�o houver processo executando. 
 * Desempate � feito pela ordem de chegada.
 * 
 * Tempo que leva para fazer uma opera��o de entrada e sa�da: valor constante igual a 3. 
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
