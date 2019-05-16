package design_patterns.metier.Builder;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Jules
 */
public class Message {

    private int idmsg;
    private String contenu;
    private LocalDate dateEnvoi;
    private Set<Employe> liste = new HashSet<>();

  

    public Message(MessageBuilder mb) {
        this.idmsg = mb.idmsg;
        this.contenu = mb.contenu;
        this.dateEnvoi=LocalDate.now();
        this.liste=mb.liste;
       
    }
    

    public int getIdmsg() {
        return idmsg;
    }

    public void setIdmsg(int idmsg) {
        this.idmsg = idmsg;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public LocalDate getDateEnvoi() {
        return LocalDate.now();
    }
    
    /*public void setDateEnvoi() {
        this.dateEnvoi = LocalDate.now();
    }*/

    public Set<Employe> getListe() {
        return liste;
    }

    public void setListe(Set<Employe> liste) {
        this.liste = liste;
    }



    @Override
    public String toString() {
        return "Message{" + "idmsg=" + idmsg + ", contenu=" + contenu + ", dateEnvoi=" + dateEnvoi + ", liste=" + liste + '}';
    }
    

    public static class MessageBuilder {

        private int idmsg;
        private String contenu;
        private LocalDate dateEnvoi=LocalDate.now();
        //private int idemp;
         private Set<Employe> liste = new HashSet<>();

        public MessageBuilder() {

        }

        public MessageBuilder setIdmsgB(int idmsg) {
            this.idmsg = idmsg;
            return this;
        }

        public MessageBuilder setContenuB(String contenu) {
            this.contenu = contenu;
            return this;
        }
        public MessageBuilder ajoutEmp(Employe e){
            //this.liste.add(e);
            liste.add(e);
            return this;
        }
        /*public MessageBuilder setDateenvoiB() {
          this.dateEnvoi=LocalDate.now();
           return this;
        }*/

        /*public MessageBuilder setidempB(int idemp) {
            this.idemp = idemp;
            return this;
        }*/

        public Message build() throws Exception {
            
            
            if(contenu==null){
                throw new Exception("le contenu ne peut être null");
            }
            if(liste==null){
                throw new Exception("La liste ne peut être null");
            }
            return new Message(this);
        }
    }
}
