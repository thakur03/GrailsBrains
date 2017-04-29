package com.grailsbrains.forms;


public class Carrier {
	private Integer id;
	private String name;

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

	public Carrier(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

	public Carrier() {
	}

	@Override
	public String toString() {
		return "Carrier{" +
				"id=" + id +
				", name='" + name + '\'' +
				'}';
	}
}
