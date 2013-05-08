package net.gjashop.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "address"
)
/*
 * This class is generated from the entity 'Address' defined in the HEDL model.
 * Note: Any change made to this class will be overridden.
 */
public class Address {
	
	@GenericGenerator(name="AddressIdGenerator", strategy="org.hibernate.id.MultipleHiLoPerTableGenerator",
	  parameters = {
	    @Parameter(name="table", value="IdentityGenerator"),
	    @Parameter(name="primary_key_column", value="sequence_name"),
	    @Parameter(name="primary_key_value", value="Address"),
	    @Parameter(name="value_column", value="next_hi_value"),
	    @Parameter(name="primary_key_length", value="100"),
	    @Parameter(name="max_lo", value="1000")
	  }
	)
	@Id 
	@GeneratedValue(strategy=GenerationType.TABLE, generator="AddressIdGenerator")
	private int id;

	@Column(name="city")
	private java.lang.String city;
	
	@Column(name="street")
	private java.lang.String street;
	
	@Column(name="zip")
	private java.lang.String zip;
	
	/**
	 * Default constructor. Only used by Hibernate.
	 */
	public Address() {
		super();
	}

	/**
	 * Constructor using all read-only and all non-nullable properties.
	 */
	public Address(java.lang.String city, java.lang.String street, java.lang.String zip) {
		super();
		this.city = city;
		this.street = street;
		this.zip = zip;
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
	 * Returns the value of property 'city'.
	 */
	public java.lang.String getCity() {
		return city;
	}
	
	/**
	 * Sets the value of property 'city'.
	 */
	public void setCity(java.lang.String newValue) {
		this.city = newValue;
	}
	
	/**
	 * Returns the value of property 'street'.
	 */
	public java.lang.String getStreet() {
		return street;
	}
	
	/**
	 * Sets the value of property 'street'.
	 */
	public void setStreet(java.lang.String newValue) {
		this.street = newValue;
	}
	
	/**
	 * Returns the value of property 'zip'.
	 */
	public java.lang.String getZip() {
		return zip;
	}
	
	/**
	 * Sets the value of property 'zip'.
	 */
	public void setZip(java.lang.String newValue) {
		this.zip = newValue;
	}
	
}
