package net.gjashop.dao;

import java.util.List;

import net.gjashop.entities.Address;
import net.gjashop.entities.AddressBinding;
import net.gjashop.entities.Category;
import net.gjashop.entities.ClientOrder;
import net.gjashop.entities.Contact;
import net.gjashop.entities.ContactBinding;
import net.gjashop.entities.Delivery;
import net.gjashop.entities.OrderBinding;
import net.gjashop.entities.PaymentType;
import net.gjashop.entities.Picture;
import net.gjashop.entities.Product;
import net.gjashop.entities.Rating;
import net.gjashop.entities.Segment;
import net.gjashop.entities.Sign;
import net.gjashop.entities.User;

import org.hibernate.Query;
import org.hibernate.classic.Session;
import org.hibernate.metadata.ClassMetadata;
import org.hibernate.persister.entity.AbstractEntityPersister;

/**
 * This class provides all default operations that are derived from the HEDL entity model.
 *
 * Note: This class is generated. Any change will be overridden.
 */
public abstract class OperationProviderBase implements IDBOperationsBase {
		
	private Session session;
	
	private CategoryDAO categoryDAO = new CategoryDAO();
	private SegmentDAO segmentDAO = new SegmentDAO();
	private SignDAO signDAO = new SignDAO();
	private ClientOrderDAO clientOrderDAO = new ClientOrderDAO();
	private OrderBindingDAO orderBindingDAO = new OrderBindingDAO();
	private ProductDAO productDAO = new ProductDAO();
	private PictureDAO pictureDAO = new PictureDAO();
	private UserDAO userDAO = new UserDAO();
	private RatingDAO ratingDAO = new RatingDAO();
	private DeliveryDAO deliveryDAO = new DeliveryDAO();
	private PaymentTypeDAO paymentTypeDAO = new PaymentTypeDAO();
	private ContactDAO contactDAO = new ContactDAO();
	private ContactBindingDAO contactBindingDAO = new ContactBindingDAO();
	private AddressDAO addressDAO = new AddressDAO();
	private AddressBindingDAO addressBindingDAO = new AddressBindingDAO();

	public OperationProviderBase(Session session) {
		this.session = session;
	}
	
	public Session getSession() {
		return session;
	}
	
	public void update(Object entity) {
		getSession().update(entity);
	}
	
	/** 
	 * Creates an instance of type Category using all read-only and all non-null properties.
	 */
	public Category createCategory(java.lang.String name) {
		return categoryDAO.create(session, name);
	}
	
	/**
	 * Returns the Category with the given id.
	 */
	public Category getCategory(int id) {
		Category entity = categoryDAO.get(session, id);
		return entity;
	}
	
	/**
	 * Returns all entities of type Category.
	 */
	public List<Category> getAllCategorys() {
		final List<Category> entities = categoryDAO.getAll(session);
		return entities;
	}
	
	/**
	 * Searches for entities of type Category.
	 */
	public List<Category> searchCategorys(String _searchString, int _maxResults) {
		return categoryDAO.search(session, _searchString, _maxResults);
	}
	
	/**
	 * Deletes a Category.
	 */
	public void delete(Category entity) {
		categoryDAO.delete(session, entity);
	}
	
		/**
	 * Counts the number of Category entities.
	 */
	public int countCategorys() {
		return categoryDAO.count(session);
	}
	
	/** 
	 * Creates an instance of type Segment using all read-only and all non-null properties.
	 */
	public Segment createSegment(Category category, java.lang.String name) {
		return segmentDAO.create(session, category, name);
	}
	
	/**
	 * Returns the Segment with the given id.
	 */
	public Segment getSegment(int id) {
		Segment entity = segmentDAO.get(session, id);
		return entity;
	}
	
	/** Returns the Segments with the given category. */
	public List<Segment> getSegmentsByCategory(Category category) {
		List<Segment> entities = segmentDAO.getByCategory(session, category);
		return entities;
	}
		
	/**
	 * Returns all entities of type Segment.
	 */
	public List<Segment> getAllSegments() {
		final List<Segment> entities = segmentDAO.getAll(session);
		return entities;
	}
	
