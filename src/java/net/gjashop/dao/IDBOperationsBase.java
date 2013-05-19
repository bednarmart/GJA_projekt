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

// this class is generated. any change will be overridden.
public interface IDBOperationsBase {
	
	/**
	 * Creates a new Category using all read-only and all non-null properties.
	 */
	public Category createCategory(java.lang.String name);
	
	/**
	 * Returns the Category with the given id.
	 */
	public Category getCategory(int id);
		
	/**
	 * Returns all entities of type Category.
	 */
	public List<Category> getAllCategorys();
		
	/**
	 * Searches for entities of type Category.
	 */
	public List<Category> searchCategorys(String _searchString, int _maxResults);
	
	/**
	 * Deletes a Category.
	 */
	public void delete(Category entity);
	
	/**
	 * Counts the number of Category entities.
	 */
	public int countCategorys();
	
	/**
	 * Creates a new Segment using all read-only and all non-null properties.
	 */
	public Segment createSegment(Category category, java.lang.String name);
	
	/**
	 * Returns the Segment with the given id.
	 */
	public Segment getSegment(int id);
		
	/**
	 * Returns the Segments with the given category.
	 */
	public List<Segment> getSegmentsByCategory(Category category);
	
	/**
	 * Returns all entities of type Segment.
	 */
	public List<Segment> getAllSegments();
		
	/**
	 * Searches for entities of type Segment.
	 */
	public List<Segment> searchSegments(String _searchString, int _maxResults);
	
	/**
	 * Searches for entities of type Segment.
	 */
	public List<Segment> searchSegmentWithCategory(final Category category, String _searchString, int _maxResults);
	
	/**
	 * Deletes a Segment.
	 */
	public void delete(Segment entity);
	
	/**
	 * Counts the number of Segment entities.
	 */
	public int countSegments();
	
	/**
	 * Creates a new Sign using all read-only and all non-null properties.
	 */
	public Sign createSign(java.lang.String name);
	
	/**
	 * Returns the Sign with the given id.
	 */
	public Sign getSign(int id);
		
	/**
	 * Returns all entities of type Sign.
	 */
	public List<Sign> getAllSigns();
		
	/**
	 * Searches for entities of type Sign.
	 */
	public List<Sign> searchSigns(String _searchString, int _maxResults);
	
	/**
	 * Deletes a Sign.
	 */
	public void delete(Sign entity);
	
	/**
	 * Counts the number of Sign entities.
	 */
	public int countSigns();
	
	/**
	 * Creates a new ClientOrder using all read-only and all non-null properties.
	 */
	public ClientOrder createClientOrder(Delivery delivery, PaymentType paymentType, User user, java.util.Date date, java.lang.String deliveryCity, java.lang.String deliveryStreet, java.lang.String deliveryZip);
	
	/**
	 * Returns the ClientOrder with the given id.
	 */
	public ClientOrder getClientOrder(int id);
		
	/**
	 * Returns the ClientOrders with the given delivery.
	 */
	public List<ClientOrder> getClientOrdersByDelivery(Delivery delivery);
	
	/**
	 * Returns the ClientOrders with the given paymentType.
	 */
	public List<ClientOrder> getClientOrdersByPaymentType(PaymentType paymentType);
	
	/**
	 * Returns the ClientOrders with the given user.
	 */
	public List<ClientOrder> getClientOrdersByUser(User user);
	
	/**
	 * Returns all ClientOrders where date is set to a value before '_maxDate'.
	 */
	public List<ClientOrder> getClientOrdersWithDateBefore(java.util.Date _maxDate);
	
	/**
	 * Returns all ClientOrders where date is set to a value after '_minDate'.
	 */
	public List<ClientOrder> getClientOrdersWithDateAfter(java.util.Date _minDate);
	
	/**
	 * Returns all entities of type ClientOrder.
	 */
	public List<ClientOrder> getAllClientOrders();
		
	/**
	 * Searches for entities of type ClientOrder.
	 */
	public List<ClientOrder> searchClientOrders(String _searchString, int _maxResults);
	
	/**
	 * Searches for entities of type ClientOrder.
	 */
	public List<ClientOrder> searchClientOrderWithDelivery(final Delivery delivery, String _searchString, int _maxResults);
	
