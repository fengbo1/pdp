package pdp.score.dao;
// default package

import ccb.dao.BaseHibernateDAO;
import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pdp.score.pojo.Score;

/**
 	* A data access object (DAO) providing persistence and search support for Score entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .Score
  * @author MyEclipse Persistence Tools 
 */

public class ScoreDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(ScoreDAO.class);
		//property constants
	public static final String NEWNUMBER = "newnumber";
	public static final String NAME = "name";
	public static final String POSITIONNAME = "positionname";
	public static final String POSITIONCHU = "positionchu";
	public static final String POSITIONTUAN = "positiontuan";
	public static final String POSITIONZU = "positionzu";
	public static final String SCOREA = "scorea";
	public static final String SCOREB = "scoreb";
	public static final String SCOREC = "scorec";
	public static final String SCORED = "scored";
	public static final String PROPA = "propa";
	public static final String PROPB = "propb";
	public static final String PROPC = "propc";
	public static final String PROPD = "propd";
	public static final String SCORE = "score";
	public static final String YEAR = "year";
	public static final String SEASON = "season";



    
    public void save(Score transientInstance) {
        log.debug("saving Score instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(Score persistentInstance) {
        log.debug("deleting Score instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public Score findById( java.lang.Integer id) {
        log.debug("getting Score instance with id: " + id);
        try {
            Score instance = (Score) getSession()
                    .get("Score", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(Score instance) {
        log.debug("finding Score instance by example");
        try {
            List results = getSession()
                    .createCriteria("Score")
                    .add(Example.create(instance))
            .list();
            log.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }    
    
    public List findByProperty(String propertyName, Object value) {
      log.debug("finding Score instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from Score as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByNewnumber(Object newnumber
	) {
		return findByProperty(NEWNUMBER, newnumber
		);
	}
	
	public List findByName(Object name
	) {
		return findByProperty(NAME, name
		);
	}
	
	public List findByPositionname(Object positionname
	) {
		return findByProperty(POSITIONNAME, positionname
		);
	}
	
	public List findByPositionchu(Object positionchu
	) {
		return findByProperty(POSITIONCHU, positionchu
		);
	}
	
	public List findByPositiontuan(Object positiontuan
	) {
		return findByProperty(POSITIONTUAN, positiontuan
		);
	}
	
	public List findByPositionzu(Object positionzu
	) {
		return findByProperty(POSITIONZU, positionzu
		);
	}
	
	public List findByScorea(Object scorea
	) {
		return findByProperty(SCOREA, scorea
		);
	}
	
	public List findByScoreb(Object scoreb
	) {
		return findByProperty(SCOREB, scoreb
		);
	}
	
	public List findByScorec(Object scorec
	) {
		return findByProperty(SCOREC, scorec
		);
	}
	
	public List findByScored(Object scored
	) {
		return findByProperty(SCORED, scored
		);
	}
	
	public List findByPropa(Object propa
	) {
		return findByProperty(PROPA, propa
		);
	}
	
	public List findByPropb(Object propb
	) {
		return findByProperty(PROPB, propb
		);
	}
	
	public List findByPropc(Object propc
	) {
		return findByProperty(PROPC, propc
		);
	}
	
	public List findByPropd(Object propd
	) {
		return findByProperty(PROPD, propd
		);
	}
	
	public List findByScore(Object score
	) {
		return findByProperty(SCORE, score
		);
	}
	
	public List findByYear(Object year
	) {
		return findByProperty(YEAR, year
		);
	}
	
	public List findBySeason(Object season
	) {
		return findByProperty(SEASON, season
		);
	}
	

	public List findAll() {
		log.debug("finding all Score instances");
		try {
			String queryString = "from Score";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public Score merge(Score detachedInstance) {
        log.debug("merging Score instance");
        try {
            Score result = (Score) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(Score instance) {
        log.debug("attaching dirty Score instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(Score instance) {
        log.debug("attaching clean Score instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}