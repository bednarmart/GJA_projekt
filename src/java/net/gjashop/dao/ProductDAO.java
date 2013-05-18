package net.gjashop.dao;

import java.util.List;

import net.gjashop.entities.Product;
import net.gjashop.entities.Segment;
import net.gjashop.entities.Sign;

import org.hibernate.Criteria;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

/**
 * This class provides all default operations that are derived from the HEDL entity model
 * for type Product.
 *
 * Note: This class is generated. Any change will be overridden.
 */
public class ProductDAO {
	
	public final static String FIELD__ID = getField(Product.class, "id");
	public final static String FIELD__NAME = getField(Product.class, "name");
	public final static String FIELD__SEGMENT = getField(Product.class, "segment");
	public final static String FIELD__SIGN = getField(Product.class, "sign");
	public final static String FIELD__SEX = getField(Product.class, "sex");
	public final static String FIELD__SIZE = getField(Product.class, "size");
	public final static String FIELD__COLOR = getField(Product.class, "color");
	public final static String FIELD__PRICE = getField(Product.class, "price");
	public final static String FIELD__DELIVERYTIME = getField(Product.class, "deliveryTime");
	public final static String FIELD__COUNT = getField(Product.class, "count");
	
	/**
	 * Creates a Product using all read-only and all non-null properties.
	 */
	public Product create(Session session, java.lang.String name, Segment segment, Sign sign, double price, java.lang.String deliveryTime, int count) {
		Product newEntity = new Product(name, segment, sign, price, deliveryTime, count);
		session.save(newEntity);
		return newEntity;
	}
	
	/**
	 * Returns the Product with the given id.
	 */
	public Product get(Session session, int id) {
		Product entity = (Product) session.get(Product.class, id);
		return entity;
	}
	
	/**
	 * Returns the Products with the given segment.
	 */
	public List<Product> getBySegment(Session session, Segment segment) {
		Criteria criteria = session.createCriteria(Product.class);
		criteria = criteria.add(Restrictions.eq(FIELD__SEGMENT, segment));
		@SuppressWarnings("unchecked")
		List<Product> list = (List<Product>) criteria.list();
		return list;
	}
	
	/**
	 * Returns the Products with the given sign.
	 */
	public List<Product> getBySign(Session session, Sign sign) {
		Criteria criteria = session.createCriteria(Product.class);
		criteria = criteria.add(Restrictions.eq(FIELD__SIGN, sign));
		@SuppressWarnings("unchecked")
		List<Product> list = (List<Product>) criteria.list();
		return list;
	}
	
	/**
	 * Returns all entities of type Product.
	 */
	public List<Product> getAll(Session session) {
		Criteria criteria = session.createCriteria(Product.class);
		@SuppressWarnings("unchecked")
		List<Product> entities = (List<Product>) criteria.list();
		return entities;
	}
	
	/**
	 * Searches for entities of type Product.
	 */
	public List<Product> search(Session _session, String _searchString, int _maxResults) {
		Criteria criteria = _session.createCriteria(Product.class);
		Disjunction disjunction = Restrictions.disjunction();
		disjunction.add(Restrictions.like(FIELD__NAME, _searchString.trim(), MatchMode.ANYWHERE));
		disjunction.add(Restrictions.like(FIELD__SIZE, _searchString.trim(), MatchMode.ANYWHERE));
		disjunction.add(Restrictions.like(FIELD__COLOR, _searchString.trim(), MatchMode.ANYWHERE));
		disjunction.add(Restrictions.like(FIELD__DELIVERYTIME, _searchString.trim(), MatchMode.ANYWHERE));
		criteria = criteria.add(disjunction);
		criteria = criteria.setMaxResults(_maxResults);
		@SuppressWarnings("unchecked")
		List<Product> entities = (List<Product>) criteria.list();
		return entities;
	}
	
	/**
	 * Searches for entities of type Product.
	 */
	public List<Product> searchWithSegment(Session _session, Segment segment, String _searchString, int _maxResults) {
		Criteria criteria = _session.createCriteria(Product.class);
		// restrict by the value of the unique property
		criteria = criteria.add(Restrictions.eq(FIELD__SEGMENT, segment));
		Disjunction disjunction = Restrictions.disjunction();
		disjunction.add(Restrictions.like(FIELD__NAME, _searchString.trim(), MatchMode.ANYWHERE));
		disjunction.add(Restrictions.like(FIELD__SIZE, _searchString.trim(), MatchMode.ANYWHERE));
		disjunction.add(Restrictions.like(FIELD__COLOR, _searchString.trim(), MatchMode.ANYWHERE));
		disjunction.add(Restrictions.like(FIELD__DELIVERYTIME, _searchString.trim(), MatchMode.ANYWHERE));
		criteria = criteria.add(disjunction);
		criteria = criteria.setMaxResults(_maxResults);
		@SuppressWarnings("unchecked")
		List<Product> entities = (List<Product>) criteria.list();
		return entities;
	}
	
	/**
	 * Searches for entities of type Product.
	 */
	public List<Product> searchWithSign(Session _session, Sign sign, String _searchString, int _maxResults) {
		Criteria criteria = _session.createCriteria(Product.class);
		// restrict by the value of the unique property
		criteria = criteria.add(Restrictions.eq(FIELD__SIGN, sign));
		Disjunction disjunction = Restrictions.disjunction();
		disjunction.add(Restrictions.like(FIELD__NAME, _searchString.trim(), MatchMode.ANYWHERE));
		disjunction.add(Restrictions.like(FIELD__SIZE, _searchString.trim(), MatchMode.ANYWHERE));
		disjunction.add(Restrictions.like(FIELD__COLOR, _searchString.trim(), MatchMode.ANYWHERE));
		disjunction.add(Restrictions.like(FIELD__DELIVERYTIME, _searchString.trim(), MatchMode.ANYWHERE));
		criteria = criteria.add(disjunction);
		criteria = criteria.setMaxResults(_maxResults);
		@SuppressWarnings("unchecked")
		List<Product> entities = (List<Product>) criteria.list();
		return entities;
	}
	
	/**
	 * Deletes a Product.
	 */
	public void delete(Session session, Product entity) {
		session.delete(entity);
	}
	
	/**
	 * Counts the number of Product entities.
	 */
	public int count(Session session) {
		return ((Long) session.createQuery("select count(*) from Product").uniqueResult()).intValue();
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
