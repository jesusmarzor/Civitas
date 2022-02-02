/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package civitas;

import java.util.ArrayList;

/**
 *
 * @author Jesus Martin
 */
public class CasillaSorpresa extends Casilla{
    
    // variables de instancia
    private MazoSorpresas mazo; // tipo = Sorpresa
    private Sorpresa sorpresa; // tipo = Sorpresa
    
    // Constructor casilla tipo sorpresa
    CasillaSorpresa(String nombre, MazoSorpresas mazo) {
        super(nombre);
        this.init();
        this.mazo = mazo;
    }
    
    // aplica la sorpresa que toca al jugador que cae en la casilla tipo sorpresa
    @Override
    void recibeJugador(int iactual,ArrayList<Jugador> todos){
        this.sorpresa = mazo.siguiente();
        this.informe(iactual, todos);
        this.sorpresa.aplicarAJugador(iactual, todos);
    }
    private void init(){
        this.mazo = new MazoSorpresas();
    }
    
    @Override
    public String toString() {
        // Lo modifico paraa que se vea más claro a la hora de jugar
        return this.nombre + ", tipo Sorpresa";
    }
}
