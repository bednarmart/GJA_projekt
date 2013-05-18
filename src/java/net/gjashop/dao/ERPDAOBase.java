package net.gjashop.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import net.gjashop.custom.IDBOperations;
import net.gjashop.custom.OperationProvider;
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

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.TransactionException;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.hibernate.stat.Statistics;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.hibernate.tool.hbm2ddl.SchemaUpdate;

// this class is generated. any change will be overridden.
public abstract class ERPDAOBase implements IDBOperationsBase {
	
	private static SessionFactory sessionFactory;
	
	private Class<?> contextClass;

	public ERPDAOBase() {
		this(null);
	}
	
	/**
	 * Creates a new DAO that uses the given context class to load the
	 * Hibernate configuration 'hibernate.properties' using 
	 * Class.getResourceAsStream().
	 */
	public ERPDAOBase(Class<?> contextClass) {
		this.contextClass = contextClass;
	}
	
	private void configure() throws HibernateException {
		Configuration configuration = getConfiguration();
		//configuration.setProperty("hibernate.show_sql", "true");
		sessionFactory = configuration.buildSessionFactory();
	}

	private Configuration getConfiguration() {
		Configuration configuration = new Configuration();
/*		configuration = configuration.addAnnotatedClass(Category.class);
		configuration = configuration.addAnnotatedClass(Segment.class);
		configuration = configuration.addAnnotatedClass(Sign.class);
		configuration = configuration.addAnnotatedClass(ClientOrder.class);
		configuration = configuration.addAnnotatedClass(OrderBinding.class);
		configuration = configuration.addAnnotatedClass(Product.class);
		configuration = configuration.addAnnotatedClass(Picture.class);
		configuration = configuration.addAnnotatedClass(User.class);
		configuration = configuration.addAnnotatedClass(Rating.class);
		configuration = configuration.addAnnotatedClass(Delivery.class);
		configuration = configuration.addAnnotatedClass(PaymentType.class);
		configuration = configuration.addAnnotatedClass(Contact.class);
		configuration = configuration.addAnnotatedClass(ContactBinding.class);
		configuration = configuration.addAnnotatedClass(Address.class);
		configuration = configuration.addAnnotatedClass(AddressBinding.class);*/
		if (contextClass != null) {
			Properties properties = new Properties();
			try {
				properties.load(contextClass.getResourceAsStream("hibernate.properties"));
			} catch(IOException ioe) {
				throw new RuntimeException("Can't find hibernate.properties next to context class.");
			}
			configuration.setProperties(properties);
		}
		return configuration;
	}
	
	protected SessionFactory getSessionFactory() {
		synchronized (ERPDAOBase.class) {
			if (sessionFactory == null) {
				configure();
			}
			return sessionFactory;
		}
	}
	
	/**
	 * This method is deprecated. It is not meant
	 * to be used on the DAO directly. 
	 * Use OperationProvider.update(Object entity) instead.
	 */
	@Deprecated
	public void update(Object entity) {
	}
	
	public void createSchema() throws HibernateException {
		SchemaExport schemaExport = new SchemaExport(getConfiguration());
		schemaExport.setFormat(true);
		schemaExport.create(false, false);
	}

	public void updateSchema() {
		SchemaUpdate update = new SchemaUpdate(getConfiguration());
		update.execute(true, true);
		List<?> exceptions = update.getExceptions();
		for (Object object : exceptions) {
			System.err.println("Exception while updating schema " + object);
		}
	}
	
	public void executeInTransaction(ICommand command) {
		executeInTransaction(command, true);
	}
	
	private void executeInTransaction(ICommand command, boolean retry) {
		boolean successful = false;
		boolean closed = false;
		
		Session session = getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			command.execute(new OperationProvider(session));
			tx.commit();
			successful = true;
		} catch (Exception e) {
			handleException(e, retry);
			if (tx != null) {
				try {
					tx.rollback();
				} catch (TransactionException te) {
					handleException(te, retry);
				}
			}
		} finally {
			try {
				session.close();
				closed = true;
			} catch (HibernateException he) {
				handleException(he, retry);
			}
		}
		
