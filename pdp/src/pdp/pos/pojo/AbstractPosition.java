package pdp.pos.pojo;
// default package



/**
 * AbstractPosition entity provides the base persistence definition of the Position entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractPosition  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String name;
     private String chu;
     private String tuan;
     private String kpinorma;
     private String kpinormpropa;
     private String ktinormb;
     private String ktinormpropb;
     private String kcinormc;
     private String kcinormpropc;
     private String kcinormd;
     private String kcinormpropd;
     private Double propa;
     private Double propb;
     private Double propc;
     private Double propd;


    // Constructors

    /** default constructor */
    public AbstractPosition() {
    }

    
    /** full constructor */
    public AbstractPosition(String name, String chu, String tuan, String kpinorma, String kpinormpropa, String ktinormb, String ktinormpropb, String kcinormc, String kcinormpropc, String kcinormd, String kcinormpropd, Double propa, Double propb, Double propc, Double propd) {
        this.name = name;
        this.chu = chu;
        this.tuan = tuan;
        this.kpinorma = kpinorma;
        this.kpinormpropa = kpinormpropa;
        this.ktinormb = ktinormb;
        this.ktinormpropb = ktinormpropb;
        this.kcinormc = kcinormc;
        this.kcinormpropc = kcinormpropc;
        this.kcinormd = kcinormd;
        this.kcinormpropd = kcinormpropd;
        this.propa = propa;
        this.propb = propb;
        this.propc = propc;
        this.propd = propd;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public String getChu() {
        return this.chu;
    }
    
    public void setChu(String chu) {
        this.chu = chu;
    }

    public String getTuan() {
        return this.tuan;
    }
    
    public void setTuan(String tuan) {
        this.tuan = tuan;
    }

    public String getKpinorma() {
        return this.kpinorma;
    }
    
    public void setKpinorma(String kpinorma) {
        this.kpinorma = kpinorma;
    }

    public String getKpinormpropa() {
        return this.kpinormpropa;
    }
    
    public void setKpinormpropa(String kpinormpropa) {
        this.kpinormpropa = kpinormpropa;
    }

    public String getKtinormb() {
        return this.ktinormb;
    }
    
    public void setKtinormb(String ktinormb) {
        this.ktinormb = ktinormb;
    }

    public String getKtinormpropb() {
        return this.ktinormpropb;
    }
    
    public void setKtinormpropb(String ktinormpropb) {
        this.ktinormpropb = ktinormpropb;
    }

    public String getKcinormc() {
        return this.kcinormc;
    }
    
    public void setKcinormc(String kcinormc) {
        this.kcinormc = kcinormc;
    }

    public String getKcinormpropc() {
        return this.kcinormpropc;
    }
    
    public void setKcinormpropc(String kcinormpropc) {
        this.kcinormpropc = kcinormpropc;
    }

    public String getKcinormd() {
        return this.kcinormd;
    }
    
    public void setKcinormd(String kcinormd) {
        this.kcinormd = kcinormd;
    }

    public String getKcinormpropd() {
        return this.kcinormpropd;
    }
    
    public void setKcinormpropd(String kcinormpropd) {
        this.kcinormpropd = kcinormpropd;
    }

    public Double getPropa() {
        return this.propa;
    }
    
    public void setPropa(Double propa) {
        this.propa = propa;
    }

    public Double getPropb() {
        return this.propb;
    }
    
    public void setPropb(Double propb) {
        this.propb = propb;
    }

    public Double getPropc() {
        return this.propc;
    }
    
    public void setPropc(Double propc) {
        this.propc = propc;
    }

    public Double getPropd() {
        return this.propd;
    }
    
    public void setPropd(Double propd) {
        this.propd = propd;
    }
   








}