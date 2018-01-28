package com.aftnlistener.bean;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

/**
 * A data access object (DAO) providing persistence and search support for Aftn
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.aftnlistener.bean.Aftn
 * @author MyEclipse Persistence Tools
 */
public class AftnDAO extends BaseHibernateDAO {
	private static final Log log = LogFactory.getLog(AftnDAO.class);
	// property constants
	public static final String _编组3 = "编组3";
	public static final String _编组5 = "编组5";
	public static final String _编组7 = "编组7";
	public static final String _编组8 = "编组8";
	public static final String _编组9 = "编组9";
	public static final String _编组10 = "编组10";
	public static final String _编组13 = "编组13";
	public static final String _编组14 = "编组14";
	public static final String _编组15 = "编组15";
	public static final String _编组16 = "编组16";
	public static final String _编组17 = "编组17";
	public static final String _编组18 = "编组18";
	public static final String _编组19 = "编组19";
	public static final String _编组20 = "编组20";
	public static final String _编组21 = "编组21";
	public static final String _编组22 = "编组22";

	public void save(Aftn transientInstance) {
		log.debug("saving Aftn instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Aftn persistentInstance) {
		log.debug("deleting Aftn instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Aftn findById(java.lang.Integer id) {
		log.debug("getting Aftn instance with id: " + id);
		try {
			Aftn instance = (Aftn) getSession().get("com.aftnlistener.bean.Aftn", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Aftn instance) {
		log.debug("finding Aftn instance by example");
		try {
			List results = getSession().createCriteria("com.aftnlistener.bean.Aftn").add(Example.create(instance))
					.list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Aftn instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from Aftn as model where model." + propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findBy编组3(Object 编组3) {
		return findByProperty(_编组3, 编组3);
	}

	public List findBy编组5(Object 编组5) {
		return findByProperty(_编组5, 编组5);
	}

	public List findBy编组7(Object 编组7) {
		return findByProperty(_编组7, 编组7);
	}

	public List findBy编组8(Object 编组8) {
		return findByProperty(_编组8, 编组8);
	}

	public List findBy编组9(Object 编组9) {
		return findByProperty(_编组9, 编组9);
	}

	public List findBy编组10(Object 编组10) {
		return findByProperty(_编组10, 编组10);
	}

	public List findBy编组13(Object 编组13) {
		return findByProperty(_编组13, 编组13);
	}

	public List findBy编组14(Object 编组14) {
		return findByProperty(_编组14, 编组14);
	}

	public List findBy编组15(Object 编组15) {
		return findByProperty(_编组15, 编组15);
	}

	public List findBy编组16(Object 编组16) {
		return findByProperty(_编组16, 编组16);
	}

	public List findBy编组17(Object 编组17) {
		return findByProperty(_编组17, 编组17);
	}

	public List findBy编组18(Object 编组18) {
		return findByProperty(_编组18, 编组18);
	}

	public List findBy编组19(Object 编组19) {
		return findByProperty(_编组19, 编组19);
	}

	public List findBy编组20(Object 编组20) {
		return findByProperty(_编组20, 编组20);
	}

	public List findBy编组21(Object 编组21) {
		return findByProperty(_编组21, 编组21);
	}

	public List findBy编组22(Object 编组22) {
		return findByProperty(_编组22, 编组22);
	}

	public List findAll() {
		log.debug("finding all Aftn instances");
		try {
			String queryString = "from Aftn";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Aftn merge(Aftn detachedInstance) {
		log.debug("merging Aftn instance");
		try {
			Aftn result = (Aftn) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Aftn instance) {
		log.debug("attaching dirty Aftn instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Aftn instance) {
		log.debug("attaching clean Aftn instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}