/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import civitas.Casilla;
import civitas.CivitasJuego;
import civitas.Diario;
import civitas.OperacionJuego;
import controladorCivitas.Respuesta;
import civitas.OperacionInmobiliaria;
import civitas.Jugador;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author jesus
 */
public class VistaTextual implements Vista {
    private static String separador = "=====================";

    private Scanner in;

    CivitasJuego juegoModel;

    public VistaTextual (CivitasJuego juegoModel) {
      in = new Scanner (System.in);
      this.juegoModel=juegoModel;
    }



   public  void pausa() {
      System.out.print ("\nPulsa una tecla");
      in.nextLine();
    }

   /*
   permite obtener de la consola un número entero
   */
   
    int leeEntero (int max, String msg1, String msg2) {
      Boolean ok;
      String cadena;
      int numero = -1;
      do {
        System.out.print (msg1);
        cadena = in.nextLine();
        try {  
          numero = Integer.parseInt(cadena);
          ok = true;
        } catch (NumberFormatException e) { // No se ha introducido un entero
          System.out.println (msg2);
          ok = false;  
        }
        if (ok && (numero < 0 || numero >= max)) {
          System.out.println (msg2);
          ok = false;
        }
      } while (!ok);

      return numero;
    }

    int menu (String titulo, ArrayList<String> lista) {
      String tab = "  ";
      int opcion;
      System.out.println (titulo);
      for (int i = 0; i < lista.size(); i++) {
        System.out.println (tab+i+"-"+lista.get(i));
      }

      opcion = leeEntero(lista.size(),
                            "\n"+tab+"Elige una opción: ",
                            tab+"Valor erróneo");
      return opcion;
    }

    @Override
    public void actualiza() {
        // no aparece en el pdf
    }

    @Override
    public Respuesta comprar() {
        ArrayList<String> comprar = new ArrayList();
        comprar.add("Si");
        comprar.add("No");
        return Respuesta.values()[this.menu("¿Desea comprar esta calle?", comprar)];
    }

    @Override
    public OperacionInmobiliaria elegirOperacion() {
        ArrayList<String> operacion = new ArrayList();
        operacion.add("Construir casa");
        operacion.add("Construir hotel");
        operacion.add("Terminar");
        return OperacionInmobiliaria.values()[this.menu("¿Qué gestión inmobiliaria dese realizar?", operacion)];
    }

    @Override
    public int elegirPropiedad() {
        ArrayList<String> propiedades = new ArrayList();
        ArrayList<Casilla> casillas = juegoModel.getTablero().getCasillas();
        for(int i = 0; i < casillas.size() ; i++){
            if(casillas.get(i).tienePropietario() && casillas.get(i).esEsteElPropietario(this.juegoModel.getJugadorActual())){
                propiedades.add(casillas.get(i).toString());
            }
        }
        return this.menu("¿En cuál de tus propiedades deseas realizar la gestión?",propiedades);
    }

    @Override
    public void mostrarSiguienteOperacion(OperacionJuego operación) {
        System.out.println(operación);
    }

    @Override
    public void mostrarEventos() {
        while(Diario.getInstance().eventosPendientes()){
            System.out.println(Diario.getInstance().leerEvento());
        }
    }
    
    @Override
    public void mostrarEstado() {
        if(!juegoModel.finalDelJuego()){
            System.out.println("Es el turno de " + juegoModel.getJugadorActual());
            // Lo he comentado por que es repetitivo que te ponga en que casilla te encuentras todo el rato ya que muestra a que casilla te mueves
            //System.out.println(juegoModel.getTablero().getCasilla(juegoModel.getJugadorActual().getCasillaActual()));
        }else{
            System.out.println("Ranking final: ");
            ArrayList<Jugador> ranking = juegoModel.ranking(); // He tenido que poner publico el metodo ranking() de CivitasJuego
            for(int i = 0; i < ranking.size(); i++){
                System.out.println(ranking.get(i));
            }
        }
    }

}
