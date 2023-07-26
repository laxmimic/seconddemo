package com.mic.sboot.service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class DataStorage {

	public static void storeData(String insertStatement) {
		
		// Implement storing the data in the appropriate table file
		// For simplicity, let's assume each table has its own file (e.g.,
		// table_name.txt , below I am giving table name as 'mics').

		try {
			String tableName = extractTableName(insertStatement);
			System.out.println("-tablename-" + tableName);

			BufferedWriter writer = new BufferedWriter(new FileWriter("mics" + ".txt", true));
			writer.write(insertStatement);
			writer.newLine();
			writer.close();
		} catch (IOException e) {
			throw new RuntimeException("Error while storing data.", e);
		}
	}

	private static String extractTableName(String insertStatement) {
		// Implement parsing to extract the table name from the INSERT INTO statement.
		// For simplicity, let's assume the table name is enclosed in double quotes.

		int startIndex = insertStatement.indexOf('"');
		int endIndex = insertStatement.indexOf('"', startIndex + 1);
		return insertStatement.substring(startIndex + 1, endIndex);
	}
}
