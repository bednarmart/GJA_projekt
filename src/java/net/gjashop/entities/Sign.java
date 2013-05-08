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
@Table(name = "sign"
)
/*
 * This class is generated from the entity 'Sign' defined in the HEDL model.
 * Note: Any change made to this class will be overridden.
 */
public class Sign {
	
	@GenericGenerator(name="SignIdGenerator", strategy="org.hibernate.id.MultipleHiLoPerTableGenerator",
	  parameters = {
	    @Parameter(name="table", value="IdentityGenerator"),
	    @Parameter(name="primary_key_column", value="sequence_name"),
	    @Parameter(name="primary_key_value", value="Sign"),
	    @Parameter(name="value_column", value="next_hi_value"),
	    @Parameter(name="primary_key_length", value="100"),
	    @Parameter(name="max_lo", value="1000")
	  }
	)
	@Id 
	@GeneratedValue(strategy=GenerationType.TABLE, generator="SignIdGenerator")
	private int id;

	@Column(name="name")
	private java.lang.String name;
	
	/**
	 * Default constructor. Only used by Hibernate.
	 */
	public Sign() {
		super();
	}

	/**
	 * Constructor using all read-only and all non-nullable properties.
	 */
	public Sign(java.lang.String name) {
		super();
		this.name = name;
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
	 * Returns the value of property 'name'.
	 */
	public java.lang.String getName() {
		return name;
	}
	
	/**
	 * Sets the value of property 'name'.
	 */
	public void setName(java.lang.String newValue) {
		this.name = newValue;
	}
	
}
