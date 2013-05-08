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
@Table(name = "user"
)
/*
 * This class is generated from the entity 'User' defined in the HEDL model.
 * Note: Any change made to this class will be overridden.
 */
public class User {
	
	@GenericGenerator(name="UserIdGenerator", strategy="org.hibernate.id.MultipleHiLoPerTableGenerator",
	  parameters = {
	    @Parameter(name="table", value="IdentityGenerator"),
	    @Parameter(name="primary_key_column", value="sequence_name"),
	    @Parameter(name="primary_key_value", value="User"),
	    @Parameter(name="value_column", value="next_hi_value"),
	    @Parameter(name="primary_key_length", value="100"),
	    @Parameter(name="max_lo", value="1000")
	  }
	)
	@Id 
	@GeneratedValue(strategy=GenerationType.TABLE, generator="UserIdGenerator")
	private int id;

	@Column(name="name")
	private java.lang.String name;
	
	@Column(name="surname")
	private java.lang.String surname;
	
	@Column(name="login")
	private java.lang.String login;
	
	@Column(name="pass")
	private java.lang.String pass;
	
	@Column(name="privilegy")
	private int privilegy;
	
	/**
	 * Default constructor. Only used by Hibernate.
	 */
	public User() {
		super();
	}

	/**
	 * Constructor using all read-only and all non-nullable properties.
	 */
	public User(java.lang.String name, java.lang.String surname, java.lang.String login, java.lang.String pass, int privilegy) {
		super();
		this.name = name;
		this.surname = surname;
		this.login = login;
		this.pass = pass;
		this.privilegy = privilegy;
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
	 * Returns the value of property 'surname'.
	 */
	public java.lang.String getSurname() {
		return surname;
	}
	
	/**
	 * Sets the value of property 'surname'.
	 */
	public void setSurname(java.lang.String newValue) {
		this.surname = newValue;
	}
	
	/**
	 * Returns the value of property 'login'.
	 */
	public java.lang.String getLogin() {
		return login;
	}
	
	/**
	 * Sets the value of property 'login'.
	 */
	public void setLogin(java.lang.String newValue) {
		this.login = newValue;
	}
	
	/**
	 * Returns the value of property 'pass'.
	 */
	public java.lang.String getPass() {
		return pass;
	}
	
	/**
	 * Sets the value of property 'pass'.
	 */
	public void setPass(java.lang.String newValue) {
		this.pass = newValue;
	}
	
	/**
	 * Returns the value of property 'privilegy'.
	 */
	public int getPrivilegy() {
		return privilegy;
	}
	
	/**
	 * Sets the value of property 'privilegy'.
	 */
	public void setPrivilegy(int newValue) {
		this.privilegy = newValue;
	}
	
}