		if ((!successful || !closed) && retry) {
			// retry once
			executeInTransaction(command, false);
		}
	}
	
	public abstract void handleException(Exception e, boolean retry);
	
	public Statistics getStatistics() {
		Statistics statistics = sessionFactory.getStatistics();
		return statistics;
	}
	
	public void tearDown() {
		synchronized (ERPDAOBase.class) {
			if (sessionFactory != null) {
				sessionFactory.close();
				sessionFactory = null;
			}
		}
	}

	/**
	 * Creates a new Category using all read-only and all non-null properties.
	 */
	public Category createCategory(final java.lang.String name) {
		final Category[] entity = new Category[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entity[0] = operations.createCategory(name);
			}
		});
		return entity[0];
	}
	
	/**
	 * Returns the Category with the given id.
	 */
	public Category getCategory(final int id) {
		final Category[] entity = new Category[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entity[0] = operations.getCategory(id);
			}
		});
		return entity[0];
	}
	
	/**
	 * Returns all entities of type Category.
	 */
	public List<Category> getAllCategorys() {
		final List<Category> entities = new ArrayList<Category>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.getAllCategorys());
			}
		});
		return entities;
	}
	
	/**
	 * Searches for entities of type Category.
	 */
	public List<Category> searchCategorys(final String _searchString, final int _maxResults) {
		final List<Category> entities = new ArrayList<Category>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.searchCategorys(_searchString, _maxResults));
			}
		});
		return entities;
	}
	
	/**
	 * Deletes a Category.
	 */
	public void delete(final Category entity) {
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				operations.delete(entity);
			}
		});
	}
	
	/**
	 * Counts the number of Category entities.
	 */
	public int countCategorys() {
		final int[] count = new int[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				count[0] = operations.countCategorys();
			}
		});
		return count[0];
	}
	
	/**
	 * Creates a new Segment using all read-only and all non-null properties.
	 */
	public Segment createSegment(final Category category, final java.lang.String name) {
		final Segment[] entity = new Segment[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entity[0] = operations.createSegment(category, name);
			}
		});
		return entity[0];
	}
	
	/**
	 * Returns the Segment with the given id.
	 */
	public Segment getSegment(final int id) {
		final Segment[] entity = new Segment[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entity[0] = operations.getSegment(id);
			}
		});
		return entity[0];
	}
	
	/**
	 * Returns the Segments with the given category.
	 */
	public List<Segment> getSegmentsByCategory(final Category category) {
		final List<Segment> entities = new ArrayList<Segment>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.getSegmentsByCategory(category));
			}
		});
		return entities;
	}
	
	/**
	 * Returns all entities of type Segment.
	 */
	public List<Segment> getAllSegments() {
		final List<Segment> entities = new ArrayList<Segment>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.getAllSegments());
			}
		});
		return entities;
	}
	
	/**
	 * Searches for entities of type Segment.
	 */
	public List<Segment> searchSegments(final String _searchString, final int _maxResults) {
		final List<Segment> entities = new ArrayList<Segment>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.searchSegments(_searchString, _maxResults));
			}
		});
		return entities;
	}
	
	/**
	 * Searches for entities of type Segment.
	 */
	public List<Segment> searchSegmentWithCategory(final Category category, final String _searchString, final int _maxResults) {
		final List<Segment> entities = new ArrayList<Segment>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.searchSegmentWithCategory(category, _searchString, _maxResults));
			}
		});
		return entities;
	}
	
	/**
	 * Deletes a Segment.
	 */
	public void delete(final Segment entity) {
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				operations.delete(entity);
			}
		});
	}
	
	/**
	 * Counts the number of Segment entities.
	 */
	public int countSegments() {
		final int[] count = new int[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				count[0] = operations.countSegments();
			}
		});
		return count[0];
	}
	
	/**
	 * Creates a new Sign using all read-only and all non-null properties.
	 */
	public Sign createSign(final java.lang.String name) {
		final Sign[] entity = new Sign[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entity[0] = operations.createSign(name);
			}
		});
		return entity[0];
	}
	
	/**
	 * Returns the Sign with the given id.
	 */
	public Sign getSign(final int id) {
		final Sign[] entity = new Sign[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entity[0] = operations.getSign(id);
			}
		});
		return entity[0];
	}
	
	/**
	 * Returns all entities of type Sign.
	 */
	public List<Sign> getAllSigns() {
		final List<Sign> entities = new ArrayList<Sign>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.getAllSigns());
			}
		});
		return entities;
	}
	
	/**
	 * Searches for entities of type Sign.
	 */
	public List<Sign> searchSigns(final String _searchString, final int _maxResults) {
		final List<Sign> entities = new ArrayList<Sign>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.searchSigns(_searchString, _maxResults));
			}
		});
		return entities;
	}
	
	/**
	 * Deletes a Sign.
	 */
	public void delete(final Sign entity) {
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				operations.delete(entity);
			}
		});
	}
	
	/**
	 * Counts the number of Sign entities.
	 */
	public int countSigns() {
		final int[] count = new int[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				count[0] = operations.countSigns();
			}
		});
		return count[0];
	}
	
	/**
	 * Creates a new ClientOrder using all read-only and all non-null properties.
	 */
	public ClientOrder createClientOrder(final Delivery delivery, final PaymentType paymentType, final User user, final java.util.Date date, final java.lang.String deliveryCity, final java.lang.String deliveryStreet, final java.lang.String deliveryZip) {
		final ClientOrder[] entity = new ClientOrder[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entity[0] = operations.createClientOrder(delivery, paymentType, user, date, deliveryCity, deliveryStreet, deliveryZip);
			}
		});
		return entity[0];
	}
	
	/**
	 * Returns the ClientOrder with the given id.
	 */
	public ClientOrder getClientOrder(final int id) {
		final ClientOrder[] entity = new ClientOrder[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entity[0] = operations.getClientOrder(id);
			}
		});
		return entity[0];
	}
	
	/**
	 * Returns the ClientOrders with the given delivery.
	 */
	public List<ClientOrder> getClientOrdersByDelivery(final Delivery delivery) {
		final List<ClientOrder> entities = new ArrayList<ClientOrder>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.getClientOrdersByDelivery(delivery));
			}
		});
		return entities;
	}
	
	/**
	 * Returns the ClientOrders with the given paymentType.
	 */
	public List<ClientOrder> getClientOrdersByPaymentType(final PaymentType paymentType) {
		final List<ClientOrder> entities = new ArrayList<ClientOrder>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.getClientOrdersByPaymentType(paymentType));
			}
		});
		return entities;
	}
	
	/**
	 * Returns the ClientOrders with the given user.
	 */
	public List<ClientOrder> getClientOrdersByUser(final User user) {
		final List<ClientOrder> entities = new ArrayList<ClientOrder>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.getClientOrdersByUser(user));
			}
		});
		return entities;
	}
	
	/**
	 * Returns all ClientOrders where date is set to a value before '_maxDate'.
	 */
	public List<ClientOrder> getClientOrdersWithDateBefore(final java.util.Date _maxDate) {
		final List<ClientOrder> entities = new ArrayList<ClientOrder>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.getClientOrdersWithDateBefore(_maxDate));
			}
		});
		return entities;
	}
	
	/**
	 * Returns all ClientOrders where date is set to a value after '_minDate'.
	 */
	public List<ClientOrder> getClientOrdersWithDateAfter(final java.util.Date _minDate) {
		final List<ClientOrder> entities = new ArrayList<ClientOrder>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.getClientOrdersWithDateAfter(_minDate));
			}
		});
		return entities;
	}
	
	/**
	 * Returns all entities of type ClientOrder.
	 */
	public List<ClientOrder> getAllClientOrders() {
		final List<ClientOrder> entities = new ArrayList<ClientOrder>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.getAllClientOrders());
			}
		});
		return entities;
	}
	
	/**
	 * Searches for entities of type ClientOrder.
	 */
	public List<ClientOrder> searchClientOrders(final String _searchString, final int _maxResults) {
		final List<ClientOrder> entities = new ArrayList<ClientOrder>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.searchClientOrders(_searchString, _maxResults));
			}
		});
		return entities;
	}
	
	/**
	 * Searches for entities of type ClientOrder.
	 */
	public List<ClientOrder> searchClientOrderWithDelivery(final Delivery delivery, final String _searchString, final int _maxResults) {
		final List<ClientOrder> entities = new ArrayList<ClientOrder>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.searchClientOrderWithDelivery(delivery, _searchString, _maxResults));
			}
		});
		return entities;
	}
	
	/**
	 * Searches for entities of type ClientOrder.
	 */
	public List<ClientOrder> searchClientOrderWithPaymentType(final PaymentType paymentType, final String _searchString, final int _maxResults) {
		final List<ClientOrder> entities = new ArrayList<ClientOrder>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.searchClientOrderWithPaymentType(paymentType, _searchString, _maxResults));
			}
		});
		return entities;
	}
	
	/**
	 * Searches for entities of type ClientOrder.
	 */
	public List<ClientOrder> searchClientOrderWithUser(final User user, final String _searchString, final int _maxResults) {
		final List<ClientOrder> entities = new ArrayList<ClientOrder>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.searchClientOrderWithUser(user, _searchString, _maxResults));
			}
		});
		return entities;
	}
	
	/**
	 * Deletes a ClientOrder.
	 */
	public void delete(final ClientOrder entity) {
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				operations.delete(entity);
			}
		});
	}
	
	/**
	 * Deletes all ClientOrders where date is set to a value before '_maxDate'.
	 */
	public void deleteClientOrdersWithDateBefore(final java.util.Date _maxDate) {
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				operations.deleteClientOrdersWithDateBefore(_maxDate);
			}
		});
	}
	
	/**
	 * Deletes all ClientOrders where date is set to a value after '_minDate'.
	 */
	public void deleteClientOrdersWithDateAfter(final java.util.Date _minDate) {
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				operations.deleteClientOrdersWithDateBefore(_minDate);
			}
		});
	}
	
	/**
	 * Counts the number of ClientOrder entities.
	 */
	public int countClientOrders() {
		final int[] count = new int[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				count[0] = operations.countClientOrders();
			}
		});
		return count[0];
	}
	
	/**
	 * Creates a new OrderBinding using all read-only and all non-null properties.
	 */
	public OrderBinding createOrderBinding(final ClientOrder order, final Product product, final User user, final double price, final int count) {
		final OrderBinding[] entity = new OrderBinding[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entity[0] = operations.createOrderBinding(order, product, user, price, count);
			}
		});
		return entity[0];
	}
	
	/**
	 * Returns the OrderBinding with the given id.
	 */
	public OrderBinding getOrderBinding(final int id) {
		final OrderBinding[] entity = new OrderBinding[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entity[0] = operations.getOrderBinding(id);
			}
		});
		return entity[0];
	}
	
	/**
	 * Returns the OrderBindings with the given order.
	 */
	public List<OrderBinding> getOrderBindingsByOrder(final ClientOrder order) {
		final List<OrderBinding> entities = new ArrayList<OrderBinding>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.getOrderBindingsByOrder(order));
			}
		});
		return entities;
	}
	
	/**
	 * Returns the OrderBindings with the given product.
	 */
	public List<OrderBinding> getOrderBindingsByProduct(final Product product) {
		final List<OrderBinding> entities = new ArrayList<OrderBinding>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.getOrderBindingsByProduct(product));
			}
		});
		return entities;
	}
	
	/**
	 * Returns the OrderBindings with the given user.
	 */
	public List<OrderBinding> getOrderBindingsByUser(final User user) {
		final List<OrderBinding> entities = new ArrayList<OrderBinding>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.getOrderBindingsByUser(user));
			}
		});
		return entities;
	}
	
	/**
	 * Returns all entities of type OrderBinding.
	 */
	public List<OrderBinding> getAllOrderBindings() {
		final List<OrderBinding> entities = new ArrayList<OrderBinding>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.getAllOrderBindings());
			}
		});
		return entities;
	}
	
	/**
	 * Searches for entities of type OrderBinding.
	 */
	public List<OrderBinding> searchOrderBindings(final String _searchString, final int _maxResults) {
		final List<OrderBinding> entities = new ArrayList<OrderBinding>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.searchOrderBindings(_searchString, _maxResults));
			}
		});
		return entities;
	}
	
	/**
	 * Searches for entities of type OrderBinding.
	 */
	public List<OrderBinding> searchOrderBindingWithOrder(final ClientOrder order, final String _searchString, final int _maxResults) {
		final List<OrderBinding> entities = new ArrayList<OrderBinding>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.searchOrderBindingWithOrder(order, _searchString, _maxResults));
			}
		});
		return entities;
	}
	
	/**
	 * Searches for entities of type OrderBinding.
	 */
	public List<OrderBinding> searchOrderBindingWithProduct(final Product product, final String _searchString, final int _maxResults) {
		final List<OrderBinding> entities = new ArrayList<OrderBinding>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.searchOrderBindingWithProduct(product, _searchString, _maxResults));
			}
		});
		return entities;
	}
	
	/**
	 * Searches for entities of type OrderBinding.
	 */
	public List<OrderBinding> searchOrderBindingWithUser(final User user, final String _searchString, final int _maxResults) {
		final List<OrderBinding> entities = new ArrayList<OrderBinding>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.searchOrderBindingWithUser(user, _searchString, _maxResults));
			}
		});
		return entities;
	}
	
	/**
	 * Deletes a OrderBinding.
	 */
	public void delete(final OrderBinding entity) {
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				operations.delete(entity);
			}
		});
	}
	
	/**
	 * Counts the number of OrderBinding entities.
	 */
	public int countOrderBindings() {
		final int[] count = new int[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				count[0] = operations.countOrderBindings();
			}
		});
		return count[0];
	}
	
	/**
	 * Creates a new Product using all read-only and all non-null properties.
	 */
	public Product createProduct(final java.lang.String name, final Segment segment, final Sign sign, final double price, final java.lang.String deliveryTime, final int count) {
		final Product[] entity = new Product[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entity[0] = operations.createProduct(name, segment, sign, price, deliveryTime, count);
			}
		});
		return entity[0];
	}
	
	/**
	 * Returns the Product with the given id.
	 */
	public Product getProduct(final int id) {
		final Product[] entity = new Product[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entity[0] = operations.getProduct(id);
			}
		});
		return entity[0];
	}
	
	/**
	 * Returns the Products with the given segment.
	 */
	public List<Product> getProductsBySegment(final Segment segment) {
		final List<Product> entities = new ArrayList<Product>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.getProductsBySegment(segment));
			}
		});
		return entities;
	}
	
	/**
	 * Returns the Products with the given sign.
	 */
	public List<Product> getProductsBySign(final Sign sign) {
		final List<Product> entities = new ArrayList<Product>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.getProductsBySign(sign));
			}
		});
		return entities;
	}
	
	/**
	 * Returns all entities of type Product.
	 */
	public List<Product> getAllProducts() {
		final List<Product> entities = new ArrayList<Product>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.getAllProducts());
			}
		});
		return entities;
	}
	
	/**
	 * Searches for entities of type Product.
	 */
	public List<Product> searchProducts(final String _searchString, final int _maxResults) {
		final List<Product> entities = new ArrayList<Product>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.searchProducts(_searchString, _maxResults));
			}
		});
		return entities;
	}
	
	/**
	 * Searches for entities of type Product.
	 */
	public List<Product> searchProductWithSegment(final Segment segment, final String _searchString, final int _maxResults) {
		final List<Product> entities = new ArrayList<Product>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.searchProductWithSegment(segment, _searchString, _maxResults));
			}
		});
		return entities;
	}
	
	/**
	 * Searches for entities of type Product.
	 */
	public List<Product> searchProductWithSign(final Sign sign, final String _searchString, final int _maxResults) {
		final List<Product> entities = new ArrayList<Product>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.searchProductWithSign(sign, _searchString, _maxResults));
			}
		});
		return entities;
	}
	
	/**
	 * Deletes a Product.
	 */
	public void delete(final Product entity) {
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				operations.delete(entity);
			}
		});
	}
	
	/**
	 * Counts the number of Product entities.
	 */
	public int countProducts() {
		final int[] count = new int[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				count[0] = operations.countProducts();
			}
		});
		return count[0];
	}
	
	/**
	 * Creates a new Picture using all read-only and all non-null properties.
	 */
	public Picture createPicture(final Product product, final java.lang.String path) {
		final Picture[] entity = new Picture[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entity[0] = operations.createPicture(product, path);
			}
		});
		return entity[0];
	}
	
	/**
	 * Returns the Picture with the given id.
	 */
	public Picture getPicture(final int id) {
		final Picture[] entity = new Picture[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entity[0] = operations.getPicture(id);
			}
		});
		return entity[0];
	}
	
	/**
	 * Returns the Pictures with the given product.
	 */
	public List<Picture> getPicturesByProduct(final Product product) {
		final List<Picture> entities = new ArrayList<Picture>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.getPicturesByProduct(product));
			}
		});
		return entities;
	}
	
	/**
	 * Returns all entities of type Picture.
	 */
	public List<Picture> getAllPictures() {
		final List<Picture> entities = new ArrayList<Picture>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.getAllPictures());
			}
		});
		return entities;
	}
	
	/**
	 * Searches for entities of type Picture.
	 */
	public List<Picture> searchPictures(final String _searchString, final int _maxResults) {
		final List<Picture> entities = new ArrayList<Picture>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.searchPictures(_searchString, _maxResults));
			}
		});
		return entities;
	}
	
	/**
	 * Searches for entities of type Picture.
	 */
	public List<Picture> searchPictureWithProduct(final Product product, final String _searchString, final int _maxResults) {
		final List<Picture> entities = new ArrayList<Picture>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.searchPictureWithProduct(product, _searchString, _maxResults));
			}
		});
		return entities;
	}
	
	/**
	 * Deletes a Picture.
	 */
	public void delete(final Picture entity) {
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				operations.delete(entity);
			}
		});
	}
	
	/**
	 * Counts the number of Picture entities.
	 */
	public int countPictures() {
		final int[] count = new int[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				count[0] = operations.countPictures();
			}
		});
		return count[0];
	}
	
	/**
	 * Creates a new User using all read-only and all non-null properties.
	 */
	public User createUser(final java.lang.String name, final java.lang.String surname, final java.lang.String login, final java.lang.String pass, final int privilegy) {
		final User[] entity = new User[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entity[0] = operations.createUser(name, surname, login, pass, privilegy);
			}
		});
		return entity[0];
	}
	
	/**
	 * Returns the User with the given id.
	 */
	public User getUser(final int id) {
		final User[] entity = new User[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entity[0] = operations.getUser(id);
			}
		});
		return entity[0];
	}
	
	/**
	 * Returns all entities of type User.
	 */
	public List<User> getAllUsers() {
		final List<User> entities = new ArrayList<User>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.getAllUsers());
			}
		});
		return entities;
	}
	
	/**
	 * Searches for entities of type User.
	 */
	public List<User> searchUsers(final String _searchString, final int _maxResults) {
		final List<User> entities = new ArrayList<User>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.searchUsers(_searchString, _maxResults));
			}
		});
		return entities;
	}
	
	/**
	 * Deletes a User.
	 */
	public void delete(final User entity) {
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				operations.delete(entity);
			}
		});
	}
	
	/**
	 * Counts the number of User entities.
	 */
	public int countUsers() {
		final int[] count = new int[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				count[0] = operations.countUsers();
			}
		});
		return count[0];
	}
	
	/**
	 * Creates a new Rating using all read-only and all non-null properties.
	 */
	public Rating createRating(final User user, final Product product, final int value) {
		final Rating[] entity = new Rating[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entity[0] = operations.createRating(user, product, value);
			}
		});
		return entity[0];
	}
	
	/**
	 * Returns the Rating with the given id.
	 */
	public Rating getRating(final int id) {
		final Rating[] entity = new Rating[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entity[0] = operations.getRating(id);
			}
		});
		return entity[0];
	}
	
	/**
	 * Returns the Ratings with the given user.
	 */
	public List<Rating> getRatingsByUser(final User user) {
		final List<Rating> entities = new ArrayList<Rating>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.getRatingsByUser(user));
			}
		});
		return entities;
	}
	
	/**
	 * Returns the Ratings with the given product.
	 */
	public List<Rating> getRatingsByProduct(final Product product) {
		final List<Rating> entities = new ArrayList<Rating>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.getRatingsByProduct(product));
			}
		});
		return entities;
	}
	
	/**
	 * Returns all entities of type Rating.
	 */
	public List<Rating> getAllRatings() {
		final List<Rating> entities = new ArrayList<Rating>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.getAllRatings());
			}
		});
		return entities;
	}
	
	/**
	 * Searches for entities of type Rating.
	 */
	public List<Rating> searchRatings(final String _searchString, final int _maxResults) {
		final List<Rating> entities = new ArrayList<Rating>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.searchRatings(_searchString, _maxResults));
			}
		});
		return entities;
	}
	
	/**
	 * Searches for entities of type Rating.
	 */
	public List<Rating> searchRatingWithUser(final User user, final String _searchString, final int _maxResults) {
		final List<Rating> entities = new ArrayList<Rating>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.searchRatingWithUser(user, _searchString, _maxResults));
			}
		});
		return entities;
	}
	
	/**
	 * Searches for entities of type Rating.
	 */
	public List<Rating> searchRatingWithProduct(final Product product, final String _searchString, final int _maxResults) {
		final List<Rating> entities = new ArrayList<Rating>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.searchRatingWithProduct(product, _searchString, _maxResults));
			}
		});
		return entities;
	}
	
	/**
	 * Deletes a Rating.
	 */
	public void delete(final Rating entity) {
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				operations.delete(entity);
			}
		});
	}
	
	/**
	 * Counts the number of Rating entities.
	 */
	public int countRatings() {
		final int[] count = new int[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				count[0] = operations.countRatings();
			}
		});
		return count[0];
	}
	
	/**
	 * Creates a new Delivery using all read-only and all non-null properties.
	 */
	public Delivery createDelivery(final java.lang.String name) {
		final Delivery[] entity = new Delivery[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entity[0] = operations.createDelivery(name);
			}
		});
		return entity[0];
	}
	
	/**
	 * Returns the Delivery with the given id.
	 */
	public Delivery getDelivery(final int id) {
		final Delivery[] entity = new Delivery[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entity[0] = operations.getDelivery(id);
			}
		});
		return entity[0];
	}
	
	/**
	 * Returns all entities of type Delivery.
	 */
	public List<Delivery> getAllDeliverys() {
		final List<Delivery> entities = new ArrayList<Delivery>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.getAllDeliverys());
			}
		});
		return entities;
	}
	
	/**
	 * Searches for entities of type Delivery.
	 */
	public List<Delivery> searchDeliverys(final String _searchString, final int _maxResults) {
		final List<Delivery> entities = new ArrayList<Delivery>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.searchDeliverys(_searchString, _maxResults));
			}
		});
		return entities;
	}
	
	/**
	 * Deletes a Delivery.
	 */
	public void delete(final Delivery entity) {
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				operations.delete(entity);
			}
		});
	}
	
	/**
	 * Counts the number of Delivery entities.
	 */
	public int countDeliverys() {
		final int[] count = new int[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				count[0] = operations.countDeliverys();
			}
		});
		return count[0];
	}
	
	/**
	 * Creates a new PaymentType using all read-only and all non-null properties.
	 */
	public PaymentType createPaymentType(final java.lang.String name) {
		final PaymentType[] entity = new PaymentType[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entity[0] = operations.createPaymentType(name);
			}
		});
		return entity[0];
	}
	
	/**
	 * Returns the PaymentType with the given id.
	 */
	public PaymentType getPaymentType(final int id) {
		final PaymentType[] entity = new PaymentType[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entity[0] = operations.getPaymentType(id);
			}
		});
		return entity[0];
	}
	
	/**
	 * Returns all entities of type PaymentType.
	 */
	public List<PaymentType> getAllPaymentTypes() {
		final List<PaymentType> entities = new ArrayList<PaymentType>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.getAllPaymentTypes());
			}
		});
		return entities;
	}
	
	/**
	 * Searches for entities of type PaymentType.
	 */
	public List<PaymentType> searchPaymentTypes(final String _searchString, final int _maxResults) {
		final List<PaymentType> entities = new ArrayList<PaymentType>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.searchPaymentTypes(_searchString, _maxResults));
			}
		});
		return entities;
	}
	
	/**
	 * Deletes a PaymentType.
	 */
	public void delete(final PaymentType entity) {
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				operations.delete(entity);
			}
		});
	}
	
	/**
	 * Counts the number of PaymentType entities.
	 */
	public int countPaymentTypes() {
		final int[] count = new int[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				count[0] = operations.countPaymentTypes();
			}
		});
		return count[0];
	}
	
	/**
	 * Creates a new Contact using all read-only and all non-null properties.
	 */
	public Contact createContact(final java.lang.String name) {
		final Contact[] entity = new Contact[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entity[0] = operations.createContact(name);
			}
		});
		return entity[0];
	}
	
	/**
	 * Returns the Contact with the given id.
	 */
	public Contact getContact(final int id) {
		final Contact[] entity = new Contact[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entity[0] = operations.getContact(id);
			}
		});
		return entity[0];
	}
	
	/**
	 * Returns all entities of type Contact.
	 */
	public List<Contact> getAllContacts() {
		final List<Contact> entities = new ArrayList<Contact>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.getAllContacts());
			}
		});
		return entities;
	}
	
	/**
	 * Searches for entities of type Contact.
	 */
	public List<Contact> searchContacts(final String _searchString, final int _maxResults) {
		final List<Contact> entities = new ArrayList<Contact>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.searchContacts(_searchString, _maxResults));
			}
		});
		return entities;
	}
	
	/**
	 * Deletes a Contact.
	 */
	public void delete(final Contact entity) {
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				operations.delete(entity);
			}
		});
	}
	
	/**
	 * Counts the number of Contact entities.
	 */
	public int countContacts() {
		final int[] count = new int[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				count[0] = operations.countContacts();
			}
		});
		return count[0];
	}
	
	/**
	 * Creates a new ContactBinding using all read-only and all non-null properties.
	 */
	public ContactBinding createContactBinding(final Contact contact, final User user) {
		final ContactBinding[] entity = new ContactBinding[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entity[0] = operations.createContactBinding(contact, user);
			}
		});
		return entity[0];
	}
	
	/**
	 * Returns the ContactBinding with the given id.
	 */
	public ContactBinding getContactBinding(final int id) {
		final ContactBinding[] entity = new ContactBinding[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entity[0] = operations.getContactBinding(id);
			}
		});
		return entity[0];
	}
	
	/**
	 * Returns the ContactBindings with the given contact.
	 */
	public List<ContactBinding> getContactBindingsByContact(final Contact contact) {
		final List<ContactBinding> entities = new ArrayList<ContactBinding>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.getContactBindingsByContact(contact));
			}
		});
		return entities;
	}
	
	/**
	 * Returns the ContactBindings with the given user.
	 */
	public List<ContactBinding> getContactBindingsByUser(final User user) {
		final List<ContactBinding> entities = new ArrayList<ContactBinding>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.getContactBindingsByUser(user));
			}
		});
		return entities;
	}
	
	/**
	 * Returns all entities of type ContactBinding.
	 */
	public List<ContactBinding> getAllContactBindings() {
		final List<ContactBinding> entities = new ArrayList<ContactBinding>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.getAllContactBindings());
			}
		});
		return entities;
	}
	
	/**
	 * Searches for entities of type ContactBinding.
	 */
	public List<ContactBinding> searchContactBindings(final String _searchString, final int _maxResults) {
		final List<ContactBinding> entities = new ArrayList<ContactBinding>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.searchContactBindings(_searchString, _maxResults));
			}
		});
		return entities;
	}
	
	/**
	 * Searches for entities of type ContactBinding.
	 */
	public List<ContactBinding> searchContactBindingWithContact(final Contact contact, final String _searchString, final int _maxResults) {
		final List<ContactBinding> entities = new ArrayList<ContactBinding>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.searchContactBindingWithContact(contact, _searchString, _maxResults));
			}
		});
		return entities;
	}
	
	/**
	 * Searches for entities of type ContactBinding.
	 */
	public List<ContactBinding> searchContactBindingWithUser(final User user, final String _searchString, final int _maxResults) {
		final List<ContactBinding> entities = new ArrayList<ContactBinding>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.searchContactBindingWithUser(user, _searchString, _maxResults));
			}
		});
		return entities;
	}
	
	/**
	 * Deletes a ContactBinding.
	 */
	public void delete(final ContactBinding entity) {
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				operations.delete(entity);
			}
		});
	}
	
	/**
	 * Counts the number of ContactBinding entities.
	 */
	public int countContactBindings() {
		final int[] count = new int[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				count[0] = operations.countContactBindings();
			}
		});
		return count[0];
	}
	
	/**
	 * Creates a new Address using all read-only and all non-null properties.
	 */
	public Address createAddress(final java.lang.String city, final java.lang.String street, final java.lang.String zip) {
		final Address[] entity = new Address[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entity[0] = operations.createAddress(city, street, zip);
			}
		});
		return entity[0];
	}
	
	/**
	 * Returns the Address with the given id.
	 */
	public Address getAddress(final int id) {
		final Address[] entity = new Address[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entity[0] = operations.getAddress(id);
			}
		});
		return entity[0];
	}
	
	/**
	 * Returns all entities of type Address.
	 */
	public List<Address> getAllAddresss() {
		final List<Address> entities = new ArrayList<Address>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.getAllAddresss());
			}
		});
		return entities;
	}
	
	/**
	 * Searches for entities of type Address.
	 */
	public List<Address> searchAddresss(final String _searchString, final int _maxResults) {
		final List<Address> entities = new ArrayList<Address>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.searchAddresss(_searchString, _maxResults));
			}
		});
		return entities;
	}
	
	/**
	 * Deletes a Address.
	 */
	public void delete(final Address entity) {
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				operations.delete(entity);
			}
		});
	}
	
	/**
	 * Counts the number of Address entities.
	 */
	public int countAddresss() {
		final int[] count = new int[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				count[0] = operations.countAddresss();
			}
		});
		return count[0];
	}
	
	/**
	 * Creates a new AddressBinding using all read-only and all non-null properties.
	 */
	public AddressBinding createAddressBinding(final Address address, final User user, final boolean deliveryHome) {
		final AddressBinding[] entity = new AddressBinding[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entity[0] = operations.createAddressBinding(address, user, deliveryHome);
			}
		});
		return entity[0];
	}
	
	/**
	 * Returns the AddressBinding with the given id.
	 */
	public AddressBinding getAddressBinding(final int id) {
		final AddressBinding[] entity = new AddressBinding[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entity[0] = operations.getAddressBinding(id);
			}
		});
		return entity[0];
	}
	
	/**
	 * Returns the AddressBindings with the given address.
	 */
	public List<AddressBinding> getAddressBindingsByAddress(final Address address) {
		final List<AddressBinding> entities = new ArrayList<AddressBinding>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.getAddressBindingsByAddress(address));
			}
		});
		return entities;
	}
	
	/**
	 * Returns the AddressBindings with the given user.
	 */
	public List<AddressBinding> getAddressBindingsByUser(final User user) {
		final List<AddressBinding> entities = new ArrayList<AddressBinding>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.getAddressBindingsByUser(user));
			}
		});
		return entities;
	}
	
	/**
	 * Returns all entities of type AddressBinding.
	 */
	public List<AddressBinding> getAllAddressBindings() {
		final List<AddressBinding> entities = new ArrayList<AddressBinding>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.getAllAddressBindings());
			}
		});
		return entities;
	}
	
	/**
	 * Searches for entities of type AddressBinding.
	 */
	public List<AddressBinding> searchAddressBindings(final String _searchString, final int _maxResults) {
		final List<AddressBinding> entities = new ArrayList<AddressBinding>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.searchAddressBindings(_searchString, _maxResults));
			}
		});
		return entities;
	}
	
	/**
	 * Searches for entities of type AddressBinding.
	 */
	public List<AddressBinding> searchAddressBindingWithAddress(final Address address, final String _searchString, final int _maxResults) {
		final List<AddressBinding> entities = new ArrayList<AddressBinding>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.searchAddressBindingWithAddress(address, _searchString, _maxResults));
			}
		});
		return entities;
	}
	
	/**
	 * Searches for entities of type AddressBinding.
	 */
	public List<AddressBinding> searchAddressBindingWithUser(final User user, final String _searchString, final int _maxResults) {
		final List<AddressBinding> entities = new ArrayList<AddressBinding>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.searchAddressBindingWithUser(user, _searchString, _maxResults));
			}
		});
		return entities;
	}
	
	/**
	 * Deletes a AddressBinding.
	 */
	public void delete(final AddressBinding entity) {
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				operations.delete(entity);
			}
		});
	}
	
	/**
	 * Counts the number of AddressBinding entities.
	 */
	public int countAddressBindings() {
		final int[] count = new int[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				count[0] = operations.countAddressBindings();
			}
		});
		return count[0];
	}
		
}
