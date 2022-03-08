package myProject;

import java.util.Scanner;

public class TestClases {
    public static void main(String[] args) throws InterruptedException {
       int[][] tableroPrincipal;
        Scanner input =new Scanner(System.in);
        Scanner sc = new Scanner(System.in);

        TableroUsuario tablero = new TableroUsuario();
        ModelJugadores model = new ModelJugadores();
        tableroPrincipal = new int [10][10];

        System.out.println("Ingresa tu destructor en la columna:");
        int numeroc = input.nextInt();
        System.out.println("Ingresa tu destructor en la fila:");
        int numerof = input.nextInt();

        for(int i=0; i<tableroPrincipal.length ;i++){
            for (int j = 0; j < tableroPrincipal[i].length; j++) {
                System.out.print(tableroPrincipal[i][j] + "");
        }
            System.out.println();

    }
        System.out.println("-------------------------------------");
        int num = 0;
        while(num<2){
            for (int i = 0; i < tableroPrincipal.length; i++) {
                num++;
                for (int j = 0; j < tableroPrincipal[i].length; j++) {
                    tableroPrincipal[numerof][numeroc] = 3;
                }
            }
        }
        System.out.println("-------------------------------------");

        for(int i=0; i<tableroPrincipal.length ;i++){
            for (int j = 0; j < tableroPrincipal[i].length; j++) {
                System.out.print(tableroPrincipal[i][j] + "");
            }
            System.out.println();
        }

}}
