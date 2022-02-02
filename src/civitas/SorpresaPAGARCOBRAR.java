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
public class SorpresaPAGARCOBRAR extends Sorpresa{
    private int valor;
    public SorpresaPAGARCOBRAR(String texto, int valor) {
        super(texto);
        this.valor = valor;
    }
    
    /*
    se utiliza el 
    método informe y  se modifica el saldo del jugador actual(método modificaSaldo) con el 
    valor de la sorpresa
    */
    @Override
    void aplicarAJugador(int actual,ArrayList<Jugador> todos){
        this.informe(actual, todos);
        todos.get(actual).modificarSaldo(this.valor);
    }
}
