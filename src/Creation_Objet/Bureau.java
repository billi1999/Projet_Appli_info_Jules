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

    public Bureau() {
    }

    public Bureau(int idbur, String sigle, String tel, String description) {
        this.idbur = idbur;
        this.sigle = sigle;
        this.tel = tel;
        this.description = description;
    }

    public int getIdbur() {
        return idbur;
    }

    public String getSigle() {
        return sigle;
    }

    public String getTel() {
        return tel;
    }

    public String getDescription() {
        return description;
    }

    public void setIdbur(int idbur) {
        this.idbur = idbur;
    }

    public void setSigle(String sigle) {
        this.sigle = sigle;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Bureau{" + "idbur=" + idbur + ", sigle=" + sigle + ", tel=" + tel + ", description=" + description + '}';
    }

}
