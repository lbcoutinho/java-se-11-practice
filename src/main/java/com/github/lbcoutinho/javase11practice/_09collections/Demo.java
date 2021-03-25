package com.github.lbcoutinho.javase11practice._09collections;

import java.util.Objects;

public class Demo {

	private Integer id;
	private String name;

	public Demo(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

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

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Demo demo = (Demo) o;
		return id.equals(demo.id) && name.equals(demo.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name);
	}

	@Override
	public String toString() {
		return "Demo{" +
				"id=" + id +
				", name='" + name + '\'' +
				'}';
	}
}