	/**
	 * Searches for entities of type ClientOrder.
	 */
	public List<ClientOrder> searchClientOrderWithPaymentType(final PaymentType paymentType, String _searchString, int _maxResults);
	
	/**
	 * Searches for entities of type ClientOrder.
	 */
	public List<ClientOrder> searchClientOrderWithUser(final User user, String _searchString, int _maxResults);
	
	/**
	 * Deletes a ClientOrder.
	 */
	public void delete(ClientOrder entity);
	
	/**
	 * Deletes all ClientOrders where date is set to a value before '_maxDate'.
	 */
	public void deleteClientOrdersWithDateBefore(java.util.Date _maxDate);
	
	/**
	 * Deletes all ClientOrders where date is set to a value after '_minDate'.
	 */
	public void deleteClientOrdersWithDateAfter(java.util.Date _minDate);
	
	/**
	 * Counts the number of ClientOrder entities.
	 */
	public int countClientOrders();
	
	/**
	 * Creates a new OrderBinding using all read-only and all non-null properties.
	 */
	public OrderBinding createOrderBinding(ClientOrder clientOrder, Product product, User user, double price, int count);
	
	/**
	 * Returns the OrderBinding with the given id.
	 */
	public OrderBinding getOrderBinding(int id);
		
	/**
	 * Returns the OrderBindings with the given clientOrder.
	 */
	public List<OrderBinding> getOrderBindingsByClientOrder(ClientOrder clientOrder);
	
	/**
	 * Returns the OrderBindings with the given product.
	 */
	public List<OrderBinding> getOrderBindingsByProduct(Product product);
	
	/**
	 * Returns the OrderBindings with the given user.
	 */
	public List<OrderBinding> getOrderBindingsByUser(User user);
	
	/**
	 * Returns all entities of type OrderBinding.
	 */
	public List<OrderBinding> getAllOrderBindings();
		
	/**
	 * Searches for entities of type OrderBinding.
	 */
	public List<OrderBinding> searchOrderBindings(String _searchString, int _maxResults);
	
	/**
	 * Searches for entities of type OrderBinding.
	 */
	public List<OrderBinding> searchOrderBindingWithClientOrder(final ClientOrder clientOrder, String _searchString, int _maxResults);
	
	/**
	 * Searches for entities of type OrderBinding.
	 */
	public List<OrderBinding> searchOrderBindingWithProduct(final Product product, String _searchString, int _maxResults);
	
	/**
	 * Searches for entities of type OrderBinding.
	 */
	public List<OrderBinding> searchOrderBindingWithUser(final User user, String _searchString, int _maxResults);
	
	/**
	 * Deletes a OrderBinding.
	 */
	public void delete(OrderBinding entity);
	
	/**
	 * Counts the number of OrderBinding entities.
	 */
	public int countOrderBindings();
	
	/**
	 * Creates a new Product using all read-only and all non-null properties.
	 */
	public Product createProduct(java.lang.String name, Segment segment, Sign sign, double price, java.lang.String deliveryTime, int count);
	
	/**
	 * Returns the Product with the given id.
	 */
	public Product getProduct(int id);
		
	/**
	 * Returns the Products with the given segment.
	 */
	public List<Product> getProductsBySegment(Segment segment);
	
	/**
	 * Returns the Products with the given sign.
	 */
	public List<Product> getProductsBySign(Sign sign);
	
	/**
	 * Returns all entities of type Product.
	 */
	public List<Product> getAllProducts();
		
	/**
	 * Searches for entities of type Product.
	 */
	public List<Product> searchProducts(String _searchString, int _maxResults);
	
	/**
	 * Searches for entities of type Product.
	 */
	public List<Product> searchProductWithSegment(final Segment segment, String _searchString, int _maxResults);
	
	/**
	 * Searches for entities of type Product.
	 */
	public List<Product> searchProductWithSign(final Sign sign, String _searchString, int _maxResults);
	
	/**
	 * Deletes a Product.
	 */
	public void delete(Product entity);
	
	/**
	 * Counts the number of Product entities.
	 */
	public int countProducts();
	
	/**
	 * Creates a new Picture using all read-only and all non-null properties.
	 */
	public Picture createPicture(Product product, java.lang.String path);
	