	/**
	 * Searches for entities of type Segment.
	 */
	public List<Segment> searchSegments(String _searchString, int _maxResults) {
		return segmentDAO.search(session, _searchString, _maxResults);
	}
	
	/**
	 * Searches for entities of type Segment.
	 */
	public List<Segment> searchSegmentWithCategory(Category category, String _searchString, int _maxResults) {
		return segmentDAO.searchWithCategory(session, category, _searchString, _maxResults);
	}
	
	/**
	 * Deletes a Segment.
	 */
	public void delete(Segment entity) {
		segmentDAO.delete(session, entity);
	}
	
		/**
	 * Counts the number of Segment entities.
	 */
	public int countSegments() {
		return segmentDAO.count(session);
	}
	
	/** 
	 * Creates an instance of type Sign using all read-only and all non-null properties.
	 */
	public Sign createSign(java.lang.String name) {
		return signDAO.create(session, name);
	}
	
	/**
	 * Returns the Sign with the given id.
	 */
	public Sign getSign(int id) {
		Sign entity = signDAO.get(session, id);
		return entity;
	}
	
	/**
	 * Returns all entities of type Sign.
	 */
	public List<Sign> getAllSigns() {
		final List<Sign> entities = signDAO.getAll(session);
		return entities;
	}
	
	/**
	 * Searches for entities of type Sign.
	 */
	public List<Sign> searchSigns(String _searchString, int _maxResults) {
		return signDAO.search(session, _searchString, _maxResults);
	}
	
	/**
	 * Deletes a Sign.
	 */
	public void delete(Sign entity) {
		signDAO.delete(session, entity);
	}
	
		/**
	 * Counts the number of Sign entities.
	 */
	public int countSigns() {
		return signDAO.count(session);
	}
	
	/** 
	 * Creates an instance of type ClientOrder using all read-only and all non-null properties.
	 */
	public ClientOrder createClientOrder(Delivery delivery, PaymentType paymentType, User user, java.util.Date date, java.lang.String deliveryCity, java.lang.String deliveryStreet, java.lang.String deliveryZip) {
		return clientOrderDAO.create(session, delivery, paymentType, user, date, deliveryCity, deliveryStreet, deliveryZip);
	}
	
	/**
	 * Returns the ClientOrder with the given id.
	 */
	public ClientOrder getClientOrder(int id) {
		ClientOrder entity = clientOrderDAO.get(session, id);
		return entity;
	}
	
	/** Returns the ClientOrders with the given delivery. */
	public List<ClientOrder> getClientOrdersByDelivery(Delivery delivery) {
		List<ClientOrder> entities = clientOrderDAO.getByDelivery(session, delivery);
		return entities;
	}
		
	/** Returns the ClientOrders with the given paymentType. */
	public List<ClientOrder> getClientOrdersByPaymentType(PaymentType paymentType) {
		List<ClientOrder> entities = clientOrderDAO.getByPaymentType(session, paymentType);
		return entities;
	}
		
	/** Returns the ClientOrders with the given user. */
	public List<ClientOrder> getClientOrdersByUser(User user) {
		List<ClientOrder> entities = clientOrderDAO.getByUser(session, user);
		return entities;
	}
		
	/**
	 * Returns all ClientOrders where date is set to a value before '_maxDate'.
	 */
	public List<ClientOrder> getClientOrdersWithDateBefore(java.util.Date _maxDate) {
		final List<ClientOrder> entities = clientOrderDAO.getDateBefore(session, _maxDate);
		return entities;
	}
	
	/**
	 * Returns all ClientOrders where date is set to a value after '_minDate'.
	 */
	public List<ClientOrder> getClientOrdersWithDateAfter(java.util.Date _minDate) {
		final List<ClientOrder> entities = clientOrderDAO.getDateAfter(session, _minDate);
		return entities;
	}
	
	/**
	 * Returns all entities of type ClientOrder.
	 */
	public List<ClientOrder> getAllClientOrders() {
		final List<ClientOrder> entities = clientOrderDAO.getAll(session);
		return entities;
	}
	
	/**
	 * Searches for entities of type ClientOrder.
	 */
	public List<ClientOrder> searchClientOrders(String _searchString, int _maxResults) {
		return clientOrderDAO.search(session, _searchString, _maxResults);
	}
	
