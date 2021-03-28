package com.github.lbcoutinho.javase11practice._11streams;

import java.time.LocalDateTime;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

import static java.util.Comparator.reverseOrder;
import static java.util.stream.Collectors.*;

public class Main {

	public static void main(String[] args) {
		// Infinite stream data that stops being processed when condition is matched
//		int sum = IntStream.generate(() -> {
//			var n = (int) (Math.random() * 10);
//			System.out.println("n = " + n);
//			return n;
//		}).takeWhile(n -> n != 3).sum();
//		System.out.println("sum = " + sum);

		Predicate<Integer> evenNumber = n -> n % 2 == 0;
		System.out.println("evenNumber - 2 = " + evenNumber.test(2));
		System.out.println("evenNumber - 3 = " + evenNumber.test(3));

		Function<Integer, String> f = n -> String.format("Number is %d", n);
		System.out.println("function = " + f.apply(10));

		// Extends Function class, has same features, but input and output type is the same
		UnaryOperator<String> f2 = n -> "Number is " + n;
		System.out.println("unary function = " + f2.apply("9"));

		Supplier<String> dateSupplier = () -> LocalDateTime.now().toString();
		System.out.println("dateSupplier = " + dateSupplier.get());

		Consumer<Object> printer = o -> System.out.println("printer = " + o.toString());
		printer.accept(new Object());

		// Filter
		Predicate<Integer> isEven = n -> n % 2 == 0;
		Predicate<Integer> lowerThan5 = n -> n < 5;
		var listInts = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		System.out.println("even < 5 = " + listInts.stream().filter(isEven.and(lowerThan5)).collect(toList()));
		System.out.println("odd < 5 = " + listInts.stream().filter(isEven.negate().and(lowerThan5)).collect(toList()));
		System.out.println("odd numbers = " + listInts.stream().filter(isEven.and(lowerThan5).negate()).collect(toList()));
		System.out.println("odd numbers >= 5 = " + listInts.stream().filter(isEven.or(lowerThan5).negate()).collect(toList()));
		System.out.println("5 = " + listInts.stream().filter(Predicate.isEqual(5)).collect(toList()));

		// FlatMap
		var order1 = new Order();
		order1.addItems("11", "12", "13");
		var order2 = new Order();
		order2.addItems("21", "22", "23");
		var order3 = new Order();
		order3.addItems("31", "32", "33");
		var orders = List.of(order1, order2, order3);

		orders.stream()
				.flatMap(Order::getItems)
				.map(Order.Item::getName)
				.mapToInt(Integer::parseInt)
				.filter(name -> name > 20)
				.forEach(System.out::println);

		// Other intermediate operations
		listInts = List.of(2, 5, 4, 6, 7, 1, 1, 5, 2, 7, 8, 10, 1, 2, 4, 9, 9, 3, 2, 6, 7);
		System.out.println("distinct and sorted reverse = " + listInts.stream().distinct().sorted(reverseOrder()).collect(toList()));
		// Obs: dropWhile includes the element found, takeWhile is excludes the element when found)
		System.out.println("skip, dropWhile, takeWhile and limit = " + listInts.stream()
				.skip(3) // [6, 7, 1, 1, 5, 2, 7, 8, 10, 1, 2, 4, 9, 9, 3, 2, 6, 7]
				.dropWhile(n -> n != 2) // [2, 7, 8, 10, 1, 2, 4, 9, 9, 3, 2, 6, 7]
				.takeWhile(n -> n != 4) // [2, 7, 8, 10, 1, 2]
				.limit(3) // [2, 7, 8]
				.collect(toList()));

		// Short-circuit terminal operations
		listInts = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		// findAny returns ANY element from the stream. Return is more inconsistent when using parallel streams.
		for (int i = 0; i < 100; i++) {
			System.out.println(listInts.parallelStream().findAny().get());
		}

		// Collectors
		listInts = List.of(1, 1, 2, 2, 3);
		System.out.println("summarizingDouble = " + listInts.stream().collect(summarizingDouble(i -> i)));
		System.out.println("summarizingInt = " + listInts.stream().collect(summarizingInt(i -> i)));
		System.out.println("mapping and joining = " + listInts.stream().collect(mapping(Object::toString, joining("-"))));
		System.out.println("toSet = " + listInts.stream().collect(toSet()));
		System.out.println("sum numbers and multiply result by 10 = " + listInts.stream().collect(collectingAndThen(Collectors.summingInt(i -> i), i -> i * 10)));


	}
}