	/**
	 * Returns the Picture with the given id.
	 */
	public Picture getPicture(int id);
		
	/**
	 * Returns the Pictures with the given product.
	 */
	public List<Picture> getPicturesByProduct(Product product);
	
	/**
	 * Returns all entities of type Picture.
	 */
	public List<Picture> getAllPictures();
		
	/**
	 * Searches for entities of type Picture.
	 */
	public List<Picture> searchPictures(String _searchString, int _maxResults);
	
	/**
	 * Searches for entities of type Picture.
	 */
	public List<Picture> searchPictureWithProduct(final Product product, String _searchString, int _maxResults);
	
	/**
	 * Deletes a Picture.
	 */
	public void delete(Picture entity);
	
	/**
	 * Counts the number of Picture entities.
	 */
	public int countPictures();
	
	/**
	 * Creates a new User using all read-only and all non-null properties.
	 */
	public User createUser(java.lang.String name, java.lang.String surname, java.lang.String login, java.lang.String pass, int privilegy);
	
	/**
	 * Returns the User with the given id.
	 */
	public User getUser(int id);
		
	/**
	 * Returns all entities of type User.
	 */
	public List<User> getAllUsers();
		
	/**
	 * Searches for entities of type User.
	 */
	public List<User> searchUsers(String _searchString, int _maxResults);
	
	/**
	 * Deletes a User.
	 */
	public void delete(User entity);
	
	/**
	 * Counts the number of User entities.
	 */
	public int countUsers();
	
	/**
	 * Creates a new Rating using all read-only and all non-null properties.
	 */
	public Rating createRating(User user, Product product, int value);
	
	/**
	 * Returns the Rating with the given id.
	 */
	public Rating getRating(int id);
		
	/**
	 * Returns the Ratings with the given user.
	 */
	public List<Rating> getRatingsByUser(User user);
	
	/**
	 * Returns the Ratings with the given product.
	 */
	public List<Rating> getRatingsByProduct(Product product);
	
	/**
	 * Returns all entities of type Rating.
	 */
	public List<Rating> getAllRatings();
		
	/**
	 * Searches for entities of type Rating.
	 */
	public List<Rating> searchRatings(String _searchString, int _maxResults);
	
	/**
	 * Searches for entities of type Rating.
	 */
	public List<Rating> searchRatingWithUser(final User user, String _searchString, int _maxResults);
	
	/**
	 * Searches for entities of type Rating.
	 */
	public List<Rating> searchRatingWithProduct(final Product product, String _searchString, int _maxResults);
	
	/**
	 * Deletes a Rating.
	 */
	public void delete(Rating entity);
	
	/**
	 * Counts the number of Rating entities.
	 */
	public int countRatings();
	
	/**
	 * Creates a new Delivery using all read-only and all non-null properties.
	 */
	public Delivery createDelivery(java.lang.String name);
	
	/**
	 * Returns the Delivery with the given id.
	 */
	public Delivery getDelivery(int id);
		
	/**
	 * Returns all entities of type Delivery.
	 */
	public List<Delivery> getAllDeliverys();
		
	/**
	 * Searches for entities of type Delivery.
	 */
	public List<Delivery> searchDeliverys(String _searchString, int _maxResults);
	
	/**
	 * Deletes a Delivery.
	 */
	public void delete(Delivery entity);
	
	/**
	 * Counts the number of Delivery entities.
	 */
	public int countDeliverys();
	
	/**
	 * Creates a new PaymentType using all read-only and all non-null properties.
	 */
	public PaymentType createPaymentType(java.lang.String name);
	
	/**
	 * Returns the PaymentType with the given id.
	 */
	public PaymentType getPaymentType(int id);
		
	/**
	 * Returns all entities of type PaymentType.
	 */
	public List<PaymentType> getAllPaymentTypes();
		
	/**
	 * Searches for entities of type PaymentType.
	 */
	public List<PaymentType> searchPaymentTypes(String _searchString, int _maxResults);
	
	/**
	 * Deletes a PaymentType.
	 */
	public void delete(PaymentType entity);
	
	/**
	 * Counts the number of PaymentType entities.
	 */
	public int countPaymentTypes();
	
