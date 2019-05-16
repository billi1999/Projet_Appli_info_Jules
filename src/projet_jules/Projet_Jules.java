package projet_jules;

import java.sql.*;
import myconnections.DBConnection;
import java.util.*;
import Creation_Objet.Bureau;
import Creation_Objet.Employe;
import Creation_Objet.VueBureauEmploye;
import DAO.BureauDAO;
import DAO.EmployeDAO;

/**
 *
 * @author Jules
 */
public class Projet_Jules {

    //Bureau bur=new Bureau();
    Bureau bur = null;
    Employe emp = null;

    private BureauDAO BureauDAO;
    private EmployeDAO EmployeDAO;
    Scanner sc = new Scanner(System.in);
    Connection dbConnect = DBConnection.getConnection();

    public void menuDebut() throws SQLException {

        String rep = "";
        int choix;
        if (dbConnect == null) {
            System.out.print("Problème de connexion à la base de donnée");

            System.exit(1);
        }
        BureauDAO = new BureauDAO();
        EmployeDAO = new EmployeDAO();
        BureauDAO.setConnection(dbConnect);
        EmployeDAO.setConnection(dbConnect);
        do {
            do {

                System.out.println("\nEntrer une valeur pour :\n\t1.Gérer les bureaux\n\t2.Gérer les employés\n\t4. Quitter l'application");
                System.out.print("Choix :");
                rep = sc.nextLine();

            } while (verifier_chaine(rep, "[1-4]") == false);//mettre [0-4]
            choix = Integer.parseInt(rep);
            switch (choix) {

                case 1:

                    menuBureau();
                    break;
                case 2:
                    menuEmploye();
                    break;
                case 3:
                    modifierEmploye();
                    break;
                case 4:
                    break;
            }
        } while (choix != 4);

    }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public boolean verifier_chaine(String chaine, String regexp) {
        return chaine.matches(regexp);
    }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public void menuBureau() throws SQLException {
        String rep = "";
        int choix;
        do {

            System.out.print("\nEntrer une valeur pour :"
                    + "\n\t1.Créer un bureaux"
                    + "\n\t2.Rechercher par sigle(supprimer + maj)"
                    + "\n\t3.Recherche sur base de la description"
                    + "\n\t4.Modifier les éléments d'un sigle"
                    + "\nChoix :");

            rep = sc.nextLine();
        } while (verifier_chaine(rep, "[1-5]") == false);
        choix = Integer.parseInt(rep);
        switch (choix) {
            case 1:
                creationBureau();
                break;
            case 2:
                MenuRechercherSigle();
                break;
            case 3:
                rechercherDesc();
                break;
            case 4:
                modifierBureau();
                break;

            default:
                break;
        }

    }
////////////////////////////////////////////////////////////////////////////

    public void menuEmploye() throws SQLException {
        String rep = "";
        int choix;
        do {
            System.out.println("Entrer une valeur pour :"
                    + "\n\t1.Créer un Employé"
                    + "\n\t2.Rechercher par idemp(supprimer + maj)"
                    + "\n\t3.Modifier un employé"
                    + "\nChoix :");
            rep = sc.nextLine();
        } while (verifier_chaine(rep, "[1-5]") == false);
        choix = Integer.parseInt(rep);
        switch (choix) {
            case 1:
                creationEmploye();
                break;
            case 2:
                MenuRechercherIdemp();
                break;

            case 3:
                modifierEmploye();
                break;
            default:
                break;

        }
    }
////////////////////////////////////////////////////////////////////////////
//création avec affichage de l'id résultant

    public void creationBureau() {
        System.out.print("Sigle :");
        String sigle = sc.nextLine();
        System.out.print("Tel :");
        String tel = sc.nextLine();
        System.out.print("Description :");
        String description = sc.nextLine();
        bur = new Bureau(0, sigle, tel, description);
        try {
            bur = BureauDAO.create(bur);
            System.out.println("\n\tLa valeur de idbur :" + bur.getIdbur()
                    + "\n\tSigle :" + bur.getSigle()
                    + "\n\tTel :" + bur.getTel()
                    + "\n\tDescription :" + bur.getDescription());
        } catch (SQLException e) {

            System.out.println("Erreur de création(creationBureau) :" + e);
        }
    }
///////////////////////////////////////////////////////////////////////////

