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
     private String norma;
     private String normpropa;
     private String normb;
     private String normpropb;
     private String normc;
     private String normpropc;
     private String normd;
     private String normpropd;
     private Double propa;
     private Double propb;
     private Double propc;
     private Double propd;
     private Integer status;


    // Constructors

    /** default constructor */
    public AbstractPosition() {
    }

    
    /** full constructor */
    public AbstractPosition(String name, String chu, String tuan, String norma, String normpropa, String normb, String normpropb, String normc, String normpropc, String normd, String normpropd, Double propa, Double propb, Double propc, Double propd, Integer status) {
        this.name = name;
        this.chu = chu;
        this.tuan = tuan;
        this.norma = norma;
        this.normpropa = normpropa;
        this.normb = normb;
        this.normpropb = normpropb;
        this.normc = normc;
        this.normpropc = normpropc;
        this.normd = normd;
        this.normpropd = normpropd;
        this.propa = propa;
        this.propb = propb;
        this.propc = propc;
        this.propd = propd;
        this.status = status;
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

    public String getNorma() {
        return this.norma;
    }
    
    public void setNorma(String norma) {
        this.norma = norma;
    }

    public String getNormpropa() {
        return this.normpropa;
    }
    
    public void setNormpropa(String normpropa) {
        this.normpropa = normpropa;
    }

    public String getNormb() {
        return this.normb;
    }
    
    public void setNormb(String normb) {
        this.normb = normb;
    }

    public String getNormpropb() {
        return this.normpropb;
    }
    
    public void setNormpropb(String normpropb) {
        this.normpropb = normpropb;
    }

    public String getNormc() {
        return this.normc;
    }
    
    public void setNormc(String normc) {
        this.normc = normc;
    }

    public String getNormpropc() {
        return this.normpropc;
    }
    
    public void setNormpropc(String normpropc) {
        this.normpropc = normpropc;
    }

    public String getNormd() {
        return this.normd;
    }
    
    public void setNormd(String normd) {
        this.normd = normd;
    }

    public String getNormpropd() {
        return this.normpropd;
    }
    
    public void setNormpropd(String normpropd) {
        this.normpropd = normpropd;
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

    public Integer getStatus() {
        return this.status;
    }
    
    public void setStatus(Integer status) {
        this.status = status;
    }
   








}