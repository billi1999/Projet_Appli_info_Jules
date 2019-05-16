/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package design_patterns.metier.Observer;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/**
 *
 * @author Jules
 */
public class Employe extends Subject{
    private int idemp;
    private String matricule;
    private String nom;
    private String prenom;
    private int idbur;
    

    public Employe(int idemp, String matricule, String nom, String prenom, int idbur) {
        this.idemp = idemp;
        this.matricule = matricule;
        this.nom = nom;
        this.prenom = prenom;
        this.idbur = idbur;
    }
    public Employe(){
        
    }
    
    @Override
    public String toString() {
        return "Employe{" + "idemp=" + idemp + ", matricule=" + matricule + ", nom=" + nom + ", prenom=" + prenom + ", idbur=" + idbur + '}';
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
        notifyObservers();
    }

    public List<Observer> getMyObservers() {
        return myObservers;
    }

    public void setMyObservers(List<Observer> myObservers) {
        this.myObservers = myObservers;
    }

    @Override
    public String getNotification() {
        return "nouveau bureau :"+idbur;
    }
    
    
    
    
}
