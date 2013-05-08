package net.gjashop.dao;

import java.util.List;

import net.gjashop.entities.Product;
import net.gjashop.entities.Rating;
import net.gjashop.entities.User;

import org.hibernate.Criteria;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Restrictions;

/**
 * This class provides all default operations that are derived from the HEDL entity model
 * for type Rating.
 *
 * Note: This class is generated. Any change will be overridden.
 */
public class RatingDAO {
	
	public final static String FIELD__ID = getField(Rating.class, "id");
	public final static String FIELD__USER = getField(Rating.class, "user");
	public final static String FIELD__PRODUCT = getField(Rating.class, "product");
	public final static String FIELD__VALUE = getField(Rating.class, "value");
	
	/**
	 * Creates a Rating using all read-only and all non-null properties.
	 */
	public Rating create(Session session, User user, Product product, int value) {
		Rating newEntity = new Rating(user, product, value);
		session.save(newEntity);
		return newEntity;
	}
	
	/**
	 * Returns the Rating with the given id.
	 */
	public Rating get(Session session, int id) {
		Rating entity = (Rating) session.get(Rating.class, id);
		return entity;
	}
	
	/**
	 * Returns the Ratings with the given user.
	 */
	public List<Rating> getByUser(Session session, User user) {
		Criteria criteria = session.createCriteria(Rating.class);
		criteria = criteria.add(Restrictions.eq(FIELD__USER, user));
		@SuppressWarnings("unchecked")
		List<Rating> list = (List<Rating>) criteria.list();
		return list;
	}
	
	/**
	 * Returns the Ratings with the given product.
	 */
	public List<Rating> getByProduct(Session session, Product product) {
		Criteria criteria = session.createCriteria(Rating.class);
		criteria = criteria.add(Restrictions.eq(FIELD__PRODUCT, product));
		@SuppressWarnings("unchecked")
		List<Rating> list = (List<Rating>) criteria.list();
		return list;
	}
	
	/**
	 * Returns all entities of type Rating.
	 */
	public List<Rating> getAll(Session session) {
		Criteria criteria = session.createCriteria(Rating.class);
		@SuppressWarnings("unchecked")
		List<Rating> entities = (List<Rating>) criteria.list();
		return entities;
	}
	
	/**
	 * Searches for entities of type Rating.
	 */
	public List<Rating> search(Session _session, String _searchString, int _maxResults) {
		Criteria criteria = _session.createCriteria(Rating.class);
		Disjunction disjunction = Restrictions.disjunction();
		criteria = criteria.add(disjunction);
		criteria = criteria.setMaxResults(_maxResults);
		@SuppressWarnings("unchecked")
		List<Rating> entities = (List<Rating>) criteria.list();
		return entities;
	}
	
	/**
	 * Searches for entities of type Rating.
	 */
	public List<Rating> searchWithUser(Session _session, User user, String _searchString, int _maxResults) {
		Criteria criteria = _session.createCriteria(Rating.class);
		// restrict by the value of the unique property
		criteria = criteria.add(Restrictions.eq(FIELD__USER, user));
		Disjunction disjunction = Restrictions.disjunction();
		criteria = criteria.add(disjunction);
		criteria = criteria.setMaxResults(_maxResults);
		@SuppressWarnings("unchecked")
		List<Rating> entities = (List<Rating>) criteria.list();
		return entities;
	}
	
	/**
	 * Searches for entities of type Rating.
	 */
	public List<Rating> searchWithProduct(Session _session, Product product, String _searchString, int _maxResults) {
		Criteria criteria = _session.createCriteria(Rating.class);
		// restrict by the value of the unique property
		criteria = criteria.add(Restrictions.eq(FIELD__PRODUCT, product));
		Disjunction disjunction = Restrictions.disjunction();
		criteria = criteria.add(disjunction);
		criteria = criteria.setMaxResults(_maxResults);
		@SuppressWarnings("unchecked")
		List<Rating> entities = (List<Rating>) criteria.list();
		return entities;
	}
	
	/**
	 * Deletes a Rating.
	 */
	public void delete(Session session, Rating entity) {
		session.delete(entity);
	}
	
	/**
	 * Counts the number of Rating entities.
	 */
	public int count(Session session) {
		return ((Long) session.createQuery("select count(*) from Rating").uniqueResult()).intValue();
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
