/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package civitas;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author jesus
 */
public class Civitas {

    /**
     * @param args the command line arguments
     */
    
    /*
    public static void main(String[] args) {
        // TODO code application logic here
        // Probando Casilla
//        Casilla c1 = new  Casilla("casilla1",100,20,10);
//        System.out.println(c1.toString());
//        
//        // Probando dado
//        System.out.println("Al tirar el dado sale: " + Dado.getInstance().tirar());
//        System.out.println("De 4(0...3) jugadores, empieza el jugador numero: " + Dado.getInstance().quienEmpieza(4));
//        
//        /*
//            1)
//            Llama 100 veces al método quienEmpieza()  de  Dado  considerando que hay 4 jugadores,  y
//            calcula cuantas veces se obtiene cada uno de los valores posibles. Comprueba si se cumplen
//            a nivel práctico las probabilidades de cada valor.
//        */
//        int cero = 0,uno = 0,dos = 0,tres = 0;
//        for(int i = 0; i<100; i++){
//            int valor = Dado.getInstance().quienEmpieza(4);
//            switch(valor){
//                case 0:
//                    cero++;
//                    break;
//                case 1:
//                    uno++;
//                    break;
//                case 2:
//                    dos++;
//                    break;
//                case 3:
//                    tres++;
//            }    
//        }
//        System.out.println("0->"+cero+" veces");
//        System.out.println("1->"+uno+" veces");
//        System.out.println("2->"+dos+" veces");
//        System.out.println("3->"+tres+" veces");
//        
//        /*
//            2)
//            Asegúrate de que funciona el modo debug del dado activando y desactivando ese modo, y
//            realizando varias tiradas en cada modo.
//        */
//        System.out.println("Al tirar el dado sale: " + Dado.getInstance().tirar());
//        Dado.getInstance().setDebug(true);
//        System.out.println("Al tirar el dado sale: " + Dado.getInstance().tirar());
//        System.out.println(Diario.getInstance().getEventos().get(Diario.getInstance().getEventos().size()-1));
//        Dado.getInstance().setDebug(false);
//        System.out.println("Al tirar el dado sale: " + Dado.getInstance().tirar());
//        System.out.println(Diario.getInstance().getEventos().get(Diario.getInstance().getEventos().size()-1));
//        Dado.getInstance().setDebug(true);
//        System.out.println("Al tirar el dado sale: " + Dado.getInstance().tirar());
//        System.out.println(Diario.getInstance().getEventos().get(Diario.getInstance().getEventos().size()-1));
//        Dado.getInstance().setDebug(false);
//        System.out.println("Al tirar el dado sale: " + Dado.getInstance().tirar());
//        
//        /*
//            3)
//            Prueba al menos una vez el método getUltimoResultado() de Dado
//        */
//        System.out.println("El ultimo resultado del dado es: " + Dado.getInstance().getUltimoResultado());
//        
//        
//        /*
//            4)
//            Muestra al menos un valor de cada tipo enumerado
//        */
//        
//        
//        /*
//            5)
//            Crea un objeto Tablero y haz las siguientes pruebas: añade algunas calles al tablero, obtén
//            dichas casillas y muestra su estado por consola usando el método toString de la clase
//            Casilla
//        */
//        Tablero tablero = new Tablero();
//        Casilla ceuta = new  Casilla("Ceuta",100,20,10);
//        Casilla granada = new  Casilla("Granada",300,50,18);
//        Casilla madrid = new  Casilla("Madrid",450,80,35);
//        Casilla barcelona = new  Casilla("Barcelona",500,90,40);
//        tablero.añadeCasilla(ceuta);
//        tablero.añadeCasilla(granada);
//        tablero.añadeCasilla(madrid);
//        tablero.añadeCasilla(barcelona);
//        ArrayList<Casilla> casillasTablero = tablero.getCasillas();
//        for(int i = 0; i < casillasTablero.size(); i++){
//            System.out.println(casillasTablero.get(i));
//        }
//        
//        /*
//            6)
//            Crea algunos bucles sobre la totalidad de las calles para calcular y mostrar cuál es la calle
//            más cara (en cuanto a su precio de compra), la más barata y el precio medio de las calles
//        */
//        Casilla masCara = casillasTablero.get(0);
//        Casilla masBarata = casillasTablero.get(0);
//        float suma = casillasTablero.get(0).getPrecioCompra();
//        for(int i = 1; i < casillasTablero.size(); i++){
//            suma += casillasTablero.get(i).getPrecioCompra();
//            if(masCara.getPrecioCompra() < casillasTablero.get(i).getPrecioCompra()){
//                masCara = casillasTablero.get(i);
//            }
//            if(masBarata.getPrecioCompra() > casillasTablero.get(i).getPrecioCompra()){
//                masBarata = casillasTablero.get(i);
//            }
//        }
//        System.out.println(masCara.toString() + " es la calle mas cara");
//        System.out.println(masBarata.toString() + " es la calle mas barata");
//        System.out.println("El precio de todas las calles juntas es: " + suma);
//        
//        
//        /*
//            7)
//            Usa la clase Diario, aprovecha y prueba todos los métodos de Diario
//        */
//        Diario.getInstance().ocurreEvento("Empieza el JUEGOOO");
//        while(Diario.getInstance().eventosPendientes()){
//            System.out.println(Diario.getInstance().leerEvento());
//        }
//        
//        
//        /*
//            8)
//            Finalmente, realiza distintas tiradas con el dado y asegúrate de que se calcula correctamente
//            la posición de destino en el tablero
//        */
//        System.out.println("El tablero tiene " + casillasTablero.size() + " casillas y estas en la casilla número 3");
//        int tirada = Dado.getInstance().tirar();
//        System.out.println("Te ha salido un " + tirada);
//        int nuevaPosicion = tablero.nuevaPosicion(3,tirada); // las casillas van de la 0 a la n
//        System.out.println("Tu nueva posicion es la " + nuevaPosicion);
/*
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
        System.out.println("El jugador actual es:" + juego.getJugadorActual().getNombre());
        ArrayList<Casilla> casillas = juego.getTablero().getCasillas();
        for(int i = 0; i<casillas.size();i++){
            System.out.println(casillas.get(i).toString());
        }
    }
    */
    
}
