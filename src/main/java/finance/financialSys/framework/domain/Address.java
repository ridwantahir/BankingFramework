package finance.financialSys.framework.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Address implements IAddress {
	
	public Address()
	{
		
	}
	public Address(String street, String city, String state, int zip) {
		this.street = street;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}

	@Id @GeneratedValue
	int id;
	private String street;
	private String city;
	private String state;
	private int zip;
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public void setStreet(String street) {
		this.street = street;
	}

	@Override
	public String getStreet() {
		return street;
	}

	@Override
	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String getCity() {
		return city;
	}

	@Override
	public void setState(String state) {
		this.state = state;
	}

	@Override
	public String getState() {
		return state;
	}

	@Override
	public void setZip(int zip) {
		this.zip = zip;
	}

	@Override
	public int getZip() {
		return zip;
	}

}