package net.gjashop.dao;

import java.util.List;

import net.gjashop.entities.Category;
import net.gjashop.entities.Segment;

import org.hibernate.Criteria;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

/**
 * This class provides all default operations that are derived from the HEDL entity model
 * for type Segment.
 *
 * Note: This class is generated. Any change will be overridden.
 */
public class SegmentDAO {
	
	public final static String FIELD__ID = getField(Segment.class, "id");
	public final static String FIELD__CATEGORY = getField(Segment.class, "category");
	public final static String FIELD__NAME = getField(Segment.class, "name");
	
	/**
	 * Creates a Segment using all read-only and all non-null properties.
	 */
	public Segment create(Session session, Category category, java.lang.String name) {
		Segment newEntity = new Segment(category, name);
		session.save(newEntity);
		return newEntity;
	}
	
	/**
	 * Returns the Segment with the given id.
	 */
	public Segment get(Session session, int id) {
		Segment entity = (Segment) session.get(Segment.class, id);
		return entity;
	}
	
	/**
	 * Returns the Segments with the given category.
	 */
	public List<Segment> getByCategory(Session session, Category category) {
		Criteria criteria = session.createCriteria(Segment.class);
		criteria = criteria.add(Restrictions.eq(FIELD__CATEGORY, category));
		@SuppressWarnings("unchecked")
		List<Segment> list = (List<Segment>) criteria.list();
		return list;
	}
	
	/**
	 * Returns all entities of type Segment.
	 */
	public List<Segment> getAll(Session session) {
		Criteria criteria = session.createCriteria(Segment.class);
		@SuppressWarnings("unchecked")
		List<Segment> entities = (List<Segment>) criteria.list();
		return entities;
	}
	
	/**
	 * Searches for entities of type Segment.
	 */
	public List<Segment> search(Session _session, String _searchString, int _maxResults) {
		Criteria criteria = _session.createCriteria(Segment.class);
		Disjunction disjunction = Restrictions.disjunction();
		disjunction.add(Restrictions.like(FIELD__NAME, _searchString.trim(), MatchMode.ANYWHERE));
		criteria = criteria.add(disjunction);
		criteria = criteria.setMaxResults(_maxResults);
		@SuppressWarnings("unchecked")
		List<Segment> entities = (List<Segment>) criteria.list();
		return entities;
	}
	
	/**
	 * Searches for entities of type Segment.
	 */
	public List<Segment> searchWithCategory(Session _session, Category category, String _searchString, int _maxResults) {
		Criteria criteria = _session.createCriteria(Segment.class);
		// restrict by the value of the unique property
		criteria = criteria.add(Restrictions.eq(FIELD__CATEGORY, category));
		Disjunction disjunction = Restrictions.disjunction();
		disjunction.add(Restrictions.like(FIELD__NAME, _searchString.trim(), MatchMode.ANYWHERE));
		criteria = criteria.add(disjunction);
		criteria = criteria.setMaxResults(_maxResults);
		@SuppressWarnings("unchecked")
		List<Segment> entities = (List<Segment>) criteria.list();
		return entities;
	}
	
	/**
	 * Deletes a Segment.
	 */
	public void delete(Session session, Segment entity) {
		session.delete(entity);
	}
	
	/**
	 * Counts the number of Segment entities.
	 */
	public int count(Session session) {
		return ((Long) session.createQuery("select count(*) from Segment").uniqueResult()).intValue();
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
