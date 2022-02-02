/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;

import civitas.CasillaCalle;
import civitas.Jugador;
import java.util.ArrayList;

/**
 *
 * @author Jesus Martin
 */
public class JugadorPanel extends javax.swing.JPanel {

    Jugador jugador;
    
    /**
     * Creates new form JugadorPanel
     */
    public JugadorPanel() {
        initComponents();
    }
    
    protected void setJugador(Jugador jugador){
        this.jugador = jugador;
        textNombre.setText(jugador.getNombre());
        textSaldo.setText(Float.toString(jugador.getSaldo()));
        textEspeculador.setText(Boolean.toString(jugador.isEspeculador()));
        this.rellenaPropiedades(jugador.getPropiedades());
        this.repaint();
        this.revalidate();
    }
    
    private void rellenaPropiedades (ArrayList<CasillaCalle> lista) {
        // Se elimina la información antigua
        listaPropiedades.removeAll();
        // Se recorre la lista de propiedades para ir creando sus vistas individuales y añadirlas al panel
        for (CasillaCalle t : lista) {
            PropiedadPanel vistaPropiedad = new PropiedadPanel();
            vistaPropiedad.setPropiedad(t); 
            listaPropiedades.add(vistaPropiedad);
            vistaPropiedad.setVisible(true);
        }
        // Se fuerza la actualización visual del panel propiedades y del panel del jugador
        this.repaint();
        this.revalidate();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        titulo = new javax.swing.JLabel();
        atributosJugadorPanel = new javax.swing.JPanel();
        nombre = new javax.swing.JLabel();
        textNombre = new javax.swing.JTextField();
        saldo = new javax.swing.JLabel();
        textSaldo = new javax.swing.JTextField();
        especulador = new javax.swing.JLabel();
        textEspeculador = new javax.swing.JTextField();
        propiedadesPanel = new javax.swing.JPanel();
        tituloPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        listaPropiedades = new javax.swing.JPanel();

        setLayout(new java.awt.BorderLayout());

        jPanel1.setLayout(new java.awt.BorderLayout());

        titulo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo.setText("Jugador Actual");
        jPanel1.add(titulo, java.awt.BorderLayout.NORTH);

        nombre.setText("nombre");
        atributosJugadorPanel.add(nombre);

        textNombre.setEditable(false);
        textNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textNombreActionPerformed(evt);
            }
        });
        atributosJugadorPanel.add(textNombre);

        saldo.setText("saldo");
        atributosJugadorPanel.add(saldo);

        textSaldo.setEditable(false);
        atributosJugadorPanel.add(textSaldo);

        especulador.setText("especulador");
        atributosJugadorPanel.add(especulador);

        textEspeculador.setEditable(false);
        atributosJugadorPanel.add(textEspeculador);

        jPanel1.add(atributosJugadorPanel, java.awt.BorderLayout.CENTER);

        add(jPanel1, java.awt.BorderLayout.NORTH);

        propiedadesPanel.setLayout(new java.awt.BorderLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Propiedades");
        tituloPanel.add(jLabel2);

        propiedadesPanel.add(tituloPanel, java.awt.BorderLayout.NORTH);

        listaPropiedades.setLayout(new javax.swing.BoxLayout(listaPropiedades, javax.swing.BoxLayout.LINE_AXIS));
        propiedadesPanel.add(listaPropiedades, java.awt.BorderLayout.CENTER);

        add(propiedadesPanel, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void textNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textNombreActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel atributosJugadorPanel;
    private javax.swing.JLabel especulador;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel listaPropiedades;
    private javax.swing.JLabel nombre;
    private javax.swing.JPanel propiedadesPanel;
    private javax.swing.JLabel saldo;
    private javax.swing.JTextField textEspeculador;
    private javax.swing.JTextField textNombre;
    private javax.swing.JTextField textSaldo;
    private javax.swing.JLabel titulo;
    private javax.swing.JPanel tituloPanel;
    // End of variables declaration//GEN-END:variables
}