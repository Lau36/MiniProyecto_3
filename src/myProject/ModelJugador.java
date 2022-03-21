package myProject;

/**
 * @version v.1.0.0 date:04/03/2022
 * @autors Laura Jaimes, laura.jaimes@correounivalle.edu.co, 2040430-3743
 * Esteban Hernandez, esteban.cortes@correounivalle.edu.co, 2042817 - 3743
 */

public class ModelJugador {
    private int agua;
    private int tocado;
    private int hundido;
    private boolean encontrado;
    private TableroUsuario tablero;
    private TableroComputador tableroComputador;


    /**
     * Constructor of GUI class
     */
    public ModelJugador() {
        tablero = new TableroUsuario();
        encontrado = false;
        agua = 0;
        tocado = 5;
        hundido = 6;
        /*
        Los numero con el que identificamos los barcos son los siguientes
        Portaaviones ->1
        Submarinos -> 2
        Destructores -> 3
        Fragats -> 4
        */
    }


    /**
     * Verifica si en la coordenada donde se disparo hay un barco y le da el valor a la nueva matriz con los disparos
     *
     * @version v.1.0.0 date 18/03/2022
     */
    public void verificarCoordenada(int fila, int columna) {
        for (int i = 0; i < tableroComputador.getMatrizC().length; i++) {
            for (int j = 0; j < tableroComputador.getMatrizC()[i].length; j++) {
                if (tableroComputador.getMatrizC()[fila][columna] == 1 || tableroComputador.getMatrizC()[fila][columna] == 2 || tableroComputador.getMatrizC()[fila][columna] == 3) {
                    tableroComputador.getMatrizC()[fila][columna] = tocado;
                } else if (tableroComputador.getMatrizC()[fila][columna] == 4) {
                    tableroComputador.getMatrizC()[fila][columna] = hundido;
                } else if (tableroComputador.getMatrizC()[fila][columna] == 0) {
                    tableroComputador.getMatrizC()[fila][columna] = agua;
                }
            }
        }
    }

    /**
     * Muestra en consola la matriz con los datos
     *
     * @version v.1.0.0 date 18/03/2022
     */
    public void mostrarLaMatriz(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + "");
            }
            System.out.println();

        }
        System.out.println("-------------------------------");

    }


}



