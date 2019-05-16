/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package design_patterns.metier.Builder;

/**
 *
 * @author Jules
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Employe e1=new Employe();
        e1.setId(1);
         Employe e2=new Employe();
        e1.setId(3);
        
        try{
            Message mess=new Message.MessageBuilder().
                    setContenuB("blabla").
                    ajoutEmp(e1).
                    ajoutEmp(e2).
                    setIdmsgB(1).
                    build();
                    
            System.out.println(mess);
        }catch(Exception e){
            System.out.println("Impossible de créer l'objet 1 :"+e);
        }
    }
}