	/**
	 * Searches for entities of type ClientOrder.
	 */
	public List<ClientOrder> searchClientOrderWithDelivery(Delivery delivery, String _searchString, int _maxResults) {
		return clientOrderDAO.searchWithDelivery(session, delivery, _searchString, _maxResults);
	}
	
	/**
	 * Searches for entities of type ClientOrder.
	 */
	public List<ClientOrder> searchClientOrderWithPaymentType(PaymentType paymentType, String _searchString, int _maxResults) {
		return clientOrderDAO.searchWithPaymentType(session, paymentType, _searchString, _maxResults);
	}
	
	/**
	 * Searches for entities of type ClientOrder.
	 */
	public List<ClientOrder> searchClientOrderWithUser(User user, String _searchString, int _maxResults) {
		return clientOrderDAO.searchWithUser(session, user, _searchString, _maxResults);
	}
	
	/**
	 * Deletes a ClientOrder.
	 */
	public void delete(ClientOrder entity) {
		clientOrderDAO.delete(session, entity);
	}
	
		/**
	 * Deletes all ClientOrders where date is set to a value before '_maxDate'.
	 */
	public void deleteClientOrdersWithDateBefore(java.util.Date _maxDate) {
		Query query = getSession().createQuery(
			"DELETE FROM " + ClientOrder.class.getName() + " " +
			"WHERE " + ClientOrderDAO.FIELD__DATE + " < ?"
		);
		query.setParameter(0, _maxDate);
		query.executeUpdate();
	}
	
	/**
	 * Deletes all ClientOrders where date is set to a value after '_minDate'.
	 */
	public void deleteClientOrdersWithDateAfter(java.util.Date _minDate) {
		Query query = getSession().createQuery(
			"DELETE FROM " + ClientOrder.class.getName() + " " +
			"WHERE " + ClientOrderDAO.FIELD__DATE + " > ?"
		);
		query.setParameter(0, _minDate);
		query.executeUpdate();
	}
	
		/**
	 * Counts the number of ClientOrder entities.
	 */
	public int countClientOrders() {
		return clientOrderDAO.count(session);
	}
	
	/** 
	 * Creates an instance of type OrderBinding using all read-only and all non-null properties.
	 */
	public OrderBinding createOrderBinding(ClientOrder order, Product product, User user, double price, int count) {
		return orderBindingDAO.create(session, order, product, user, price, count);
	}
	
	/**
	 * Returns the OrderBinding with the given id.
	 */
	public OrderBinding getOrderBinding(int id) {
		OrderBinding entity = orderBindingDAO.get(session, id);
		return entity;
	}
	
	/** Returns the OrderBindings with the given order. */
	public List<OrderBinding> getOrderBindingsByOrder(ClientOrder order) {
		List<OrderBinding> entities = orderBindingDAO.getByOrder(session, order);
		return entities;
	}
		
	/** Returns the OrderBindings with the given product. */
	public List<OrderBinding> getOrderBindingsByProduct(Product product) {
		List<OrderBinding> entities = orderBindingDAO.getByProduct(session, product);
		return entities;
	}
		
	/** Returns the OrderBindings with the given user. */
	public List<OrderBinding> getOrderBindingsByUser(User user) {
		List<OrderBinding> entities = orderBindingDAO.getByUser(session, user);
		return entities;
	}
		
	/**
	 * Returns all entities of type OrderBinding.
	 */
	public List<OrderBinding> getAllOrderBindings() {
		final List<OrderBinding> entities = orderBindingDAO.getAll(session);
		return entities;
	}
	
	/**
	 * Searches for entities of type OrderBinding.
	 */
	public List<OrderBinding> searchOrderBindings(String _searchString, int _maxResults) {
		return orderBindingDAO.search(session, _searchString, _maxResults);
	}
	
	/**
	 * Searches for entities of type OrderBinding.
	 */
	public List<OrderBinding> searchOrderBindingWithOrder(ClientOrder order, String _searchString, int _maxResults) {
		return orderBindingDAO.searchWithOrder(session, order, _searchString, _maxResults);
	}
	
