/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Creation_Objet;

import java.util.Objects;

/**
 *
 * @author Jules
 */
public class Bureau {

    protected int idbur;
    protected String sigle;
    protected String tel;
    protected String description;

    
/**
 * fonction qui va vérifier si l'objet bureau est fonctionnel au travers de test
 * @param obj
 * @return booléen
 *  
 */
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
        final Bureau other = (Bureau) obj;
        if (this.idbur != other.idbur) {
            return false;
        }
        if (!Objects.equals(this.sigle, other.sigle)) {
            return false;
        }
        if (!Objects.equals(this.tel, other.tel)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        return true;
    }
/**
 * Constructeur vide du bureau
 */
    public Bureau() {
    }
/**
 * 
 * @param idbur
 * @param sigle
 * @param tel
 * @param description 
 * constructeur remplit du bureau
 */
    public Bureau(int idbur, String sigle, String tel, String description) {
        this.idbur = idbur;
        this.sigle = sigle;
        this.tel = tel;
        this.description = description;
    }
/**fonction pour obtenir l'identité du bureau
 * 
 * @return l'id du bureau
 */
    public int getIdbur() {
        return idbur;
    }
/**fonction pour obtenir le sigle du bureau
 * 
 * @return le sigle du bureau
 */
    public String getSigle() {
        return sigle;
    }
/**fonction pour obtenir le téléphone du bureau
 * 
 * @return le numéro de téléphone
 */
    public String getTel() {
        return tel;
    }
/**fonction pour obtenir la description du bureau
 * 
 * @return la description
 */
    public String getDescription() {
        return description;
    }
/**méthode pour mettre à jour l'id du bureau
 * 
 * @param idbur 
 */
    public void setIdbur(int idbur) {
        this.idbur = idbur;
    }
/**méthode pour mettre à jour le Sigle du bureau
 * 
 * @param sigle 
 */
    public void setSigle(String sigle) {
        this.sigle = sigle;
    }
/**méthode pour mettre à jour le téléphone du bureau
 * 
 * @param tel 
 */
    public void setTel(String tel) {
        this.tel = tel;
    }
/**méthode pour mettre à jour la description
 * 
 * @param description 
 */
    public void setDescription(String description) {
        this.description = description;
    }
/**méthode pour afficher le contenu de l'objet
 * 
 * @return 
 */
    @Override
    public String toString() {
        return "Bureau{" + "idbur=" + idbur + ", sigle=" + sigle + ", tel=" + tel + ", description=" + description + '}';
    }

}
