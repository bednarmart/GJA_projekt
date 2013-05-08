package net.gjashop.dao;

import java.util.List;

import net.gjashop.entities.Contact;
import net.gjashop.entities.ContactBinding;
import net.gjashop.entities.User;

import org.hibernate.Criteria;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Restrictions;

/**
 * This class provides all default operations that are derived from the HEDL entity model
 * for type ContactBinding.
 *
 * Note: This class is generated. Any change will be overridden.
 */
public class ContactBindingDAO {
	
	public final static String FIELD__ID = getField(ContactBinding.class, "id");
	public final static String FIELD__CONTACT = getField(ContactBinding.class, "contact");
	public final static String FIELD__USER = getField(ContactBinding.class, "user");
	
	/**
	 * Creates a ContactBinding using all read-only and all non-null properties.
	 */
	public ContactBinding create(Session session, Contact contact, User user) {
		ContactBinding newEntity = new ContactBinding(contact, user);
		session.save(newEntity);
		return newEntity;
	}
	
	/**
	 * Returns the ContactBinding with the given id.
	 */
	public ContactBinding get(Session session, int id) {
		ContactBinding entity = (ContactBinding) session.get(ContactBinding.class, id);
		return entity;
	}
	
	/**
	 * Returns the ContactBindings with the given contact.
	 */
	public List<ContactBinding> getByContact(Session session, Contact contact) {
		Criteria criteria = session.createCriteria(ContactBinding.class);
		criteria = criteria.add(Restrictions.eq(FIELD__CONTACT, contact));
		@SuppressWarnings("unchecked")
		List<ContactBinding> list = (List<ContactBinding>) criteria.list();
		return list;
	}
	
	/**
	 * Returns the ContactBindings with the given user.
	 */
	public List<ContactBinding> getByUser(Session session, User user) {
		Criteria criteria = session.createCriteria(ContactBinding.class);
		criteria = criteria.add(Restrictions.eq(FIELD__USER, user));
		@SuppressWarnings("unchecked")
		List<ContactBinding> list = (List<ContactBinding>) criteria.list();
		return list;
	}
	
	/**
	 * Returns all entities of type ContactBinding.
	 */
	public List<ContactBinding> getAll(Session session) {
		Criteria criteria = session.createCriteria(ContactBinding.class);
		@SuppressWarnings("unchecked")
		List<ContactBinding> entities = (List<ContactBinding>) criteria.list();
		return entities;
	}
	
	/**
	 * Searches for entities of type ContactBinding.
	 */
	public List<ContactBinding> search(Session _session, String _searchString, int _maxResults) {
		Criteria criteria = _session.createCriteria(ContactBinding.class);
		Disjunction disjunction = Restrictions.disjunction();
		criteria = criteria.add(disjunction);
		criteria = criteria.setMaxResults(_maxResults);
		@SuppressWarnings("unchecked")
		List<ContactBinding> entities = (List<ContactBinding>) criteria.list();
		return entities;
	}
	
	/**
	 * Searches for entities of type ContactBinding.
	 */
	public List<ContactBinding> searchWithContact(Session _session, Contact contact, String _searchString, int _maxResults) {
		Criteria criteria = _session.createCriteria(ContactBinding.class);
		// restrict by the value of the unique property
		criteria = criteria.add(Restrictions.eq(FIELD__CONTACT, contact));
		Disjunction disjunction = Restrictions.disjunction();
		criteria = criteria.add(disjunction);
		criteria = criteria.setMaxResults(_maxResults);
		@SuppressWarnings("unchecked")
		List<ContactBinding> entities = (List<ContactBinding>) criteria.list();
		return entities;
	}
	
	/**
	 * Searches for entities of type ContactBinding.
	 */
	public List<ContactBinding> searchWithUser(Session _session, User user, String _searchString, int _maxResults) {
		Criteria criteria = _session.createCriteria(ContactBinding.class);
		// restrict by the value of the unique property
		criteria = criteria.add(Restrictions.eq(FIELD__USER, user));
		Disjunction disjunction = Restrictions.disjunction();
		criteria = criteria.add(disjunction);
		criteria = criteria.setMaxResults(_maxResults);
		@SuppressWarnings("unchecked")
		List<ContactBinding> entities = (List<ContactBinding>) criteria.list();
		return entities;
	}
	
	/**
	 * Deletes a ContactBinding.
	 */
	public void delete(Session session, ContactBinding entity) {
		session.delete(entity);
	}
	
	/**
	 * Counts the number of ContactBinding entities.
	 */
	public int count(Session session) {
		return ((Long) session.createQuery("select count(*) from ContactBinding").uniqueResult()).intValue();
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
