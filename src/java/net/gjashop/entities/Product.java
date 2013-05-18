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
@Table(name = "product"
)
/*
 * This class is generated from the entity 'Product' defined in the HEDL model.
 * Note: Any change made to this class will be overridden.
 */
public class Product {
	
	@GenericGenerator(name="ProductIdGenerator", strategy="org.hibernate.id.MultipleHiLoPerTableGenerator",
	  parameters = {
	    @Parameter(name="table", value="IdentityGenerator"),
	    @Parameter(name="primary_key_column", value="sequence_name"),
	    @Parameter(name="primary_key_value", value="Product"),
	    @Parameter(name="value_column", value="next_hi_value"),
	    @Parameter(name="primary_key_length", value="100"),
	    @Parameter(name="max_lo", value="1000")
	  }
	)
	@Id 
	@GeneratedValue(strategy=GenerationType.TABLE, generator="ProductIdGenerator")
	private int id;

	@Column(name="name")
	private java.lang.String name;
	
	@ManyToOne(cascade={CascadeType.ALL})
	@JoinColumn(name="segment", nullable=false)
	private Segment segment;
	
	@ManyToOne(cascade={CascadeType.ALL})
	@JoinColumn(name="sign", nullable=false)
	private Sign sign;
	
	@Column(name="sex")
	private int sex;
	
	@Column(name="size")
	private java.lang.String size;
	
	@Column(name="color")
	private java.lang.String color;
	
	@Column(name="price")
	private double price;
	
	@Column(name="deliverytime")
	private java.lang.String deliveryTime;
	
	@Column(name="count")
	private int count;
	
	/**
	 * Default constructor. Only used by Hibernate.
	 */
	public Product() {
		super();
	}

	/**
	 * Constructor using all read-only and all non-nullable properties.
	 */
	public Product(java.lang.String name, Segment segment, Sign sign, double price, java.lang.String deliveryTime, int count) {
		super();
		this.name = name;
		this.segment = segment;
		this.sign = sign;
		this.price = price;
		this.deliveryTime = deliveryTime;
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
	
	/**
	 * Returns the value of property 'segment'.
	 */
	public Segment getSegment() {
		return segment;
	}
	
	/**
	 * Sets the value of property 'segment'.
	 */
	public void setSegment(Segment newValue) {
		this.segment = newValue;
	}
	
	/**
	 * Returns the value of property 'sign'.
	 */
	public Sign getSign() {
		return sign;
	}
	
	/**
	 * Sets the value of property 'sign'.
	 */
	public void setSign(Sign newValue) {
		this.sign = newValue;
	}
	
	/**
	 * Returns the value of property 'sex'.
	 */
	public int getSex() {
		return sex;
	}
	
	/**
	 * Sets the value of property 'sex'.
	 */
	public void setSex(int newValue) {
		this.sex = newValue;
	}
	
	/**
	 * Returns the value of property 'size'.
	 */
	public java.lang.String getSize() {
		return size;
	}
	
	/**
	 * Sets the value of property 'size'.
	 */
	public void setSize(java.lang.String newValue) {
		this.size = newValue;
	}
	
	/**
	 * Returns the value of property 'color'.
	 */
	public java.lang.String getColor() {
		return color;
	}
	
	/**
	 * Sets the value of property 'color'.
	 */
	public void setColor(java.lang.String newValue) {
		this.color = newValue;
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
	 * Returns the value of property 'deliveryTime'.
	 */
	public java.lang.String getDeliveryTime() {
		return deliveryTime;
	}
	
	/**
	 * Sets the value of property 'deliveryTime'.
	 */
	public void setDeliveryTime(java.lang.String newValue) {
		this.deliveryTime = newValue;
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
