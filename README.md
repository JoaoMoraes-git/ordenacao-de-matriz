# Introdução
O projeto é um sistema de ordenação de matrizes numéricas em ordem crescente.

## Classe Matriz

### Responsabilidade
A classe matriz lida com dados numéricos dados pelo usuário ou gerados aleatoriamente, criando uma matriz de
tamanho definido pelo usuário, ordenando os valores por linha, coluna e o vetor inteiro.

### Atributos
| Atributo | Tipo    | O que faz                                                                                                                                |
|----------|---------|------------------------------------------------------------------------------------------------------------------------------------------|
| matriz   | int[][] | Inicializado vazio, e usado junto com o método novaMatriz<br/>para criar uma matriz bidimensional com tamanho definido<br/>pelo usuário. |
| scan     | Scanner | Recebe o input do usuário, usado para definir opções,<br/>como tamanho da matriz, forma de preenchimento e<br/>valores.                  |
| r        | Random  | Gera uma série de números aleatórios para serem<br/>preenchidos na matriz caso o usuário escolha o<br/>preenchimento automático.         |

### Métodos
| Método                                          | O que faz                                                                                                                                                                                                                                                                                                                                        |
|-------------------------------------------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| novaMatriz()                                    | Pede uma quantidade de linhas e colunas para o usuário e cria uma matriz<br/>vazia com isso.                                                                                                                                                                                                                                                     |
| preenchimento()                                 | Pergunta ao usuário como a matriz será preenchida, podendo ser de forma manual em que o usuário digita todos os valores. E automático em que a matriz é preenchida com valores aleatórios de 0 a 100.                                                                                                                                            |
| mostrarMatriz()                                 | Printa toda a matriz em formato tabular.                                                                                                                                                                                                                                                                                                         |
| bubbleSortPorLinha(int[][] matriz)              | Ordena uma linha da matriz usando bubbleSort e após isso passa para a  próxima  linha até todas ficarem ordenadas.                                                                                                                                                                                                                               |
| bubbleSortPorColuna(int[][] matriz)             | Ordena uma coluna da matriz usando bubbleSort e após isso passa para a próxima coluna até todas ficarem ordenadas.                                                                                                                                                                                                                               |
| ordenarPorVetor(int[][] matriz)                 | Recebe a matriz, e cria um array 1d com a mesma quantidade de índices,<br/> após isso preenche o array com os valores da matriz, o array é passado<br/> para o método mergeSort que ordena ele, após isso volta para esse<br/> método e troca os valores da matriz pelos valores novos do array, assim<br/> ordenando o vetor inteiro da matriz. |
| mergeSort(int[] tempArray, int inicio, int fim) | Recebe o array de ordenarPorVetor e ordena ela usando mergeSort.                                                                                                                                                                                                                                                                                 |
| merge()                                         | Usado em conjunto com o mergeSort para ordenação.                                                                                                                                                                                                                                                                                                |

## Explicação de funcionalidades

### Criação da matriz
A classe matriz começa com uma matriz 2d originalmente vazia, em que os seus valores são passados posteriormente.

O usuário define no método novaMatriz o tamanho da matriz, para isso, é usado Scanners para pedir o tamanho de colunas e
linhas, que são armazenadas e variáveis, e esses valores são passadas para a matriz vazia para definir o seu tamanho.

Isso apenas define o tamanho da matriz, mas os seus valores continuam sendo vazios (0).


### Prenchimento

O método preenchimento pede ao usuário um número através de um Scanner se a matriz deve ser preenchida manualmente (digitando 1)
ou automáticamente (digitando 2), além disso a pergunta é feita novamente caso o usuário decida uma opção inválida.

Explicação de cada opção:

**1**. O prenchimento é feito de forma manual. O programa percorre toda a matriz usando laços de repetição, a cada coluna
dentro de uma linha, é pedido que um valor numérico para o usuário com Scanner, o índice na posição atual recebe o valor
do usuário. Após passar por todas as colunas de uma linha, a repetição continua na próxima linha, continuando até que todas
as linhas sejam preenchidas.

**2**. O preenchimento é feito de forma automática. O programa percorre todas as linhas e colunas, por cada índice, é 
gerado um valor de 0 a 100 usando Random, e o índice recebe esse valor.

**Opção invãida**. O método chama ele mesmo dentro de sí, assim repetindo o processo até que seja escolhido algo válido.

