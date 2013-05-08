package net.gjashop.dao;

import java.util.List;

import net.gjashop.entities.Contact;

import org.hibernate.Criteria;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

/**
 * This class provides all default operations that are derived from the HEDL entity model
 * for type Contact.
 *
 * Note: This class is generated. Any change will be overridden.
 */
public class ContactDAO {
	
	public final static String FIELD__ID = getField(Contact.class, "id");
	public final static String FIELD__NAME = getField(Contact.class, "name");
	
	/**
	 * Creates a Contact using all read-only and all non-null properties.
	 */
	public Contact create(Session session, java.lang.String name) {
		Contact newEntity = new Contact(name);
		session.save(newEntity);
		return newEntity;
	}
	
	/**
	 * Returns the Contact with the given id.
	 */
	public Contact get(Session session, int id) {
		Contact entity = (Contact) session.get(Contact.class, id);
		return entity;
	}
	
	/**
	 * Returns all entities of type Contact.
	 */
	public List<Contact> getAll(Session session) {
		Criteria criteria = session.createCriteria(Contact.class);
		@SuppressWarnings("unchecked")
		List<Contact> entities = (List<Contact>) criteria.list();
		return entities;
	}
	
	/**
	 * Searches for entities of type Contact.
	 */
	public List<Contact> search(Session _session, String _searchString, int _maxResults) {
		Criteria criteria = _session.createCriteria(Contact.class);
		Disjunction disjunction = Restrictions.disjunction();
		disjunction.add(Restrictions.like(FIELD__NAME, _searchString.trim(), MatchMode.ANYWHERE));
		criteria = criteria.add(disjunction);
		criteria = criteria.setMaxResults(_maxResults);
		@SuppressWarnings("unchecked")
		List<Contact> entities = (List<Contact>) criteria.list();
		return entities;
	}
	
	/**
	 * Deletes a Contact.
	 */
	public void delete(Session session, Contact entity) {
		session.delete(entity);
	}
	
	/**
	 * Counts the number of Contact entities.
	 */
	public int count(Session session) {
		return ((Long) session.createQuery("select count(*) from Contact").uniqueResult()).intValue();
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
