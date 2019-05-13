package design_patterns.metier.bureau;

/**
 *
 * @author Jules
 */
public class Bureau {

    private int idbur;
    private String sigle;
    private String tel;
    private String desc;

    private Bureau(BureauBuilder bb) {
        this.idbur = bb.idbur;
        this.sigle = bb.sigle;
        this.tel = bb.tel;
        this.desc = bb.desc;
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

    public String getDesc() {
        return desc;
    }

    @Override
    public String toString() {
        return "Bureau{" + "idbur=" + idbur + ", sigle=" + sigle + ", tel=" + tel + ", desc=" + desc + '}';
    }

    public static class BureauBuilder {

        private int idbur;
        private String sigle;
        private String tel;
        private String desc;
        
        public BureauBuilder(){
            
        }
        public BureauBuilder setIdbur(int idbur) {
            this.idbur = idbur;
            return this;
        }

        public BureauBuilder setSigle(String sigle) {
            this.sigle = sigle;
            return this;
        }

        public BureauBuilder setTel(String tel) {
            this.tel = tel;
            return this;
        }

        public BureauBuilder setDesc(String desc) {
            this.desc = desc;
            return this;
        }
       public Bureau build() throws Exception{
           if(sigle==null){
               throw new Exception("idbur ne peut être null");
           }
           if(tel==null){
               throw new Exception("le tel ne peut être null");
           }
                     
           return new Bureau(this);
       } 
    }

}
