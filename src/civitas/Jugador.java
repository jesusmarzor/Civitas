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
public class Jugador implements Comparable<Jugador>{ // Para poder hacer un ranking de jugadores
    protected static final int CasasMax = 4;
    protected static final int CasasPorHotel = 4;
    private int casillaActual;
    protected static final int HotelesMax = 4;
    private String nombre;
    protected static final float PasoPorSalida = 1000;
    private boolean puedeComprar;
    private float saldo;
    private static final float SaldoInicial = 7500;
    private ArrayList<CasillaCalle> propiedades;
    
    int cantidadCasasHoteles(){
        int cantidad = 0;
        for(int i = 0; i < this.propiedades.size(); i++){
            cantidad += propiedades.get(i).cantidadCasasHoteles();
        }
        return cantidad;
    }
    
    /*
    Este método delega en el método compare de clase Float 
    para comparar el saldo del jugador con el saldo del jugador pasado como parámetro. 
    Investiga lo que devuelve el método compareTo de la interfaz Comparable
    
    - 0: si son iguales
    - negativo: si saldo1 es menor que saldo2
    - positivo: si saldo1 es mayor que saldo2
    
    */
    @Override
    public int compareTo(Jugador otro){
        return Float.compare(this.getSaldo(), otro.getSaldo());
    }
    
    boolean comprar(CasillaCalle titulo){
        boolean result = false;
        if(this.puedeComprar){
            float precio = titulo.getPrecioCompra();
            if(this.puedoGastar(precio)){
                result = titulo.comprar(this);
                this.propiedades.add(titulo);
                Diario.getInstance().ocurreEvento("El jugador " + this + " ha comprado la calle " + titulo + " por " + titulo.getPrecioCompra() + " euros");
                this.puedeComprar = false;
            }else{
                Diario.getInstance().ocurreEvento("El jugador " + this + " no tiene saldo para comprar la calle " + titulo);
            }
        }
        return result;
    }
    
    boolean construirCasa(int ip){
        boolean result = false;
        if(this.existeLaPropiedad(ip)){
            CasillaCalle propiedad = this.propiedades.get(ip);
            if(this.puedoEdificarCasa(propiedad)){
                result = propiedad.construirCasa(this);
                Diario.getInstance().ocurreEvento("El jugador " + this.getNombre() + " construye una casa en la propiedad " + propiedad);
            }else{
                Diario.getInstance().ocurreEvento("El jugador " + this.getNombre() + " no puede construir una casa en la propiedad " + propiedad);
            }
        }
        return result;
    }
    
    boolean construirHotel (int ip){
        boolean result = false;
        if(this.existeLaPropiedad(ip)){
            CasillaCalle propiedad = this.propiedades.get(ip);
            if(this.puedoEdificarHotel(propiedad)){
                result = propiedad.construirHotel(this);
                propiedad.derruirCasa(Jugador.CasasPorHotel,this);
                Diario.getInstance().ocurreEvento("El jugador " + this.getNombre() + " construye un hotel en la propiedad " + propiedad);
            }else{
                Diario.getInstance().ocurreEvento("El jugador " + this.getNombre() + " no puede construir un hotel en la propiedad " + propiedad);
            }
        }
        return result;
    }
    
    boolean enBancarrota (){
        return this.getSaldo() <= 0;
    }
    
    //Comprueba que el índice ip es un índice válido dentro de las propiedades del jugador
    private boolean existeLaPropiedad(int ip){
        return ip >= 0 && ip <this.getPropiedades().size();
    }

    private static int getCasasMax() {
        return CasasMax;
    }

    static int getCasasPorHotel() {
        return CasasPorHotel;
    }

    public int getCasillaActual() {
        return casillaActual;
    }

    static int getHotelesMax() {
        return HotelesMax;
    }

    public String getNombre() {
        return nombre;
    }

    private static float getPremioPasoSalida() {
        return PasoPorSalida;
    }

    // Devuelve TituloPropiedad[1..*]
    public ArrayList<CasillaCalle> getPropiedades() {
        return propiedades;
    }

    boolean getPuedeComprar() {
        return puedeComprar;
    }

    public float getSaldo() {
        return saldo;
    }
    
