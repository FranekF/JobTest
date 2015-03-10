package mfrankowski.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


public class Calculator 
{
	private FileReader fileReader;
	private BufferedReader bufferedReader;
	private String line;
	private float sum;
	
	Calculator()
	{
		sum = 0;
	}
	
	public void openFile(String filePath)
	{
		try 
		{
			fileReader = new FileReader(filePath);
			bufferedReader = new BufferedReader(fileReader);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public float sum()
	{
		try 
		{
			while((line = bufferedReader.readLine()) != null)
			{
				int beginIndex = line.indexOf("@amount:") + 8;
				int endIndex = line.indexOf("PLN");
				
				if(beginIndex == -1 || endIndex == -1 )
				{
					System.err.println("Wrong file data format");
					System.exit(-1);
				}
				
				sum += Float.parseFloat(line.substring(beginIndex, endIndex).replace(',', '.'));
			}
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		return sum;
	}
	
}
