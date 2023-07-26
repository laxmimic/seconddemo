package com.mic.sboot.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

public class MetadataStorage {

	public static boolean storeMetadata(String createTableStatement) {
		
		// Implement storing the metadata in metadata.txt
		boolean flag = false;
		try {
			// FileOutputStream writer = new FileOutputStream("metadata.txt", true);
			// writer.write(createTableStatement);
			// writer.newLine();
			PrintWriter out = new PrintWriter(new FileOutputStream(new File("metadata.txt")), false);
			out.println(createTableStatement);
			out.close();
			flag = true;

		} catch (IOException e) {
			throw new RuntimeException("Error while storing metadata.", e);
		}
		return flag;
	}
}