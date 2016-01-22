package com.evh98.stext.main;

public class Sys {
	
	public static String line1;
	public static String line2;
	public static String line3;
	public static String line4;
	public static String line5;
	public static String line6;
	public static String line7;
	public static String line8;

	/**
	 * Prints out a String
	 * @param text - String to print out
	 */
	public static void print(String text){
		line8 = line7;
		line7 = line6;
		line6 = line5;
		line5 = line4;
		line4 = line3;
		line3 = line2;
		line2 = line1;
		line1 = text;
		
		Window.line1.setText(line1);
		Window.line2.setText(line2);
		Window.line3.setText(line3);
		Window.line4.setText(line4);
		Window.line5.setText(line5);
		Window.line6.setText(line6);
		Window.line7.setText(line7);
		Window.line8.setText(line8);
	}
}