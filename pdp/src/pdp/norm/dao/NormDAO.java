package pdp.norm.dao;
// default package

import ccb.dao.BaseHibernateDAO;
import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pdp.norm.pojo.Norm;

/**
 	* A data access object (DAO) providing persistence and search support for Norm entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .Norm
  * @author MyEclipse Persistence Tools 
 */

public class NormDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(NormDAO.class);
		//property constants
	public static final String NAME = "name";
	public static final String TYPE = "type";
	public static final String LEVEL = "level";
	public static final String TARGET = "target";
	public static final String SCORE = "score";
	public static final String RULE = "rule";
	public static final String REMARK = "remark";



    
    public void save(Norm transientInstance) {
        log.debug("saving Norm instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(Norm persistentInstance) {
        log.debug("deleting Norm instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public Norm findById( java.lang.Integer id) {
        log.debug("getting Norm instance with id: " + id);
        try {
            Norm instance = (Norm) getSession()
                    .get("Norm", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(Norm instance) {
        log.debug("finding Norm instance by example");
        try {
            List results = getSession()
                    .createCriteria("Norm")
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
      log.debug("finding Norm instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from Norm as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByName(Object name
	) {
		return findByProperty(NAME, name
		);
	}
	
	public List findByType(Object type
	) {
		return findByProperty(TYPE, type
		);
	}
	
	public List findByLevel(Object level
	) {
		return findByProperty(LEVEL, level
		);
	}
	
	public List findByTarget(Object target
	) {
		return findByProperty(TARGET, target
		);
	}
	
	public List findByScore(Object score
	) {
		return findByProperty(SCORE, score
		);
	}
	
	public List findByRule(Object rule
	) {
		return findByProperty(RULE, rule
		);
	}
	
	public List findByRemark(Object remark
	) {
		return findByProperty(REMARK, remark
		);
	}
	

	public List findAll() {
		log.debug("finding all Norm instances");
		try {
			String queryString = "from Norm";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public Norm merge(Norm detachedInstance) {
        log.debug("merging Norm instance");
        try {
            Norm result = (Norm) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(Norm instance) {
        log.debug("attaching dirty Norm instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(Norm instance) {
        log.debug("attaching clean Norm instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}