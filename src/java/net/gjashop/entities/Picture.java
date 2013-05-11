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
@Table(name = "picture"
)
/*
 * This class is generated from the entity 'Picture' defined in the HEDL model.
 * Note: Any change made to this class will be overridden.
 */
public class Picture {
	
	@GenericGenerator(name="PictureIdGenerator", strategy="org.hibernate.id.MultipleHiLoPerTableGenerator",
	  parameters = {
	    @Parameter(name="table", value="IdentityGenerator"),
	    @Parameter(name="primary_key_column", value="sequence_name"),
	    @Parameter(name="primary_key_value", value="Picture"),
	    @Parameter(name="value_column", value="next_hi_value"),
	    @Parameter(name="primary_key_length", value="100"),
	    @Parameter(name="max_lo", value="1000")
	  }
	)
	@Id 
	@GeneratedValue(strategy=GenerationType.TABLE, generator="PictureIdGenerator")
	private int id;

	@ManyToOne(cascade={CascadeType.ALL})
	@JoinColumn(name="product", nullable=false)
	private Product product;
	
	@Column(name="path")
	private java.lang.String path;
	
	/**
	 * Default constructor. Only used by Hibernate.
	 */
	public Picture() {
		super();
	}

	/**
	 * Constructor using all read-only and all non-nullable properties.
	 */
	public Picture(Product product, java.lang.String path) {
		super();
		this.product = product;
		this.path = path;
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
	 * Returns the value of property 'path'.
	 */
	public java.lang.String getPath() {
		return path;
	}
	
	/**
	 * Sets the value of property 'path'.
	 */
	public void setPath(java.lang.String newValue) {
		this.path = newValue;
	}
	
}
