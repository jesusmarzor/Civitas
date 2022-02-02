/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import civitas.CivitasJuego;
import controladorCivitas.Controlador;
import java.util.ArrayList;

/**
 *
 * @author Jesus Martin
 */
public class TestP5 {
    public static void main(String[] args) {
        CivitasView vista = new CivitasView();
        Dado.createInstance(vista);
        Dado.getInstance().setDebug(false);
        CapturaNombres capNombres = new CapturaNombres(vista, true);
        ArrayList<String> nombresJugadores = new ArrayList();
        nombresJugadores = capNombres.getNombres();
        CivitasJuego juego = new CivitasJuego(nombresJugadores, false);
        Controlador controlador = new Controlador(juego,vista);
        vista.setCivitasJuego(juego);
        controlador.juega();
    }
}
