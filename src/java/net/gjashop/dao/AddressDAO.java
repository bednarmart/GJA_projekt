package net.gjashop.dao;

import java.util.List;

import net.gjashop.entities.Address;

import org.hibernate.Criteria;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

/**
 * This class provides all default operations that are derived from the HEDL entity model
 * for type Address.
 *
 * Note: This class is generated. Any change will be overridden.
 */
public class AddressDAO {
	
	public final static String FIELD__ID = getField(Address.class, "id");
	public final static String FIELD__CITY = getField(Address.class, "city");
	public final static String FIELD__STREET = getField(Address.class, "street");
	public final static String FIELD__ZIP = getField(Address.class, "zip");
	
	/**
	 * Creates a Address using all read-only and all non-null properties.
	 */
	public Address create(Session session, java.lang.String city, java.lang.String street, java.lang.String zip) {
		Address newEntity = new Address(city, street, zip);
		session.save(newEntity);
		return newEntity;
	}
	
	/**
	 * Returns the Address with the given id.
	 */
	public Address get(Session session, int id) {
		Address entity = (Address) session.get(Address.class, id);
		return entity;
	}
	
	/**
	 * Returns all entities of type Address.
	 */
	public List<Address> getAll(Session session) {
		Criteria criteria = session.createCriteria(Address.class);
		@SuppressWarnings("unchecked")
		List<Address> entities = (List<Address>) criteria.list();
		return entities;
	}
	
	/**
	 * Searches for entities of type Address.
	 */
	public List<Address> search(Session _session, String _searchString, int _maxResults) {
		Criteria criteria = _session.createCriteria(Address.class);
		Disjunction disjunction = Restrictions.disjunction();
		disjunction.add(Restrictions.like(FIELD__CITY, _searchString.trim(), MatchMode.ANYWHERE));
		disjunction.add(Restrictions.like(FIELD__STREET, _searchString.trim(), MatchMode.ANYWHERE));
		disjunction.add(Restrictions.like(FIELD__ZIP, _searchString.trim(), MatchMode.ANYWHERE));
		criteria = criteria.add(disjunction);
		criteria = criteria.setMaxResults(_maxResults);
		@SuppressWarnings("unchecked")
		List<Address> entities = (List<Address>) criteria.list();
		return entities;
	}
	
	/**
	 * Deletes a Address.
	 */
	public void delete(Session session, Address entity) {
		session.delete(entity);
	}
	
	/**
	 * Counts the number of Address entities.
	 */
	public int count(Session session) {
		return ((Long) session.createQuery("select count(*) from Address").uniqueResult()).intValue();
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
