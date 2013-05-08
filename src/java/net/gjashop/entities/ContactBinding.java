package net.gjashop.entities;

import javax.persistence.CascadeType;
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
@Table(name = "contactbinding"
)
/*
 * This class is generated from the entity 'ContactBinding' defined in the HEDL model.
 * Note: Any change made to this class will be overridden.
 */
public class ContactBinding {
	
	@GenericGenerator(name="ContactBindingIdGenerator", strategy="org.hibernate.id.MultipleHiLoPerTableGenerator",
	  parameters = {
	    @Parameter(name="table", value="IdentityGenerator"),
	    @Parameter(name="primary_key_column", value="sequence_name"),
	    @Parameter(name="primary_key_value", value="ContactBinding"),
	    @Parameter(name="value_column", value="next_hi_value"),
	    @Parameter(name="primary_key_length", value="100"),
	    @Parameter(name="max_lo", value="1000")
	  }
	)
	@Id 
	@GeneratedValue(strategy=GenerationType.TABLE, generator="ContactBindingIdGenerator")
	private int id;

	@ManyToOne(cascade={CascadeType.ALL})
	@JoinColumn(name="contact", nullable=false)
	private Contact contact;
	
	@ManyToOne(cascade={CascadeType.ALL})
	@JoinColumn(name="user", nullable=false)
	private User user;
	
	/**
	 * Default constructor. Only used by Hibernate.
	 */
	public ContactBinding() {
		super();
	}

	/**
	 * Constructor using all read-only and all non-nullable properties.
	 */
	public ContactBinding(Contact contact, User user) {
		super();
		this.contact = contact;
		this.user = user;
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
	 * Returns the value of property 'contact'.
	 */
	public Contact getContact() {
		return contact;
	}
	
	/**
	 * Sets the value of property 'contact'.
	 */
	public void setContact(Contact newValue) {
		this.contact = newValue;
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
	
}
