package pdp.userinfo.dao;
// default package

import ccb.dao.BaseHibernateDAO;
import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pdp.userinfo.pojo.Rater;
import pdp.userinfo.pojo.UserInfo;

/**
 	* A data access object (DAO) providing persistence and search support for Rater entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .Rater
  * @author MyEclipse Persistence Tools 
 */

public class RaterDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(RaterDAO.class);
		//property constants
	public static final String NAME = "name";
	public static final String STATUS = "status";



    
    public void save(Rater transientInstance) {
        log.debug("saving Rater instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(Rater persistentInstance) {
        log.debug("deleting Rater instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public Rater findById( java.lang.Integer id) {
        log.debug("getting Rater instance with id: " + id);
        try {
            Rater instance = (Rater) getSession()
                    .get("Rater", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(Rater instance) {
        log.debug("finding Rater instance by example");
        try {
            List results = getSession()
                    .createCriteria("Rater")
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
      log.debug("finding Rater instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from Rater as model where model." 
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
	
	public List findByStatus(Object status
	) {
		return findByProperty(STATUS, status
		);
	}
	

	public List findAll() {
		log.debug("finding all Rater instances");
		try {
			String queryString = "from Rater";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public Rater merge(Rater detachedInstance) {
        log.debug("merging Rater instance");
        try {
            Rater result = (Rater) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(Rater instance) {
        log.debug("attaching dirty Rater instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(Rater instance) {
        log.debug("attaching clean Rater instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    /**
     * 
     * @param chu
     * @param innot in 和 not in
     *      * @return
     */
	public String findAllNamesToString(String chu,String innot) {
		log.debug("finding all Rater instances");
		try {
			UserInfoDAO uidao = new UserInfoDAO();
			String chupeople = uidao.findChushiToString(chu);
			String peoples = "";
			String queryString = "from Rater where name "+innot+" ('"+chupeople.replace(",", "','")+"')";
	         Query queryObject = getSession().createQuery(queryString);
	         List<Rater> list = queryObject.list();
	         if(list.size()>0)
	         {
	        	 for(int i=0;i<list.size();i++)
		         {
	        		 Rater r = list.get(i);
		        	 peoples+=r.getName();
		        	 peoples+=",";
		         }
	        	 peoples = peoples.substring(0, peoples.length()-1);
	         }
	         return peoples;
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	public List findAllNamesToList(String chu,String innot) {
		log.debug("finding all Rater instances");
		try {
			UserInfoDAO uidao = new UserInfoDAO();
			String chupeople = uidao.findChushiToString(chu);
			String peoples = "";
			String queryString = "from Rater where name "+innot+" ('"+chupeople.replace(",", "','")+"')";
	         Query queryObject = getSession().createQuery(queryString);
	         return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
}