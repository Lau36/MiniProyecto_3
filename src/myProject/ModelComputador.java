package myProject;

import java.awt.*;
import java.util.Random;

public class ModelComputador {
    private int[][] matriz;
    private int counter1, counter2, counter3, counter4;
    private int numAleatorio;

    public ModelComputador() {
        matriz = new int[10][10];
        counter1 = 0;
        counter2 = 0;
        counter3 = 0;
        counter4 = 0;
        Random aleatorio = new Random();
        numAleatorio = aleatorio.nextInt(5);
    }

    public void insertarPortaavionesC(int fila, int columna) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + "");
            }
            System.out.println();

        }
        System.out.println("-------------------------------");

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[fila][columna] = 1;
            }
        }

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + "");
            }
            System.out.println();
        }
    }

    public void insertarSubmarinosC(int fila, int columna) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + "");
            }
            System.out.println();

        }
        System.out.println("-------------------------------");

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[fila][columna] = 2;
            }
        }

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + "");
            }
            System.out.println();
        }
    }

    public void insertarDestructoresC(int fila, int columna) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + "");
            }
            System.out.println();

        }
        System.out.println("-------------------------------");

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[fila][columna] = 3;
            }
        }

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + "");
            }
            System.out.println();
        }
    }

    public void insertarFragatasC(int fila, int columna) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + "");
            }
            System.out.println();

        }
        System.out.println("-------------------------------");

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[fila][columna] = 4;
            }
        }

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + "");
            }
            System.out.println();
        }
    }



    //---------Funcion larga--------------------------------------------------------------------------------------------
    public void tablerosAleatorios(int valor) {
        if (valor == 0) {
            while (counter1 < 4) {
                if (counter1 == 0) {

                    insertarPortaavionesC(3, 0);
                    counter1++;
                }
                if (counter1 == 1) {

                    insertarPortaavionesC(4, 0);
                    counter1++;
                }
                if (counter1 == 2) {

                    insertarPortaavionesC(5, 0);
                    counter1++;
                }
                if (counter1 == 3) {

                    insertarPortaavionesC(6, 0);
                    counter1++;
                }
            }
            while (counter2 < 6) {
                if (counter2 == 0) {

                    insertarSubmarinosC(5, 2);
                    counter2++;

                }
                if (counter2 == 1) {

                    insertarSubmarinosC(5, 3);
                    counter2++;
                }
                if (counter2 == 2) {

                    insertarSubmarinosC(5, 4);
                    counter2++;
                }
                if (counter2 == 3) {

                    insertarSubmarinosC(7, 2);
                    counter2++;

                }
                if (counter2 == 4) {

                    insertarSubmarinosC(7, 3);
                    counter2++;

                }
                if (counter2 == 5) {

                    insertarSubmarinosC(7, 4);
                    counter2++;

                }

            }
            while (counter3 < 6) {
                if (counter3 == 0) {

                    insertarDestructoresC(3, 2);
                    counter3++;
                }
                if (counter3 == 1) {

                    insertarDestructoresC(3, 3);
                    counter3++;

                }
                if (counter3 == 2) {

                    insertarDestructoresC(3, 5);
                    counter3++;

                }
                if (counter3 == 3) {
                    insertarDestructoresC(3, 6);

                    counter3++;

                }
                if (counter3 == 4) {


                    insertarDestructoresC(1, 3);
                    counter3++;

                }
                if (counter3 == 5) {

                    insertarDestructoresC(1, 4);
                    counter3++;

                }

            }
            while (counter4 < 4) {
                if (counter4 == 0) {


                    insertarFragatasC(9, 6);
                    counter4++;

                }
                if (counter4 == 1) {


                    insertarFragatasC(8, 7);
                    counter4++;
                }
                if (counter4 == 2) {

                    insertarFragatasC(7, 8);
                    counter4++;

                }
                if (counter4 == 3) {


                    insertarFragatasC(6, 9);
                    counter4++;

                }

            }
        }

        if (valor == 1) {
            while (counter1 < 4) {
                if (counter1 == 0) {

                    insertarPortaavionesC(7, 6);
                    counter1++;
                }
                if (counter1 == 1) {

                    insertarPortaavionesC(6, 6);
                    counter1++;
                }
                if (counter1 == 2) {

                    insertarPortaavionesC(5, 6);
                    counter1++;
                }
                if (counter1 == 3) {

                    insertarPortaavionesC(4, 6);
                    counter1++;
                }
            }
            while (counter2 < 6) {
                if (counter2 == 0) {

                    insertarSubmarinosC(8, 2);
                    counter2++;

                }
                if (counter2 == 1) {

                    insertarSubmarinosC(7, 2);
                    counter2++;
                }
                if (counter2 == 2) {

                    insertarSubmarinosC(6, 2);
                    counter2++;
                }
                if (counter2 == 3) {

                    insertarSubmarinosC(4, 1);
                    counter2++;

                }
                if (counter2 == 4) {


                    insertarSubmarinosC(3, 1);
                    counter2++;

                }
                if (counter2 == 5) {


                    insertarSubmarinosC(2, 1);
                    counter2++;

                }

            }
            while (counter3 < 6) {
                if (counter3 == 0) {
                    insertarDestructoresC(4, 3);
                    counter3++;
                }
                if (counter3 == 1) {


                    insertarDestructoresC(4, 4);
                    counter3++;

                }
                if (counter3 == 2) {
                    insertarDestructoresC(3, 8);
                    counter3++;

                }
                if (counter3 == 3) {
                    insertarDestructoresC(4, 8);
                    counter3++;

                }
                if (counter3 == 4) {
                    insertarDestructoresC(9, 4);
                    counter3++;

                }
                if (counter3 == 5) {
                    insertarDestructoresC(9, 5);
                    counter3++;

                }

            }
            while (counter4 < 4) {
                if (counter4 == 0) {
                    insertarFragatasC(8, 8);
                    counter4++;

                }
                if (counter4 == 1) {
                    insertarFragatasC(2, 5);
                    counter4++;
                }
                if (counter4 == 2) {
                    insertarFragatasC(7, 4);
                    counter4++;

                }
                if (counter4 == 3) {
                    insertarFragatasC(6, 1);
                    counter4++;

                }

            }


        }

        if (valor == 2) {
            while (counter1 < 4) {
                if (counter1 == 0) {
                    insertarPortaavionesC(3, 3);
                    counter1++;
                }
                if (counter1 == 1) {
                    insertarPortaavionesC(4, 3);
                    counter1++;
                }
                if (counter1 == 2) {

                    insertarPortaavionesC(5, 3);
                    counter1++;
                }
                if (counter1 == 3) {

                    insertarPortaavionesC(6, 3);
                    counter1++;
                }
            }
            while (counter2 < 6) {
                if (counter2 == 0) {

                    insertarSubmarinosC(2, 1);
                    counter2++;

                }
                if (counter2 == 1) {

                    insertarSubmarinosC(3, 1);
                    counter2++;
                }
                if (counter2 == 2) {


                    insertarSubmarinosC(4, 1);
                    counter2++;
                }
                if (counter2 == 3) {

                    insertarSubmarinosC(2, 5);
                    counter2++;

                }
                if (counter2 == 4) {


                    insertarSubmarinosC(3, 5);
                    counter2++;

                }
                if (counter2 == 5) {


                    insertarSubmarinosC(4, 5);
                    counter2++;

                }

            }
            while (counter3 < 6) {
                if (counter3 == 0) {

                    insertarDestructoresC(7, 0);
                    counter3++;
                }
                if (counter3 == 1)


                insertarDestructoresC(7, 1);
                counter3++;

            }
            if (counter3 == 2) {


                insertarDestructoresC(7, 5);
                counter3++;

            }
            if (counter3 == 3) {

                insertarDestructoresC(7, 6);
                counter3++;

            }
            if (counter3 == 4) {

                insertarDestructoresC(4, 9);
                counter3++;

            }
            if (counter3 == 5) {


                insertarDestructoresC(5, 9);
                counter3++;

            }

        }
        while (counter4 < 4) {
            if (counter4 == 0) {


                insertarFragatasC(1, 0);
                counter4++;

            }
            if (counter4 == 1) {


                insertarFragatasC(1, 2);
                counter4++;
            }
            if (counter4 == 2) {


                insertarFragatasC(8, 3);
                counter4++;

            }
            if (counter4 == 3) {

                insertarFragatasC(2, 7);
                counter4++;

            }

        }

        if (valor == 3) {
            while (counter1 < 4) {
                if (counter1 == 0) {


                    insertarPortaavionesC(2, 6);
                    counter1++;
                }
                if (counter1 == 1) {

                    insertarPortaavionesC(2, 7);
                    counter1++;
                }
                if (counter1 == 2) {

                    insertarPortaavionesC(2, 8);
                    counter1++;
                }
                if (counter1 == 3) {
                    insertarPortaavionesC(2, 9);
                    counter1++;
                }
            }
            while (counter2 < 6) {
                if (counter2 == 0) {

                    insertarSubmarinosC(1, 4);
                    counter2++;

                }
                if (counter2 == 1) {

                    insertarSubmarinosC(2, 4);
                    counter2++;
                }
                if (counter2 == 2) {


                    insertarSubmarinosC(3, 4);
                    counter2++;
                }
                if (counter2 == 3) {

                    insertarSubmarinosC(5, 2);
                    counter2++;

                }
                if (counter2 == 4) {


                    insertarSubmarinosC(6, 2);
                    counter2++;

                }
                if (counter2 == 5) {

                    insertarSubmarinosC(7, 2);
                    counter2++;

                }

            }
            while (counter3 < 6) {
                if (counter3 == 0) {


                    insertarDestructoresC(5, 6);
                    counter3++;
                }
                if (counter3 == 1) {


                    insertarDestructoresC(5, 7);
                    counter3++;

                }
                if (counter3 == 2) {


                    insertarDestructoresC(7, 8);
                    counter3++;

                }
                if (counter3 == 3) {

                    insertarDestructoresC(7, 9);
                    counter3++;

                }
                if (counter3 == 4) {

                    insertarDestructoresC(9, 6);
                    counter3++;

                }
                if (counter3 == 5) {


                    insertarDestructoresC(9, 7);
                    counter3++;

                }

            }
            while (counter4 < 4) {
                if (counter4 == 0) {

                    insertarFragatasC(1, 2);
                    counter4++;

                }
                if (counter4 == 1) {

                    insertarFragatasC(4, 0);
                    counter4++;
                }
                if (counter4 == 2) {

                    insertarFragatasC(8, 0);
                    counter4++;

                }
                if (counter4 == 3) {
                    ;

                    insertarFragatasC(6, 4);
                    counter4++;

                }

            }
        }
    }

    public int[][] getMatrizC() {
        return matriz;
    }

    public int getNumAleatorio() {
        return numAleatorio;
    }
}


