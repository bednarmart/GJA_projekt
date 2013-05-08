package net.gjashop.dao;

import java.util.List;

import net.gjashop.entities.Delivery;

import org.hibernate.Criteria;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

/**
 * This class provides all default operations that are derived from the HEDL entity model
 * for type Delivery.
 *
 * Note: This class is generated. Any change will be overridden.
 */
public class DeliveryDAO {
	
	public final static String FIELD__ID = getField(Delivery.class, "id");
	public final static String FIELD__NAME = getField(Delivery.class, "name");
	
	/**
	 * Creates a Delivery using all read-only and all non-null properties.
	 */
	public Delivery create(Session session, java.lang.String name) {
		Delivery newEntity = new Delivery(name);
		session.save(newEntity);
		return newEntity;
	}
	
	/**
	 * Returns the Delivery with the given id.
	 */
	public Delivery get(Session session, int id) {
		Delivery entity = (Delivery) session.get(Delivery.class, id);
		return entity;
	}
	
	/**
	 * Returns all entities of type Delivery.
	 */
	public List<Delivery> getAll(Session session) {
		Criteria criteria = session.createCriteria(Delivery.class);
		@SuppressWarnings("unchecked")
		List<Delivery> entities = (List<Delivery>) criteria.list();
		return entities;
	}
	
	/**
	 * Searches for entities of type Delivery.
	 */
	public List<Delivery> search(Session _session, String _searchString, int _maxResults) {
		Criteria criteria = _session.createCriteria(Delivery.class);
		Disjunction disjunction = Restrictions.disjunction();
		disjunction.add(Restrictions.like(FIELD__NAME, _searchString.trim(), MatchMode.ANYWHERE));
		criteria = criteria.add(disjunction);
		criteria = criteria.setMaxResults(_maxResults);
		@SuppressWarnings("unchecked")
		List<Delivery> entities = (List<Delivery>) criteria.list();
		return entities;
	}
	
	/**
	 * Deletes a Delivery.
	 */
	public void delete(Session session, Delivery entity) {
		session.delete(entity);
	}
	
	/**
	 * Counts the number of Delivery entities.
	 */
	public int count(Session session) {
		return ((Long) session.createQuery("select count(*) from Delivery").uniqueResult()).intValue();
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
