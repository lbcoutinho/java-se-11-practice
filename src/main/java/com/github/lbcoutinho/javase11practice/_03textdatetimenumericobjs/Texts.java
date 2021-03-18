package com.github.lbcoutinho.javase11practice._03textdatetimenumericobjs;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

public class Texts {

	public static void main(String[] args) {
		BigDecimal price = BigDecimal.valueOf(2.99);
		Double tax = 0.2;
		int quantity = 12345;
		Locale locale = new Locale("en", "GB");
		NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(locale);
		System.out.println("currencyFormat = " + currencyFormat.format(price));
		NumberFormat percentageFormat = NumberFormat.getPercentInstance(locale);
		System.out.println("percentageFormat = " + percentageFormat.format(tax));
		NumberFormat numberFormat = NumberFormat.getNumberInstance(locale);
		System.out.println("numberFormat = " + numberFormat.format(quantity));
	}
}
