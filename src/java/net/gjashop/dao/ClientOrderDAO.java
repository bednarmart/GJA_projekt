package net.gjashop.dao;

import java.util.List;

import net.gjashop.entities.ClientOrder;
import net.gjashop.entities.Delivery;
import net.gjashop.entities.PaymentType;
import net.gjashop.entities.User;

import org.hibernate.Criteria;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

/**
 * This class provides all default operations that are derived from the HEDL entity model
 * for type ClientOrder.
 *
 * Note: This class is generated. Any change will be overridden.
 */
public class ClientOrderDAO {
	
	public final static String FIELD__ID = getField(ClientOrder.class, "id");
	public final static String FIELD__DELIVERY = getField(ClientOrder.class, "delivery");
	public final static String FIELD__PAYMENTTYPE = getField(ClientOrder.class, "paymentType");
	public final static String FIELD__USER = getField(ClientOrder.class, "user");
	public final static String FIELD__DATE = getField(ClientOrder.class, "date");
	public final static String FIELD__DELIVERYCITY = getField(ClientOrder.class, "deliveryCity");
	public final static String FIELD__DELIVERYSTREET = getField(ClientOrder.class, "deliveryStreet");
	public final static String FIELD__DELIVERYZIP = getField(ClientOrder.class, "deliveryZip");
	
	/**
	 * Creates a ClientOrder using all read-only and all non-null properties.
	 */
	public ClientOrder create(Session session, Delivery delivery, PaymentType paymentType, User user, java.util.Date date, java.lang.String deliveryCity, java.lang.String deliveryStreet, java.lang.String deliveryZip) {
		ClientOrder newEntity = new ClientOrder(delivery, paymentType, user, date, deliveryCity, deliveryStreet, deliveryZip);
		session.save(newEntity);
		return newEntity;
	}
	
	/**
	 * Returns the ClientOrder with the given id.
	 */
	public ClientOrder get(Session session, int id) {
		ClientOrder entity = (ClientOrder) session.get(ClientOrder.class, id);
		return entity;
	}
	
	/**
	 * Returns the ClientOrders with the given delivery.
	 */
	public List<ClientOrder> getByDelivery(Session session, Delivery delivery) {
		Criteria criteria = session.createCriteria(ClientOrder.class);
		criteria = criteria.add(Restrictions.eq(FIELD__DELIVERY, delivery));
		@SuppressWarnings("unchecked")
		List<ClientOrder> list = (List<ClientOrder>) criteria.list();
		return list;
	}
	
	/**
	 * Returns the ClientOrders with the given paymentType.
	 */
	public List<ClientOrder> getByPaymentType(Session session, PaymentType paymentType) {
		Criteria criteria = session.createCriteria(ClientOrder.class);
		criteria = criteria.add(Restrictions.eq(FIELD__PAYMENTTYPE, paymentType));
		@SuppressWarnings("unchecked")
		List<ClientOrder> list = (List<ClientOrder>) criteria.list();
		return list;
	}
	
	/**
	 * Returns the ClientOrders with the given user.
	 */
	public List<ClientOrder> getByUser(Session session, User user) {
		Criteria criteria = session.createCriteria(ClientOrder.class);
		criteria = criteria.add(Restrictions.eq(FIELD__USER, user));
		@SuppressWarnings("unchecked")
		List<ClientOrder> list = (List<ClientOrder>) criteria.list();
		return list;
	}
	
	/**
	 * Returns all ClientOrders where date is set to a value before '_maxDate'.
	 */
	public List<ClientOrder> getDateBefore(Session session, java.util.Date _maxDate) {
		Criteria criteria = session.createCriteria(ClientOrder.class);
		criteria = criteria.add(Restrictions.le(FIELD__DATE, _maxDate));
		List<?> list = criteria.list();
		@SuppressWarnings("unchecked")
		List<ClientOrder> entities = (List<ClientOrder>) list;
		return entities;
	}
	
	/**
	 * Returns all ClientOrders where date is set to a value after '_minDate'.
	 */
	public List<ClientOrder> getDateAfter(Session session, java.util.Date _minDate) {
		Criteria criteria = session.createCriteria(ClientOrder.class);
		criteria = criteria.add(Restrictions.ge(FIELD__DATE, _minDate));
		List<?> list = criteria.list();
		@SuppressWarnings("unchecked")
		List<ClientOrder> entities = (List<ClientOrder>) list;
		return entities;
	}
	
	/**
	 * Returns all entities of type ClientOrder.
	 */
	public List<ClientOrder> getAll(Session session) {
		Criteria criteria = session.createCriteria(ClientOrder.class);
		@SuppressWarnings("unchecked")
		List<ClientOrder> entities = (List<ClientOrder>) criteria.list();
		return entities;
	}
	
