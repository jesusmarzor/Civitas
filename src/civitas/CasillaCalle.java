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
public class CasillaCalle extends Casilla{
    
    // Atributos de clase
    private static final float FACTORALQUILERCALLE = 1.0f;
    private static final float FACTORALQUILERCASA  = 1.0f;
    private static final float FACTORALQUILERHOTEL = 4.0f;
    
    // Atributos de instancia
    private int numCasas;
    private int numHoteles;
    private float precioCompra;
    private float precioEdificar;
    private float precioBaseAlquiler;
    private Jugador propietario;
    
    
    // Constructor casilla tipo calle
    CasillaCalle(String nombre, float precioCompra, float precioEdificar, float precioBaseAlquiler) {
        super(nombre);
        this.precioCompra = precioCompra;
        this.precioEdificar = precioEdificar;
        this.precioBaseAlquiler = precioBaseAlquiler;
    }
    
    // devuelve la suma del número de las casas y hoteles construidos
    public int cantidadCasasHoteles(){
        return this.numCasas + this.numHoteles;
    }
    
    @Override
    public boolean esEsteElPropietario(Jugador jugador){
        return this.propietario == jugador;
    }
    
    public int getNumCasas() {
        return numCasas;
    }

    public int getNumHoteles() {
        return numHoteles;
    }
    
    // devuelve el precio del alquiler calculado según las reglas del juego
    public float getPrecioAlquilerCompleto() {
        float precioAlquilerCompleto = this.precioBaseAlquiler * this.FACTORALQUILERCALLE * (this.FACTORALQUILERCASA +this.numCasas + (this.numHoteles*this.FACTORALQUILERHOTEL));
        return precioAlquilerCompleto;
    }
    
    public float getPrecioCompra() {
        return precioCompra;
    }

    float getPrecioEdificar() {
        return precioEdificar;
    }
    
    // si tiene propietario: paga el alquiler si no es el propietario, si no tiene propietario: puede comprarla
    @Override
    void recibeJugador(int iactual,ArrayList<Jugador> todos){
        this.informe(iactual, todos);
        Jugador jugador= todos.get(iactual);
        if(!this.tienePropietario()){
            jugador.puedeComprarCasilla();
        }else{
            this.tramitarAlquiler(jugador);
        }
    }
    
    
    // inicializa los atributos con valores adecuados
    private void init(){
        this.precioCompra = 0;
        this.precioEdificar = 0;
        this.precioBaseAlquiler = 0;
        this.numCasas = 0;
        this.numHoteles = 0;
        this.propietario = null;
    }
    
    // Se le asigna un propietario a la casilla y se devuelve true cuando el jugador paga (siempre será true porque ya está conprobado antes en Casilla.puedeGastar(precio))
    boolean comprar(Jugador jugador){
        this.propietario = jugador;
        return jugador.paga(this.precioCompra);
    }
    
    // Primero paga y despues se construye una casa (siempre devuelve true porque se comprueba antes en Jugador.puedoEdificarCasa())
    boolean construirCasa(Jugador jugador){
        jugador.paga(this.precioEdificar);
        this.numCasas++;
        return true;
    }
    
    // Primero paga y despues se construye un hotel (siempre devuelve true porque se comprueba antes en Jugador.puedoEdificarHotel())
    boolean construirHotel(Jugador jugador){
        jugador.paga(this.precioEdificar);
        this.numHoteles++;
        return true;
    }
    
    // El propietario puede destruir n casas si el numero de casas es mayor o igual a ese
    boolean derruirCasa(int n, Jugador jugador){
        if(this.esEsteElPropietario(jugador) && this.getNumCasas() >= n){
            this.numCasas = this.getNumCasas()-n;
            return true;
        }
        return false;
    }
    @Override
    public String toString() {
        // Lo modifico paraa que se vea más claro a la hora de jugar
        if(this.tienePropietario()){
            return this.nombre + " (tiene " + this.getNumCasas() + " casas, " + this.getNumHoteles() + " hoteles y su alquiler es de " + this.getPrecioAlquilerCompleto() + " euros), su propietario es " + this.propietario;
        }
        return this.nombre + ", no tiene propietario, el precio de compra es de " + this.precioCompra + " euros"; 
    }
    //
    @Override
    public boolean tienePropietario(){
        return this.propietario != null;
    }
    // El jugador que cae en esta casilla debe pagar el alquiler si no es el propietario
    public void tramitarAlquiler(Jugador jugador){
        if(this.tienePropietario() && !this.esEsteElPropietario(jugador)){
            Diario.getInstance().ocurreEvento(jugador + " paga " + this.getPrecioAlquilerCompleto() + " de alquiler a " + this.propietario);
            jugador.pagaAlquiler(this.getPrecioAlquilerCompleto());
            this.propietario.recibe(this.getPrecioAlquilerCompleto());
        }
    }
    
    public void actualizaPropietarioPorConversion(Jugador jugador){
        this.propietario = jugador;
    }

    public Jugador getPropietario() {
        return propietario;
    }
    
}