	/**
	 * Searches for entities of type OrderBinding.
	 */
	public List<OrderBinding> searchOrderBindingWithProduct(Product product, String _searchString, int _maxResults) {
		return orderBindingDAO.searchWithProduct(session, product, _searchString, _maxResults);
	}
	
	/**
	 * Searches for entities of type OrderBinding.
	 */
	public List<OrderBinding> searchOrderBindingWithUser(User user, String _searchString, int _maxResults) {
		return orderBindingDAO.searchWithUser(session, user, _searchString, _maxResults);
	}
	
	/**
	 * Deletes a OrderBinding.
	 */
	public void delete(OrderBinding entity) {
		orderBindingDAO.delete(session, entity);
	}
	
		/**
	 * Counts the number of OrderBinding entities.
	 */
	public int countOrderBindings() {
		return orderBindingDAO.count(session);
	}
	
	/** 
	 * Creates an instance of type Product using all read-only and all non-null properties.
	 */
	public Product createProduct(java.lang.String name, Segment segment, Sign sign, double price, java.lang.String deliveryTime, int count) {
		return productDAO.create(session, name, segment, sign, price, deliveryTime, count);
	}
	
	/**
	 * Returns the Product with the given id.
	 */
	public Product getProduct(int id) {
		Product entity = productDAO.get(session, id);
		return entity;
	}
	
	/** Returns the Products with the given segment. */
	public List<Product> getProductsBySegment(Segment segment) {
		List<Product> entities = productDAO.getBySegment(session, segment);
		return entities;
	}
		
	/** Returns the Products with the given sign. */
	public List<Product> getProductsBySign(Sign sign) {
		List<Product> entities = productDAO.getBySign(session, sign);
		return entities;
	}
		
	/**
	 * Returns all entities of type Product.
	 */
	public List<Product> getAllProducts() {
		final List<Product> entities = productDAO.getAll(session);
		return entities;
	}
	
	/**
	 * Searches for entities of type Product.
	 */
	public List<Product> searchProducts(String _searchString, int _maxResults) {
		return productDAO.search(session, _searchString, _maxResults);
	}
	
	/**
	 * Searches for entities of type Product.
	 */
	public List<Product> searchProductWithSegment(Segment segment, String _searchString, int _maxResults) {
		return productDAO.searchWithSegment(session, segment, _searchString, _maxResults);
	}
	
	/**
	 * Searches for entities of type Product.
	 */
	public List<Product> searchProductWithSign(Sign sign, String _searchString, int _maxResults) {
		return productDAO.searchWithSign(session, sign, _searchString, _maxResults);
	}
	
	/**
	 * Deletes a Product.
	 */
	public void delete(Product entity) {
		productDAO.delete(session, entity);
	}
	
		/**
	 * Counts the number of Product entities.
	 */
	public int countProducts() {
		return productDAO.count(session);
	}
	
	/** 
	 * Creates an instance of type Picture using all read-only and all non-null properties.
	 */
	public Picture createPicture(Product product, java.lang.String path) {
		return pictureDAO.create(session, product, path);
	}
	
	/**
	 * Returns the Picture with the given id.
	 */
	public Picture getPicture(int id) {
		Picture entity = pictureDAO.get(session, id);
		return entity;
	}
	
	/** Returns the Pictures with the given product. */
	public List<Picture> getPicturesByProduct(Product product) {
		List<Picture> entities = pictureDAO.getByProduct(session, product);
		return entities;
	}
		
	/**
	 * Returns all entities of type Picture.
	 */
	public List<Picture> getAllPictures() {
		final List<Picture> entities = pictureDAO.getAll(session);
		return entities;
	}
	
	/**
	 * Searches for entities of type Picture.
	 */
	public List<Picture> searchPictures(String _searchString, int _maxResults) {
		return pictureDAO.search(session, _searchString, _maxResults);
	}
	
	/**
	 * Searches for entities of type Picture.
	 */
	public List<Picture> searchPictureWithProduct(Product product, String _searchString, int _maxResults) {
		return pictureDAO.searchWithProduct(session, product, _searchString, _maxResults);
	}
	
	/**
	 * Deletes a Picture.
	 */
	public void delete(Picture entity) {
		pictureDAO.delete(session, entity);
	}
	
