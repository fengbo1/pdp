package pdp.userinfo.pojo;
// default package



/**
 * AbstractUserPos entity provides the base persistence definition of the UserPos entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractUserPos  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String username;
     private String newnumber;
     private String pos;


    // Constructors

    /** default constructor */
    public AbstractUserPos() {
    }

    
    /** full constructor */
    public AbstractUserPos(String username, String newnumber, String pos) {
        this.username = username;
        this.newnumber = newnumber;
        this.pos = pos;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }

    public String getNewnumber() {
        return this.newnumber;
    }
    
    public void setNewnumber(String newnumber) {
        this.newnumber = newnumber;
    }

    public String getPos() {
        return this.pos;
    }
    
    public void setPos(String pos) {
        this.pos = pos;
    }
   








}