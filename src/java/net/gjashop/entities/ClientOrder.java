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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "clientorder"
)
/*
 * This class is generated from the entity 'ClientOrder' defined in the HEDL model.
 * Note: Any change made to this class will be overridden.
 */
public class ClientOrder {
	
	@GenericGenerator(name="ClientOrderIdGenerator", strategy="org.hibernate.id.MultipleHiLoPerTableGenerator",
	  parameters = {
	    @Parameter(name="table", value="IdentityGenerator"),
	    @Parameter(name="primary_key_column", value="sequence_name"),
	    @Parameter(name="primary_key_value", value="ClientOrder"),
	    @Parameter(name="value_column", value="next_hi_value"),
	    @Parameter(name="primary_key_length", value="100"),
	    @Parameter(name="max_lo", value="1000")
	  }
	)
	@Id 
	@GeneratedValue(strategy=GenerationType.TABLE, generator="ClientOrderIdGenerator")
	private int id;

	@ManyToOne(cascade={CascadeType.ALL})
	@JoinColumn(name="delivery", nullable=false)
	private Delivery delivery;
	
	@ManyToOne(cascade={CascadeType.ALL})
	@JoinColumn(name="paymenttype", nullable=false)
	private PaymentType paymentType;
	
	@ManyToOne(cascade={CascadeType.ALL})
	@JoinColumn(name="user", nullable=false)
	private User user;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="date")
	private java.util.Date date;
	
	@Column(name="deliverycity")
	private java.lang.String deliveryCity;
	
	@Column(name="deliverystreet")
	private java.lang.String deliveryStreet;
	
	@Column(name="deliveryzip")
	private java.lang.String deliveryZip;
	
	/**
	 * Default constructor. Only used by Hibernate.
	 */
	public ClientOrder() {
		super();
	}

	/**
	 * Constructor using all read-only and all non-nullable properties.
	 */
	public ClientOrder(Delivery delivery, PaymentType paymentType, User user, java.util.Date date, java.lang.String deliveryCity, java.lang.String deliveryStreet, java.lang.String deliveryZip) {
		super();
		this.delivery = delivery;
		this.paymentType = paymentType;
		this.user = user;
		this.date = date;
		this.deliveryCity = deliveryCity;
		this.deliveryStreet = deliveryStreet;
		this.deliveryZip = deliveryZip;
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
	 * Returns the value of property 'delivery'.
	 */
	public Delivery getDelivery() {
		return delivery;
	}
	
	/**
	 * Sets the value of property 'delivery'.
	 */
	public void setDelivery(Delivery newValue) {
		this.delivery = newValue;
	}
	
	/**
	 * Returns the value of property 'paymentType'.
	 */
	public PaymentType getPaymentType() {
		return paymentType;
	}
	
	/**
	 * Sets the value of property 'paymentType'.
	 */
	public void setPaymentType(PaymentType newValue) {
		this.paymentType = newValue;
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
	 * Returns the value of property 'date'.
	 */
	public java.util.Date getDate() {
		return date;
	}
	
	/**
	 * Sets the value of property 'date'.
	 */
	public void setDate(java.util.Date newValue) {
		this.date = newValue;
	}
	
	/**
	 * Returns the value of property 'deliveryCity'.
	 */
	public java.lang.String getDeliveryCity() {
		return deliveryCity;
	}
	
	/**
	 * Sets the value of property 'deliveryCity'.
	 */
	public void setDeliveryCity(java.lang.String newValue) {
		this.deliveryCity = newValue;
	}
	
	/**
	 * Returns the value of property 'deliveryStreet'.
	 */
	public java.lang.String getDeliveryStreet() {
		return deliveryStreet;
	}
	
	/**
	 * Sets the value of property 'deliveryStreet'.
	 */
	public void setDeliveryStreet(java.lang.String newValue) {
		this.deliveryStreet = newValue;
	}
	
	/**
	 * Returns the value of property 'deliveryZip'.
	 */
	public java.lang.String getDeliveryZip() {
		return deliveryZip;
	}
	
	/**
	 * Sets the value of property 'deliveryZip'.
	 */
	public void setDeliveryZip(java.lang.String newValue) {
		this.deliveryZip = newValue;
	}
	
}