		/**
	 * Counts the number of Picture entities.
	 */
	public int countPictures() {
		return pictureDAO.count(session);
	}
	
	/** 
	 * Creates an instance of type User using all read-only and all non-null properties.
	 */
	public User createUser(java.lang.String name, java.lang.String surname, java.lang.String login, java.lang.String pass, int privilegy) {
		return userDAO.create(session, name, surname, login, pass, privilegy);
	}
	
	/**
	 * Returns the User with the given id.
	 */
	public User getUser(int id) {
		User entity = userDAO.get(session, id);
		return entity;
	}
	
	/**
	 * Returns all entities of type User.
	 */
	public List<User> getAllUsers() {
		final List<User> entities = userDAO.getAll(session);
		return entities;
	}
	
	/**
	 * Searches for entities of type User.
	 */
	public List<User> searchUsers(String _searchString, int _maxResults) {
		return userDAO.search(session, _searchString, _maxResults);
	}
	
	/**
	 * Deletes a User.
	 */
	public void delete(User entity) {
		userDAO.delete(session, entity);
	}
	
		/**
	 * Counts the number of User entities.
	 */
	public int countUsers() {
		return userDAO.count(session);
	}
	
	/** 
	 * Creates an instance of type Rating using all read-only and all non-null properties.
	 */
	public Rating createRating(User user, Product product, int value) {
		return ratingDAO.create(session, user, product, value);
	}
	
	/**
	 * Returns the Rating with the given id.
	 */
	public Rating getRating(int id) {
		Rating entity = ratingDAO.get(session, id);
		return entity;
	}
	
	/** Returns the Ratings with the given user. */
	public List<Rating> getRatingsByUser(User user) {
		List<Rating> entities = ratingDAO.getByUser(session, user);
		return entities;
	}
		
	/** Returns the Ratings with the given product. */
	public List<Rating> getRatingsByProduct(Product product) {
		List<Rating> entities = ratingDAO.getByProduct(session, product);
		return entities;
	}
		
	/**
	 * Returns all entities of type Rating.
	 */
	public List<Rating> getAllRatings() {
		final List<Rating> entities = ratingDAO.getAll(session);
		return entities;
	}
	
	/**
	 * Searches for entities of type Rating.
	 */
	public List<Rating> searchRatings(String _searchString, int _maxResults) {
		return ratingDAO.search(session, _searchString, _maxResults);
	}
	
	/**
	 * Searches for entities of type Rating.
	 */
	public List<Rating> searchRatingWithUser(User user, String _searchString, int _maxResults) {
		return ratingDAO.searchWithUser(session, user, _searchString, _maxResults);
	}
	
	/**
	 * Searches for entities of type Rating.
	 */
	public List<Rating> searchRatingWithProduct(Product product, String _searchString, int _maxResults) {
		return ratingDAO.searchWithProduct(session, product, _searchString, _maxResults);
	}
	
	/**
	 * Deletes a Rating.
	 */
	public void delete(Rating entity) {
		ratingDAO.delete(session, entity);
	}
	
		/**
	 * Counts the number of Rating entities.
	 */
	public int countRatings() {
		return ratingDAO.count(session);
	}
	
	/** 
	 * Creates an instance of type Delivery using all read-only and all non-null properties.
	 */
	public Delivery createDelivery(java.lang.String name) {
		return deliveryDAO.create(session, name);
	}
	
	/**
	 * Returns the Delivery with the given id.
	 */
	public Delivery getDelivery(int id) {
		Delivery entity = deliveryDAO.get(session, id);
		return entity;
	}
	
	/**
	 * Returns all entities of type Delivery.
	 */
	public List<Delivery> getAllDeliverys() {
		final List<Delivery> entities = deliveryDAO.getAll(session);
		return entities;
	}
	
	/**
	 * Searches for entities of type Delivery.
	 */
	public List<Delivery> searchDeliverys(String _searchString, int _maxResults) {
		return deliveryDAO.search(session, _searchString, _maxResults);
	}
	
	/**
	 * Deletes a Delivery.
	 */
	public void delete(Delivery entity) {
		deliveryDAO.delete(session, entity);
	}
	
		/**
	 * Counts the number of Delivery entities.
	 */
	public int countDeliverys() {
		return deliveryDAO.count(session);
	}
	
