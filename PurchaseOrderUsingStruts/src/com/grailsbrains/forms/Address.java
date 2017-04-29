package com.grailsbrains.forms;

import java.util.Date;



public class Address {
	private Integer id;
	private String refererName;
	private String address;
	private String city;
	private Date startDate;
	private Date endDate;
	private State state;
	private Country country;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRefererName() {
		return refererName;
	}

	public void setRefererName(String refererName) {
		this.refererName = refererName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "Address{" +
				"id=" + id +
				", refererName='" + refererName + '\'' +
				", address='" + address + '\'' +
				", city='" + city + '\'' +
				", startDate=" + startDate +
				", endDate=" + endDate +
				", state=" + state +
				", country=" + country +
				'}';
	}

	public Address(Integer id, String refererName, String address, String city, Date startDate, Date endDate, State state, Country country) {
		this.id = id;
		this.refererName = refererName;
		this.address = address;
		this.city = city;
		this.startDate = startDate;
		this.endDate = endDate;
		this.state = state;
		this.country = country;
	}

	public Address() {
	}
}