### Mostrar a matriz
Toda a matriz é percorrida, printando todos os valores de uma linha, um ao lado do outro até chegar ao fim da linha, então
passa a fazer o mesmo na linha abaixo, também fazendo os printes aparecem uma linha abaixo, até que toda a matriz
seja percorrida.

### Ordenação de linha e coluna.
A ordenação de linha e de a de colunas acontecem em métodos diferentes, porém ambos usam bubbleSort mas de formas diferentes.

o bubbleSort compara um índice de um array e o compara com o próximo índice, trocando um com o outro caso seja preciso,
no entanto ele precisou ser mudado das seguintes formas para funcionar com a matriz 2d e como deve ser ordenada:

**Linhas**. Um laço de repetição percorre toda a matriz, começando pela primeira linha na qual todos os índices dessa linha,
outro laço define quantas vezes a linha será percorrida e por fim os valores dos índices são comparados com o próximo índice,
os trocando de posição caso necessário para ser ordenado corretamente, após isso passa para a próxima linha e repete o mesmo
processo sucessivamente até a matriz ser completamento percorrida.

**Colunas**. Um laço de repetição percorre toda a matriz, começando pela primeira coluna, em que todos os índices são comparados
com o índice na linha abaixo dele, trocando os dois de posição e caso preciso e mandando o valor maior para baixo, após isso
passa para a próxima coluna até que todas sejam percorridas.

### Ordenação de vetor
O vetor inteiro é ordenado, seguindo da esquerda para direita de uma linha e continuando para a próxima linha quando o espaço
acabar. Para isso foi toda a matriz foi achatada em un array 1d, depois ordenado com mergeSort, e por fim montado em forma
bidimensional novamente. Múltiplos métodos são usados para realizar o processo, sendo eles:

**ordenarPorVetor**. Conta quantos índices tem na matriz, e com base nisso cria um array 1d com valores vazios com a mesma quantidade de índices,
após isso percorre toda a matriz, passando os valores para o array.

Em seguida passa o array preenchido para o método mergeSort, onde seus valores são organizados. (mais detalhes dessa parte em 'mergeSort' e 'merge')

após isso o método continua, o array ordenado é percorrido, passando o seus valores para os índices da matriz, da esquerda para a direita, e passando para a linha de baixo até que todos os valores sejam passados.

**mergeSort**. Recebe o array de ordenarPorVetor, o divide pela metade, e repete o processo nos arrays divididos, até todos
os arrays tiverem apenas 1 índice, após isso para esses arrays pequenos para o método merge, que organiza eles, (mais detalhes em 'merge')

**merge**. junta um array recebido pelo mergeSort junto com outro array, e junta esses arrays maiores com outros arrays de
mesmo tamanho, até montar o array completo novamente mas ordenado.

## Comparação de algorítmos
O projeto utilizou os algorítmos bubbleSort (iterativo) e mergeSort (recursivo).

O bubbleSort é iterativa, usando 'for' para se percorrer continuamente até que a matriz fique corretamente organizada, sendo um processo
leve para a memória e fácil de se aplicar, porém sendo menos eficaz (mais lento), isso não é um problema em casos pequenos (como os desse projeto), mas
ao percorrer algo maior, o problema fica claramente visível. Por isso é recomendado ser usado para ordenações de porte pequeno.

O mergeSort é recursivo, dividindo o problema em partes menores e sendo percorrido continuamente e se chamando multiplas vezes
até que a ordenação fique pronta. Sendo um processo muito eficiente e rápido, porém pesando mais na memória e sendo significativamente
mais difícil de se aplicar. Sendo uma ótima opção para casos de porte grande, mas podendo ser substituído por um método
iterativo para casos pequenos.

## Conclusão
A ordenação de dados acabou sendo mais complexa do que pude imaginar, apesar de realizar as organizações de arrays 1d sejam
fáceis com bubbleSort e mergeSort, mudar eles para que funcionem em uma matriz bidimensional e para funcionar como pedido
(ordenando por linha, coluna e todo o vetor) se mostrou ser desafiante.

A maior dificuldade acabou sendo a ordenação do vetor, já que foi necessário achatar toda a matriz para ser enviado para o mergeSort e merge, que por ser um método bastante
extenso e complexo, acabou sendo bem complicado de se mexer.

No entanto esse trabalho foi bastante útil para o aprendizado dos sistemas de ordenação.