	/** 
	 * Creates an instance of type PaymentType using all read-only and all non-null properties.
	 */
	public PaymentType createPaymentType(java.lang.String name) {
		return paymentTypeDAO.create(session, name);
	}
	
	/**
	 * Returns the PaymentType with the given id.
	 */
	public PaymentType getPaymentType(int id) {
		PaymentType entity = paymentTypeDAO.get(session, id);
		return entity;
	}
	
	/**
	 * Returns all entities of type PaymentType.
	 */
	public List<PaymentType> getAllPaymentTypes() {
		final List<PaymentType> entities = paymentTypeDAO.getAll(session);
		return entities;
	}
	
	/**
	 * Searches for entities of type PaymentType.
	 */
	public List<PaymentType> searchPaymentTypes(String _searchString, int _maxResults) {
		return paymentTypeDAO.search(session, _searchString, _maxResults);
	}
	
	/**
	 * Deletes a PaymentType.
	 */
	public void delete(PaymentType entity) {
		paymentTypeDAO.delete(session, entity);
	}
	
		/**
	 * Counts the number of PaymentType entities.
	 */
	public int countPaymentTypes() {
		return paymentTypeDAO.count(session);
	}
	
	/** 
	 * Creates an instance of type Contact using all read-only and all non-null properties.
	 */
	public Contact createContact(java.lang.String name) {
		return contactDAO.create(session, name);
	}
	
	/**
	 * Returns the Contact with the given id.
	 */
	public Contact getContact(int id) {
		Contact entity = contactDAO.get(session, id);
		return entity;
	}
	
	/**
	 * Returns all entities of type Contact.
	 */
	public List<Contact> getAllContacts() {
		final List<Contact> entities = contactDAO.getAll(session);
		return entities;
	}
	
	/**
	 * Searches for entities of type Contact.
	 */
	public List<Contact> searchContacts(String _searchString, int _maxResults) {
		return contactDAO.search(session, _searchString, _maxResults);
	}
	
	/**
	 * Deletes a Contact.
	 */
	public void delete(Contact entity) {
		contactDAO.delete(session, entity);
	}
	
		/**
	 * Counts the number of Contact entities.
	 */
	public int countContacts() {
		return contactDAO.count(session);
	}
	
	/** 
	 * Creates an instance of type ContactBinding using all read-only and all non-null properties.
	 */
	public ContactBinding createContactBinding(Contact contact, User user) {
		return contactBindingDAO.create(session, contact, user);
	}
	
	/**
	 * Returns the ContactBinding with the given id.
	 */
	public ContactBinding getContactBinding(int id) {
		ContactBinding entity = contactBindingDAO.get(session, id);
		return entity;
	}
	
	/** Returns the ContactBindings with the given contact. */
	public List<ContactBinding> getContactBindingsByContact(Contact contact) {
		List<ContactBinding> entities = contactBindingDAO.getByContact(session, contact);
		return entities;
	}
		
	/** Returns the ContactBindings with the given user. */
	public List<ContactBinding> getContactBindingsByUser(User user) {
		List<ContactBinding> entities = contactBindingDAO.getByUser(session, user);
		return entities;
	}
		
	/**
	 * Returns all entities of type ContactBinding.
	 */
	public List<ContactBinding> getAllContactBindings() {
		final List<ContactBinding> entities = contactBindingDAO.getAll(session);
		return entities;
	}
	
	/**
	 * Searches for entities of type ContactBinding.
	 */
	public List<ContactBinding> searchContactBindings(String _searchString, int _maxResults) {
		return contactBindingDAO.search(session, _searchString, _maxResults);
	}
	
	/**
	 * Searches for entities of type ContactBinding.
	 */
	public List<ContactBinding> searchContactBindingWithContact(Contact contact, String _searchString, int _maxResults) {
		return contactBindingDAO.searchWithContact(session, contact, _searchString, _maxResults);
	}
	
	/**
	 * Searches for entities of type ContactBinding.
	 */
	public List<ContactBinding> searchContactBindingWithUser(User user, String _searchString, int _maxResults) {
		return contactBindingDAO.searchWithUser(session, user, _searchString, _maxResults);
	}
	
