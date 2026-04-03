//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {

    Matriz matriz = new Matriz();

    matriz.novaMatriz();
    matriz.preenchimento();
    matriz.mostrarMatriz();

    System.out.println("--Ordenação de Linhas--");
    matriz.bubbleSortPorLinha(matriz.matriz);
    matriz.mostrarMatriz();

    System.out.println("--Ordenação de Vetor--");
    matriz.ordenarPorVetor(matriz.matriz);
    matriz.mostrarMatriz();

}
