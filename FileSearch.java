package com.prodapt.march28.assignment;

import java.io.File;
import java.util.Scanner;

public class FileSearch {
    public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter Directory: ");
		String directory=scan.nextLine();
		System.out.println("Enter Format: ");
		String format=scan.nextLine();
		String path = directory;
		File file=new File(path);
		
		if(file.isDirectory()) System.out.println("File is directory");
	    else System.out.println("File is not directory");
		File[] f = file.listFiles();
		for(int i=0;i<f.length;i++)
			{
				if((f[i].getAbsolutePath()).contains(format))
		     	System.out.println(f[i]);
			}
		scan.close();

	}

}
