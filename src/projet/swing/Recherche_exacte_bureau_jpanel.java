/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet.swing;

import Creation_Objet.Bureau;
import DAO.BureauDAO;
import javax.swing.JOptionPane;

/**
 *
 * @author Jules
 */
public class Recherche_exacte_bureau_jpanel extends javax.swing.JPanel {

    /**
     * Creates new form Recherche_exacte_bureau_jpanel
     */
    BureauDAO burDAO=null;
    Bureau bur=null;
    
   
    public Recherche_exacte_bureau_jpanel() {
        initComponents();
    }
    public void setBureauDAO(BureauDAO burDAO){
        this.burDAO=burDAO;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sigle_rech_text = new javax.swing.JLabel();
        idbur_rech_text = new javax.swing.JLabel();
        tel_rech_text = new javax.swing.JLabel();
        desc_rech_text = new javax.swing.JLabel();
        idbur_rech = new javax.swing.JTextField();
        tel_rech = new javax.swing.JTextField();
        sigle_rech = new javax.swing.JTextField();
        desc_rech = new javax.swing.JTextField();
        bt_maj = new javax.swing.JButton();
        bt_rech = new javax.swing.JButton();
        bt_del = new javax.swing.JButton();

        sigle_rech_text.setText("Sigle :");

        idbur_rech_text.setText("idbur :");

        tel_rech_text.setText("tel :");

        desc_rech_text.setText("description");

        idbur_rech.setMinimumSize(new java.awt.Dimension(50, 20));
        idbur_rech.setPreferredSize(new java.awt.Dimension(150, 30));
        idbur_rech.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idbur_rechActionPerformed(evt);
            }
        });

        tel_rech.setMinimumSize(new java.awt.Dimension(50, 20));
        tel_rech.setPreferredSize(new java.awt.Dimension(150, 30));

        sigle_rech.setMinimumSize(new java.awt.Dimension(50, 20));
        sigle_rech.setPreferredSize(new java.awt.Dimension(150, 30));

        desc_rech.setMinimumSize(new java.awt.Dimension(50, 20));
        desc_rech.setPreferredSize(new java.awt.Dimension(150, 30));

        bt_maj.setText("Mise à jour");
        bt_maj.setPreferredSize(new java.awt.Dimension(150, 30));
        bt_maj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_majActionPerformed(evt);
            }
        });

        bt_rech.setText("Rechercher");
        bt_rech.setPreferredSize(new java.awt.Dimension(150, 30));
        bt_rech.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_rechActionPerformed(evt);
            }
        });

        bt_del.setText("Effaçer");
        bt_del.setPreferredSize(new java.awt.Dimension(150, 30));
        bt_del.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_delActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bt_rech, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bt_maj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addComponent(bt_del, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tel_rech, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(desc_rech_text)
                                    .addComponent(tel_rech_text)
                                    .addComponent(sigle_rech_text)
                                    .addComponent(idbur_rech_text))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(31, 31, 31)
                                        .addComponent(desc_rech, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(sigle_rech, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(idbur_rech, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idbur_rech, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(idbur_rech_text))
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sigle_rech_text)
                    .addComponent(sigle_rech, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tel_rech, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tel_rech_text))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(desc_rech_text)
                    .addComponent(desc_rech, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_maj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_del, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_rech, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void idbur_rechActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idbur_rechActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idbur_rechActionPerformed

    private void bt_majActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_majActionPerformed
        
        try{
            int idbur=Integer.parseInt(idbur_rech.getText());
            String sigle=sigle_rech.getText();
            String tel=tel_rech.getText();
            String desc=desc_rech.getText();
            Bureau bur=new Bureau(idbur,sigle,tel,desc);
            burDAO.update(bur);
            JOptionPane.showMessageDialog(this,"bureau mis à jour","succès",JOptionPane.INFORMATION_MESSAGE);

        }catch(Exception e){
            JOptionPane.showMessageDialog(this, e.getMessage(),"ERREUR",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_bt_majActionPerformed

    private void bt_rechActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_rechActionPerformed
       
        try{
            int idbur=Integer.parseInt(idbur_rech.getText());
            bur=burDAO.read(idbur);
            sigle_rech.setText(bur.getSigle());
            tel_rech.setText(bur.getTel());
            desc_rech.setText(bur.getDescription());
            JOptionPane.showConfirmDialog(this,"bureau trouvé","succès",JOptionPane.INFORMATION_MESSAGE);
        }catch(Exception e){
            JOptionPane.showMessageDialog(this,e.getMessage(),"ERREUR",JOptionPane.ERROR_MESSAGE);

        }
    }//GEN-LAST:event_bt_rechActionPerformed

    private void bt_delActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_delActionPerformed
       
        try{
            int idbur=Integer.parseInt(idbur_rech.getText());
            burDAO.delete(bur);
            idbur_rech.setText("");
            sigle_rech.setText("");
            tel_rech.setText("");
            desc_rech.setText("");
                         JOptionPane.showMessageDialog(this,"bureau effacé","succès",JOptionPane.INFORMATION_MESSAGE);

        }catch(Exception e){
            JOptionPane.showMessageDialog(this,e.getMessage(),"ERREUR",JOptionPane.ERROR_MESSAGE);

        }
    }//GEN-LAST:event_bt_delActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_del;
    private javax.swing.JButton bt_maj;
    private javax.swing.JButton bt_rech;
    private javax.swing.JTextField desc_rech;
    private javax.swing.JLabel desc_rech_text;
    private javax.swing.JTextField idbur_rech;
    private javax.swing.JLabel idbur_rech_text;
    private javax.swing.JTextField sigle_rech;
    private javax.swing.JLabel sigle_rech_text;
    private javax.swing.JTextField tel_rech;
    private javax.swing.JLabel tel_rech_text;
    // End of variables declaration//GEN-END:variables
}