    public void creationEmploye() {
        System.out.print("Matricule :");
        String matr = sc.nextLine();
        System.out.println("Nom :");
        String nom = sc.nextLine();
        System.out.println("Prenom :");
        String pre = sc.nextLine();
        System.out.println("Idbur :");
        int idbur = sc.nextInt();
        sc.skip("\n");
        emp = new Employe(0, matr, nom, pre, idbur);
        try {
            emp = EmployeDAO.create(emp);
            System.out.println("\n\tLa valeur de idemp :" + emp.getIdemp() + ""
                    + "\nMatricule :" + emp.getMatricule() + ""
                    + "\nNom :" + emp.getNom() + ""
                    + "\nPrenom :" + emp.getPrenom() + ""
                    + "\nidbur" + emp.getIdbur());

        } catch (SQLException e) {
            System.out.println("Erreur dans la création (creationEmploye) :" + e);
        }

    }

///////////////////////////////////////////////////////////////////////////
    public void rechercherDesc() {
        System.out.println("Cherchez un bureau sur base de la description :");

        String desc = sc.nextLine();
        try {
            List<Bureau> liste = BureauDAO.rechDescription(desc);
            for (Bureau k : liste) {
                System.out.println("Idbur :" + k.getIdbur() + ""
                        + "\tSigle :" + k.getSigle() + ""
                        + "\tTel :" + k.getTel() + ""
                        + "\tDescription :"
                        + k.getDescription());
            }
        } catch (SQLException e) {
            System.out.println("erreur (rechercherDesc)" + e);
        }
    }

//////////////////////////////////////////////////////////////////////////
    public void MenuRechercherSigle() throws SQLException {
        int rep;
        System.out.print("Sigle que vous voulez trouver : ");
        String sigle = sc.nextLine();
        try {
            bur = BureauDAO.readSigle(sigle);
        } catch (SQLException e) {
            System.out.println("Impossible de trouver le sigle (MenuRechercherSigle) : " + e);
        }

        System.out.println("\nLocal retrouvé !\n\tLa valeur de idbur :" + bur.getIdbur()
                + "\n\tSigle :" + bur.getSigle()
                + "\n\tTel :" + bur.getTel()
                + "\n\tDescription :" + bur.getDescription());
        int choix;

        System.out.print("\nEntrer votre choix :"
                + "\n\t1.Modifier le bureau"
                + "\n\t2.Supprimer le bureau"
                + "\n\t3.afficher tout les employés de ce bureau"
                + "\n\t4.Retourner au menu");

        choix = sc.nextInt();
        sc.skip("\n");

        switch (choix) {

            case 1:
                modifierBureau();

                break;

            case 2:
                deleteBur();
                break;
            case 3:
                rechEmpBur(bur.getIdbur());

                break;
            case 4:
                break;
        }

    }
////////////////////////////////////////////////////////////////////////////

    public void MenuRechercherIdemp() throws SQLException {

        int rep;
        System.out.println("Entrer l'idemp que vous recherchez :");
        int idemp = sc.nextInt();
        sc.skip("\n");
        try {

            emp = EmployeDAO.read(idemp);
            System.out.println("\nEmployé retrouvé !\n\tLa valeur de matricule :" + emp.getMatricule()
                    + "\n\tNom :" + emp.getNom()
                    + "\n\tPrenom :" + emp.getPrenom()
                    + "\n\tIdbur :" + emp.getIdbur());

        } catch (SQLException e) {
            System.out.println("Impossible de trouver l'idemp (MenuRechercherIdemp)" + e);

        }

        int choix;
        System.out.println("\nEntrer votre choix :"
                + "\n\t1.Modifier le client"
                + "\n\t2.Supprimer le client"
                + "\n\t3.Retourner au menu");
        choix = sc.nextInt();
        sc.skip("\n");
        switch (choix) {
            case 1:
                modifierEmploye();
                break;
            case 2:
                deleteEmp();
                break;
            case 3:
                break;
        }

    }
////////////////////////////////////////////////////////////////////////////

