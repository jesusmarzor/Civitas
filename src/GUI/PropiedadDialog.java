/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package GUI;

import civitas.CasillaCalle;
import civitas.Jugador;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.DefaultListModel;

/**
 *
 * @author Jesus Martin
 */
public class PropiedadDialog extends javax.swing.JDialog {

    int propiedadElegida;
    
    /**
     * Creates new form PropiedadDialog
     */
    public PropiedadDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    public PropiedadDialog(java.awt.Frame parent, Jugador jugador) {
        super(parent, true);
        initComponents();
        this.propiedadElegida = -1;
        setLocationRelativeTo(null);
        DefaultListModel propiedades = new DefaultListModel<>(); // datos para la lista
        ArrayList<CasillaCalle> opciones = jugador.getPropiedades();
        for (CasillaCalle p: opciones){
            propiedades.addElement(p.getNombre());
        } //se completan los datos
        listaPropiedades.setModel(propiedades); //se le dice a la lista cuáles son esos datos
        this.setVisible(true);
        this.repaint();
        this.revalidate();
    }

    public int getPropiedad() {
        return propiedadElegida;
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
        jScrollPane1 = new javax.swing.JScrollPane();
        listaPropiedades = new javax.swing.JList<>();
        ok = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        titulo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo.setText("Propiedades");
        getContentPane().add(titulo, java.awt.BorderLayout.PAGE_START);

        listaPropiedades.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(listaPropiedades);

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

        ok.setText("OK");
        ok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okActionPerformed(evt);
            }
        });
        getContentPane().add(ok, java.awt.BorderLayout.PAGE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void okActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okActionPerformed
        // TODO add your handling code here:
        this.propiedadElegida = listaPropiedades.getSelectedIndex(); 
        this.dispose();
    }//GEN-LAST:event_okActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> listaPropiedades;
    private javax.swing.JButton ok;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables
}