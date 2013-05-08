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
@Table(name = "rating"
)
/*
 * This class is generated from the entity 'Rating' defined in the HEDL model.
 * Note: Any change made to this class will be overridden.
 */
public class Rating {
	
	@GenericGenerator(name="RatingIdGenerator", strategy="org.hibernate.id.MultipleHiLoPerTableGenerator",
	  parameters = {
	    @Parameter(name="table", value="IdentityGenerator"),
	    @Parameter(name="primary_key_column", value="sequence_name"),
	    @Parameter(name="primary_key_value", value="Rating"),
	    @Parameter(name="value_column", value="next_hi_value"),
	    @Parameter(name="primary_key_length", value="100"),
	    @Parameter(name="max_lo", value="1000")
	  }
	)
	@Id 
	@GeneratedValue(strategy=GenerationType.TABLE, generator="RatingIdGenerator")
	private int id;

	@ManyToOne(cascade={CascadeType.ALL})
	@JoinColumn(name="user", nullable=false)
	private User user;
	
	@ManyToOne(cascade={CascadeType.ALL})
	@JoinColumn(name="product", nullable=false)
	private Product product;
	
	@Column(name="value")
	private int value;
	
	/**
	 * Default constructor. Only used by Hibernate.
	 */
	public Rating() {
		super();
	}

	/**
	 * Constructor using all read-only and all non-nullable properties.
	 */
	public Rating(User user, Product product, int value) {
		super();
		this.user = user;
		this.product = product;
		this.value = value;
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
	 * Returns the value of property 'value'.
	 */
	public int getValue() {
		return value;
	}
	
	/**
	 * Sets the value of property 'value'.
	 */
	public void setValue(int newValue) {
		this.value = newValue;
	}
	
}
