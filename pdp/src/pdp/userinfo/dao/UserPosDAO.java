package pdp.userinfo.dao;
// default package

import ccb.dao.BaseHibernateDAO;
import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pdp.userinfo.pojo.UserPos;

/**
 	* A data access object (DAO) providing persistence and search support for UserPos entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .UserPos
  * @author MyEclipse Persistence Tools 
 */

public class UserPosDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(UserPosDAO.class);
		//property constants
	public static final String USERNAME = "username";
	public static final String NEWNUMBER = "newnumber";
	public static final String POS = "pos";



    
    public void save(UserPos transientInstance) {
        log.debug("saving UserPos instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(UserPos persistentInstance) {
        log.debug("deleting UserPos instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public UserPos findById( java.lang.Integer id) {
        log.debug("getting UserPos instance with id: " + id);
        try {
            UserPos instance = (UserPos) getSession()
                    .get("UserPos", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(UserPos instance) {
        log.debug("finding UserPos instance by example");
        try {
            List results = getSession()
                    .createCriteria("UserPos")
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
      log.debug("finding UserPos instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from UserPos as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByUsername(Object username
	) {
		return findByProperty(USERNAME, username
		);
	}
	
	public List findByNewnumber(Object newnumber
	) {
		return findByProperty(NEWNUMBER, newnumber
		);
	}
	
	public List findByPos(Object pos
	) {
		return findByProperty(POS, pos
		);
	}
	

	public List findAll() {
		log.debug("finding all UserPos instances");
		try {
			String queryString = "from UserPos";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public UserPos merge(UserPos detachedInstance) {
        log.debug("merging UserPos instance");
        try {
            UserPos result = (UserPos) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(UserPos instance) {
        log.debug("attaching dirty UserPos instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(UserPos instance) {
        log.debug("attaching clean UserPos instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}