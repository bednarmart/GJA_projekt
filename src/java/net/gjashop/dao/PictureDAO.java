package net.gjashop.dao;

import java.util.List;

import net.gjashop.entities.Picture;
import net.gjashop.entities.Product;

import org.hibernate.Criteria;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

/**
 * This class provides all default operations that are derived from the HEDL entity model
 * for type Picture.
 *
 * Note: This class is generated. Any change will be overridden.
 */
public class PictureDAO {
	
	public final static String FIELD__ID = getField(Picture.class, "id");
	public final static String FIELD__PRODUCT = getField(Picture.class, "product");
	public final static String FIELD__PATH = getField(Picture.class, "path");
	
	/**
	 * Creates a Picture using all read-only and all non-null properties.
	 */
	public Picture create(Session session, Product product, java.lang.String path) {
		Picture newEntity = new Picture(product, path);
		session.save(newEntity);
		return newEntity;
	}
	
	/**
	 * Returns the Picture with the given id.
	 */
	public Picture get(Session session, int id) {
		Picture entity = (Picture) session.get(Picture.class, id);
		return entity;
	}
	
	/**
	 * Returns the Pictures with the given product.
	 */
	public List<Picture> getByProduct(Session session, Product product) {
		Criteria criteria = session.createCriteria(Picture.class);
		criteria = criteria.add(Restrictions.eq(FIELD__PRODUCT, product));
		@SuppressWarnings("unchecked")
		List<Picture> list = (List<Picture>) criteria.list();
		return list;
	}
	
	/**
	 * Returns all entities of type Picture.
	 */
	public List<Picture> getAll(Session session) {
		Criteria criteria = session.createCriteria(Picture.class);
		@SuppressWarnings("unchecked")
		List<Picture> entities = (List<Picture>) criteria.list();
		return entities;
	}
	
	/**
	 * Searches for entities of type Picture.
	 */
	public List<Picture> search(Session _session, String _searchString, int _maxResults) {
		Criteria criteria = _session.createCriteria(Picture.class);
		Disjunction disjunction = Restrictions.disjunction();
		disjunction.add(Restrictions.like(FIELD__PATH, _searchString.trim(), MatchMode.ANYWHERE));
		criteria = criteria.add(disjunction);
		criteria = criteria.setMaxResults(_maxResults);
		@SuppressWarnings("unchecked")
		List<Picture> entities = (List<Picture>) criteria.list();
		return entities;
	}
	
	/**
	 * Searches for entities of type Picture.
	 */
	public List<Picture> searchWithProduct(Session _session, Product product, String _searchString, int _maxResults) {
		Criteria criteria = _session.createCriteria(Picture.class);
		// restrict by the value of the unique property
		criteria = criteria.add(Restrictions.eq(FIELD__PRODUCT, product));
		Disjunction disjunction = Restrictions.disjunction();
		disjunction.add(Restrictions.like(FIELD__PATH, _searchString.trim(), MatchMode.ANYWHERE));
		criteria = criteria.add(disjunction);
		criteria = criteria.setMaxResults(_maxResults);
		@SuppressWarnings("unchecked")
		List<Picture> entities = (List<Picture>) criteria.list();
		return entities;
	}
	
	/**
	 * Deletes a Picture.
	 */
	public void delete(Session session, Picture entity) {
		session.delete(entity);
	}
	
	/**
	 * Counts the number of Picture entities.
	 */
	public int count(Session session) {
		return ((Long) session.createQuery("select count(*) from Picture").uniqueResult()).intValue();
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
