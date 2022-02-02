/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import civitas.Casilla;
import civitas.CivitasJuego;
import civitas.Diario;
import civitas.Jugador;
import civitas.OperacionInmobiliaria;
import civitas.OperacionJuego;
import controladorCivitas.Respuesta;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.util.Scanner;
import controladorCivitas.Respuesta;
import javax.swing.JFrame;

/**
 *
 * @author Jesus Martin
 */
public class CivitasView extends javax.swing.JFrame implements Vista {
    CivitasJuego juego;
    private Scanner in;
    /**
     * Creates new form CivitasView
     */
    public CivitasView() {
        initComponents();
        in = new Scanner (System.in);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    protected void setCivitasJuego( CivitasJuego juego ) {
        this.juego = juego;
        this.setVisible(true);
    }
    
    @Override
    public void mostrarSiguienteOperacion(OperacionJuego operación) {
        textSiguienteOperacion.setText(operación.toString());
        
        if(operación == OperacionJuego.AVANZAR){
            Dado dadoD = Dado.getInstance();
            System.out.print(dadoD.getDebug());
            dadoD.setVisible(true);
        }
        this.repaint();
    }
    
    @Override
    public void actualiza() {
        jugadorPanel.setJugador(this.juego.getJugadorActual());
        casillaPanel.setCasilla(this.juego.getTablero().getCasilla(this.juego.getJugadorActual().getCasillaActual()));
        rankingPanel.setVisible(false);
        // Falta mostrar el ranking al acabar
        if(this.juego.finalDelJuego()){
            rankingPanel.setVisible(true);
            ArrayList<Jugador> clasificacion = this.juego.ranking();
            String clasificacionText = "";
            for (Jugador j : clasificacion) {
                clasificacionText += j.getNombre() + " \n ";
            }
            textRanking.setText(clasificacionText);
            this.repaint();
            this.revalidate();
        }
        
    }
    
    public void pausa() {
        int val = JOptionPane.showConfirmDialog(null, "¿Continuar?", "Siguiente paso", JOptionPane.YES_NO_OPTION);
        if (val==1) System.exit(0);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titulo = new javax.swing.JLabel();
        casillaPanel = new GUI.CasillaPanel();
        jPanel1 = new javax.swing.JPanel();
        siguienteOperacion = new javax.swing.JLabel();
        textSiguienteOperacion = new javax.swing.JTextField();
        rankingPanel = new javax.swing.JPanel();
        ranking = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textRanking = new javax.swing.JTextArea();
        jugadorPanel = new GUI.JugadorPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        titulo.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo.setText("Civitas");
        getContentPane().add(titulo, java.awt.BorderLayout.PAGE_START);
        getContentPane().add(casillaPanel, java.awt.BorderLayout.WEST);

        siguienteOperacion.setText("Siguiente Operacion");
        jPanel1.add(siguienteOperacion);

        textSiguienteOperacion.setEditable(false);
        textSiguienteOperacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textSiguienteOperacionActionPerformed(evt);
            }
        });
        jPanel1.add(textSiguienteOperacion);

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_END);

        rankingPanel.setLayout(new java.awt.BorderLayout());

        ranking.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        ranking.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ranking.setText("Ranking");
        ranking.setVerifyInputWhenFocusTarget(false);
        rankingPanel.add(ranking, java.awt.BorderLayout.NORTH);

        textRanking.setColumns(20);
        textRanking.setRows(5);
        jScrollPane1.setViewportView(textRanking);

        rankingPanel.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        getContentPane().add(rankingPanel, java.awt.BorderLayout.EAST);
        getContentPane().add(jugadorPanel, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void textSiguienteOperacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textSiguienteOperacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textSiguienteOperacionActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private GUI.CasillaPanel casillaPanel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private GUI.JugadorPanel jugadorPanel;
    private javax.swing.JLabel ranking;
    private javax.swing.JPanel rankingPanel;
    private javax.swing.JLabel siguienteOperacion;
    private javax.swing.JTextArea textRanking;
    private javax.swing.JTextField textSiguienteOperacion;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables
    
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
    public Respuesta comprar() {
        int opcion = 1-JOptionPane.showConfirmDialog(null, "¿Quieres comprar la calle actual?", "Compra", JOptionPane.YES_NO_OPTION);
        return Respuesta.values()[opcion];
    }

    @Override
    public OperacionInmobiliaria elegirOperacion() {
        GestionarDialog gestion = new GestionarDialog(this);
        int operacion = gestion.getGestion();
        return OperacionInmobiliaria.values()[operacion];
    }

    @Override
    public int elegirPropiedad() {
        PropiedadDialog propiedadD = new PropiedadDialog(this,juego.getJugadorActual());
        int propiedad = propiedadD.getPropiedad();
        return propiedad;
    }

    @Override
    public void mostrarEventos() {
        if (!Diario.getInstance().getEventos().isEmpty()) {
            DiarioDialog diarioD = new DiarioDialog(this);
        }
    }
    
    @Override
    public void mostrarEstado() {
        if(!juego.finalDelJuego()){
            System.out.println("Es el turno de " + juego.getJugadorActual());
            // Lo he comentado por que es repetitivo que te ponga en que casilla te encuentras todo el rato ya que muestra a que casilla te mueves
            //System.out.println(juegoModel.getTablero().getCasilla(juegoModel.getJugadorActual().getCasillaActual()));
        }else{
            System.out.println("Ranking final: ");
            ArrayList<Jugador> ranking = juego.ranking(); // He tenido que poner publico el metodo ranking() de CivitasJuego
            for(int i = 0; i < ranking.size(); i++){
                System.out.println(ranking.get(i));
            }
        }
    }
}