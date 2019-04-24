# Round Robin

Ler de um arquivo as seguintes informações, nesta ordem: número de processos, tamanho de fatia de tempo, e para cada processo, tempo de chegada, tempo de execução, e tempos de acesso a operações de E/S (tempo correspondente a sua execução, ou seja, após ele executar x unidades de tempo ele faz E/S).

Imprimir um gráfico (texto) mostrando como os processo foram executados.

Considerar uma unidade de tempo para troca de contexto (representado abaixo como C). Tempo começa em 1. Processos podem iniciar logo após haver a troca de contexto, ou seja, se o processo chega no tempo x, ele pode começar a executar no tempo x+1, se não houver processo executando. Desempate é feito pela ordem de chegada.

Tempo que leva para fazer uma operação de entrada e saída: use valor constante igual a 3. 

Exemplo de arquivo de entrada:

           3

           4

           3 6 2

           5 8 

           9 7 1 2


Neste exemplo, temos 3 processos, a fatia de tempo é de 4 unidades. O processo P1 chega no instante 3, executará 6 unidades de tempo, e depois de ter executado 2 unidades de tempo faz uma operação de E/S. O processo P2 chega no instante 5, executa por 8 unidades de tempo e não faz E/S.   O processo P3 chega no instante 9, executa por  unidades de tempo, depois de ter executado 1 unidade de tempo faz uma operação de E/S, e após voltar para a CPU e executar mais 2 unidades de tempo faz mais uma operação de E/S. 

Quando retornar à CPU o processo deve terminar sua fatia de tempo (não pode começar uma nova). 

 
Exemplo de gráfico a ser exibido para o exemplo acima:

           --C11C2222C11C3C2222C11C33C-C3C333
