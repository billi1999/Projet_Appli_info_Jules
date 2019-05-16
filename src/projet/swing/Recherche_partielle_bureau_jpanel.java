/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet.swing;

import Creation_Objet.Bureau;
import DAO.BureauDAO;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jules
 */
public class Recherche_partielle_bureau_jpanel extends javax.swing.JPanel {

    /**
     * Creates new form Recherche_partielle_bureau_jpanel
     */
    BureauDAO burDAO=null;
    DefaultTableModel dft1=new DefaultTableModel();
    public Recherche_partielle_bureau_jpanel() {
        initComponents();
        dft1.addColumn("idbur");
        dft1.addColumn("Sigle");
        dft1.addColumn("tel");
        dft1.addColumn("description");
        Table_rech_par.setModel(dft1);
        
    }
    public void setBureauDao(BureauDAO burDAO){
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

        jScrollPane1 = new javax.swing.JScrollPane();
        Table_rech_par = new javax.swing.JTable();
        nom_rech = new javax.swing.JTextField();
        desc_rech = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        Table_rech_par.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "idbur", "sigle", "tel", "description"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(Table_rech_par);

        nom_rech.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nom_rechActionPerformed(evt);
            }
        });

        desc_rech.setText("Description :");

        jLabel1.setText("Recherche partielle dans la table bureau");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(82, 82, 82)
                                .addComponent(desc_rech)
                                .addGap(81, 81, 81)
                                .addComponent(nom_rech, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(129, 129, 129)
                                .addComponent(jLabel1)))
                        .addGap(0, 42, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nom_rech, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(desc_rech))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void nom_rechActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nom_rechActionPerformed
        try{
            String rech=nom_rech.getText();
            List<Bureau> lbur=burDAO.rechDescription(rech);
            int i=dft1.getRowCount();
            for(int j=i-1;j>=0;j--){
                dft1.removeRow(j);
            }
            for(Bureau bur:lbur){
                Vector v=new Vector();
                v.add(bur.getIdbur());
                v.add(bur.getSigle());
                v.add(bur.getTel());
                v.add(bur.getDescription());
                dft1.addRow(v);
            }
        }catch(Exception e){
           JOptionPane.showMessageDialog(this,e.getMessage(),"ERREUR",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_nom_rechActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Table_rech_par;
    private javax.swing.JLabel desc_rech;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nom_rech;
    // End of variables declaration//GEN-END:variables

}