	/**
	 * Creates a new Contact using all read-only and all non-null properties.
	 */
	public Contact createContact(java.lang.String name);
	
	/**
	 * Returns the Contact with the given id.
	 */
	public Contact getContact(int id);
		
	/**
	 * Returns all entities of type Contact.
	 */
	public List<Contact> getAllContacts();
		
	/**
	 * Searches for entities of type Contact.
	 */
	public List<Contact> searchContacts(String _searchString, int _maxResults);
	
	/**
	 * Deletes a Contact.
	 */
	public void delete(Contact entity);
	
	/**
	 * Counts the number of Contact entities.
	 */
	public int countContacts();
	
	/**
	 * Creates a new ContactBinding using all read-only and all non-null properties.
	 */
	public ContactBinding createContactBinding(Contact contact, User user);
	
	/**
	 * Returns the ContactBinding with the given id.
	 */
	public ContactBinding getContactBinding(int id);
		
	/**
	 * Returns the ContactBindings with the given contact.
	 */
	public List<ContactBinding> getContactBindingsByContact(Contact contact);
	
	/**
	 * Returns the ContactBindings with the given user.
	 */
	public List<ContactBinding> getContactBindingsByUser(User user);
	
	/**
	 * Returns all entities of type ContactBinding.
	 */
	public List<ContactBinding> getAllContactBindings();
		
	/**
	 * Searches for entities of type ContactBinding.
	 */
	public List<ContactBinding> searchContactBindings(String _searchString, int _maxResults);
	
	/**
	 * Searches for entities of type ContactBinding.
	 */
	public List<ContactBinding> searchContactBindingWithContact(final Contact contact, String _searchString, int _maxResults);
	
	/**
	 * Searches for entities of type ContactBinding.
	 */
	public List<ContactBinding> searchContactBindingWithUser(final User user, String _searchString, int _maxResults);
	
	/**
	 * Deletes a ContactBinding.
	 */
	public void delete(ContactBinding entity);
	
	/**
	 * Counts the number of ContactBinding entities.
	 */
	public int countContactBindings();
	
	/**
	 * Creates a new Address using all read-only and all non-null properties.
	 */
	public Address createAddress(java.lang.String city, java.lang.String street, java.lang.String zip);
	
	/**
	 * Returns the Address with the given id.
	 */
	public Address getAddress(int id);
		
	/**
	 * Returns all entities of type Address.
	 */
	public List<Address> getAllAddresss();
		
	/**
	 * Searches for entities of type Address.
	 */
	public List<Address> searchAddresss(String _searchString, int _maxResults);
	
	/**
	 * Deletes a Address.
	 */
	public void delete(Address entity);
	
	/**
	 * Counts the number of Address entities.
	 */
	public int countAddresss();
	
	/**
	 * Creates a new AddressBinding using all read-only and all non-null properties.
	 */
	public AddressBinding createAddressBinding(Address address, User user, boolean deliveryHome);
	
	/**
	 * Returns the AddressBinding with the given id.
	 */
	public AddressBinding getAddressBinding(int id);
		
	/**
	 * Returns the AddressBindings with the given address.
	 */
	public List<AddressBinding> getAddressBindingsByAddress(Address address);
	
	/**
	 * Returns the AddressBindings with the given user.
	 */
	public List<AddressBinding> getAddressBindingsByUser(User user);
	
	/**
	 * Returns all entities of type AddressBinding.
	 */
	public List<AddressBinding> getAllAddressBindings();
		
	/**
	 * Searches for entities of type AddressBinding.
	 */
	public List<AddressBinding> searchAddressBindings(String _searchString, int _maxResults);
	
	/**
	 * Searches for entities of type AddressBinding.
	 */
	public List<AddressBinding> searchAddressBindingWithAddress(final Address address, String _searchString, int _maxResults);
	
	/**
	 * Searches for entities of type AddressBinding.
	 */
	public List<AddressBinding> searchAddressBindingWithUser(final User user, String _searchString, int _maxResults);
	
	/**
	 * Deletes a AddressBinding.
	 */
	public void delete(AddressBinding entity);
	
	/**
	 * Counts the number of AddressBinding entities.
	 */
	public int countAddressBindings();
	
	
	public void update(Object entity);
}
