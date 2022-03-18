package myProject;

/**
 *
 * @version v.1.0.0 date:04/03/2022
 * @autors Laura Jaimes, laura.jaimes@correounivalle.edu.co, 2040430-3743
 * Esteban Hernandez, esteban.cortes@correounivalle.edu.co, 2042817 - 3743
 */

public class ModelJugadores{
    private int fragata;
    private int destructores;
    private int submarinos;
    private int portaaviones;
    private int agua;
    private int tocado;
    private int hundido;
    private boolean encontrado;
    private TableroUsuario tablero;
    private VentanaPrincipal ventanaPrincipal;


    /**
     * Constructor of GUI class
     */
    public ModelJugadores(){
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


}



