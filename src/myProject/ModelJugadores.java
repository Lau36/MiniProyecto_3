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
        tablero = new TableroUsuario();
        encontrado = false;
        fragata = 1;
        destructores = 2;
        submarinos = 3;
        portaaviones = 4;
        agua = 0;
        tocado = 5;
        hundido =6;
    }

    //recorre la matriz y verifica si hay una fragata
    public boolean verificarPortaaviones(){
        for(int i=0; i< ventanaPrincipal.getFilaVariable();i++){
            for(int j=0; j< ventanaPrincipal.getColumnaVariable();j++){
                if(ventanaPrincipal.getId1()==4){
                    encontrado = true;
                    System.out.println("EL VALOR "+encontrado);
                    break;
                    }
                }
            }
        return encontrado;
        }

    }

