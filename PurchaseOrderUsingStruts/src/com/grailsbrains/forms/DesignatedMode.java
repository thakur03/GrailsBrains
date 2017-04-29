package com.grailsbrains.forms;


public class DesignatedMode {
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

	public DesignatedMode(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

	public DesignatedMode() {
	}

	@Override
	public String toString() {
		return "DesignatedMode{" +
				"id=" + id +
				", name='" + name + '\'' +
				'}';
	}
}