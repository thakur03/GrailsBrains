package com.grailsbrains.forms;



public class TransResp {
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

	public TransResp(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

	public TransResp() {
	}

	@Override
	public String toString() {
		return "TransResp{" +
				"id=" + id +
				", name='" + name + '\'' +
				'}';
	}
}
