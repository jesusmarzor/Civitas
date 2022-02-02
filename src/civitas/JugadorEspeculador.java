/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package civitas;

/**
 *
 * @author Jesus Martin
 */
public class JugadorEspeculador extends Jugador{
    protected static final int FactorEspectacular = 2;
    protected static final int CasasMax = 4 * JugadorEspeculador.FactorEspectacular;
    protected static final int CasasPorHotel = 4 * JugadorEspeculador.FactorEspectacular;
    
    @Override
    protected boolean puedoEdificarCasa(CasillaCalle propiedad){
        return this.puedoGastar(propiedad.getPrecioEdificar()) && propiedad.getNumCasas() < (Jugador.CasasMax * JugadorEspeculador.FactorEspectacular);
    }
    
    // En verdad se le pasa una propiedad que es un objeto de TituloPropiedad
    @Override
    protected boolean puedoEdificarHotel(CasillaCalle propiedad){
        return this.puedoGastar(propiedad.getPrecioEdificar()) && propiedad.getNumHoteles() < (Jugador.getHotelesMax() * JugadorEspeculador.FactorEspectacular) && propiedad.getNumCasas() >= (Jugador.CasasPorHotel * JugadorEspeculador.FactorEspectacular); 
    }
    
    @Override
    boolean paga(float cantidad){
        return this.modificarSaldo((cantidad/JugadorEspeculador.FactorEspectacular) * -1);
    }
    
    protected JugadorEspeculador(Jugador jugador) {
        super(jugador);
        this.actualizaPropiedadesPorConversion(this);
    }
    
    public String toString() {
        //return this.nombre + ", está en la casilla " + this.casillaActual + " y tiene " + this.saldo + " euros"; // + "Jugador{" + "casillaActual=" + casillaActual + ", nombre=" + nombre + ", puedeComprar=" + puedeComprar + ", saldo=" + saldo + ", propiedades=" + propiedades + '}';
        return this.getNombre() + " (tiene " + this.getSaldo() + " y es especulador)";
    }
    
    @Override
    public boolean isEspeculador(){
        return true;
    }
}
