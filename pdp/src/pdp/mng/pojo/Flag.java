package pdp.mng.pojo;
// default package



/**
 * Flag entity. @author MyEclipse Persistence Tools
 */
public class Flag extends AbstractFlag implements java.io.Serializable {

    // Constructors

    /** default constructor */
    public Flag() {
    }

    
    /** full constructor */
    public Flag(Integer year, Integer season, Integer flag, Integer isnew) {
        super(year, season, flag, isnew);        
    }
   
}
