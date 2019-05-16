package DAO;

import java.sql.*;

import java.util.*;
import Creation_Objet.Bureau;
/*import Creation_Objet.Employe;*/
import Creation_Objet.VueBureauEmploye;

public class BureauDAO extends DAO<Bureau> {//réimplémenter les méthodes

    /**
     * affichage des valeurs d'un bureau sur base de son sigle
     *
     * @param Sigle
     * @return Bureau trouvé
     * @throws SQLException
     */
    public Bureau readSigle(String Sigle) throws SQLException {

        String request = "select * from PRO_BUREAU where SIGLE=?";
        try (PreparedStatement pstm = dbConnect.prepareStatement(request)) {
            pstm.setString(1, Sigle);
            try (ResultSet rs = pstm.executeQuery()) {
                //System.out.println("ok "+Sigle);
                if (rs.next()) {

                    int idbur = rs.getInt("IDBUR");
                    String tel = rs.getString("TEL");
                    String desc = rs.getString("DESCRIPTION");
                    return new Bureau(idbur, Sigle, tel, desc);

                } else {
                    throw new SQLException("problème de lecture avec le sigle");
                }
            }

        }

    }

    /**
     * crée un local sur base des valeurs entrée dans le main
     *
     * @param obj
     * @return Bureau créé
     * @throws SQLException
     */
    @Override//création avec affichage de l'id résultant
    public Bureau create(Bureau obj) throws SQLException {
        assert obj != null : "Le Bureau ne peut pas être null!";
        String request1 = "insert into PRO_BUREAU(SIGLE,TEL,DESCRIPTION) values (?,?,?)";
        String request2 = "select IDBUR from PRO_BUREAU where SIGLE=? and TEL=? and DESCRIPTION=?";
        try (PreparedStatement pstm1 = dbConnect.prepareStatement(request1);
                PreparedStatement pstm2 = dbConnect.prepareStatement(request2)) {
            pstm1.setString(1, obj.getSigle());
            pstm1.setString(2, obj.getTel());
            pstm1.setString(3, obj.getDescription());

            int n = pstm1.executeUpdate();
            if (n == 0) {
                throw new SQLException("Impossible de créer un bureau, aucune ligne insérée");

            }
            pstm2.setString(1, obj.getSigle());
            pstm2.setString(2, obj.getTel());
            pstm2.setString(3, obj.getDescription());
            try (ResultSet rs = pstm2.executeQuery()) {
                if (rs.next()) {
                    int idbur = rs.getInt(1);
                    obj.setIdbur(idbur);
                    return read(idbur);
                } else {
                    throw new SQLException("Impossible de creer l'objet avec l'idbur");
                }
            } catch (SQLException e) {
                System.out.println("Problème creation bureau: " + e);
                return null;
            }

        }
    }

    /**
     * Mets à jour un bureau en fonction de son identifiant
     *
     * @param obj
     * @return obj (objet mit à jour)
     * @throws SQLException
     */
    @Override//modification des informations d'un élément dont indique le sigle
    public Bureau update(Bureau obj) throws SQLException {
        //Bureau a = null;
        //String request = "update PRO_BUREAU set DESCRIPTION=?,TEL=? where SIGLE=?";
        String request = "update PRO_BUREAU set DESCRIPTION=?,TEL=?, SIGLE=? where idbur =?";
        try (PreparedStatement pstm = dbConnect.prepareStatement(request)) {
            pstm.setString(1, obj.getDescription());
            pstm.setString(2, obj.getTel());
            pstm.setString(3, obj.getSigle());
            pstm.setInt(4, obj.getIdbur());
            int n = pstm.executeUpdate();
            if (n == 0) {
                throw new SQLException("\nAucun bureau n'a été mit à jour");

            } else {
                System.out.println("\nBureau mis à jour !");
            }

            return obj;
        }
    }

    /**
     * bureau à effacer en fonction de son identifiant
     *
     * @param obj
     * @throws SQLException
     */
    @Override//effacement d'un élément dont on indique le sigle
    public void delete(Bureau obj) throws SQLException {
        String request = "delete from PRO_BUREAU where sigle=?";
        try (PreparedStatement pstm = dbConnect.prepareStatement(request)) {

            pstm.setString(1, obj.getSigle());
            int n = pstm.executeUpdate();

            if (n == 0) {
                throw new SQLException("Aucun record trouvé : le bureau n'existe pas ");
            } else {
                System.out.println("Bureau supprimé ! ");
            }

        }
    }

    /**
     * Bureau à retrouver grâce à l'id
     *
     * @param idbur
     * @return bureau trouvé
     * @throws SQLException
     */
    @Override
    public Bureau read(int idbur) throws SQLException {
        String request = "select * from PRO_BUREAU where IDBUR=?";
        try (PreparedStatement pstm = dbConnect.prepareStatement(request)) {
            pstm.setInt(1, idbur);
            try (ResultSet rs = pstm.executeQuery()) {
                if (rs.next()) {
                    String sigle = rs.getString("SIGLE");
                    String tel = rs.getString("TEL");
                    String description = rs.getString("DESCRIPTION");
                    return new Bureau(idbur, sigle, tel, description);
                } else {
                    throw new SQLException("Idbur introuvable ");
                }
            }
        } catch (SQLException e) {
            throw e;
            //System.out.println("Erreur lors de la lecture: " + e);
            //return null;
        }
    }

    /**
     * Liste de bureau trouvé dans une liste en focntion d'une description
     *
     * @param descriptionrech
     * @return liste de bureaux trouvé
     * @throws SQLException
     */
    public List<Bureau> rechDescription(String descriptionrech) throws SQLException {

        List<Bureau> listeBureau = new ArrayList<>();

        String request = "select * from PRO_BUREAU where description like ? ";

        try (PreparedStatement pstm = dbConnect.prepareStatement(request)) {
            pstm.setString(1, "%" + descriptionrech + "%");
            try (ResultSet rs = pstm.executeQuery()) {
                boolean found = false;
                while (rs.next()) {

                    found = true;

                    int idbur = rs.getInt("IDBUR");
                    String Sigle = rs.getString("SIGLE");
                    String tel = rs.getString("TEL");
                    String desc = rs.getString("DESCRIPTION");

                    listeBureau.add(new Bureau(idbur, Sigle, tel, desc));
                }

                if (!found) {
                    throw new SQLException("Bureau introuvable");
                } else {
                    return listeBureau;
                }
            }
        }

    }

    public List<VueBureauEmploye> rechEmploye(int idbur) throws SQLException {
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
                    throw new SQLException("Problème dans la recherche des employé");

                } else {
                    return rechEmp;
                }
            }
        }

    }

}