    public void deleteBur() throws SQLException {
        try {
            BureauDAO.delete(bur);
            bur = null;
        } catch (SQLException e) {
            System.out.println("\nerreur de suppression :" + e.getMessage());

        }
        menuDebut();
    }
////////////////////////////////////////////////////////////////////////////

    public void deleteEmp() throws SQLException {
        try {
            EmployeDAO.delete(emp);
            emp = null;

        } catch (SQLException e) {
            System.out.println("\nerreur de suppression :" + e.getMessage());

        }

        menuDebut();
    }
////////////////////////////////////////////////////////////////////////////

    public void modifierBureau() throws SQLException {
        int choix;
        do {
            System.out.println("Modifications : "
                    + "\n\t1.Modifier téléphone"
                    + "\n\t2.Modifier la description"
                    + "\n\t3.Retour au menu précédent\nChoix :");
            choix = sc.nextInt();
            sc.skip("\n");
            switch (choix) {
                case 1:
                    System.out.println("Entrer le numéro de téléphone :");
                    String tel = sc.nextLine();
                    bur.setTel(tel);
                    BureauDAO.update(bur);
                    break;

                case 2:
                    System.out.println("Entrer la nouvelle description :");
                    String desc = sc.nextLine();
                    bur.setDescription(desc);
                    BureauDAO.update(bur);

                case 3:
                    break;
            }

        } while (choix != 3);
    }
////////////////////////////////////////////////////////////////////////////

    public void modifierEmploye() throws SQLException {
        int choix;
        do {
            System.out.println("Mdifications :"
                    + "\n\t1.Modifier matricule"
                    + "\n\t2.Modifier le nom"
                    + "\n\t3.Modifier le prénom"
                    + "\n\t4.Retour au menu précédent\nChoix :");
            choix = sc.nextInt();
            sc.skip("\n");
            switch (choix) {
                case 1:
                    System.out.println("Entrer le matricule :");
                    String mat = sc.nextLine();
                    emp.setMatricule(mat);
                    EmployeDAO.update(emp);
                    break;
                case 2:
                    System.out.println("Entrer le nom :");
                    String nom = sc.nextLine();
                    emp.setNom(nom);
                    EmployeDAO.update(emp);
                    break;
                case 3:
                    System.out.println("Entrer le prenom :");
                    String pre = sc.nextLine();
                    emp.setNom(pre);
                    EmployeDAO.update(emp);
                    break;
                case 4:
                    break;

            }

        } while (choix != 4);
    }

    public void rechercherDesce() {
        System.out.println("Cherchez un bureau sur base de la description :");

        String desc = sc.nextLine();
        try {
            List<Bureau> liste = BureauDAO.rechDescription(desc);
            for (Bureau k : liste) {
                System.out.println("Idbur :" + k.getIdbur() + ""
                        + "\tSigle :" + k.getSigle() + ""
                        + "\tTel :" + k.getTel() + ""
                        + "\tDescription :"
                        + k.getDescription());
            }
        } catch (SQLException e) {
            System.out.println("erreur (rechercherDesc)" + e);
        }
    }

    private void rechEmpBur(int idbur) {
        /*System.out.println("Entrer le bureau dont vous voulez les emp :");
        int idburrech = sc.nextInt();*/
        try {
            List<VueBureauEmploye> listeEmp = BureauDAO.rechEmploye(idbur);
            for (VueBureauEmploye e : listeEmp) {
                System.out.println("\nidemp :" + e.getIdemp()
                        + "\n\tMatricule :" + e.getMatricule()
                        + "\n\tNom :" + e.getNom()
                        + "\n\tPrenom :" + e.getPrenom()
                        + "\n\tidbur :" + idbur);
            }
        } catch (SQLException e) {
            System.out.println("erreur (rechEmpBur)" + e);
        }
    }
////////////////////////////////////////////////////////////////////////////

    public static void main(String[] args) throws SQLException {
        Projet_Jules projet = new Projet_Jules();
        projet.menuDebut();

    }

}
