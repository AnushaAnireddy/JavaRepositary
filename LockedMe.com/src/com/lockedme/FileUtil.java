package com.lockedme;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {

	static int count=0;
	List<MyFile> files= new ArrayList<>();
	private String dirName = "e://java//";
	private String fileExtension = ".txt";
	
	public FileUtil(){
		File f = new File(dirName);
		String[] fs = f.list();
		for(String file:fs)
		{
			count++;
			files.add(new MyFile(count,file));
		}
	}
	
	public List<MyFile> getFiles()
	{		
		return files;
	}
	
	public void addFile(String fileName) throws IOException
	{
		File f=new File(dirName + fileName + fileExtension);
		f.createNewFile();
		count++;
		files.add(new MyFile(count,fileName + fileExtension));
		System.out.println("File added successfully");
	}
	
	public boolean deleteFile(String fileName)
	{
		boolean isDeleted=false;
		for(MyFile file:files) 
		{
			if(file.getFileName().startsWith(fileName))
			{ 
				File f=new File(dirName + fileName + fileExtension);
			    if(f.delete()) {		    	
			    	if(files.remove(file))
			    	count--;
			    isDeleted=true;
			    }
			    break;
			}
		}
		return isDeleted;
	}
	
	public boolean search(String fileName)
	{
		boolean isIdentified=false;
		for(MyFile file:files)
		{
			if(file.getFileName().startsWith(fileName))
			{
				isIdentified=true;
				break;
			}
		}
		return isIdentified;
	}
}
