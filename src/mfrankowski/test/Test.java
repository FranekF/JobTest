package mfrankowski.test;

import java.io.FileNotFoundException;

public class Test 
{
	private static String filePath;
	private static Calculator calculator;
	
	public static void main(String[] args) throws FileNotFoundException
	{
		filePath = args[0];
		calculator = new Calculator();
		calculator.openFile("filePath");
		System.out.printf("Sum is: %f\n", calculator.sum());
	}

}
