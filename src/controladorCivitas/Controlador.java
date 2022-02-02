/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladorCivitas;

import GUI.CivitasView;
import civitas.CivitasJuego;
import civitas.GestionInmobiliaria;
import civitas.OperacionInmobiliaria;
import civitas.OperacionJuego;
import GUI.Vista;
import GUI.VistaTextual;

/**
 *
 * @author jesus
 */
public class Controlador {
    private CivitasJuego juegoModel;
    private Vista vista;
    
    public Controlador(CivitasJuego juegoModel, VistaTextual vista){
        this.juegoModel = juegoModel;
        this.vista = vista;
    }
    
    public Controlador(CivitasJuego juegoModel, CivitasView vista){
        this.juegoModel = juegoModel;
        this.vista = vista;
    }
    public void juega(){
        while(!juegoModel.finalDelJuego()){
            this.vista.actualiza();
            this.vista.mostrarEstado();
            this.vista.pausa();
            OperacionJuego operacionJ = this.juegoModel.siguientePaso();
            this.vista.mostrarSiguienteOperacion(operacionJ);
            if(operacionJ != OperacionJuego.PASAR_TURNO){
                this.vista.mostrarEventos();
            }
            if(!this.juegoModel.finalDelJuego()){
                if(operacionJ == OperacionJuego.COMPRAR){
                    if(this.vista.comprar() == Respuesta.SI){
                        this.juegoModel.comprar();
                    }
                    this.juegoModel.siguientePasoCompletado(operacionJ);
                }else if(operacionJ == OperacionJuego.GESTIONAR){
                    OperacionInmobiliaria operacionI = this.vista.elegirOperacion();
                    if(operacionI != OperacionInmobiliaria.TERMINAR){
                        int propiedad = this.vista.elegirPropiedad();
                        GestionInmobiliaria gestion = new GestionInmobiliaria(operacionI,propiedad);
                        if(gestion.getOperacion() == OperacionInmobiliaria.CONSTRUIR_CASA){
                            this.juegoModel.construirCasa(propiedad);
                        }else{
                            this.juegoModel.construirHotel(propiedad);
                        }
                    }else{
                        this.juegoModel.siguientePasoCompletado(operacionJ);
                    }
                }
            }else{
                this.vista.mostrarEstado();
            }
            
        }
    }
}
