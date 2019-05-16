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
        Employe e3=new Employe(3,"cl3","cl3","cl3",2);
        Employe e4=new Employe(4,"cl4","cl4","cl4",2);
        e1.addObserver(b1);
        e2.addObserver(b1);
        
       
        e1.setIdbur(2);
        e2.setIdbur(2);
       //b1.addObserver(e1);
    }
    
}
