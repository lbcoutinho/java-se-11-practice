package com.github.lbcoutinho.javase11practice._07interfaces;

public class ClassClonable implements Cloneable {

	private String title;

	public ClassClonable(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	@Override
	public String toString() {
		return "ClassClonable{" +
				"title='" + title + '\'' +
				'}';
	}
}
