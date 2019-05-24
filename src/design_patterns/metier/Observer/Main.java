/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package design_patterns.metier.Observer;

/**
 *
 * @author Jules
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Bureau b1=new Bureau(1,"a","a","a");
        Bureau b2=new Bureau(2,"b","b","b");
        Employe e1=new Employe(1,"cl1","cl1","cl1",1);
        Employe e2=new Employe(2,"cl2","cl2","cl2",1);
        //on ajoute le fait que les employés soit mist au courant lors d'un chengement de bureau
        e1.addObserver(b1);
        e2.addObserver(b2);
        
       //on vérifie les observer
        e1.setIdbur(1);
        e2.setIdbur(2);
     
    }
    
}
