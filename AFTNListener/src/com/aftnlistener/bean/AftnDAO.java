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
	public static final String _����3 = "����3";
	public static final String _����5 = "����5";
	public static final String _����7 = "����7";
	public static final String _����8 = "����8";
	public static final String _����9 = "����9";
	public static final String _����10 = "����10";
	public static final String _����13 = "����13";
	public static final String _����14 = "����14";
	public static final String _����15 = "����15";
	public static final String _����16 = "����16";
	public static final String _����17 = "����17";
	public static final String _����18 = "����18";
	public static final String _����19 = "����19";
	public static final String _����20 = "����20";
	public static final String _����21 = "����21";
	public static final String _����22 = "����22";

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

	public List findBy����3(Object ����3) {
		return findByProperty(_����3, ����3);
	}

	public List findBy����5(Object ����5) {
		return findByProperty(_����5, ����5);
	}

	public List findBy����7(Object ����7) {
		return findByProperty(_����7, ����7);
	}

	public List findBy����8(Object ����8) {
		return findByProperty(_����8, ����8);
	}

	public List findBy����9(Object ����9) {
		return findByProperty(_����9, ����9);
	}

	public List findBy����10(Object ����10) {
		return findByProperty(_����10, ����10);
	}

	public List findBy����13(Object ����13) {
		return findByProperty(_����13, ����13);
	}

	public List findBy����14(Object ����14) {
		return findByProperty(_����14, ����14);
	}

	public List findBy����15(Object ����15) {
		return findByProperty(_����15, ����15);
	}

	public List findBy����16(Object ����16) {
		return findByProperty(_����16, ����16);
	}

	public List findBy����17(Object ����17) {
		return findByProperty(_����17, ����17);
	}

	public List findBy����18(Object ����18) {
		return findByProperty(_����18, ����18);
	}

	public List findBy����19(Object ����19) {
		return findByProperty(_����19, ����19);
	}

	public List findBy����20(Object ����20) {
		return findByProperty(_����20, ����20);
	}

	public List findBy����21(Object ����21) {
		return findByProperty(_����21, ����21);
	}

	public List findBy����22(Object ����22) {
		return findByProperty(_����22, ����22);
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