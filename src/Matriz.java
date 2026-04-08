import java.util.Random;
import java.util.Scanner;

public class Matriz {
    int matriz[][];
    Scanner scan = new Scanner(System.in);
    Random r = new Random();

    public void novaMatriz() {

        System.out.println("Quantas colunas deve ter na matriz");
        int x = scan.nextInt();

        System.out.println("Quantas linhas deve ter na matriz");
        int y = scan.nextInt();

        matriz = new int[y][x];

    }

    public void preenchimento() {
        System.out.println("Digite 1 para preenchimento manual ou 2 para preenchimento automático");
        int escolha = scan.nextInt();

        //Manual
        if (escolha == 1) {

            for (int i = 0; i < matriz.length; i++) {
                for (int j = 0; j < matriz[i].length; j++) {
                    System.out.println("Digite o número da posição: [" + i + "] [" + j + "]");
                    matriz[i][j] = scan.nextInt();
                    scan.nextLine();
                }
            }

            //Automático e aleatório
        } else if (escolha == 2) {
            System.out.println("Gerando valores na matriz...");
            for (int i = 0; i < matriz.length; i++) {
                for (int j = 0; j < matriz[i].length; j++) {
                    matriz[i][j] = r.nextInt(101);
                }
            }
        } else {
            preenchimento();
        }

    }

    public void mostrarMatriz() {
        for (int i = 0; i < matriz.length; i++) {
            System.out.print("[");
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.print("]");
            System.out.println();
        }
    }

    public void bubbleSortPorLinha(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            int n = matriz[i].length;

            for (int j = 0; j < n - 1; j++) {
                for (int k = 0; k < n - j - 1; k++) {
                    if (matriz[i][k] > matriz[i][k + 1]) {
                        int temp = matriz[i][k];
                        matriz[i][k] = matriz[i][k + 1];
                        matriz[i][k + 1] = temp;
                    }
                }
            }
        }
    }

    public void bubbleSortPorColuna(int[][] matriz) {
        for (int j = 0; j < matriz[0].length; j++) {
            int n = matriz.length;

            for (int i = 0; i < n - 1; i++) {
                for (int k = 0; k < n - 1; k++) {
                    if (matriz[k][j] > matriz[k + 1][j]) {
                        int temp = matriz[k][j];
                        matriz[k][j] = matriz[k + 1][j];
                        matriz[k + 1][j] = temp;
                    }
                }
            }
        }
    }

    public void ordenarPorVetor(int[][] vetor){
        int contagem = 0;

        for (int i = 0; i < vetor.length; i++){
            for (int j = 0; j < vetor[i].length; j++) {
                contagem++;
            }
        }

        int[] tempArray = new int[contagem];
        int pos = 0;

        for(int i = 0; i < vetor.length; i++){
            for (int j = 0; j < vetor[i].length; j++){
                tempArray[pos] = vetor[i][j];
                pos++;
            }
        }

        mergeSort(tempArray, 0, tempArray.length - 1);
        pos = 0;

        for(int i = 0; i < vetor.length; i++){
            for (int j = 0; j < vetor[i].length; j++){
                vetor[i][j] = tempArray[pos];
                pos++;
            }
        }

    }

    public static void mergeSort(int[] tempArray, int inicio, int fim) {


        if (inicio < fim) {
            int meio = (inicio + fim) / 2;
            mergeSort(tempArray, inicio, meio);
            mergeSort(tempArray, meio + 1, fim);
            merge(tempArray, inicio, meio, fim);
        }
    }

    public static void merge(int[] vetor, int inicio, int meio, int fim) {
        // Passo 1: Determinar os tamanhos dos dois subarrays
        int n1 = meio - inicio + 1;
        int n2 = fim - meio;

        // Passo 2: Criar arrays temporários para armazenar os subarrays
        int[] esquerda = new int[n1];
        int[] direita = new int[n2];

        // Passo 3: Copiar os dados para os arrays temporários
        for (int i = 0; i < n1; i++)
            esquerda[i] = vetor[inicio + i];
        for (int j = 0; j < n2; j++)
            direita[j] = vetor[meio + 1 + j];

        // Passo 4: Mesclar os arrays temporários de volta no array original
        int i = 0, j = 0;
        int k = inicio;
        while (i < n1 && j < n2) {
            if (esquerda[i] <= direita[j]) {
                vetor[k] = esquerda[i];
                i++;
            } else {
                vetor[k] = direita[j];
                j++;
            }
            k++;
        }

        // Passo 5: Copiar os elementos restantes de esquerda[], se houver
        while (i < n1) {
            vetor[k] = esquerda[i];
            i++;
            k++;
        }

        // Passo 6: Copiar os elementos restantes de direita[], se houver
        while (j < n2) {
            vetor[k] = direita[j];
            j++;
            k++;
        }

    }

}