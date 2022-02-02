/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package civitas;

import GUI.Dado;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author jesus
 */
public class CivitasJuego {
    private int indiceJugadorActual;
    private Tablero tablero;
    private MazoSorpresas mazo;
    private EstadoJuego estado;
    private ArrayList<Jugador> jugadores;
    private GestorEstados gestor;
    
    // tira el dado y se mueve a la casilla nueva
    private void avanzaJugador(){
        Jugador jugadorActual = this.getJugadorActual();
        int posicionActual = jugadorActual.getCasillaActual();
        int tirada = Dado.getInstance().tirar();
        int posicionNueva = tablero.nuevaPosicion(posicionActual, tirada);
        Casilla casilla = tablero.getCasilla(posicionNueva);
        this.contabilizarPasosPorSalida();
        jugadorActual.moverACasilla(posicionNueva);
        casilla.recibeJugador(this.indiceJugadorActual, this.jugadores);
    }
    
    // Le añado por parametro el modo debug porque lo pone en el PDF
    public CivitasJuego(ArrayList<String> nombres, boolean debug){
        //Inicializar jugadores
        this.jugadores = new ArrayList();
        for(int i = 0; i < nombres.size(); i++){
            this.jugadores.add(new Jugador(nombres.get(i)));
        }
        // Crear el gestor de estados
        this.gestor = new GestorEstados();
        // Inicializar estado
        this.estado = gestor.estadoInicial();
        // Dado en  modo debug/no debug segun el argumento del constructor
        Dado.getInstance().setDebug(debug);
        // Inicializar el indice del jugador actual
        this.indiceJugadorActual = Dado.getInstance().quienEmpieza(this.jugadores.size());
        // Mazo en modo debug/no debug segun el argumento del constructor
        this.mazo = new MazoSorpresas(debug);
        // Inicializar tablero
        this.tablero = new Tablero();
        this.inicializaTablero(mazo);
        // Inicializar Mazo Sorpresas
        this.inicializaMazoSorpresas();
    }
    public boolean comprar(){
        Jugador jugador = this.getJugadorActual();
        int numCasillaActual = jugador.getCasillaActual();
        CasillaCalle casilla = (CasillaCalle) tablero.getCasilla(numCasillaActual);
        return jugador.comprar(casilla);
    }
    // este método delega totalmente en el método con el mismo nombre del jugador actual
    public boolean construirCasa(int ip){
        return this.getJugadorActual().construirCasa(ip);
    }
    // este método delega totalmente en el método con el mismo nombre del jugador actua
    public boolean construirHotel(int ip){
        return this.getJugadorActual().construirHotel(ip);
    }
    /*
    si el método 
    computarPasoPorSalida del tablero devuelve true, se llama al método pasaPorSalida del 
    jugador pasado como parámetro. Al llamar a ese método el jugador actual cobra el premio 
    por pasar por la salida
    */
    /*
    Comentado porque habia 2 en el pdf
    
    private void contabilizarPasosPorSalida(Jugador jugadorActual){
       if(this.tablero.computarPasoPorSalida()){
           jugadorActual.pasaPorSalida();
           jugadorActual.recibe(Jugador.PasoPorSalida);
       }
    }
    */
    //  este método devuelve true si alguno de los jugadores está en bancarrota
    public boolean finalDelJuego(){
        for(int i = 0; i < this.jugadores.size(); i++){
            if(this.jugadores.get(i).enBancarrota()){
                return true;
            }
        }
        return false;
    }
    public int getIndiceJugadorActual(){
        return this.indiceJugadorActual;
    }
    public Jugador getJugadorActual(){
        return this.jugadores.get(this.indiceJugadorActual);
    }
    public ArrayList<Jugador> getJugadores(){
        return this.jugadores;
    }
    public Tablero getTablero(){
        return this.tablero;
    }
    // este método crea todas las cartas sorpresa y las almacena en el mazo de sorpresas ya creado en el constructor.
    private void inicializaMazoSorpresas(){
        this.mazo.alMazo(new SorpresaPAGARCOBRAR("han robado en una de tus propiedades, debes abonar 300 euros para reponer lo robado",-300));
        this.mazo.alMazo(new SorpresaPAGARCOBRAR("el techo de una de tus propiedades se cae, debes abonar 500 euros para repararlo",-500));
        this.mazo.alMazo(new SorpresaPAGARCOBRAR("una de tus propiedades ha volado en pedazos, debes abonar 1000 euros para reconstruirla como estaba",-1000));
        this.mazo.alMazo(new SorpresaPAGARCOBRAR("alguien se ha olvidado en esta casilla 500 euros, recibes 500 euros",500));
        this.mazo.alMazo(new SorpresaPAGARCOBRAR("una persona anonima te ha donado 100 euros, recibes 100 euros",100));
        this.mazo.alMazo(new SorpresaPAGARCOBRAR("eres muy afortunado, has ganado 1000 euros en la lotería de ayer",1000));
        this.mazo.alMazo(new SorpresaPORCASAHOTEL("lo siento, te quitamos 50 por cada casa u hotel que tengas",-50));
        this.mazo.alMazo(new SorpresaPORCASAHOTEL("lo siento, te quitamos 70 por cada casa u hotel que tengas",-70));
        this.mazo.alMazo(new SorpresaPORCASAHOTEL("enhorabuena, has ganado 50 por cada casa u hotel que tengas",50));
        this.mazo.alMazo(new SorpresaPORCASAHOTEL("enhorabuena, has ganado 100 por cada casa u hotel que tengas",100));
        this.mazo.alMazo(new Sorpresa("te encontraste una poción en el suelo, la tomaste y te convirtió en un especulador"));
        
    }
    //este método añade al tablero todas las casillas, las cuales se van creando conforme se añaden
    private void inicializaTablero(MazoSorpresas mazo){  //                                 C   S   D
        this.tablero.añadeCasilla(new Casilla("Salida")); // descanso                               1
        this.tablero.añadeCasilla(new  CasillaCalle("Ceuta",200,100,50)); // calle           1
        this.tablero.añadeCasilla(new  CasillaCalle("Granada",300,150,100)); // calle        2
        this.tablero.añadeCasilla(new  CasillaCalle("Cádiz",100,20,50)); // calle            3
        this.tablero.añadeCasilla(new CasillaSorpresa("Córdoba",mazo)); // sorpresa              1
        this.tablero.añadeCasilla(new  CasillaCalle("Sevilla",450,200,150)); // calle        4
        this.tablero.añadeCasilla(new  CasillaCalle("Huelva",350,200,120)); // calle         5
        this.tablero.añadeCasilla(new  CasillaCalle("Málaga",400,300,200)); // calle         6
        this.tablero.añadeCasilla(new CasillaSorpresa("Almería",mazo)); // sorpresa              2
        this.tablero.añadeCasilla(new  CasillaCalle("Barcelona",700,500,400)); // calle      7
        this.tablero.añadeCasilla(new Casilla("Parada")); // descanso                               2
        this.tablero.añadeCasilla(new  CasillaCalle("Madrid",650,450,350)); // calle         8
        this.tablero.añadeCasilla(new  CasillaCalle("Salamanca",400,250,150)); // calle      9
        this.tablero.añadeCasilla(new CasillaSorpresa("León",mazo)); // sorpresa                 3
        this.tablero.añadeCasilla(new  CasillaCalle("Badajoz",400,150,100)); // calle        10
        this.tablero.añadeCasilla(new  CasillaCalle("Cáceres",500,250,200)); // calle        11
        this.tablero.añadeCasilla(new  CasillaCalle("Valencia",700,400,300)); // calle       12
        this.tablero.añadeCasilla(new CasillaSorpresa("Navarra",mazo)); // sorpresa              4
        this.tablero.añadeCasilla(new  CasillaCalle("Soria",400,250,200)); // calle          13
        this.tablero.añadeCasilla(new  CasillaCalle("Albacete",1000,700,500)); // calle      14
        
        
        
    }
    // actualiza el índice del jugador actual como consecuencia del cambio de turno. Se debe poner atención al caso en que el jugador actual sea el último de la lista
    private void pasarTurno(){
        this.indiceJugadorActual++;
        if(this.indiceJugadorActual >= this.jugadores.size()){
            this.indiceJugadorActual = 0;
        }
    }
    /*
    este método ordena la lista de jugadores en función de su 
    saldo. Investiga como ordenar una colección en Java teniendo en cuenta que ya creaste el 
    metodo compareTo para la las instancias de la clase Jugador
    
    Lo he cambiado a public para que se pueda acceder desde VistaTextual
    */
    public ArrayList<Jugador> ranking(){
        ArrayList<Jugador> ranking = this.jugadores;
        for(int i = 0; i < ranking.size()-1; i++){
            for(int j = i+1; j < this.ranking().size(); j++){
                if(ranking.get(i).compareTo(ranking.get(j)) < 0){
                    Jugador aux = ranking.get(i);
                    ranking.set(i, ranking.get(j));
                    ranking.set(j, aux);
                }   
            }
        }
        return ranking;
    }
    public OperacionJuego siguientePaso(){
        Jugador jugadorActual = this.getJugadorActual();
        OperacionJuego operacion = this.gestor.siguienteOperacion(jugadorActual, estado);
        if(operacion == OperacionJuego.PASAR_TURNO){
            this.pasarTurno();
            this.siguientePasoCompletado(operacion);
        }else if(operacion == OperacionJuego.AVANZAR){
            this.avanzaJugador(); // metodo de CivitasJuego: avanzaJugador()
            this.siguientePasoCompletado(operacion);
        }
        return operacion;
    }
    /*
    se actualiza el estado del 
    juego obteniendo el siguiente estado del gestor de estados (método siguienteEstado). Para 
    ello es necesario obtener el jugador actual.
    */
    public void siguientePasoCompletado(OperacionJuego operacion){
        this.estado = gestor.siguienteEstado(this.getJugadorActual(), this.estado, operacion);
    }
    /*
    este método pide al tablero que compruebe y actualice si ha 
    habido paso por salida (método computarPasoPorSalida) y, si la hubo, premia al jugador 
    que pasó por ella (el jugador actual), mediante el método de Jugador pasaPorSalida
    */
    private void contabilizarPasosPorSalida(){
       if(this.tablero.computarPasoPorSalida()){
           this.getJugadorActual().pasaPorSalida();
       }
    }
}
