package pdp.userinfo.pojo;
// default package



/**
 * AbstractRater entity provides the base persistence definition of the Rater entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractRater  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String name;
     private Integer status;


    // Constructors

    /** default constructor */
    public AbstractRater() {
    }

    
    /** full constructor */
    public AbstractRater(String name, Integer status) {
        this.name = name;
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

    public Integer getStatus() {
        return this.status;
    }
    
    public void setStatus(Integer status) {
        this.status = status;
    }
   








}