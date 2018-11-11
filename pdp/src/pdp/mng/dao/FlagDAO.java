package pdp.mng.dao;
// default package

import ccb.dao.BaseHibernateDAO;
import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pdp.mng.pojo.Flag;

/**
 	* A data access object (DAO) providing persistence and search support for Flag entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .Flag
  * @author MyEclipse Persistence Tools 
 */

public class FlagDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(FlagDAO.class);
		//property constants
	public static final String YEAR = "year";
	public static final String SEASON = "season";
	public static final String FLAG = "flag";
	public static final String ISNEW = "isnew";



    
    public void save(Flag transientInstance) {
        log.debug("saving Flag instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(Flag persistentInstance) {
        log.debug("deleting Flag instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public Flag findById( java.lang.Integer id) {
        log.debug("getting Flag instance with id: " + id);
        try {
            Flag instance = (Flag) getSession()
                    .get("Flag", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(Flag instance) {
        log.debug("finding Flag instance by example");
        try {
            List results = getSession()
                    .createCriteria("Flag")
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
      log.debug("finding Flag instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from Flag as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
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
	
	public List findByFlag(Object flag
	) {
		return findByProperty(FLAG, flag
		);
	}
	
	public List findByIsnew(Object isnew
	) {
		return findByProperty(ISNEW, isnew
		);
	}
	

	public List findAll() {
		log.debug("finding all Flag instances");
		try {
			String queryString = "from Flag";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public Flag merge(Flag detachedInstance) {
        log.debug("merging Flag instance");
        try {
            Flag result = (Flag) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(Flag instance) {
        log.debug("attaching dirty Flag instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(Flag instance) {
        log.debug("attaching clean Flag instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}