	/**
	 * Deletes a ContactBinding.
	 */
	public void delete(ContactBinding entity) {
		contactBindingDAO.delete(session, entity);
	}
	
		/**
	 * Counts the number of ContactBinding entities.
	 */
	public int countContactBindings() {
		return contactBindingDAO.count(session);
	}
	
	/** 
	 * Creates an instance of type Address using all read-only and all non-null properties.
	 */
	public Address createAddress(java.lang.String city, java.lang.String street, java.lang.String zip) {
		return addressDAO.create(session, city, street, zip);
	}
	
	/**
	 * Returns the Address with the given id.
	 */
	public Address getAddress(int id) {
		Address entity = addressDAO.get(session, id);
		return entity;
	}
	
	/**
	 * Returns all entities of type Address.
	 */
	public List<Address> getAllAddresss() {
		final List<Address> entities = addressDAO.getAll(session);
		return entities;
	}
	
	/**
	 * Searches for entities of type Address.
	 */
	public List<Address> searchAddresss(String _searchString, int _maxResults) {
		return addressDAO.search(session, _searchString, _maxResults);
	}
	
	/**
	 * Deletes a Address.
	 */
	public void delete(Address entity) {
		addressDAO.delete(session, entity);
	}
	
		/**
	 * Counts the number of Address entities.
	 */
	public int countAddresss() {
		return addressDAO.count(session);
	}
	
	/** 
	 * Creates an instance of type AddressBinding using all read-only and all non-null properties.
	 */
	public AddressBinding createAddressBinding(Address address, User user, boolean deliveryHome) {
		return addressBindingDAO.create(session, address, user, deliveryHome);
	}
	
	/**
	 * Returns the AddressBinding with the given id.
	 */
	public AddressBinding getAddressBinding(int id) {
		AddressBinding entity = addressBindingDAO.get(session, id);
		return entity;
	}
	
	/** Returns the AddressBindings with the given address. */
	public List<AddressBinding> getAddressBindingsByAddress(Address address) {
		List<AddressBinding> entities = addressBindingDAO.getByAddress(session, address);
		return entities;
	}
		
	/** Returns the AddressBindings with the given user. */
	public List<AddressBinding> getAddressBindingsByUser(User user) {
		List<AddressBinding> entities = addressBindingDAO.getByUser(session, user);
		return entities;
	}
		
	/**
	 * Returns all entities of type AddressBinding.
	 */
	public List<AddressBinding> getAllAddressBindings() {
		final List<AddressBinding> entities = addressBindingDAO.getAll(session);
		return entities;
	}
	
	/**
	 * Searches for entities of type AddressBinding.
	 */
	public List<AddressBinding> searchAddressBindings(String _searchString, int _maxResults) {
		return addressBindingDAO.search(session, _searchString, _maxResults);
	}
	
	/**
	 * Searches for entities of type AddressBinding.
	 */
	public List<AddressBinding> searchAddressBindingWithAddress(Address address, String _searchString, int _maxResults) {
		return addressBindingDAO.searchWithAddress(session, address, _searchString, _maxResults);
	}
	
	/**
	 * Searches for entities of type AddressBinding.
	 */
	public List<AddressBinding> searchAddressBindingWithUser(User user, String _searchString, int _maxResults) {
		return addressBindingDAO.searchWithUser(session, user, _searchString, _maxResults);
	}
	
	/**
	 * Deletes a AddressBinding.
	 */
	public void delete(AddressBinding entity) {
		addressBindingDAO.delete(session, entity);
	}
	
		/**
	 * Counts the number of AddressBinding entities.
	 */
	public int countAddressBindings() {
		return addressBindingDAO.count(session);
	}
	
	/**
	 * Returns the name of the table that contains entities of the given type.
	 */
	public String getTableName(Class<?> clazz) {
		ClassMetadata hibernateMetadata = getSession().getSessionFactory().getClassMetadata(clazz);
		if (hibernateMetadata == null) {
		    return null;
		}
		if (hibernateMetadata instanceof AbstractEntityPersister) {
		     AbstractEntityPersister persister = (AbstractEntityPersister) hibernateMetadata;
		     return persister.getTableName();
		}
		return null;
	}
}