	/**
	 * Searches for entities of type ClientOrder.
	 */
	public List<ClientOrder> search(Session _session, String _searchString, int _maxResults) {
		Criteria criteria = _session.createCriteria(ClientOrder.class);
		Disjunction disjunction = Restrictions.disjunction();
		disjunction.add(Restrictions.like(FIELD__DELIVERYCITY, _searchString.trim(), MatchMode.ANYWHERE));
		disjunction.add(Restrictions.like(FIELD__DELIVERYSTREET, _searchString.trim(), MatchMode.ANYWHERE));
		disjunction.add(Restrictions.like(FIELD__DELIVERYZIP, _searchString.trim(), MatchMode.ANYWHERE));
		criteria = criteria.add(disjunction);
		criteria = criteria.setMaxResults(_maxResults);
		@SuppressWarnings("unchecked")
		List<ClientOrder> entities = (List<ClientOrder>) criteria.list();
		return entities;
	}
	
	/**
	 * Searches for entities of type ClientOrder.
	 */
	public List<ClientOrder> searchWithDelivery(Session _session, Delivery delivery, String _searchString, int _maxResults) {
		Criteria criteria = _session.createCriteria(ClientOrder.class);
		// restrict by the value of the unique property
		criteria = criteria.add(Restrictions.eq(FIELD__DELIVERY, delivery));
		Disjunction disjunction = Restrictions.disjunction();
		disjunction.add(Restrictions.like(FIELD__DELIVERYCITY, _searchString.trim(), MatchMode.ANYWHERE));
		disjunction.add(Restrictions.like(FIELD__DELIVERYSTREET, _searchString.trim(), MatchMode.ANYWHERE));
		disjunction.add(Restrictions.like(FIELD__DELIVERYZIP, _searchString.trim(), MatchMode.ANYWHERE));
		criteria = criteria.add(disjunction);
		criteria = criteria.setMaxResults(_maxResults);
		@SuppressWarnings("unchecked")
		List<ClientOrder> entities = (List<ClientOrder>) criteria.list();
		return entities;
	}
	
	/**
	 * Searches for entities of type ClientOrder.
	 */
	public List<ClientOrder> searchWithPaymentType(Session _session, PaymentType paymentType, String _searchString, int _maxResults) {
		Criteria criteria = _session.createCriteria(ClientOrder.class);
		// restrict by the value of the unique property
		criteria = criteria.add(Restrictions.eq(FIELD__PAYMENTTYPE, paymentType));
		Disjunction disjunction = Restrictions.disjunction();
		disjunction.add(Restrictions.like(FIELD__DELIVERYCITY, _searchString.trim(), MatchMode.ANYWHERE));
		disjunction.add(Restrictions.like(FIELD__DELIVERYSTREET, _searchString.trim(), MatchMode.ANYWHERE));
		disjunction.add(Restrictions.like(FIELD__DELIVERYZIP, _searchString.trim(), MatchMode.ANYWHERE));
		criteria = criteria.add(disjunction);
		criteria = criteria.setMaxResults(_maxResults);
		@SuppressWarnings("unchecked")
		List<ClientOrder> entities = (List<ClientOrder>) criteria.list();
		return entities;
	}
	
	/**
	 * Searches for entities of type ClientOrder.
	 */
	public List<ClientOrder> searchWithUser(Session _session, User user, String _searchString, int _maxResults) {
		Criteria criteria = _session.createCriteria(ClientOrder.class);
		// restrict by the value of the unique property
		criteria = criteria.add(Restrictions.eq(FIELD__USER, user));
		Disjunction disjunction = Restrictions.disjunction();
		disjunction.add(Restrictions.like(FIELD__DELIVERYCITY, _searchString.trim(), MatchMode.ANYWHERE));
		disjunction.add(Restrictions.like(FIELD__DELIVERYSTREET, _searchString.trim(), MatchMode.ANYWHERE));
		disjunction.add(Restrictions.like(FIELD__DELIVERYZIP, _searchString.trim(), MatchMode.ANYWHERE));
		criteria = criteria.add(disjunction);
		criteria = criteria.setMaxResults(_maxResults);
		@SuppressWarnings("unchecked")
		List<ClientOrder> entities = (List<ClientOrder>) criteria.list();
		return entities;
	}
	
	/**
	 * Deletes a ClientOrder.
	 */
	public void delete(Session session, ClientOrder entity) {
		session.delete(entity);
	}
	
	/**
	 * Counts the number of ClientOrder entities.
	 */
	public int count(Session session) {
		return ((Long) session.createQuery("select count(*) from ClientOrder").uniqueResult()).intValue();
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
