package myProject;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

/**
 * @version v.1.0.0 date:16/03/2022
 * @autors Laura Jaimes, laura.jaimes@correounivalle.edu.co, 2040430-3743
 * Esteban Hernandez, esteban.cortes@correounivalle.edu.co, 2042817 - 3743
 */

public class TableroComputador extends JPanel {
    private int[][] matriz;
    private int counter1, counter2, counter3, counter4;
    private int numAleatorio;

    /**
     * Class Constructor
     */
    public TableroComputador() {
        matriz = new int[10][10];
        counter1 = 0;
        counter2 = 0;
        counter3 = 0;
        counter4 = 0;
        Random aleatorio = new Random();
        numAleatorio = aleatorio.nextInt(5);
    }

    /**
     * Inserta los barcos de tipo Portaaviones a la matriz del jugador computador
     *
     * @version v.1.0.0 date 16/03/2022
     */
    public void insertarPortaavionesC(int fila, int columna) {

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[fila][columna] = 1;
            }
        }

    }

    /**
     * Inserta los barcos de tipo Submarinos a la matriz del jugador computador
     *
     * @version v.1.0.0 date 16/03/2022
     */
    public void insertarSubmarinosC(int fila, int columna) {

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[fila][columna] = 2;
            }
        }

    }

    /**
     * Inserta los barcos de tipo Destructores a la matriz del jugador computador
     *
     * @version v.1.0.0 date 16/03/2022
     */
    public void insertarDestructoresC(int fila, int columna) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[fila][columna] = 3;
            }
        }

    }

    /**
     * Inserta los barcos de tipo Fragata a la matriz del jugador computador
     *
     * @version v.1.0.0 date 16/03/2022
     */
    public void insertarFragatasC(int fila, int columna) {

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[fila][columna] = 4;
            }
        }

    }

    /**
     * Genera los tableros aleatorios de la flota del jugador maquina
     *
     * @version v.1.0.0 date 16/03/2022
     */
    public void tablerosAleatorios(int valor, CasillaMaquina[][] nuevasCasillas1, CasillaMaquina casillaMaquina1) {
        if (valor == 0) {
            while (counter1 < 4) {
                if (counter1 == 0) {
                    casillaMaquina1 = nuevasCasillas1[3][0];
                    casillaMaquina1.setBackground(Color.GRAY);
                    insertarPortaavionesC(3, 0);
                    counter1++;
                }
                if (counter1 == 1) {
                    casillaMaquina1 = nuevasCasillas1[4][0];
                    casillaMaquina1.setBackground(Color.GRAY);
                    insertarPortaavionesC(4, 0);
                    counter1++;
                }
                if (counter1 == 2) {
                    casillaMaquina1 = nuevasCasillas1[5][0];
                    casillaMaquina1.setBackground(Color.GRAY);
                    insertarPortaavionesC(5, 0);
                    counter1++;
                }
                if (counter1 == 3) {
                    casillaMaquina1 = nuevasCasillas1[6][0];
                    casillaMaquina1.setBackground(Color.GRAY);
                    insertarPortaavionesC(6, 0);
                    counter1++;
                }
            }
            while (counter2 < 6) {
                if (counter2 == 0) {
                    casillaMaquina1 = nuevasCasillas1[5][2];
                    casillaMaquina1.setBackground(Color.BLUE);
                    insertarSubmarinosC(5, 2);
                    counter2++;

                }
                if (counter2 == 1) {
                    casillaMaquina1 = nuevasCasillas1[5][3];
                    casillaMaquina1.setBackground(Color.BLUE);
                    insertarSubmarinosC(5, 3);
                    counter2++;
                }
                if (counter2 == 2) {
                    casillaMaquina1 = nuevasCasillas1[5][4];
                    casillaMaquina1.setBackground(Color.BLUE);
                    insertarSubmarinosC(5, 4);
                    counter2++;
                }
                if (counter2 == 3) {
                    casillaMaquina1 = nuevasCasillas1[7][2];
                    casillaMaquina1.setBackground(Color.BLUE);
                    insertarSubmarinosC(7, 2);
                    counter2++;

                }
                if (counter2 == 4) {
                    casillaMaquina1 = nuevasCasillas1[7][3];
                    casillaMaquina1.setBackground(Color.BLUE);
                    insertarSubmarinosC(7, 3);
                    counter2++;

                }
                if (counter2 == 5) {
                    casillaMaquina1 = nuevasCasillas1[7][4];
                    casillaMaquina1.setBackground(Color.BLUE);
                    insertarSubmarinosC(7, 4);
                    counter2++;

                }

            }
            while (counter3 < 6) {
                if (counter3 == 0) {
                    casillaMaquina1 = nuevasCasillas1[3][2];
                    casillaMaquina1.setBackground(Color.RED);
                    insertarDestructoresC(3, 2);
                    counter3++;
                }
                if (counter3 == 1) {
                    casillaMaquina1 = nuevasCasillas1[3][3];
                    casillaMaquina1.setBackground(Color.RED);
                    insertarDestructoresC(3, 3);
                    counter3++;

                }
                if (counter3 == 2) {
                    casillaMaquina1 = nuevasCasillas1[3][5];
                    casillaMaquina1.setBackground(Color.RED);
                    insertarDestructoresC(3, 5);
                    counter3++;

                }
                if (counter3 == 3) {
                    casillaMaquina1 = nuevasCasillas1[3][6];
                    casillaMaquina1.setBackground(Color.RED);
                    insertarDestructoresC(3, 6);
                    counter3++;

                }
                if (counter3 == 4) {
                    casillaMaquina1 = nuevasCasillas1[1][3];
                    casillaMaquina1.setBackground(Color.RED);
                    insertarDestructoresC(1, 3);
                    counter3++;

                }
                if (counter3 == 5) {
                    casillaMaquina1 = nuevasCasillas1[1][4];
                    casillaMaquina1.setBackground(Color.RED);
                    insertarDestructoresC(1, 4);
                    counter3++;

                }

            }
            while (counter4 < 4) {
                if (counter4 == 0) {
                    casillaMaquina1 = nuevasCasillas1[9][6];
                    casillaMaquina1.setBackground(Color.YELLOW);
                    insertarFragatasC(9, 6);
                    counter4++;

                }
                if (counter4 == 1) {
                    casillaMaquina1 = nuevasCasillas1[8][7];
                    casillaMaquina1.setBackground(Color.YELLOW);
                    insertarFragatasC(8, 7);
                    counter4++;
                }
                if (counter4 == 2) {
                    casillaMaquina1 = nuevasCasillas1[7][8];
                    casillaMaquina1.setBackground(Color.YELLOW);
                    insertarFragatasC(7, 8);
                    counter4++;

                }
                if (counter4 == 3) {
                    casillaMaquina1 = nuevasCasillas1[6][9];
                    casillaMaquina1.setBackground(Color.YELLOW);
                    insertarFragatasC(6, 9);
                    counter4++;

                }

            }
        }

        if (valor == 1) {
            while (counter1 < 4) {
                if (counter1 == 0) {
                    casillaMaquina1 = nuevasCasillas1[7][6];
                    casillaMaquina1.setBackground(Color.GRAY);
                    insertarPortaavionesC(7, 6);
                    counter1++;
                }
                if (counter1 == 1) {
                    casillaMaquina1 = nuevasCasillas1[6][6];
                    casillaMaquina1.setBackground(Color.GRAY);
                    insertarPortaavionesC(6, 6);
                    counter1++;
                }
                if (counter1 == 2) {
                    casillaMaquina1 = nuevasCasillas1[5][6];
                    casillaMaquina1.setBackground(Color.GRAY);
                    insertarPortaavionesC(5, 6);
                    counter1++;
                }
                if (counter1 == 3) {
                    casillaMaquina1 = nuevasCasillas1[4][6];
                    casillaMaquina1.setBackground(Color.GRAY);
                    insertarPortaavionesC(4, 6);
                    counter1++;
                }
            }
            while (counter2 < 6) {
                if (counter2 == 0) {
                    casillaMaquina1 = nuevasCasillas1[8][2];
                    casillaMaquina1.setBackground(Color.BLUE);
                    insertarSubmarinosC(8, 2);
                    counter2++;

                }
                if (counter2 == 1) {
                    casillaMaquina1 = nuevasCasillas1[7][2];
                    casillaMaquina1.setBackground(Color.BLUE);
                    insertarSubmarinosC(7, 2);
                    counter2++;
                }
                if (counter2 == 2) {
                    casillaMaquina1 = nuevasCasillas1[6][2];
                    casillaMaquina1.setBackground(Color.BLUE);
                    insertarSubmarinosC(6, 2);
                    counter2++;
                }
                if (counter2 == 3) {
                    casillaMaquina1 = nuevasCasillas1[4][1];
                    casillaMaquina1.setBackground(Color.BLUE);
                    insertarSubmarinosC(4, 1);
                    counter2++;

                }
                if (counter2 == 4) {
                    casillaMaquina1 = nuevasCasillas1[3][1];
                    casillaMaquina1.setBackground(Color.BLUE);
                    insertarSubmarinosC(3, 1);
                    counter2++;

                }
                if (counter2 == 5) {
                    casillaMaquina1 = nuevasCasillas1[2][1];
                    casillaMaquina1.setBackground(Color.BLUE);
                    insertarSubmarinosC(2, 1);
                    counter2++;

                }

            }
            while (counter3 < 6) {
                if (counter3 == 0) {
                    casillaMaquina1 = nuevasCasillas1[4][3];
                    casillaMaquina1.setBackground(Color.RED);
                    insertarDestructoresC(4, 3);
                    counter3++;
                }
                if (counter3 == 1) {
                    casillaMaquina1 = nuevasCasillas1[4][4];
                    casillaMaquina1.setBackground(Color.RED);
                    insertarDestructoresC(4, 4);
                    counter3++;

                }
                if (counter3 == 2) {
                    casillaMaquina1 = nuevasCasillas1[3][8];
                    casillaMaquina1.setBackground(Color.RED);
                    insertarDestructoresC(3, 8);
                    counter3++;

                }
                if (counter3 == 3) {
                    casillaMaquina1 = nuevasCasillas1[4][8];
                    casillaMaquina1.setBackground(Color.RED);
                    insertarDestructoresC(4, 8);
                    counter3++;

                }
                if (counter3 == 4) {
                    casillaMaquina1 = nuevasCasillas1[9][4];
                    casillaMaquina1.setBackground(Color.RED);
                    insertarDestructoresC(9, 4);
                    counter3++;

                }
                if (counter3 == 5) {
                    casillaMaquina1 = nuevasCasillas1[9][5];
                    casillaMaquina1.setBackground(Color.RED);
                    insertarDestructoresC(9, 5);
                    counter3++;

                }

            }
            while (counter4 < 4) {
                if (counter4 == 0) {
                    casillaMaquina1 = nuevasCasillas1[8][8];
                    casillaMaquina1.setBackground(Color.YELLOW);
                    insertarFragatasC(8, 8);
                    counter4++;

                }
                if (counter4 == 1) {
                    casillaMaquina1 = nuevasCasillas1[2][5];
                    casillaMaquina1.setBackground(Color.YELLOW);
                    insertarFragatasC(2, 5);
                    counter4++;
                }
                if (counter4 == 2) {
                    casillaMaquina1 = nuevasCasillas1[7][4];
                    casillaMaquina1.setBackground(Color.YELLOW);
                    insertarFragatasC(7, 4);
                    counter4++;

                }
                if (counter4 == 3) {
                    casillaMaquina1 = nuevasCasillas1[6][1];
                    casillaMaquina1.setBackground(Color.YELLOW);
                    insertarFragatasC(6, 1);
                    counter4++;

                }

            }


        }

        if (valor == 2) {
            while (counter1 < 4) {
                if (counter1 == 0) {
                    casillaMaquina1 = nuevasCasillas1[3][3];
                    casillaMaquina1.setBackground(Color.gray);
                    insertarPortaavionesC(3, 3);
                    counter1++;
                }
                if (counter1 == 1) {
                    casillaMaquina1 = nuevasCasillas1[4][3];
                    casillaMaquina1.setBackground(Color.gray);
                    insertarPortaavionesC(4, 3);
                    counter1++;
                }
                if (counter1 == 2) {
                    casillaMaquina1 = nuevasCasillas1[5][3];
                    casillaMaquina1.setBackground(Color.gray);
                    insertarPortaavionesC(5, 3);
                    counter1++;
                }
                if (counter1 == 3) {
                    casillaMaquina1 = nuevasCasillas1[6][3];
                    casillaMaquina1.setBackground(Color.gray);
                    insertarPortaavionesC(6, 3);
                    counter1++;
                }
            }
            while (counter2 < 6) {
                if (counter2 == 0) {
                    casillaMaquina1 = nuevasCasillas1[2][1];
                    casillaMaquina1.setBackground(Color.blue);
                    insertarSubmarinosC(2, 1);
                    counter2++;

                }
                if (counter2 == 1) {
                    casillaMaquina1 = nuevasCasillas1[3][1];
                    casillaMaquina1.setBackground(Color.blue);
                    insertarSubmarinosC(3, 1);
                    counter2++;
                }
                if (counter2 == 2) {
                    casillaMaquina1 = nuevasCasillas1[4][1];
                    casillaMaquina1.setBackground(Color.blue);
                    insertarSubmarinosC(4, 1);
                    counter2++;
                }
                if (counter2 == 3) {
                    casillaMaquina1 = nuevasCasillas1[2][5];
                    casillaMaquina1.setBackground(Color.blue);
                    insertarSubmarinosC(2, 5);
                    counter2++;

                }
                if (counter2 == 4) {
                    casillaMaquina1 = nuevasCasillas1[3][5];
                    casillaMaquina1.setBackground(Color.blue);
                    insertarSubmarinosC(3, 5);
                    counter2++;

                }
                if (counter2 == 5) {
                    casillaMaquina1 = nuevasCasillas1[4][5];
                    casillaMaquina1.setBackground(Color.blue);
                    insertarSubmarinosC(4, 5);
                    counter2++;

                }

            }
            while (counter3 < 6) {
                if (counter3 == 0) {
                    casillaMaquina1 = nuevasCasillas1[7][0];
                    casillaMaquina1.setBackground(Color.red);
                    insertarDestructoresC(7, 0);
                    counter3++;
                }
                if (counter3 == 1) {
                    casillaMaquina1 = nuevasCasillas1[7][1];
                    casillaMaquina1.setBackground(Color.red);
                    insertarDestructoresC(7, 1);
                    counter3++;

                }
                if (counter3 == 2) {
                    casillaMaquina1 = nuevasCasillas1[7][5];
                    casillaMaquina1.setBackground(Color.red);
                    insertarDestructoresC(7, 5);
                    counter3++;

                }
                if (counter3 == 3) {
                    casillaMaquina1 = nuevasCasillas1[7][6];
                    casillaMaquina1.setBackground(Color.red);
                    insertarDestructoresC(7, 6);
                    counter3++;

                }
                if (counter3 == 4) {
                    casillaMaquina1 = nuevasCasillas1[4][9];
                    casillaMaquina1.setBackground(Color.red);
                    insertarDestructoresC(4, 9);
                    counter3++;

                }
                if (counter3 == 5) {
                    casillaMaquina1 = nuevasCasillas1[5][9];
                    casillaMaquina1.setBackground(Color.red);
                    insertarDestructoresC(5, 9);
                    counter3++;

                }

            }
            while (counter4 < 4) {
                if (counter4 == 0) {
                    casillaMaquina1 = nuevasCasillas1[1][0];
                    casillaMaquina1.setBackground(Color.yellow);
                    insertarFragatasC(1, 0);
                    counter4++;

                }
                if (counter4 == 1) {
                    casillaMaquina1 = nuevasCasillas1[1][2];
                    casillaMaquina1.setBackground(Color.yellow);
                    insertarFragatasC(1, 2);
                    counter4++;
                }
                if (counter4 == 2) {
                    casillaMaquina1 = nuevasCasillas1[8][3];
                    casillaMaquina1.setBackground(Color.yellow);
                    insertarFragatasC(8, 3);
                    counter4++;

                }
                if (counter4 == 3) {
                    casillaMaquina1 = nuevasCasillas1[2][7];
                    casillaMaquina1.setBackground(Color.yellow);
                    insertarFragatasC(2, 7);
                    counter4++;

                }

            }
        }
        if (valor == 3) {
            while (counter1 < 4) {
                if (counter1 == 0) {
                    casillaMaquina1 = nuevasCasillas1[2][6];
                    casillaMaquina1.setBackground(Color.gray);
                    insertarPortaavionesC(2, 6);
                    counter1++;
                }
                if (counter1 == 1) {
                    casillaMaquina1 = nuevasCasillas1[2][7];
                    casillaMaquina1.setBackground(Color.gray);
                    insertarPortaavionesC(2, 7);
                    counter1++;
                }
                if (counter1 == 2) {
                    casillaMaquina1 = nuevasCasillas1[2][8];
                    casillaMaquina1.setBackground(Color.gray);
                    insertarPortaavionesC(2, 8);
                    counter1++;
                }
                if (counter1 == 3) {
                    casillaMaquina1 = nuevasCasillas1[2][9];
                    casillaMaquina1.setBackground(Color.gray);
                    insertarPortaavionesC(2, 9);
                    counter1++;
                }
            }
            while (counter2 < 6) {
                if (counter2 == 0) {
                    casillaMaquina1 = nuevasCasillas1[1][4];
                    casillaMaquina1.setBackground(Color.blue);
                    insertarSubmarinosC(1, 4);
                    counter2++;

                }
                if (counter2 == 1) {
                    casillaMaquina1 = nuevasCasillas1[2][4];
                    casillaMaquina1.setBackground(Color.blue);
                    insertarSubmarinosC(2, 4);
                    counter2++;
                }
                if (counter2 == 2) {
                    casillaMaquina1 = nuevasCasillas1[3][4];
                    casillaMaquina1.setBackground(Color.blue);
                    insertarSubmarinosC(3, 4);
                    counter2++;
                }
                if (counter2 == 3) {
                    casillaMaquina1 = nuevasCasillas1[5][2];
                    casillaMaquina1.setBackground(Color.blue);
                    insertarSubmarinosC(5, 2);
                    counter2++;

                }
                if (counter2 == 4) {
                    casillaMaquina1 = nuevasCasillas1[6][2];
                    casillaMaquina1.setBackground(Color.blue);
                    insertarSubmarinosC(6, 2);
                    counter2++;

                }
                if (counter2 == 5) {
                    casillaMaquina1 = nuevasCasillas1[7][2];
                    casillaMaquina1.setBackground(Color.blue);
                    insertarSubmarinosC(7, 2);
                    counter2++;

                }

            }
            while (counter3 < 6) {
                if (counter3 == 0) {
                    casillaMaquina1 = nuevasCasillas1[5][6];
                    casillaMaquina1.setBackground(Color.red);
                    insertarDestructoresC(5, 6);
                    counter3++;
                }
                if (counter3 == 1) {
                    casillaMaquina1 = nuevasCasillas1[5][7];
                    casillaMaquina1.setBackground(Color.red);
                    insertarDestructoresC(5, 7);
                    counter3++;

                }
                if (counter3 == 2) {
                    casillaMaquina1 = nuevasCasillas1[7][8];
                    casillaMaquina1.setBackground(Color.red);
                    insertarDestructoresC(7, 8);
                    counter3++;

                }
                if (counter3 == 3) {
                    casillaMaquina1 = nuevasCasillas1[7][9];
                    casillaMaquina1.setBackground(Color.red);
                    insertarDestructoresC(7, 9);
                    counter3++;

                }
                if (counter3 == 4) {
                    casillaMaquina1 = nuevasCasillas1[9][6];
                    casillaMaquina1.setBackground(Color.red);
                    insertarDestructoresC(9, 6);
                    counter3++;

                }
                if (counter3 == 5) {
                    casillaMaquina1 = nuevasCasillas1[9][7];
                    casillaMaquina1.setBackground(Color.red);
                    insertarDestructoresC(9, 7);
                    counter3++;

                }

            }
            while (counter4 < 4) {
                if (counter4 == 0) {
                    casillaMaquina1 = nuevasCasillas1[1][2];
                    casillaMaquina1.setBackground(Color.yellow);
                    insertarFragatasC(1, 2);
                    counter4++;

                }
                if (counter4 == 1) {
                    casillaMaquina1 = nuevasCasillas1[4][0];
                    casillaMaquina1.setBackground(Color.yellow);
                    insertarFragatasC(4, 0);
                    counter4++;
                }
                if (counter4 == 2) {
                    casillaMaquina1 = nuevasCasillas1[8][0];
                    casillaMaquina1.setBackground(Color.yellow);
                    insertarFragatasC(8, 0);
                    counter4++;

                }
                if (counter4 == 3) {
                    casillaMaquina1 = nuevasCasillas1[6][4];
                    casillaMaquina1.setBackground(Color.yellow);
                    insertarFragatasC(6, 4);
                    counter4++;

                }

            }
        }
    }

    /**
     * Getter de la matriz del computador
     *
     * @return La matriz del jugador computador
     * @version v.1.0.0 date 16/03/2022
     */
    public int[][] getMatrizC() {
        return matriz;
    }

    /**
     * Obtiene el valor del numero aleatorio
     *
     * @return el numero aleatorio de tipo int
     * @version v.1.0.0 date 16/03/2022
     */
    public int getNumAleatorio() {
        return numAleatorio;
    }
}


