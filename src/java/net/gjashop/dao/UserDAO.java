package net.gjashop.dao;

import java.util.List;

import net.gjashop.entities.User;

import org.hibernate.Criteria;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

/**
 * This class provides all default operations that are derived from the HEDL entity model
 * for type User.
 *
 * Note: This class is generated. Any change will be overridden.
 */
public class UserDAO {
	
	public final static String FIELD__ID = getField(User.class, "id");
	public final static String FIELD__NAME = getField(User.class, "name");
	public final static String FIELD__SURNAME = getField(User.class, "surname");
	public final static String FIELD__LOGIN = getField(User.class, "login");
	public final static String FIELD__PASS = getField(User.class, "pass");
	public final static String FIELD__PRIVILEGY = getField(User.class, "privilegy");
	
	/**
	 * Creates a User using all read-only and all non-null properties.
	 */
	public User create(Session session, java.lang.String name, java.lang.String surname, java.lang.String login, java.lang.String pass, int privilegy) {
		User newEntity = new User(name, surname, login, pass, privilegy);
		session.save(newEntity);
		return newEntity;
	}
	
	/**
	 * Returns the User with the given id.
	 */
	public User get(Session session, int id) {
		User entity = (User) session.get(User.class, id);
		return entity;
	}
	
	/**
	 * Returns all entities of type User.
	 */
	public List<User> getAll(Session session) {
		Criteria criteria = session.createCriteria(User.class);
		@SuppressWarnings("unchecked")
		List<User> entities = (List<User>) criteria.list();
		return entities;
	}
	
	/**
	 * Searches for entities of type User.
	 */
	public List<User> search(Session _session, String _searchString, int _maxResults) {
		Criteria criteria = _session.createCriteria(User.class);
		Disjunction disjunction = Restrictions.disjunction();
		disjunction.add(Restrictions.like(FIELD__NAME, _searchString.trim(), MatchMode.ANYWHERE));
		disjunction.add(Restrictions.like(FIELD__SURNAME, _searchString.trim(), MatchMode.ANYWHERE));
		disjunction.add(Restrictions.like(FIELD__LOGIN, _searchString.trim(), MatchMode.ANYWHERE));
		disjunction.add(Restrictions.like(FIELD__PASS, _searchString.trim(), MatchMode.ANYWHERE));
		criteria = criteria.add(disjunction);
		criteria = criteria.setMaxResults(_maxResults);
		@SuppressWarnings("unchecked")
		List<User> entities = (List<User>) criteria.list();
		return entities;
	}
	
	/**
	 * Deletes a User.
	 */
	public void delete(Session session, User entity) {
		session.delete(entity);
	}
	
	/**
	 * Counts the number of User entities.
	 */
	public int count(Session session) {
		return ((Long) session.createQuery("select count(*) from User").uniqueResult()).intValue();
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
