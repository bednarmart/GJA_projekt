package net.gjashop.dao;

import java.util.List;

import net.gjashop.entities.Category;

import org.hibernate.Criteria;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

/**
 * This class provides all default operations that are derived from the HEDL entity model
 * for type Category.
 *
 * Note: This class is generated. Any change will be overridden.
 */
public class CategoryDAO {
	
	public final static String FIELD__ID = getField(Category.class, "id");
	public final static String FIELD__NAME = getField(Category.class, "name");
	
	/**
	 * Creates a Category using all read-only and all non-null properties.
	 */
	public Category create(Session session, java.lang.String name) {
		Category newEntity = new Category(name);
		session.save(newEntity);
		return newEntity;
	}
	
	/**
	 * Returns the Category with the given id.
	 */
	public Category get(Session session, int id) {
		Category entity = (Category) session.get(Category.class, id);
		return entity;
	}
	
	/**
	 * Returns all entities of type Category.
	 */
	public List<Category> getAll(Session session) {
		Criteria criteria = session.createCriteria(Category.class);
		@SuppressWarnings("unchecked")
		List<Category> entities = (List<Category>) criteria.list();
		return entities;
	}
	
	/**
	 * Searches for entities of type Category.
	 */
	public List<Category> search(Session _session, String _searchString, int _maxResults) {
		Criteria criteria = _session.createCriteria(Category.class);
		Disjunction disjunction = Restrictions.disjunction();
		disjunction.add(Restrictions.like(FIELD__NAME, _searchString.trim(), MatchMode.ANYWHERE));
		criteria = criteria.add(disjunction);
		criteria = criteria.setMaxResults(_maxResults);
		@SuppressWarnings("unchecked")
		List<Category> entities = (List<Category>) criteria.list();
		return entities;
	}
	
	/**
	 * Deletes a Category.
	 */
	public void delete(Session session, Category entity) {
		session.delete(entity);
	}
	
	/**
	 * Counts the number of Category entities.
	 */
	public int count(Session session) {
		return ((Long) session.createQuery("select count(*) from Category").uniqueResult()).intValue();
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
