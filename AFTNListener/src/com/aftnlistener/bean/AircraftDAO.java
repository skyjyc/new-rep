package com.aftnlistener.bean;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

/**
 * A data access object (DAO) providing persistence and search support for
 * Aircraft entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.aftnlistener.bean.Aircraft
 * @author MyEclipse Persistence Tools
 */
public class AircraftDAO extends BaseHibernateDAO {
	private static final Log log = LogFactory.getLog(AircraftDAO.class);
	// property constants
	public static final String COLOUR_CODE = "colourCode";
	public static final String OTHER_COLOUR = "otherColour";
	public static final String NUMBEROF_AIRCRAFT = "numberofAircraft";
	public static final String SIGNIFICANT_MARKINGS = "significantMarkings";
	public static final String WAKE_TURBULENCE_CATEGORY = "wakeTurbulenceCategory";
	public static final String AIRCRAFT_TYPE_NUMBEROF_AIRCRAFT = "aircraftTypeNumberofAircraft";
	public static final String ICAO_AIRCRAFT_TYPE_REFERENCE = "icaoAircraftTypeReference";
	public static final String OTHER_AIRCRAFT_TYPE_REFERENCE = "otherAircraftTypeReference";
	public static final String AIRCRAFT_APPROACH_CATEGORY = "aircraftApproachCategory";
	public static final String AIRCRAFT_ADDRESS = "aircraftAddress";

	public void save(Aircraft transientInstance) {
		log.debug("saving Aircraft instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Aircraft persistentInstance) {
		log.debug("deleting Aircraft instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Aircraft findById(java.lang.String id) {
		log.debug("getting Aircraft instance with id: " + id);
		try {
			Aircraft instance = (Aircraft) getSession().get("com.aftnlistener.bean.Aircraft", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Aircraft instance) {
		log.debug("finding Aircraft instance by example");
		try {
			List results = getSession().createCriteria("com.aftnlistener.bean.Aircraft").add(Example.create(instance))
					.list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Aircraft instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from Aircraft as model where model." + propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByColourCode(Object colourCode) {
		return findByProperty(COLOUR_CODE, colourCode);
	}

	public List findByOtherColour(Object otherColour) {
		return findByProperty(OTHER_COLOUR, otherColour);
	}

	public List findByNumberofAircraft(Object numberofAircraft) {
		return findByProperty(NUMBEROF_AIRCRAFT, numberofAircraft);
	}

	public List findBySignificantMarkings(Object significantMarkings) {
		return findByProperty(SIGNIFICANT_MARKINGS, significantMarkings);
	}

	public List findByWakeTurbulenceCategory(Object wakeTurbulenceCategory) {
		return findByProperty(WAKE_TURBULENCE_CATEGORY, wakeTurbulenceCategory);
	}

	public List findByAircraftTypeNumberofAircraft(Object aircraftTypeNumberofAircraft) {
		return findByProperty(AIRCRAFT_TYPE_NUMBEROF_AIRCRAFT, aircraftTypeNumberofAircraft);
	}

	public List findByIcaoAircraftTypeReference(Object icaoAircraftTypeReference) {
		return findByProperty(ICAO_AIRCRAFT_TYPE_REFERENCE, icaoAircraftTypeReference);
	}

	public List findByOtherAircraftTypeReference(Object otherAircraftTypeReference) {
		return findByProperty(OTHER_AIRCRAFT_TYPE_REFERENCE, otherAircraftTypeReference);
	}

	public List findByAircraftApproachCategory(Object aircraftApproachCategory) {
		return findByProperty(AIRCRAFT_APPROACH_CATEGORY, aircraftApproachCategory);
	}

	public List findByAircraftAddress(Object aircraftAddress) {
		return findByProperty(AIRCRAFT_ADDRESS, aircraftAddress);
	}

	public List findAll() {
		log.debug("finding all Aircraft instances");
		try {
			String queryString = "from Aircraft";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Aircraft merge(Aircraft detachedInstance) {
		log.debug("merging Aircraft instance");
		try {
			Aircraft result = (Aircraft) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Aircraft instance) {
		log.debug("attaching dirty Aircraft instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Aircraft instance) {
		log.debug("attaching clean Aircraft instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}