package com.github.lbcoutinho.javase11practice._11streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Order {

	private final List<Item> items = new ArrayList<>();

	public void addItems(String... items) {
		this.items.addAll(Arrays.stream(items).map(Item::new).collect(toList()));
	}

	public Stream<Item> getItems() {
		return items.stream();
	}

	public static class Item {
		private final String name;

		public Item(String name) {
			this.name = name;
		}

		public String getName() {
			return name;
		}
	}
}
