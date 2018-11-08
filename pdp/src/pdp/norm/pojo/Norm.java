package pdp.norm.pojo;
// default package



/**
 * Norm entity. @author MyEclipse Persistence Tools
 */
public class Norm extends AbstractNorm implements java.io.Serializable {

    // Constructors

    /** default constructor */
    public Norm() {
    }

	/** minimal constructor */
    public Norm(String name, String type, String level) {
        super(name, type, level);        
    }
    
    /** full constructor */
    public Norm(String name, String type, String level, String target, Double score, String rule, String remark) {
        super(name, type, level, target, score, rule, remark);        
    }
   
}
