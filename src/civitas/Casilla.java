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
public class Casilla {
    
    // Atributos de instancia
    protected String nombre;
    
    // Constructor casilla tipo descanso
    Casilla(String unNombre) {
        this.nombre = unNombre;
        
    }
    
    /*
        informa al diario acerca del jugador 
        que ha caído en la casilla actual. Para proporcionar información de la casilla utiliza el 
        método toString.
    */
    void informe(int iactual, ArrayList<Jugador> todos){
        Diario.getInstance().ocurreEvento(todos.get(iactual).getNombre() + " ha caído en la casilla " + this.toString());
    }

    // reparte segun la casilla que caiga
    void recibeJugador(int iactual,ArrayList<Jugador> todos){
        this.informe(iactual, todos);
    }
    
    public boolean tienePropietario(){
        return false;
    }
    
    public boolean esEsteElPropietario(Jugador jugador){
        return false;
    }

    @Override
    public String toString() {
        // Lo modifico paraa que se vea más claro a la hora de jugar
        return this.nombre + ", tipo Descanso";
    }
    
    public String getNombre(){
        return this.nombre;
    }
}
