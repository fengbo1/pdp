package pdp.userinfo.pojo;
// default package



/**
 * UserPos entity. @author MyEclipse Persistence Tools
 */
public class UserPos extends AbstractUserPos implements java.io.Serializable {

    // Constructors

    /** default constructor */
    public UserPos() {
    }

    
    /** full constructor */
    public UserPos(String username, String newnumber, String pos) {
        super(username, newnumber, pos);        
    }
   
}
