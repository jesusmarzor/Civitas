/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package civitas;

import java.util.ArrayList;

/**
 *
 * @author jesus
 */
public class Tablero {
    private ArrayList<Casilla> tablero;
    private boolean porSalida;

    Tablero() {
        this.tablero = new ArrayList();
        this.porSalida = false;
    }
    
     void añadeCasilla(Casilla casilla) {
        this.tablero.add(casilla);
    }
     
    boolean computarPasoPorSalida() {
        if(porSalida){
            porSalida=false;
            return true;
        }
        return false;
    }
    
     // suponiendo que el numero de la casilla va de 0 a tam-1
    private boolean correcto(int numCasilla) {
        return (numCasilla >= 0 && numCasilla < this.tablero.size());
    }
    
    public Casilla getCasilla(int numCasilla) {
        if( correcto(numCasilla) ){
            return tablero.get(numCasilla);
        }
        return null;
    }
    
    public ArrayList<Casilla> getCasillas() {
        return tablero;
    }
    
    int nuevaPosicion( int actual, int tirada ) {
        int nuevaPos = actual + tirada;
        if( !correcto( nuevaPos )){
            nuevaPos = nuevaPos%this.tablero.size();
            this.porSalida = true; // pasa por la salida
        }
        return nuevaPos;
    }
    
}
