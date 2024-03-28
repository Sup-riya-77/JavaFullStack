package com.prodapt.march28.assignment;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.util.*;
public class ToLoadFileIntoAMap {

	public static void main(String[] args) throws IOException {
		Map<String,String> countryMap=new HashMap<String,String>();
		String country=null;
		String capital=null;
		File file=new File("D:\\Files\\country.csv");
			FileReader fr=new FileReader(file);
			try 
			{
				BufferedReader br = new BufferedReader(fr); 
				String line;
				while((line=br.readLine())!=null)
				{   
					String[] countryCapValue=line.split(",");
					countryMap.put(countryCapValue[0],countryCapValue[1]);
				}
			
			countryMap.put(country, capital);
			System.out.println(countryMap);
			br.close();
			}
		    catch (FileNotFoundException e)
		           {
			e.printStackTrace();
		            }
			try {
			File file1=new File("D:\\Files\\country.csv");
			FileWriter fw = new FileWriter(file1,true);
			try (BufferedWriter buffWriter = new BufferedWriter(fw)) {
				//buffWriter.write("country,capital\n");
				buffWriter.write("India,Delhi\n");
				buffWriter.write("Nepal,Katmandu\n");
				buffWriter.write("Bhutan,Timpu\n");
				buffWriter.write("UK,London\n");
			}
			}
			catch (FileNotFoundException e)
	           {
		            e.printStackTrace();
	            }
		
	

	}

}
