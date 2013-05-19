package net.gjashop.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "orderbinding"
)
/*
 * This class is generated from the entity 'OrderBinding' defined in the HEDL model.
 * Note: Any change made to this class will be overridden.
 */
public class OrderBinding {
	
	@GenericGenerator(name="OrderBindingIdGenerator", strategy="org.hibernate.id.MultipleHiLoPerTableGenerator",
	  parameters = {
	    @Parameter(name="table", value="IdentityGenerator"),
	    @Parameter(name="primary_key_column", value="sequence_name"),
	    @Parameter(name="primary_key_value", value="OrderBinding"),
	    @Parameter(name="value_column", value="next_hi_value"),
	    @Parameter(name="primary_key_length", value="100"),
	    @Parameter(name="max_lo", value="1000")
	  }
	)
	@Id 
	@GeneratedValue(strategy=GenerationType.TABLE, generator="OrderBindingIdGenerator")
	private int id;

	@ManyToOne(cascade={CascadeType.ALL})
	@JoinColumn(name="clientorder", nullable=false)
	private ClientOrder clientOrder;
	
	@ManyToOne(cascade={CascadeType.ALL})
	@JoinColumn(name="product", nullable=false)
	private Product product;
	
	@ManyToOne(cascade={CascadeType.ALL})
	@JoinColumn(name="user", nullable=false)
	private User user;
	
	@Column(name="price")
	private double price;
	
	@Column(name="count")
	private int count;
	
	/**
	 * Default constructor. Only used by Hibernate.
	 */
	public OrderBinding() {
		super();
	}

	/**
	 * Constructor using all read-only and all non-nullable properties.
	 */
	public OrderBinding(ClientOrder clientOrder, Product product, User user, double price, int count) {
		super();
		this.clientOrder = clientOrder;
		this.product = product;
		this.user = user;
		this.price = price;
		this.count = count;
	}
	
	/**
	 * Returns the automatically generated id that identifies this entity object.
	 */
	public int getId() {
		return id;
	}

	/**
	 * The property 'id' is read-only. 
	 * This setter is only provided for Hibernate. 
	 * It must not be used directly.
	 */
	@Deprecated
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Returns the value of property 'clientOrder'.
	 */
	public ClientOrder getClientOrder() {
		return clientOrder;
	}
	
	/**
	 * Sets the value of property 'clientOrder'.
	 */
	public void setClientOrder(ClientOrder newValue) {
		this.clientOrder = newValue;
	}
	
	/**
	 * Returns the value of property 'product'.
	 */
	public Product getProduct() {
		return product;
	}
	
	/**
	 * Sets the value of property 'product'.
	 */
	public void setProduct(Product newValue) {
		this.product = newValue;
	}
	
	/**
	 * Returns the value of property 'user'.
	 */
	public User getUser() {
		return user;
	}
	
	/**
	 * Sets the value of property 'user'.
	 */
	public void setUser(User newValue) {
		this.user = newValue;
	}
	
	/**
	 * Returns the value of property 'price'.
	 */
	public double getPrice() {
		return price;
	}
	
	/**
	 * Sets the value of property 'price'.
	 */
	public void setPrice(double newValue) {
		this.price = newValue;
	}
	
	/**
	 * Returns the value of property 'count'.
	 */
	public int getCount() {
		return count;
	}
	
	/**
	 * Sets the value of property 'count'.
	 */
	public void setCount(int newValue) {
		this.count = newValue;
	}
	
}
