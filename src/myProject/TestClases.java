package myProject;

import javax.swing.*;
import java.util.Scanner;

public class TestClases {
    public static void main(String[] args) throws InterruptedException {
        int [][] nCasillas = null;
        /*for(int i=0; i<10; i++){
            for(int j=0; j<10; j++){
                JLabel casilla = new JLabel();
                //this.add(casilla);//agrega el boton al panel
                nCasillas[i][j] = casilla;
                System.out.println(nCasillas[i][j]);
            }
        }*/
        //casillass.inicializar();
        System.out.println();
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

        for (int i = 0; i < tableroPrincipal.length; i++) {
            for (int j = 0; j < tableroPrincipal[i].length; j++) {
                tableroPrincipal[numerof][numeroc] = 3;
            }
        }
        System.out.println("-------------------------------------");

        for(int i=0; i<tableroPrincipal.length ;i++){
            for (int j = 0; j < tableroPrincipal[i].length; j++) {
                System.out.print(tableroPrincipal[i][j] + "");
            }
            System.out.println();
        }

         for(int i= 0; i<tableroPrincipal.length;i++){
             if(tableroPrincipal[i].length == 3){
                // tableroPrincipal[i] = 5;
             }
                for(int j=0; j<tableroPrincipal[i].length;j++){
                    if(tablero.getMatriz()[i][j] == 3){
                        tableroPrincipal[i][j] = 5;
                        System.out.println("LA MATRIZ NUEVA ES: "+tableroPrincipal);
                    }
                    else{
                        System.out.println("no quise hacer ni mierda yo");
                    }
                }
         }

            /*for(int i=0; i<matriz.length;i++){
                if(matriz[i].length==1){
                    encontrado=true;
                }else{
                    encontrado = false;
                }
                for(int j=0; j<matriz.length;j++){
                    if(matriz[i][j]==1){
                        encontrado = true;
                        System.out.println("EL VALOR "+encontrado);
                        break;
                    }
                }
            }
            return encontrado;
        }*/




}}
