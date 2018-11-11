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
    public Position(String name, String chu, String tuan, String norma, String normpropa, String normb, String normpropb, String normc, String normpropc, String normd, String normpropd, Double propa, Double propb, Double propc, Double propd, Integer status) {
        super(name, chu, tuan, norma, normpropa, normb, normpropb, normc, normpropc, normd, normpropd, propa, propb, propc, propd, status);        
    }
   
}
