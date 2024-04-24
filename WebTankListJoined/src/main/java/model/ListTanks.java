/**
 * @author Cory Howard - clhoward1
 * CIS175 - Spring 2024
 * Feb 1, 2024
 */
package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tanks")
public class ListTanks {
	@Id
	@GeneratedValue
	@Column(name="ID")
	private int id;
	@Column(name="COUNTRY")
	private String country;
	@Column(name="MODEL")
	private String model;
	@Column(name="GUN_CALIBER")
	private String gunCaliber;

	/**
	 * Constructors
	 */
	public ListTanks() {
		super();
	}
	
	public ListTanks(String country, String model, String gunCaliber) {
		super();
		this.country = country;
		this.model = model;
		this.gunCaliber = gunCaliber;
	}

	
	/**
	 * Getters and Setters
	 */
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}

	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	
	public String getGunCaliber() {
		return gunCaliber;
	}
	public void setGunCaliber(String gunCaliber) {
		this.gunCaliber = gunCaliber;
	}
	
	
	/**
	 * Methods
	 */
	public String returnTankDetails() {
		return this.country + ": " + this.model + " - " + this.gunCaliber;
	}

}
