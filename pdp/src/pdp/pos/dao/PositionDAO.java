package pdp.pos.dao;
// default package

import ccb.dao.BaseHibernateDAO;
import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pdp.pos.pojo.Position;

/**
 	* A data access object (DAO) providing persistence and search support for Position entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .Position
  * @author MyEclipse Persistence Tools 
 */

public class PositionDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(PositionDAO.class);
		//property constants
	public static final String NAME = "name";
	public static final String CHU = "chu";
	public static final String TUAN = "tuan";
	public static final String NORMA = "norma";
	public static final String NORMPROPA = "normpropa";
	public static final String NORMB = "normb";
	public static final String NORMPROPB = "normpropb";
	public static final String NORMC = "normc";
	public static final String NORMPROPC = "normpropc";
	public static final String NORMD = "normd";
	public static final String NORMPROPD = "normpropd";
	public static final String PROPA = "propa";
	public static final String PROPB = "propb";
	public static final String PROPC = "propc";
	public static final String PROPD = "propd";
	public static final String STATUS = "status";



    
    public void save(Position transientInstance) {
        log.debug("saving Position instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(Position persistentInstance) {
        log.debug("deleting Position instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public Position findById( java.lang.Integer id) {
        log.debug("getting Position instance with id: " + id);
        try {
            Position instance = (Position) getSession()
                    .get("Position", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(Position instance) {
        log.debug("finding Position instance by example");
        try {
            List results = getSession()
                    .createCriteria("Position")
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
      log.debug("finding Position instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from Position as model where model." 
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
	
	public List findByChu(Object chu
	) {
		return findByProperty(CHU, chu
		);
	}
	
	public List findByTuan(Object tuan
	) {
		return findByProperty(TUAN, tuan
		);
	}
	
	public List findByNorma(Object norma
	) {
		return findByProperty(NORMA, norma
		);
	}
	
	public List findByNormpropa(Object normpropa
	) {
		return findByProperty(NORMPROPA, normpropa
		);
	}
	
	public List findByNormb(Object normb
	) {
		return findByProperty(NORMB, normb
		);
	}
	
	public List findByNormpropb(Object normpropb
	) {
		return findByProperty(NORMPROPB, normpropb
		);
	}
	
	public List findByNormc(Object normc
	) {
		return findByProperty(NORMC, normc
		);
	}
	
	public List findByNormpropc(Object normpropc
	) {
		return findByProperty(NORMPROPC, normpropc
		);
	}
	
	public List findByNormd(Object normd
	) {
		return findByProperty(NORMD, normd
		);
	}
	
	public List findByNormpropd(Object normpropd
	) {
		return findByProperty(NORMPROPD, normpropd
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
	
	public List findByStatus(Object status
	) {
		return findByProperty(STATUS, status
		);
	}
	

	public List findAll() {
		log.debug("finding all Position instances");
		try {
			String queryString = "from Position";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public Position merge(Position detachedInstance) {
        log.debug("merging Position instance");
        try {
            Position result = (Position) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(Position instance) {
        log.debug("attaching dirty Position instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(Position instance) {
        log.debug("attaching clean Position instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}