    Jugador(String nombre){
        this.nombre = nombre;
        this.saldo = Jugador.SaldoInicial;
        this.casillaActual = 0;
        // Lo pongo a true para hacer el testP4
        this.puedeComprar = true;
        this.propiedades = new ArrayList();
    }
    protected Jugador(Jugador otro){
        this.nombre = otro.getNombre();
        this.saldo = otro.getSaldo();
        this.casillaActual = otro.getCasillaActual();
        this.propiedades = otro.getPropiedades();
        this.puedeComprar = otro.getPuedeComprar();
    }
    
    boolean modificarSaldo(float cantidad){
        // Quito esto ya que cuando edificas miras si puedes gastar dinero, entonces si no tienes dinero para edificar, no modificaras nunca el saldo,
        // pero si la sorpresa dice que tienes que quitarte 1000 euros, aunque no tengas tienes que quedarte en 0 euros(bancarrota)
        
        //if(cantidad < 0 && cantidad > this.getSaldo()){
        //    return false;
        //}
        this.saldo = this.getSaldo() + cantidad;
        if(this.saldo < 0 ){
            this.saldo = 0;
        }
        return true;
    }
    
    boolean moverACasilla(int numCasilla){
        Diario.getInstance().ocurreEvento(this.getNombre() + " se mueve de la casilla " + this.getCasillaActual() + " a la casilla " + numCasilla);
        this.casillaActual = numCasilla;
        this.puedeComprar = false;
        return true;
    }
    
    boolean paga(float cantidad){
        return this.modificarSaldo(cantidad * -1);
    }
    
    boolean pagaAlquiler(float cantidad){
        return this.paga(cantidad);
    }
    
    boolean pasaPorSalida(){
        this.recibe(Jugador.getPremioPasoSalida());
        Diario.getInstance().ocurreEvento(this.getNombre() + " a recibido "+ Jugador.getPremioPasoSalida() + " por pasar por la salida");
        return true;
    }
    
    //Fija el atributo puedeComprar a true y devuelve el valor de este atributo
    boolean puedeComprarCasilla(){
        if(!this.puedeComprar){
            this.puedeComprar = true;
            return false;
        }
        return true;
    }
    
    // En verdad se le pasa una propiedad que es un objeto de TituloPropiedad
    protected boolean puedoEdificarCasa(CasillaCalle propiedad){
        return this.puedoGastar(propiedad.getPrecioEdificar()) && propiedad.getNumCasas() < Jugador.CasasMax;
    }
    
    // En verdad se le pasa una propiedad que es un objeto de TituloPropiedad
    protected boolean puedoEdificarHotel(CasillaCalle propiedad){
        return this.puedoGastar(propiedad.getPrecioEdificar()) && propiedad.getNumHoteles() < Jugador.getHotelesMax() && propiedad.getNumCasas() >= Jugador.CasasPorHotel; 
    }
    // indica si el saldo es mayor o igual que el parámetro
    protected boolean puedoGastar(float precio){
        return this.getSaldo()>=precio;
    }
    
    boolean recibe (float cantidad){
        return this.modificarSaldo(cantidad);
    }
    
    // este método indica si el jugador tiene propiedades
    boolean tieneAlgoQueGestionar(){
        return this.getPropiedades().size()>0;
    }

    @Override
    public String toString() {
        //return this.nombre + ", está en la casilla " + this.casillaActual + " y tiene " + this.saldo + " euros"; // + "Jugador{" + "casillaActual=" + casillaActual + ", nombre=" + nombre + ", puedeComprar=" + puedeComprar + ", saldo=" + saldo + ", propiedades=" + propiedades + '}';
        return this.getNombre() + " (tiene " + this.getSaldo() + " y no es especulador)";
    }
    
    /*
    
    No esta en el pdf final
    
    private boolean vender(int ip){
        //this.getPropiedades().remove(ip);
        throw new UnsupportedOperationException("no implementada");
        
    }
    */
    
    public JugadorEspeculador convertir(){
        return new JugadorEspeculador(this);
    }
    
    protected void actualizaPropiedadesPorConversion(Jugador jugador){
        for(int i = 0; i < this.propiedades.size(); i++){
            this.propiedades.get(i).actualizaPropietarioPorConversion(jugador);
        }
    }
    
    public boolean isEspeculador(){
        return false;
    }
}
