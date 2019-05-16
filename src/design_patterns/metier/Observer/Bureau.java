/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package design_patterns.metier.Observer;
import java.util.HashSet;
import java.util.Set;
/**
 *
 * @author Jules
 */
public class Bureau extends Observer {
    private int idbur;
    private String sigle;
    private String tel;
    private String Description;
    protected Set<Employe> mesEmp=new HashSet<>();
   // protected Set<ComFact> mesCommandes = new HashSet<>();
   
    public Bureau(int idbur, String sigle, String tel, String Description) {
        this.idbur = idbur;
        this.sigle = sigle;
        this.tel = tel;
        this.Description = Description;
    }

    
    @Override
    public String toString() {
        return "Bureau{" + "idbur=" + idbur + ", sigle=" + sigle + ", tel=" + tel + ", Description=" + Description + '}';
    }

    
    public int getIdbur() {
        return idbur;
    }

    public void setIdbur(int idbur) {
        this.idbur = idbur;
       
        
    }

    public String getSigle() {
        return sigle;
    }

    public void setSigle(String sigle) {
        this.sigle = sigle;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public Set<Employe> getMesEmp() {
        return mesEmp;
    }

    public void setMesEmp(Set<Employe> mesEmp) {
        this.mesEmp = mesEmp;
    }
    

    @Override
    public void update(String msg) {
        System.out.println("Le bureau n°:"+idbur+" à reçu le message :"+msg);
    }
    
   
    
    
    
    
    
    
    
    
    
    
}
