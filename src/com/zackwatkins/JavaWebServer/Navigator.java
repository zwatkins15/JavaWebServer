package com.zackwatkins.JavaWebServer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Navigator {
	private File rootDir = null;
	
	public Navigator(String rootDir) {
		this.rootDir = new File(rootDir);
	}
	
	public String getRootDir() {
		return this.rootDir.getAbsolutePath();
	}
	
	public boolean doesFileExist(String fileName) {
		//TODO: I want to store all files in a HexMap. So first we'd check that.
		
		// Manually check for file (Resource hungry)
		File target = new File(fileName);
		if(target.exists())
			return true;
		else 
			return false;
	}
	
	public File getFile(String fileName) {
		return new File(fileName);
	}
	
	public String[] readFile(String targetStr) {
		File target = getFile(targetStr);
		String fileContents[] = null;
		
		try {
			FileReader fr = new FileReader(target);
			BufferedReader in = new BufferedReader(fr);
			String nextLine;
			int i = 0;
			while((nextLine = in.readLine()) != null) {
				fileContents[i] = nextLine;
				i++;
			}
		} catch (IOException e) {
			//We SHOULD have already checked for a 404
			e.printStackTrace();
		}
		
		
		return fileContents;
	}
}
