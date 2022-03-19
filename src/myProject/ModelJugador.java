package myProject;

/**
 *
 * @version v.1.0.0 date:04/03/2022
 * @autors Laura Jaimes, laura.jaimes@correounivalle.edu.co, 2040430-3743
 * Esteban Hernandez, esteban.cortes@correounivalle.edu.co, 2042817 - 3743
 */

public class ModelJugador {
    private int fragata;
    private int destructores;
    private int submarinos;
    private int portaaviones;
    private int agua;
    private int tocado;
    private int hundido;
    private boolean encontrado;
    private TableroUsuario tablero;
    private TableroComputador tableroComputador;
    private VentanaPrincipal ventanaPrincipal;


    /**
     * Constructor of GUI class
     */
    public ModelJugador(){
        //ventanaPrincipal = new VentanaPrincipal();
        tablero = new TableroUsuario();
        encontrado = false;
        /*Portaaviones ->1
          Submarinos -> 2
          Destructores -> 3
          Fragats -> 4
        */
        agua = 0;
        tocado = 5;
        hundido = 6;
    }

    public void verificarDisparoPortaavion(int fila, int columna){
        for(int i= 0; i<tablero.getMatriz().length;i++){
            for(int j=0; j<tablero.getMatriz()[i].length;j++){
                if(tablero.getMatriz()[fila][columna]==1){
                    tablero.getMatriz()[fila][columna] = 5;
                    System.out.println("LA MATRIZ NUEVA ES: "+tablero.getMatriz()[fila][columna]);
                }
            }
        }
    }

    public void verificarCoordenada(int fila, int columna){
        for (int i = 0; i < tableroComputador.getMatrizC().length; i++){
            for (int j = 0; j < tableroComputador.getMatrizC()[i].length; j++){
                if (tableroComputador.getMatrizC()[fila][columna] == 1 || tableroComputador.getMatrizC()[fila][columna] == 2 || tableroComputador.getMatrizC()[fila][columna] == 3) {
                            /*ImageIcon image = new ImageIcon(getClass().getResource("/recursos/ayudaa.jpeg"));
                            casillaMaquinaSeleccionada.setIcon(image);*/
                    tableroComputador.getMatrizC()[fila][columna] = 5;
                }
                else if (tableroComputador.getMatrizC()[fila][columna] == 4) {
                    tableroComputador.getMatrizC()[fila][columna] = 6;
                }
                else if(tableroComputador.getMatrizC()[fila][columna] == 0){
                    tableroComputador.getMatrizC()[fila][columna] = 0;
                }
            }
        }
    }

    public void mostrarLaMatriz(int [][] matriz){
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + "");
            }
            System.out.println();

        }
        System.out.println("-------------------------------");

    }


}



