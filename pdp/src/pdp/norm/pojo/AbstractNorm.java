package pdp.norm.pojo;
// default package



/**
 * AbstractNorm entity provides the base persistence definition of the Norm entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractNorm  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String name;
     private String type;
     private String level;
     private String target;
     private Double score;
     private String rule;
     private String remark;


    // Constructors

    /** default constructor */
    public AbstractNorm() {
    }

	/** minimal constructor */
    public AbstractNorm(String name, String type, String level) {
        this.name = name;
        this.type = type;
        this.level = level;
    }
    
    /** full constructor */
    public AbstractNorm(String name, String type, String level, String target, Double score, String rule, String remark) {
        this.name = name;
        this.type = type;
        this.level = level;
        this.target = target;
        this.score = score;
        this.rule = rule;
        this.remark = remark;
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

    public String getType() {
        return this.type;
    }
    
    public void setType(String type) {
        this.type = type;
    }

    public String getLevel() {
        return this.level;
    }
    
    public void setLevel(String level) {
        this.level = level;
    }

    public String getTarget() {
        return this.target;
    }
    
    public void setTarget(String target) {
        this.target = target;
    }

    public Double getScore() {
        return this.score;
    }
    
    public void setScore(Double score) {
        this.score = score;
    }

    public String getRule() {
        return this.rule;
    }
    
    public void setRule(String rule) {
        this.rule = rule;
    }

    public String getRemark() {
        return this.remark;
    }
    
    public void setRemark(String remark) {
        this.remark = remark;
    }
   








}