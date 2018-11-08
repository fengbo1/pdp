package pdp.pos.pojo;
// default package



/**
 * Position entity. @author MyEclipse Persistence Tools
 */
public class Position extends AbstractPosition implements java.io.Serializable {

    // Constructors

    /** default constructor */
    public Position() {
    }

    
    /** full constructor */
    public Position(String name, String chu, String tuan, String kpinorma, String kpinormpropa, String ktinormb, String ktinormpropb, String kcinormc, String kcinormpropc, String kcinormd, String kcinormpropd, Double propa, Double propb, Double propc, Double propd) {
        super(name, chu, tuan, kpinorma, kpinormpropa, ktinormb, ktinormpropb, kcinormc, kcinormpropc, kcinormd, kcinormpropd, propa, propb, propc, propd);        
    }
   
}
