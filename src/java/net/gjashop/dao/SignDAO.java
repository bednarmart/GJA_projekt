package net.gjashop.dao;

import java.util.List;

import net.gjashop.entities.Sign;

import org.hibernate.Criteria;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

/**
 * This class provides all default operations that are derived from the HEDL entity model
 * for type Sign.
 *
 * Note: This class is generated. Any change will be overridden.
 */
public class SignDAO {
	
	public final static String FIELD__ID = getField(Sign.class, "id");
	public final static String FIELD__NAME = getField(Sign.class, "name");
	
	/**
	 * Creates a Sign using all read-only and all non-null properties.
	 */
	public Sign create(Session session, java.lang.String name) {
		Sign newEntity = new Sign(name);
		session.save(newEntity);
		return newEntity;
	}
	
	/**
	 * Returns the Sign with the given id.
	 */
	public Sign get(Session session, int id) {
		Sign entity = (Sign) session.get(Sign.class, id);
		return entity;
	}
	
	/**
	 * Returns all entities of type Sign.
	 */
	public List<Sign> getAll(Session session) {
		Criteria criteria = session.createCriteria(Sign.class);
		@SuppressWarnings("unchecked")
		List<Sign> entities = (List<Sign>) criteria.list();
		return entities;
	}
	
	/**
	 * Searches for entities of type Sign.
	 */
	public List<Sign> search(Session _session, String _searchString, int _maxResults) {
		Criteria criteria = _session.createCriteria(Sign.class);
		Disjunction disjunction = Restrictions.disjunction();
		disjunction.add(Restrictions.like(FIELD__NAME, _searchString.trim(), MatchMode.ANYWHERE));
		criteria = criteria.add(disjunction);
		criteria = criteria.setMaxResults(_maxResults);
		@SuppressWarnings("unchecked")
		List<Sign> entities = (List<Sign>) criteria.list();
		return entities;
	}
	
	/**
	 * Deletes a Sign.
	 */
	public void delete(Session session, Sign entity) {
		session.delete(entity);
	}
	
	/**
	 * Counts the number of Sign entities.
	 */
	public int count(Session session) {
		return ((Long) session.createQuery("select count(*) from Sign").uniqueResult()).intValue();
	}
		
	private static String getField(Class<?> clazz, String fieldName) {
		try {
			return clazz.getDeclaredField(fieldName).getName();
		} catch (SecurityException e) {
			throw new RuntimeException(e.getClass().getSimpleName() + ": " + e.getMessage());
		} catch (NoSuchFieldException e) {
			throw new RuntimeException(e.getClass().getSimpleName() + ": " + e.getMessage());
		}
	}
}
