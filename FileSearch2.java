package com.prodapt.march28.assignment;
import java.io.File;
import java.util.Scanner;
public class FileSearch2 {
 //"D:\\Files\\file2.txt"
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter Directory: ");
		String directory=scan.nextLine();
		System.out.println("Enter Folder: ");
		String folder=scan.nextLine();
		System.out.println("Enter File Name: ");
		String fileName=scan.nextLine();
		System.out.println("Enter Format: ");
		String format=scan.nextLine();
		String path=directory+":\\\\"+folder+"\\\\"+fileName+"."+format;
		System.out.println("path: "+path);
		File file=new File(path);
		if(file.exists())
		{
			System.out.println("File Exists");
		}
		else System.out.println("File does not Exists");
		scan.close();
	}

}
