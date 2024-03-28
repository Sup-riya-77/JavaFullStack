package com.prodapt.march28.assignment;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
public class WriteToFile {
    public static void writeToFile(String newFileName,char ch)
    {  try {
       FileWriter fw=new FileWriter(newFileName);
       BufferedWriter bw=new BufferedWriter(fw);
       FileReader fr = new FileReader("D:\\Files\\country.csv");
	   BufferedReader br = new BufferedReader(fr); 
	   String line;
		while((line=br.readLine())!=null) {
			if(!(line.isEmpty()) && (line.charAt(0)==ch)) {
				bw.write(line);
			}
		}
		br.close();
		bw.close();
		
    }
    catch(Exception e)
    {
    	System.out.println("Error occured");
    }
    }
    public static void main(String[] args) {
		File file=new File("D:\\Files\\MyNewFile.txt");
		writeToFile(file.getAbsolutePath(),'F');

	}

}
