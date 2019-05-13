/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet.swing;

import DAO.BureauDAO;
import DAO.EmployeDAO;
import java.awt.CardLayout;
import java.sql.Connection;
import javax.swing.JOptionPane;
import myconnections.DBConnection;

/**
 *
 * @author Jules
 */
public class Gestion extends javax.swing.JFrame {

    /**
     * Creates new form gestionBureau
     */
    CardLayout cardl;
    public Gestion() {
        initComponents();
        cardl=(CardLayout)this.getContentPane().getLayout();
        Connection dbConnect = DBConnection.getConnection();
    if (dbConnect == null) {
            System.out.println("connection invalide");
            JOptionPane.showMessageDialog(this,"connexion invalide","ERREUR",JOptionPane.ERROR_MESSAGE);
    }
    BureauDAO burDAO=new BureauDAO();
    burDAO.setConnection(dbConnect);
    creation_bureau_jpanel.setBureauDAO(burDAO);
    recherche_exacte_bureau_jpanel.setBureauDAO(burDAO);
    recherche_partielle_bureau_jpanel.setBureauDao(burDAO);
    
    EmployeDAO empDAO=new EmployeDAO();
    empDAO.setConnection(dbConnect);
    creation_employe_jpanel1.setEmployeDAO(empDAO);
    recherche_exacte_employe_jpanel1.setEmployeDAO(empDAO);
    
    
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        creation_bureau_jpanel = new projet.swing.Creation_bureau_jpanel();
        recherche_exacte_bureau_jpanel = new projet.swing.Recherche_exacte_bureau_jpanel();
        recherche_partielle_bureau_jpanel = new projet.swing.Recherche_partielle_bureau_jpanel();
        creation_employe_jpanel1 = new projet.swing.Creation_employe_jpanel();
        recherche_exacte_employe_jpanel1 = new projet.swing.Recherche_exacte_employe_jpanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuBureau = new javax.swing.JMenu();
        itemCreateBureau = new javax.swing.JMenuItem();
        itemRechEx = new javax.swing.JMenuItem();
        ItemRechPar = new javax.swing.JMenuItem();
        menuEmploye = new javax.swing.JMenu();
        itemCreaEmp = new javax.swing.JMenuItem();
        itemRechEmp = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.CardLayout());
        getContentPane().add(creation_bureau_jpanel, "cardCreateBureau");
        getContentPane().add(recherche_exacte_bureau_jpanel, "cardRechExactBureau");
        getContentPane().add(recherche_partielle_bureau_jpanel, "cardRechPartBureau");
        getContentPane().add(creation_employe_jpanel1, "cardCreateEmploye");
        getContentPane().add(recherche_exacte_employe_jpanel1, "cardRechExactEmploye");

        menuBureau.setText("Bureau");

        itemCreateBureau.setText("Creer bureau");
        itemCreateBureau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemCreateBureauActionPerformed(evt);
            }
        });
        menuBureau.add(itemCreateBureau);

        itemRechEx.setText("Recherche Exacte");
        itemRechEx.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemRechExActionPerformed(evt);
            }
        });
        menuBureau.add(itemRechEx);

        ItemRechPar.setText("Recherche partielle");
        ItemRechPar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ItemRechParActionPerformed(evt);
            }
        });
        menuBureau.add(ItemRechPar);

        jMenuBar1.add(menuBureau);

        menuEmploye.setText("Employe");

        itemCreaEmp.setText("Création Employé");
        itemCreaEmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemCreaEmpActionPerformed(evt);
            }
        });
        menuEmploye.add(itemCreaEmp);

        itemRechEmp.setText("RechercheEmploye");
        itemRechEmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemRechEmpActionPerformed(evt);
            }
        });
        menuEmploye.add(itemRechEmp);

        jMenuBar1.add(menuEmploye);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void itemCreateBureauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemCreateBureauActionPerformed
        cardl.show(this.getContentPane(), "cardCreateBureau");
    }//GEN-LAST:event_itemCreateBureauActionPerformed

    private void itemRechExActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemRechExActionPerformed
       cardl.show(this.getContentPane(), "cardRechExactBureau");
    }//GEN-LAST:event_itemRechExActionPerformed

    private void ItemRechParActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ItemRechParActionPerformed
       cardl.show(this.getContentPane(),"cardRechPartBureau");
    }//GEN-LAST:event_ItemRechParActionPerformed

    private void itemCreaEmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemCreaEmpActionPerformed
       cardl.show(this.getContentPane(), "cardCreateEmploye");
    }//GEN-LAST:event_itemCreaEmpActionPerformed

    private void itemRechEmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemRechEmpActionPerformed
       cardl.show(this.getContentPane(), "cardRechExactEmploye");
    }//GEN-LAST:event_itemRechEmpActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Gestion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Gestion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Gestion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Gestion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Gestion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem ItemRechPar;
    private projet.swing.Creation_bureau_jpanel creation_bureau_jpanel;
    private projet.swing.Creation_employe_jpanel creation_employe_jpanel1;
    private javax.swing.JMenuItem itemCreaEmp;
    private javax.swing.JMenuItem itemCreateBureau;
    private javax.swing.JMenuItem itemRechEmp;
    private javax.swing.JMenuItem itemRechEx;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu menuBureau;
    private javax.swing.JMenu menuEmploye;
    private projet.swing.Recherche_exacte_bureau_jpanel recherche_exacte_bureau_jpanel;
    private projet.swing.Recherche_exacte_employe_jpanel recherche_exacte_employe_jpanel1;
    private projet.swing.Recherche_partielle_bureau_jpanel recherche_partielle_bureau_jpanel;
    // End of variables declaration//GEN-END:variables

}