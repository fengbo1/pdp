package pdp.score.pojo;
// default package



/**
 * Score entity. @author MyEclipse Persistence Tools
 */
public class Score extends AbstractScore implements java.io.Serializable {

    // Constructors

    /** default constructor */
    public Score() {
    }

    
    /** full constructor */
    public Score(String newnumber, String name, String positionname, String positionchu, String positiontuan, String positionzu, Double scorea, Double scoreb, Double scorec, Double scored, Double propa, Double propb, Double propc, Double propd, Double score, Integer year, Integer season) {
        super(newnumber, name, positionname, positionchu, positiontuan, positionzu, scorea, scoreb, scorec, scored, propa, propb, propc, propd, score, year, season);        
    }
   
}
