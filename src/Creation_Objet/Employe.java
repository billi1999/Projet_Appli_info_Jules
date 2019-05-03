
package Creation_Objet;

import java.util.Objects;

public class Employe {
    protected int idemp;
    protected String Matricule;
    protected String nom;
    protected String prenom;
    protected int idbur;

    public Employe(int idemp, String Matricule, String nom, String prenom, int idbur) {
        this.idemp = idemp;
        this.Matricule = Matricule;
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
        return Matricule;
    }

    public void setMatricule(String Matricule) {
        this.Matricule = Matricule;
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
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Employe other = (Employe) obj;
        if (this.idemp != other.idemp) {
            return false;
        }
        if (this.idbur != other.idbur) {
            return false;
        }
        if (!Objects.equals(this.Matricule, other.Matricule)) {
            return false;
        }
        if (!Objects.equals(this.nom, other.nom)) {
            return false;
        }
        if (!Objects.equals(this.prenom, other.prenom)) {
            return false;
        }
        return true;
    }

    
    @Override
    public String toString() {
        return "Employe{" + "idemp=" + idemp + ", Matricule=" + Matricule + ", nom=" + nom + ", prenom=" + prenom + ", idbur=" + idbur + '}';
    }

    

    
}
