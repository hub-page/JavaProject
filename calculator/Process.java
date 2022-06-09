package com.calculator;

import java.text.DecimalFormat;

public class Process {
	private final DecimalFormat decimalFormat;
	private char equation;
	private double input;
	private boolean isResult;
	
	Process() {
		decimalFormat = new DecimalFormat("#.########");
		equation = ' ';
		isResult = false;
	}
	
	public void setEquation(char equation) {
		this.equation = equation;
	}
	
	public char getEquation() {
		return equation;
	}
	
	public void setInput(double input) {
		this.input = input;
	}
	
	public String getInput() {
		return decimalFormat.format(input);
	}
	
	public void setIsResult(boolean isResult) {
		this.isResult = isResult;
	}
	
	public boolean getIsResult() {
		return isResult;
	}
	
	public String displayInput(String input) {
		if (input.substring(0, 2).equals("-0") &&
			!input.substring(0, 3).equals("-0.")) return input = "-" + input.substring(2);
		
		if (!(input.charAt(0) == '0') || input.substring(0, 2).equals("0.")) return input;
		return input.substring(1);
	}
	
	public String reduceString(String string) {
		if (string.length() == 1) return "0";
		return string.substring(0, string.length() - 1);
	}
	
	public String addDecimal(String string) {
		return string.contains(".") ? string : string + ".";
	}
	
	public String addSign(String string) {
		return string.contains("-") ? string.substring(1) : '-' + string;
	}
	
	public String getResult(double x, double y, char equation) {
		switch (equation) {
		case '%' -> x %= y;
		case '*' -> x *= y;
		case '/' -> x /= y;
		case '+' -> x += y;
		case '-' -> x -= y;
		default -> x += y;
		}
		return decimalFormat.format(x);
	}
}
