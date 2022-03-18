package myProject;

public class ModelComputador {
    private int[][] matriz;

    public ModelComputador(){
        matriz = new int [10][10];
    }

    public void insertarPortaavionesC(int fila, int columna){
        for(int i=0; i<matriz.length ;i++){
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + "");
            }System.out.println();

        }System.out.println("-------------------------------");

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[fila][columna] = 1;
            }
        }

        for(int i=0; i<matriz.length ;i++){
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + "");
            }
            System.out.println();
        }
    }
    public void insertarSubmarinosC(int fila, int columna){
        for(int i=0; i<matriz.length ;i++){
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + "");
            }System.out.println();

        }System.out.println("-------------------------------");

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[fila][columna] = 2;
            }
        }

        for(int i=0; i<matriz.length ;i++){
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + "");
            }
            System.out.println();
        }
    }
    public void insertarDestructoresC(int fila, int columna){
        for(int i=0; i<matriz.length ;i++){
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + "");
            }System.out.println();

        }System.out.println("-------------------------------");

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[fila][columna] = 3;
            }
        }

        for(int i=0; i<matriz.length ;i++){
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + "");
            }
            System.out.println();
        }
    }
    public void insertarFragatasC(int fila, int columna){
        for(int i=0; i<matriz.length ;i++){
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + "");
            }System.out.println();

        }System.out.println("-------------------------------");

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[fila][columna] = 4;
            }
        }

        for(int i=0; i<matriz.length ;i++){
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + "");
            }
            System.out.println();
        }
    }

    public int[][] getMatrizC() {
        return matriz;
    }

}
