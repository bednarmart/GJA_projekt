package net.gjashop.dao;

import java.util.List;

import net.gjashop.entities.Address;
import net.gjashop.entities.AddressBinding;
import net.gjashop.entities.User;

import org.hibernate.Criteria;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Restrictions;

/**
 * This class provides all default operations that are derived from the HEDL entity model
 * for type AddressBinding.
 *
 * Note: This class is generated. Any change will be overridden.
 */
public class AddressBindingDAO {
	
	public final static String FIELD__ID = getField(AddressBinding.class, "id");
	public final static String FIELD__ADDRESS = getField(AddressBinding.class, "address");
	public final static String FIELD__USER = getField(AddressBinding.class, "user");
	public final static String FIELD__DELIVERYHOME = getField(AddressBinding.class, "deliveryHome");
	
	/**
	 * Creates a AddressBinding using all read-only and all non-null properties.
	 */
	public AddressBinding create(Session session, Address address, User user, boolean deliveryHome) {
		AddressBinding newEntity = new AddressBinding(address, user, deliveryHome);
		session.save(newEntity);
		return newEntity;
	}
	
	/**
	 * Returns the AddressBinding with the given id.
	 */
	public AddressBinding get(Session session, int id) {
		AddressBinding entity = (AddressBinding) session.get(AddressBinding.class, id);
		return entity;
	}
	
	/**
	 * Returns the AddressBindings with the given address.
	 */
	public List<AddressBinding> getByAddress(Session session, Address address) {
		Criteria criteria = session.createCriteria(AddressBinding.class);
		criteria = criteria.add(Restrictions.eq(FIELD__ADDRESS, address));
		@SuppressWarnings("unchecked")
		List<AddressBinding> list = (List<AddressBinding>) criteria.list();
		return list;
	}
	
	/**
	 * Returns the AddressBindings with the given user.
	 */
	public List<AddressBinding> getByUser(Session session, User user) {
		Criteria criteria = session.createCriteria(AddressBinding.class);
		criteria = criteria.add(Restrictions.eq(FIELD__USER, user));
		@SuppressWarnings("unchecked")
		List<AddressBinding> list = (List<AddressBinding>) criteria.list();
		return list;
	}
	
	/**
	 * Returns all entities of type AddressBinding.
	 */
	public List<AddressBinding> getAll(Session session) {
		Criteria criteria = session.createCriteria(AddressBinding.class);
		@SuppressWarnings("unchecked")
		List<AddressBinding> entities = (List<AddressBinding>) criteria.list();
		return entities;
	}
	
	/**
	 * Searches for entities of type AddressBinding.
	 */
	public List<AddressBinding> search(Session _session, String _searchString, int _maxResults) {
		Criteria criteria = _session.createCriteria(AddressBinding.class);
		Disjunction disjunction = Restrictions.disjunction();
		criteria = criteria.add(disjunction);
		criteria = criteria.setMaxResults(_maxResults);
		@SuppressWarnings("unchecked")
		List<AddressBinding> entities = (List<AddressBinding>) criteria.list();
		return entities;
	}
	
	/**
	 * Searches for entities of type AddressBinding.
	 */
	public List<AddressBinding> searchWithAddress(Session _session, Address address, String _searchString, int _maxResults) {
		Criteria criteria = _session.createCriteria(AddressBinding.class);
		// restrict by the value of the unique property
		criteria = criteria.add(Restrictions.eq(FIELD__ADDRESS, address));
		Disjunction disjunction = Restrictions.disjunction();
		criteria = criteria.add(disjunction);
		criteria = criteria.setMaxResults(_maxResults);
		@SuppressWarnings("unchecked")
		List<AddressBinding> entities = (List<AddressBinding>) criteria.list();
		return entities;
	}
	
	/**
	 * Searches for entities of type AddressBinding.
	 */
	public List<AddressBinding> searchWithUser(Session _session, User user, String _searchString, int _maxResults) {
		Criteria criteria = _session.createCriteria(AddressBinding.class);
		// restrict by the value of the unique property
		criteria = criteria.add(Restrictions.eq(FIELD__USER, user));
		Disjunction disjunction = Restrictions.disjunction();
		criteria = criteria.add(disjunction);
		criteria = criteria.setMaxResults(_maxResults);
		@SuppressWarnings("unchecked")
		List<AddressBinding> entities = (List<AddressBinding>) criteria.list();
		return entities;
	}
	
	/**
	 * Deletes a AddressBinding.
	 */
	public void delete(Session session, AddressBinding entity) {
		session.delete(entity);
	}
	
	/**
	 * Counts the number of AddressBinding entities.
	 */
	public int count(Session session) {
		return ((Long) session.createQuery("select count(*) from AddressBinding").uniqueResult()).intValue();
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
