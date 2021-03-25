package com.github.lbcoutinho.javase11practice._09collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Main {

	public static void main(String[] args) {
		var l1 = Arrays.asList(1,2,3);
		var l2 = List.of(1,2,3);
		System.out.println("l1 = " + l1);
		System.out.println("l2 = " + l2);
		l1.set(0,10);
		System.out.println("l1 = " + l1);
		// List.of creates an immutable collection, using set will throw an exception
//		l2.set(0,10);
//		System.out.println("l2 = " + l2);

		var l3 = new ArrayList<>(Arrays.asList (1,null, 2,3,null, 4));
		System.out.println("l3 = " + l3);
		l3.removeIf(Objects::isNull);
		System.out.println("l3 = " + l3);

		// Testing what happens when using an object as map key and the objects become equal after inserted.
		Map<Demo, String> map = new HashMap<>();
		var key1 = new Demo(1, "1");
		map.put(key1, "One");
		var key2 = new Demo(2, "2");
		map.put(key2, "Two");
		System.out.println("map = " + map);
		key2.setId(1);
		key2.setName("1");
		System.out.println("map = " + map);
		map.put(key2, "Updated");
		System.out.println("map = " + map);
		map.remove(key2);
		System.out.println("map = " + map);
		map.remove(key2);
		System.out.println("map = " + map);
	}
}
