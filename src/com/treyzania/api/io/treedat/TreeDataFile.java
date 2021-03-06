package com.treyzania.api.io.treedat;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.Flushable;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class TreeDataFile implements Flushable {
	
	private File targetFile;
	public RootCompound rootDir;
	
	public TreeDataFile(String filename, boolean read) {		
		
		// Inits
		targetFile = new File(filename);
		rootDir = null;
		
		if (read) {
			sync();
		} else {
			resetRootDir();
		}
			
	}
	
	public void resetRootDir() {
		
		this.rootDir = new RootCompound();
		
	}
	
	public RootCompound getRD() {
		return this.rootDir;
	}
	
	private void sync() {
		
		// Inits
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		
		try {
			fis = new FileInputStream(targetFile);
			ois = new ObjectInputStream(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// Read data
		try {
			
			this.rootDir = (RootCompound) ois.readObject();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public void read() {
		this.sync();
	}
	
	@Override
	public void flush() {
		
		// Inits
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		
		try {
			fos = new FileOutputStream(targetFile);
			oos = new ObjectOutputStream(fos);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// Write data
		try {
			
			oos.writeObject(this.rootDir);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	
}
