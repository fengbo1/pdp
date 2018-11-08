package pdp.userinfo.dao;
// default package

import ccb.dao.BaseHibernateDAO;
import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pdp.userinfo.pojo.UserInfo;

/**
 	* A data access object (DAO) providing persistence and search support for UserInfo entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .UserInfo
  * @author MyEclipse Persistence Tools 
 */

public class UserInfoDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(UserInfoDAO.class);
		//property constants
	public static final String NEWNUMBER = "newnumber";
	public static final String USERNAME = "username";
	public static final String PASSWORD = "password";
	public static final String POSITION = "position";
	public static final String AUTHORITY = "authority";
	public static final String IDENTITY = "identity";
	public static final String WORKDATE = "workdate";
	public static final String CCBDATE = "ccbdate";
	public static final String ZXDATE = "zxdate";
	public static final String WORKYEARS = "workyears";
	public static final String PASSPORT = "passport";
	public static final String HKPASSPORT = "hkpassport";
	public static final String TWPASSPORT = "twpassport";
	public static final String YEARALL = "yearall";
	public static final String ROLE890 = "role890";
	public static final String ROLE891 = "role891";
	public static final String STATUS890 = "status890";
	public static final String STATUS891 = "status891";
	public static final String PAIXU = "paixu";
	public static final String REMARK1 = "remark1";
	public static final String REMARK2 = "remark2";
	public static final String OPNUMBER = "opnumber";



    
    public void save(UserInfo transientInstance) {
        log.debug("saving UserInfo instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(UserInfo persistentInstance) {
        log.debug("deleting UserInfo instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public UserInfo findById( java.lang.Integer id) {
        log.debug("getting UserInfo instance with id: " + id);
        try {
            UserInfo instance = (UserInfo) getSession()
                    .get("UserInfo", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(UserInfo instance) {
        log.debug("finding UserInfo instance by example");
        try {
            List results = getSession()
                    .createCriteria("UserInfo")
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
      log.debug("finding UserInfo instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from UserInfo as model where model." 
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
	
	public List findByUsername(Object username
	) {
		return findByProperty(USERNAME, username
		);
	}
	
	public List findByPassword(Object password
	) {
		return findByProperty(PASSWORD, password
		);
	}
	
	public List findByPosition(Object position
	) {
		return findByProperty(POSITION, position
		);
	}
	
	public List findByAuthority(Object authority
	) {
		return findByProperty(AUTHORITY, authority
		);
	}
	
	public List findByIdentity(Object identity
	) {
		return findByProperty(IDENTITY, identity
		);
	}
	
	public List findByWorkdate(Object workdate
	) {
		return findByProperty(WORKDATE, workdate
		);
	}
	
	public List findByCcbdate(Object ccbdate
	) {
		return findByProperty(CCBDATE, ccbdate
		);
	}
	
	public List findByZxdate(Object zxdate
	) {
		return findByProperty(ZXDATE, zxdate
		);
	}
	
	public List findByWorkyears(Object workyears
	) {
		return findByProperty(WORKYEARS, workyears
		);
	}
	
	public List findByPassport(Object passport
	) {
		return findByProperty(PASSPORT, passport
		);
	}
	
	public List findByHkpassport(Object hkpassport
	) {
		return findByProperty(HKPASSPORT, hkpassport
		);
	}
	
	public List findByTwpassport(Object twpassport
	) {
		return findByProperty(TWPASSPORT, twpassport
		);
	}
	
	public List findByYearall(Object yearall
	) {
		return findByProperty(YEARALL, yearall
		);
	}
	
	public List findByRole890(Object role890
	) {
		return findByProperty(ROLE890, role890
		);
	}
	
	public List findByRole891(Object role891
	) {
		return findByProperty(ROLE891, role891
		);
	}
	
	public List findByStatus890(Object status890
	) {
		return findByProperty(STATUS890, status890
		);
	}
	
	public List findByStatus891(Object status891
	) {
		return findByProperty(STATUS891, status891
		);
	}
	
	public List findByPaixu(Object paixu
	) {
		return findByProperty(PAIXU, paixu
		);
	}
	
	public List findByRemark1(Object remark1
	) {
		return findByProperty(REMARK1, remark1
		);
	}
	
	public List findByRemark2(Object remark2
	) {
		return findByProperty(REMARK2, remark2
		);
	}
	
	public List findByOpnumber(Object opnumber
	) {
		return findByProperty(OPNUMBER, opnumber
		);
	}
	

	public List findAll() {
		log.debug("finding all UserInfo instances");
		try {
			String queryString = "from UserInfo";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public UserInfo merge(UserInfo detachedInstance) {
        log.debug("merging UserInfo instance");
        try {
            UserInfo result = (UserInfo) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(UserInfo instance) {
        log.debug("attaching dirty UserInfo instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(UserInfo instance) {
        log.debug("attaching clean UserInfo instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}