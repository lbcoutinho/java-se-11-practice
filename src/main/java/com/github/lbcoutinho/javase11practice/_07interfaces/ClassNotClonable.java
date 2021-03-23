package com.github.lbcoutinho.javase11practice._07interfaces;

public class ClassNotClonable {

	private String title;

	public ClassNotClonable(String title) {
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
		return "ClassNotClonable{" +
				"title='" + title + '\'' +
				'}';
	}
}
