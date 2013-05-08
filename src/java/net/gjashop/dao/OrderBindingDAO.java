package net.gjashop.dao;

import java.util.List;

import net.gjashop.entities.ClientOrder;
import net.gjashop.entities.OrderBinding;
import net.gjashop.entities.Product;

import org.hibernate.Criteria;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Restrictions;

/**
 * This class provides all default operations that are derived from the HEDL entity model
 * for type OrderBinding.
 *
 * Note: This class is generated. Any change will be overridden.
 */
public class OrderBindingDAO {
	
	public final static String FIELD__ID = getField(OrderBinding.class, "id");
	public final static String FIELD__ORDER = getField(OrderBinding.class, "order");
	public final static String FIELD__PRODUCT = getField(OrderBinding.class, "product");
	public final static String FIELD__PRICE = getField(OrderBinding.class, "price");
	public final static String FIELD__COUNT = getField(OrderBinding.class, "count");
	
	/**
	 * Creates a OrderBinding using all read-only and all non-null properties.
	 */
	public OrderBinding create(Session session, ClientOrder order, Product product, double price, int count) {
		OrderBinding newEntity = new OrderBinding(order, product, price, count);
		session.save(newEntity);
		return newEntity;
	}
	
	/**
	 * Returns the OrderBinding with the given id.
	 */
	public OrderBinding get(Session session, int id) {
		OrderBinding entity = (OrderBinding) session.get(OrderBinding.class, id);
		return entity;
	}
	
	/**
	 * Returns the OrderBindings with the given order.
	 */
	public List<OrderBinding> getByOrder(Session session, ClientOrder order) {
		Criteria criteria = session.createCriteria(OrderBinding.class);
		criteria = criteria.add(Restrictions.eq(FIELD__ORDER, order));
		@SuppressWarnings("unchecked")
		List<OrderBinding> list = (List<OrderBinding>) criteria.list();
		return list;
	}
	
	/**
	 * Returns the OrderBindings with the given product.
	 */
	public List<OrderBinding> getByProduct(Session session, Product product) {
		Criteria criteria = session.createCriteria(OrderBinding.class);
		criteria = criteria.add(Restrictions.eq(FIELD__PRODUCT, product));
		@SuppressWarnings("unchecked")
		List<OrderBinding> list = (List<OrderBinding>) criteria.list();
		return list;
	}
	
	/**
	 * Returns all entities of type OrderBinding.
	 */
	public List<OrderBinding> getAll(Session session) {
		Criteria criteria = session.createCriteria(OrderBinding.class);
		@SuppressWarnings("unchecked")
		List<OrderBinding> entities = (List<OrderBinding>) criteria.list();
		return entities;
	}
	
	/**
	 * Searches for entities of type OrderBinding.
	 */
	public List<OrderBinding> search(Session _session, String _searchString, int _maxResults) {
		Criteria criteria = _session.createCriteria(OrderBinding.class);
		Disjunction disjunction = Restrictions.disjunction();
		criteria = criteria.add(disjunction);
		criteria = criteria.setMaxResults(_maxResults);
		@SuppressWarnings("unchecked")
		List<OrderBinding> entities = (List<OrderBinding>) criteria.list();
		return entities;
	}
	
	/**
	 * Searches for entities of type OrderBinding.
	 */
	public List<OrderBinding> searchWithOrder(Session _session, ClientOrder order, String _searchString, int _maxResults) {
		Criteria criteria = _session.createCriteria(OrderBinding.class);
		// restrict by the value of the unique property
		criteria = criteria.add(Restrictions.eq(FIELD__ORDER, order));
		Disjunction disjunction = Restrictions.disjunction();
		criteria = criteria.add(disjunction);
		criteria = criteria.setMaxResults(_maxResults);
		@SuppressWarnings("unchecked")
		List<OrderBinding> entities = (List<OrderBinding>) criteria.list();
		return entities;
	}
	
	/**
	 * Searches for entities of type OrderBinding.
	 */
	public List<OrderBinding> searchWithProduct(Session _session, Product product, String _searchString, int _maxResults) {
		Criteria criteria = _session.createCriteria(OrderBinding.class);
		// restrict by the value of the unique property
		criteria = criteria.add(Restrictions.eq(FIELD__PRODUCT, product));
		Disjunction disjunction = Restrictions.disjunction();
		criteria = criteria.add(disjunction);
		criteria = criteria.setMaxResults(_maxResults);
		@SuppressWarnings("unchecked")
		List<OrderBinding> entities = (List<OrderBinding>) criteria.list();
		return entities;
	}
	
	/**
	 * Deletes a OrderBinding.
	 */
	public void delete(Session session, OrderBinding entity) {
		session.delete(entity);
	}
	
	/**
	 * Counts the number of OrderBinding entities.
	 */
	public int count(Session session) {
		return ((Long) session.createQuery("select count(*) from OrderBinding").uniqueResult()).intValue();
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
