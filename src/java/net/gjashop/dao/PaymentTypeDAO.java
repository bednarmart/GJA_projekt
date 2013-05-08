package net.gjashop.dao;

import java.util.List;

import net.gjashop.entities.PaymentType;

import org.hibernate.Criteria;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

/**
 * This class provides all default operations that are derived from the HEDL entity model
 * for type PaymentType.
 *
 * Note: This class is generated. Any change will be overridden.
 */
public class PaymentTypeDAO {
	
	public final static String FIELD__ID = getField(PaymentType.class, "id");
	public final static String FIELD__NAME = getField(PaymentType.class, "name");
	
	/**
	 * Creates a PaymentType using all read-only and all non-null properties.
	 */
	public PaymentType create(Session session, java.lang.String name) {
		PaymentType newEntity = new PaymentType(name);
		session.save(newEntity);
		return newEntity;
	}
	
	/**
	 * Returns the PaymentType with the given id.
	 */
	public PaymentType get(Session session, int id) {
		PaymentType entity = (PaymentType) session.get(PaymentType.class, id);
		return entity;
	}
	
	/**
	 * Returns all entities of type PaymentType.
	 */
	public List<PaymentType> getAll(Session session) {
		Criteria criteria = session.createCriteria(PaymentType.class);
		@SuppressWarnings("unchecked")
		List<PaymentType> entities = (List<PaymentType>) criteria.list();
		return entities;
	}
	
	/**
	 * Searches for entities of type PaymentType.
	 */
	public List<PaymentType> search(Session _session, String _searchString, int _maxResults) {
		Criteria criteria = _session.createCriteria(PaymentType.class);
		Disjunction disjunction = Restrictions.disjunction();
		disjunction.add(Restrictions.like(FIELD__NAME, _searchString.trim(), MatchMode.ANYWHERE));
		criteria = criteria.add(disjunction);
		criteria = criteria.setMaxResults(_maxResults);
		@SuppressWarnings("unchecked")
		List<PaymentType> entities = (List<PaymentType>) criteria.list();
		return entities;
	}
	
	/**
	 * Deletes a PaymentType.
	 */
	public void delete(Session session, PaymentType entity) {
		session.delete(entity);
	}
	
	/**
	 * Counts the number of PaymentType entities.
	 */
	public int count(Session session) {
		return ((Long) session.createQuery("select count(*) from PaymentType").uniqueResult()).intValue();
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
