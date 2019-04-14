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
public class Bureau {

    protected int idbur;
    protected String sigle;
    protected String tel;
    protected String description;

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
