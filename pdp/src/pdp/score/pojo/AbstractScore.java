package pdp.score.pojo;
// default package



/**
 * AbstractScore entity provides the base persistence definition of the Score entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractScore  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String newnumber;
     private String name;
     private String positionname;
     private String positionchu;
     private String positiontuan;
     private String positionzu;
     private Double scorea;
     private Double scoreb;
     private Double scorec;
     private Double scored;
     private Double propa;
     private Double propb;
     private Double propc;
     private Double propd;
     private Double score;
     private Integer year;
     private Integer season;


    // Constructors

    /** default constructor */
    public AbstractScore() {
    }

    
    /** full constructor */
    public AbstractScore(String newnumber, String name, String positionname, String positionchu, String positiontuan, String positionzu, Double scorea, Double scoreb, Double scorec, Double scored, Double propa, Double propb, Double propc, Double propd, Double score, Integer year, Integer season) {
        this.newnumber = newnumber;
        this.name = name;
        this.positionname = positionname;
        this.positionchu = positionchu;
        this.positiontuan = positiontuan;
        this.positionzu = positionzu;
        this.scorea = scorea;
        this.scoreb = scoreb;
        this.scorec = scorec;
        this.scored = scored;
        this.propa = propa;
        this.propb = propb;
        this.propc = propc;
        this.propd = propd;
        this.score = score;
        this.year = year;
        this.season = season;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public String getNewnumber() {
        return this.newnumber;
    }
    
    public void setNewnumber(String newnumber) {
        this.newnumber = newnumber;
    }

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public String getPositionname() {
        return this.positionname;
    }
    
    public void setPositionname(String positionname) {
        this.positionname = positionname;
    }

    public String getPositionchu() {
        return this.positionchu;
    }
    
    public void setPositionchu(String positionchu) {
        this.positionchu = positionchu;
    }

    public String getPositiontuan() {
        return this.positiontuan;
    }
    
    public void setPositiontuan(String positiontuan) {
        this.positiontuan = positiontuan;
    }

    public String getPositionzu() {
        return this.positionzu;
    }
    
    public void setPositionzu(String positionzu) {
        this.positionzu = positionzu;
    }

    public Double getScorea() {
        return this.scorea;
    }
    
    public void setScorea(Double scorea) {
        this.scorea = scorea;
    }

    public Double getScoreb() {
        return this.scoreb;
    }
    
    public void setScoreb(Double scoreb) {
        this.scoreb = scoreb;
    }

    public Double getScorec() {
        return this.scorec;
    }
    
    public void setScorec(Double scorec) {
        this.scorec = scorec;
    }

    public Double getScored() {
        return this.scored;
    }
    
    public void setScored(Double scored) {
        this.scored = scored;
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

    public Double getScore() {
        return this.score;
    }
    
    public void setScore(Double score) {
        this.score = score;
    }

    public Integer getYear() {
        return this.year;
    }
    
    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getSeason() {
        return this.season;
    }
    
    public void setSeason(Integer season) {
        this.season = season;
    }
   








}