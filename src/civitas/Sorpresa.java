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

// Para no crear una clase SorpresaConvertir, he usado la propia clase Sorpresa para que aplique al jugador la Sorpresa convertir
public class Sorpresa {
    private String texto;
    private MazoSorpresas mazo;
    
    //  informa al diario que se está aplicando una sorpresa a un jugador (se indica el nombre de este)
    protected void informe(int actual,ArrayList<Jugador> todos){
        //Diario.getInstance().ocurreEvento("Se le ha aplicaddo una sorpresa a " + todos.get(actual).getNombre());
        Diario.getInstance().ocurreEvento(todos.get(actual).getNombre() + ", " + this.texto);
    }
    
    /*
    se utiliza el 
    método informe y  se convierte el jugador actual en jugador especulador
    */
    void aplicarAJugador(int actual,ArrayList<Jugador> todos){
        this.informe(actual, todos);
        todos.set(actual, todos.get(actual).convertir());
    }
    
    Sorpresa(String texto){
        this.texto = texto;
        this.mazo = new MazoSorpresas();
    }

    @Override
    public String toString() {
        return this.texto;
    }
    
}
