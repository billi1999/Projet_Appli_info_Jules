/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.*;
import Creation_Objet.Employe;
import java.util.*;

/**
 *
 * @author Jules
 */
public class EmployeDAO extends DAO<Employe> {

    @Override
    public Employe read(int idemp) throws SQLException {
        String request = "select * from PRO_EMPLOYE where idemp= ?";
        try (PreparedStatement pstm = dbConnect.prepareStatement(request)) {
            pstm.setInt(1, idemp);
            try (ResultSet rs = pstm.executeQuery()) {
                if (rs.next()) {
                String mat = rs.getString("MATRICULE");
                String nom = rs.getString("NOM");
                String pre = rs.getString("PRENOM");
                int idbur = rs.getInt("IDBUR");
                return new Employe(idemp, mat, nom, pre, idbur);
            } else{
                throw new SQLException("idemp introuvable");
            }

        } catch (SQLException e) {
            throw e;
        }

    }
    }

    @Override
    public Employe create(Employe obj) throws SQLException {
        assert obj != null : "L'employe ne peut être null";
        String request1 = "insert into PRO_EMPLOYE(MATRICULE,NOM,PRENOM,IDBUR)values(?,?,?,?)";
        String request2 = "select idemp from PRO_EMPLOYE where MATRICULE=? and NOM=? and PRENOM=? and IDBUR=?";
        try (PreparedStatement pstm1 = dbConnect.prepareStatement(request1);
                PreparedStatement pstm2 = dbConnect.prepareStatement(request2)) {
            pstm1.setString(1, obj.getMatricule());
            pstm1.setString(2, obj.getNom());
            pstm1.setString(3, obj.getPrenom());
            pstm1.setInt(4, obj.getIdbur());
            
            int n = pstm1.executeUpdate();
            if (n == 0) {
                throw new SQLException("Impossible de créer un Employé, aucune ligne insérée");

            }
            pstm2.setString(1, obj.getMatricule());
            pstm2.setString(2, obj.getNom());
            pstm2.setString(3, obj.getPrenom());
            pstm2.setInt(4, obj.getIdbur());
            try (ResultSet rs = pstm2.executeQuery()) {
                if (rs.next()) {
                    int idemp = rs.getInt(1);
                    obj.setIdemp(idemp);
                    return read(idemp);
                } else {
                    throw new SQLException("Impossible de de lire l'idemp");
                }
            } catch (SQLException e) {
                System.out.println("Impossible d'executer la query (create emp) :"+e);
                return obj;
            }

        }

    }

    @Override
    public Employe update(Employe obj) throws SQLException {
        String request = "update PRO_EMPLOYE set MATRICULE=?,NOM=?,PRENOM=?,IDBUR=? where idemp=?";
        try (PreparedStatement pstm = dbConnect.prepareStatement(request)) {
            pstm.setString(1, obj.getMatricule());
            pstm.setString(2, obj.getNom());
            pstm.setString(3, obj.getPrenom());
            pstm.setInt(4, obj.getIdbur());
            pstm.setInt(5,obj.getIdemp());
                    
            int n = pstm.executeUpdate();
            //return null;
            if (n == 0) {
                throw new SQLException("\nAucun employé n'a été mit à jour");

            } else {
                System.out.println("\nEmployé mis à jour !");
            }
        }
        return obj;
    }

    @Override
    public void delete(Employe obj) throws SQLException {
        String request = "delete from PRO_EMPLOYE where MATRICULE=?";
        try (PreparedStatement pstm = dbConnect.prepareStatement(request)) {
            pstm.setString(1, obj.getMatricule());
            int n = pstm.executeUpdate();
            if (n == 0) {
                throw new SQLException("Aucun record trouvé : l'employé n'existe pas");
            } else {
                System.out.println("Employé supprimé !");
            }

        } catch (SQLException e) {
            System.out.println("erreur dans la suppression (delete employe) :" + e);
        }

    }

    /*
    public List<Employe> rechNom(String nomrech) throws SQLException {
        List<Employe> listeEmploye = new ArrayList();
        String request = "select* from pro_employe where nom like ?";
        try (PreparedStatement pstm = dbConnect.prepareStatement(request)) {
            pstm.setString(1, "%" + nomrech + "%");
            try (ResultSet rs = pstm.executeQuery()) {
                boolean found = false;
                while (rs.next()) {
                    found = true;

                    int idemp = rs.getInt("IDEMP");
                    String matricule = rs.getString("MATRICULE");
                    String nom = rs.getString("NOM");
                    String pre = rs.getString("PRENOM");
                    int idbur = rs.getInt("idbur");
                    listeEmploye.add(new Employe(idemp, matricule, nom, pre, idbur));
                }
                if (!found) {
                    throw new SQLException("Bureau introuvable");
                } else {
                    return listeEmploye;
                }

            }
        }
    }
     */

    public List<Employe> rechbur(int idburrech) throws SQLException {
        List<Employe> listeEmp = new ArrayList();
        String request = "select * from PRO_CLIENT where idbur=?";
        try (PreparedStatement pstm = dbConnect.prepareStatement(request)) {
            pstm.setInt(1, idburrech);
            try (ResultSet rs = pstm.executeQuery()) {
                boolean found = false;

                while (rs.next()) {
                    found = true;

                    int idemp = rs.getInt("idemp");
                    String matricule = rs.getString("MATRICULE");
                    String nom = rs.getString("NOM");
                    String pre = rs.getString("PRENOM");
                    int idbur = rs.getInt("idbur");
                    listeEmp.add(new Employe(idemp, matricule, nom, pre, idbur));
                }
                if (!found) {
                    throw new SQLException("idbur introuvable");
                } else {
                    return listeEmp;
                }
            }

        }
    }

}
