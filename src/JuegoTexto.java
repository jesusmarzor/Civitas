
import civitas.CivitasJuego;
import controladorCivitas.Controlador;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jesus
 */
public class JuegoTexto {
    /*
    public static void main(String[] args) {
        ArrayList<String> jugadores = new ArrayList();
        Scanner scan = new Scanner(System.in);
        int numJugadores = 0;
        while( numJugadores <= 1 || numJugadores > 4){
            System.out.println("¿Cuántos jugadores sois? (mínimo 2 y máximo 4)");
            String numero = scan.nextLine();
            if(numero.contains("2") || numero.contains("3") || numero.contains("4"))
                numJugadores = Integer.parseInt(numero);
        }
        for(int i = 0; i < numJugadores; i++){
            String nombre = "";
            while(nombre.isEmpty()){
                System.out.println("Nombre del jugador número " + (i+1));
                nombre = scan.nextLine();
            }
            jugadores.add(nombre);
        }
        CivitasJuego juego = new CivitasJuego(jugadores,false);
        VistaTextual vista = new VistaTextual(juego);
        Controlador controlador = new Controlador(juego,vista);
        controlador.juega();
    }*/
}
