
package projet_jules;

import java.sql.*;
import myconnections.DBConnection;
import java.util.*;
import Creation_Objet.Bureau;
import DAO.BureauDAO;





/**
 *
 * @author Jules
 */
public class Projet_Jules {
    //Bureau bur=new Bureau();
     Bureau bur=null;
    
    private BureauDAO BureauDAO;
Scanner sc = new Scanner(System.in);
 Connection dbConnect = DBConnection.getConnection();
 

 
 public void menuDebut() throws SQLException{
    String rep="";
    int choix;
    if(dbConnect==null){
        System.out.print("Problème de connexion à la base de donnée");
        
        System.exit(1);
    }
    BureauDAO =new BureauDAO();
    BureauDAO.setConnection(dbConnect);
    do{
        do{
            
            System.out.println("\nEntrer une valeur pour :\n\t1.Gérer les bureaux\n\t4. Quitter l'application");
            System.out.print("Choix :");
           rep=sc.nextLine();
          
        }while(verifier_chaine(rep,"[1-4]")==false);//mettre [0-4]
        choix=Integer.parseInt(rep);
        switch(choix){
            
            case 1: 
                
                menuBureau();
                break;
            
            case 4:break;
        }
    }while(choix!=4);
    
    
}


public boolean verifier_chaine(String chaine,String regexp){
    return chaine.matches(regexp);
}
public void menuBureau() throws SQLException{
    String rep="";
    int choix;
    do{
            
            System.out.print("\nEntrer une valeur pour :"
                    + "\n\t1.Créer un bureaux"
                    + "\n\t2.Rechercher par sigle(supprimer + maj)"
                    + "\n\t3.Recherche sur base de la description"
                    + "\n\t4.Modifier les éléments d'un sigle"
                    + "\nChoix :");
                    
           rep=sc.nextLine();
        }while(verifier_chaine(rep,"[1-5]")==false);
    choix=Integer.parseInt(rep);
    switch(choix){
        case 1: creationBureau();break;
        case 2: MenuRechercherSigle() ;
                break;
        case 3:rechercherDesc();break;
        case 4:modifierBureau();break;
        
        
        default:break;
    }
    
}
////////////////////////////////////////////////////////////////////////////
//création avec affichage de l'id résultant
public void creationBureau(){
    System.out.print("Sigle :");
    String sigle=sc.nextLine();
    System.out.print("Tel :");
    String tel=sc.nextLine();
    System.out.print("Description :");
    String description=sc.nextLine();
    bur=new Bureau(0,sigle,tel,description);
    //System.out.println(bur);
    try{
      bur=BureauDAO.create(bur);
      System.out.println("\n\tLa valeur de idbur :"+bur.getIdbur()+
              "\n\tSigle :"+bur.getSigle()+
              "\n\tTel :"+bur.getTel()+
              "\n\tDescription :"+bur.getDescription());
    }catch(SQLException e){
        
        System.out.println("Erreur de création(creationBureau) :"+e);
    }
}

public void rechercherDesc(){
    System.out.println("Cherchez un bureau sur base de la description :");
    
    String desc=sc.nextLine();
   try{
       List <Bureau> liste=BureauDAO.rechDescription(desc);
       for (Bureau k: liste){
           System.out.println("Idbur :"+k.getIdbur()+""
                   + "\tSigle :"+k.getSigle()+""
                   + "\tTel :"+k.getTel()+""
                   + "\tDescription :"
                   +k.getDescription());
       }
   }catch(SQLException e){
       System.out.println("erreur (rechercherDesc)"+e);
   }
}


//////////////////////////////////////////////////////////////////////////
public void MenuRechercherSigle() throws SQLException{
    int rep;
    System.out.print("Sigle que vous voulez trouver : ");
    String sigle=sc.nextLine();
    try{
        bur=BureauDAO.readSigle(sigle);
    }catch(SQLException e){
        System.out.println("Impossible de trouver le sigle (MenuRechercherSigle) : "+e);
    }
    
    System.out.println("\nLocal retrouvé !\n\tLa valeur de idbur :"+bur.getIdbur()+
              "\n\tSigle :"+bur.getSigle()+
              "\n\tTel :"+bur.getTel()+
              "\n\tDescription :"+bur.getDescription());
    int choix;
    
        System.out.print("\nEntrer votre choix :"
                + "\n\t1.Modifier le bureau"
                + "\n\t2.Supprimer le bureau"
                + "\n\t3.Retourner au menu");
        choix=sc.nextInt();
   sc.skip("\n");
    
    switch(choix){
        
        case 1: modifierBureau();
            
            break;
            
        case 2:delete();
            break;
        case 3:break;
    }
   
}

public void delete() throws SQLException{
    try{
        BureauDAO.delete(bur);
    }catch(SQLException e){
        System.out.println("\nerreur de suppression :"+e.getMessage());
    }
    menuDebut();
}

public void modifierBureau() throws SQLException {
    int choix;
    do{
        System.out.println("Modifications : "
                + "\n\t1.Modifier téléphone"
                + "\n\t2.Modifier la description"
                + "\n\t3.Retour au menu précédent\nChoix :");
        choix=sc.nextInt();
        sc.skip("\n");
        switch(choix){
            case 1:
                System.out.println("Entrer le numéro de téléphone :");
                String tel=sc.nextLine();
                bur.setTel(tel);
                BureauDAO.update(bur);
                break;
                
            case 2:
                System.out.println("Entrer la nouvelle description :");
                String desc=sc.nextLine();
                bur.setDescription(desc);
                BureauDAO.update(bur);
                
            case 3:
                break;
        }
        
        
    }while(choix!=3);
}
    public static void main(String[] args) throws SQLException {
        Projet_Jules projet=new Projet_Jules();
        projet.menuDebut();
        
    }
}
