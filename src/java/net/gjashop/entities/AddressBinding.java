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
@Table(name = "addressbinding"
)
/*
 * This class is generated from the entity 'AddressBinding' defined in the HEDL model.
 * Note: Any change made to this class will be overridden.
 */
public class AddressBinding {
	
	@GenericGenerator(name="AddressBindingIdGenerator", strategy="org.hibernate.id.MultipleHiLoPerTableGenerator",
	  parameters = {
	    @Parameter(name="table", value="IdentityGenerator"),
	    @Parameter(name="primary_key_column", value="sequence_name"),
	    @Parameter(name="primary_key_value", value="AddressBinding"),
	    @Parameter(name="value_column", value="next_hi_value"),
	    @Parameter(name="primary_key_length", value="100"),
	    @Parameter(name="max_lo", value="1000")
	  }
	)
	@Id 
	@GeneratedValue(strategy=GenerationType.TABLE, generator="AddressBindingIdGenerator")
	private int id;

	@ManyToOne(cascade={CascadeType.ALL})
	@JoinColumn(name="address", nullable=false)
	private Address address;
	
	@ManyToOne(cascade={CascadeType.ALL})
	@JoinColumn(name="user", nullable=false)
	private User user;
	
	@Column(name="deliveryhome")
	private boolean deliveryHome;
	
	/**
	 * Default constructor. Only used by Hibernate.
	 */
	public AddressBinding() {
		super();
	}

	/**
	 * Constructor using all read-only and all non-nullable properties.
	 */
	public AddressBinding(Address address, User user, boolean deliveryHome) {
		super();
		this.address = address;
		this.user = user;
		this.deliveryHome = deliveryHome;
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
	 * Returns the value of property 'address'.
	 */
	public Address getAddress() {
		return address;
	}
	
	/**
	 * Sets the value of property 'address'.
	 */
	public void setAddress(Address newValue) {
		this.address = newValue;
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
	 * Returns the value of property 'deliveryHome'.
	 */
	public boolean getDeliveryHome() {
		return deliveryHome;
	}
	
	/**
	 * Sets the value of property 'deliveryHome'.
	 */
	public void setDeliveryHome(boolean newValue) {
		this.deliveryHome = newValue;
	}
	
}
