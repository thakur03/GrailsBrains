package com.grailsbrains.forms;


public class SellerVendor {
	private Integer id;
	private String name;
	private String type;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public SellerVendor(Integer id, String name, String type) {
		this.id = id;
		this.name = name;
		this.type = type;
	}

	public SellerVendor() {
	}

	@Override
	public String toString() {
		return "SellerVendor{" +
				"id=" + id +
				", name='" + name + '\'' +
				", type='" + type + '\'' +
				'}';
	}
}
