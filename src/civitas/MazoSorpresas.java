/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package civitas;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author jesus
 */
public class MazoSorpresas {
    private ArrayList<Sorpresa> sorpresas;
    private boolean barajada;
    private int usadas;
    private boolean debug; // cuando es true, el mazo no se baraja y se cogen sorpresas en orden
    
    private void init() {
        this.sorpresas = new ArrayList();
        this.barajada = false;
        this.usadas = 0;
    }

    MazoSorpresas(boolean debug) {
        init();
        this.debug = debug;
        if(this.debug) {
            Diario.getInstance().ocurreEvento("El modo debug del MazoSorpresas está activo");
        }
    }
    
    MazoSorpresas() {
        init();
        this.debug = false;
    }
    
    void alMazo(Sorpresa s) {
        if(!this.barajada){ // si se ha barajado no puedes añadir más cartas sorpresa
            this.sorpresas.add(s);
        }
    }
    
    Sorpresa siguiente() {
        if(!this.barajada || this.usadas == this.sorpresas.size()){
            if(!this.debug){
                Collections.shuffle(this.sorpresas); // barajar el mazo
                this.usadas = 0;
                this.barajada = true;
            }
            
        }
        // empieza a coger la primera carta
        this.usadas++;
        Sorpresa sorpresaElegida = this.sorpresas.get(0);
        this.sorpresas.add(this.sorpresas.size(),sorpresaElegida);
        this.sorpresas.remove(0);
        return sorpresaElegida;
    }
}
