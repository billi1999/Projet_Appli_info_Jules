/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Creation_Objet;

/**
 *
 * @author Jules
 */
public class VueBureauEmploye {
    protected int idemp;
    protected String matricule;
    protected String nom;
    protected String prenom;
    protected int idbur;

    public VueBureauEmploye(int idemp, String matricule, String nom, String prenom, int idbur) {
        this.idemp = idemp;
        this.matricule = matricule;
        this.nom = nom;
        this.prenom = prenom;
        this.idbur = idbur;
    }

    public int getIdemp() {
        return idemp;
    }

    public void setIdemp(int idemp) {
        this.idemp = idemp;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getIdbur() {
        return idbur;
    }

    public void setIdbur(int idbur) {
        this.idbur = idbur;
    }

    @Override
    public String toString() {
        return "VueBureauEmploye{" + "idemp=" + idemp + ", matricule=" + matricule + ", nom=" + nom + ", prenom=" + prenom + ", idbur=" + idbur + '}';
    }
}
