/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;

import civitas.CasillaCalle;

/**
 *
 * @author Jesus Martin
 */
public class PropiedadPanel extends javax.swing.JPanel {
    CasillaCalle tituloPropiedad;
    /**
     * Creates new form PropiedadesPanel
     */
    public PropiedadPanel() {
        initComponents();
    }
    
    protected void setPropiedad(CasillaCalle titulo) {
        this.tituloPropiedad = titulo;
        textNombrePropiedad.setText(titulo.getNombre());
        textNumCasas.setText(Integer.toString(titulo.getNumCasas()));
        textNumHoteles.setText(Integer.toString(titulo.getNumHoteles()));
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

        nombrePropiedad = new javax.swing.JLabel();
        numCasas = new javax.swing.JLabel();
        numHoteles = new javax.swing.JLabel();
        textNombrePropiedad = new javax.swing.JTextField();
        textNumCasas = new javax.swing.JTextField();
        textNumHoteles = new javax.swing.JTextField();

        nombrePropiedad.setText("Nombre");

        numCasas.setText("nº casas");

        numHoteles.setText("nº hoteles");

        textNombrePropiedad.setEditable(false);
        textNombrePropiedad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textNombrePropiedadActionPerformed(evt);
            }
        });

        textNumCasas.setEditable(false);
        textNumCasas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textNumCasasActionPerformed(evt);
            }
        });

        textNumHoteles.setEditable(false);
        textNumHoteles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textNumHotelesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(numHoteles)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(nombrePropiedad)
                        .addComponent(numCasas)))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(textNumCasas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(textNombrePropiedad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(textNumHoteles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombrePropiedad)
                    .addComponent(textNombrePropiedad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(numCasas)
                    .addComponent(textNumCasas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(numHoteles)
                    .addComponent(textNumHoteles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void textNumCasasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textNumCasasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textNumCasasActionPerformed

    private void textNombrePropiedadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textNombrePropiedadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textNombrePropiedadActionPerformed

    private void textNumHotelesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textNumHotelesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textNumHotelesActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel nombrePropiedad;
    private javax.swing.JLabel numCasas;
    private javax.swing.JLabel numHoteles;
    private javax.swing.JTextField textNombrePropiedad;
    private javax.swing.JTextField textNumCasas;
    private javax.swing.JTextField textNumHoteles;
    // End of variables declaration//GEN-END:variables
}
