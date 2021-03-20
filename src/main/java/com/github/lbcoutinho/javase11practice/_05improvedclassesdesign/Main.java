package com.github.lbcoutinho.javase11practice._05improvedclassesdesign;

public class Main {

	public static void main(String[] args) {
		new Demo();
		/*
		 * Prints
		 * - Static initializer
		 * - Instance initializer
		 * - Constructor
		 */

		// Not possible to instantiate enums via constructor - compilation error
//		DemoEnum demoEnum = new DemoEnum("3");

		// Java memory allocation
		/*
		 * Stack is the memory context of a thread, storing local method variables. It may contain primitives and object references
		 * Heap is shared memory area, accessible from different methods and thread contexts. Classes and objects are stored in the heap
		 */

		// Parameter passing
		Integer a = 0;
		incInteger(a);
		System.out.println("a = " + a);
		int b = 0;
		incInt(b);
		System.out.println("b = " + b);
		Demo c = new Demo();
		setValue(c);
		System.out.println("c = " + c.getValue());
		/*
		* Values of a and b remain 0, because the method parameters copies the primitive value.
		* Changing the parameters values won't affect the original variable.
		*
		* In case of objects, like Demo, changing variables on the objects will take effect,
		* because the parameter copies the reference of the object, so both the original variable and the parameters
		* are pointing to the same memory position.
		 */

	}

	public static void incInteger(Integer i) {
		i = i +1;
	}

	public static void incInt(int i) {
		i = i +1;
	}

	public static void setValue(Demo demo) {
		demo.setValue(demo.getValue() + 1);
	}

	public static class Demo {
		private Integer value = 0;

		static {
			System.out.println("Static initializer");
		}

		{
			System.out.println("Instance initializer");
		}

		public Demo() {
			System.out.println("Constructor");
		}

		public Integer getValue() {
			return value;
		}

		public void setValue(Integer value) {
			this.value = value;
		}
	}

	public enum DemoEnum {
		VAL1("1"), VAL2("2");

		private final String val;

		DemoEnum(String val) {
			this.val = val;
		}

		public String getVal() {
			return val;
		}
	}
}
