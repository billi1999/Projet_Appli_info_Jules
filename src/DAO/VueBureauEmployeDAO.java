/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import Creation_Objet.Employe;
import Creation_Objet.VueBureauEmploye;
import java.sql.*;
import myconnections.DBConnection;
import java.util.*;
/**
 *
 * @author Jules
 */
public class VueBureauEmployeDAO extends DAO<VueBureauEmploye>{
    Connection dbCOnnect=DBConnection.getConnection();
    
    public List<VueBureauEmploye> affVueBurEmp(int idbur)throws SQLException{
    List<VueBureauEmploye> rechEmp = new ArrayList<>();
        String request = "select * from vue_emp_bur where idbur=?";

        try (PreparedStatement pstm = dbConnect.prepareStatement(request)) {
            pstm.setInt(1, idbur);
            try (ResultSet rs = pstm.executeQuery()) {
                boolean found = false;
                while (rs.next()) {
                    found = true;
                    int idemp = rs.getInt("idemp");
                    String mat = rs.getString("matricule");
                    String nom = rs.getString("nom");
                    String prenom = rs.getString("prenom");
                    int idburrech = rs.getInt("idbur");
                    rechEmp.add(new VueBureauEmploye(idemp, mat, nom, prenom, idburrech));
                }
                if (!found) {
                    throw new SQLException("Problème dans ma recherche des employés");

                } else {
                    return rechEmp;
                }
            }catch(SQLException e){
                System.out.println("Impossible d'exeuter la requête (affVueBurEmp)"+e);
            }
        }catch(Exception e){
            System.out.println("Impossible de se connecter a la base de données"+e);
        }
        return rechEmp;
    }
    /*public List<Employe> rechEmploye(int idbur) throws SQLException {
        List<Employe> rechEmp = new ArrayList<>();
        String request = "select * from pro_employe where idbur=?";

        try (PreparedStatement pstm = dbConnect.prepareStatement(request)) {
            pstm.setInt(1, idbur);
            try (ResultSet rs = pstm.executeQuery()) {
                boolean found = false;
                while (rs.next()) {
                    found = true;
                    int idemp = rs.getInt("idemp");
                    String mat = rs.getString("matricule");
                    String nom = rs.getString("nom");
                    String prenom = rs.getString("prenom");
                    int idburrech = rs.getInt("idbur");
                    rechEmp.add(new Employe(idemp, mat, nom, prenom, idburrech));
                }
                if (!found) {
                    throw new SQLException("Problème dans ma recherche des employé");

                } else {
                    return rechEmp;
                }
            }
        }

    } */
    
    @Override
    public VueBureauEmploye read(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public VueBureauEmploye create(VueBureauEmploye obj) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public VueBureauEmploye update(VueBureauEmploye obj) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(VueBureauEmploye obj) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
