package com.lockedme;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class UserInterface {

	public static void main(String[] args) throws IOException{
		FileUtil util = new FileUtil();
		int ch = 0;
		int ch2=0;
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to LockedMe.com");
		System.out.println("Developed by AnushaAnireddy");
		outerloop:
		do {
			System.out.println("1. Show Existing Files");
			System.out.println("2. Manage Files");
			System.out.println("3. Exit");
			System.out.println("Enter the choice:");
			try
			{
				ch2=sc.nextInt();
			}
			catch(InputMismatchException  e) {
				System.out.println("Enter Integer Inputs only");	
				sc.nextLine();
			}
			switch(ch2) {
			case 1:
				System.out.println("Exiting files are:");
				List<MyFile> files= util.getFiles();
				for(MyFile f : files)
					System.out.println(f.getId() + " " + f.getFileName());
				break;	
			case 2:
				innerloop:
				do {
					System.out.println();
					System.out.println("1.Add File");
					System.out.println("2.Delete File");
					System.out.println("3.Search File");
					System.out.println("4.Exit");
					System.out.println("Enter the choice");
					try
					{
						ch=sc.nextInt();
					}
					catch(InputMismatchException  e) {
						System.out.println("Enter Integer Inputs only");	
						sc.nextLine();
					}
					
					switch(ch) {
					
					case 1:
						String fileName;
						System.out.println("Enter the filename");
						fileName=sc.next();
						if(util.search(fileName))
							System.out.println("File is Existing");
						else
						util.addFile(fileName);
						break;
					case 2:
						String fileName1;
						System.out.println("Enter the filename");
						fileName1=sc.next();
						if(util.deleteFile(fileName1))
							System.out.println("File is deleted successfully");
						else
							System.out.println("File does not Exist");						
						break;
					case 3:
						String fileName2;
						System.out.println("Enter the filename");
						fileName2=sc.next();
						if(util.search(fileName2))
							System.out.println("File is Existing");
						else
							System.out.println("File is not Existed");
						break;
					case 4:
						break;
					default: 
						System.out.println("Invalid Input");
						break;
					}
					if (ch == 4)
					{
						break innerloop;
					}
				} while(ch>0);
			case 3:
				if(ch2 == 3)
					System.exit(0);
				break;	
				
			default: 
				System.out.println("Enter valid Integer Input else Press 3 to Exit");
				System.out.println("1.Show Existing Files");
				System.out.println("2.Manage Files");
				System.out.println("3.Exit");
				System.out.println("Enter the choice:");
				try
				{
					ch2=sc.nextInt();
					
				}
				catch(InputMismatchException  e) {
				System.out.println("Enter Integer Inputs only");	
					sc.nextLine();
				}
				break;
			}
			
		}while(ch2 > 0);
		System.out.println("Closing the Application.");
	}
}
