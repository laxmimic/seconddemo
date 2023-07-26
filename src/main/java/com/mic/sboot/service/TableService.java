package com.mic.sboot.service;

import org.springframework.stereotype.Service;

@Service
public class TableService {

	public boolean parseAndStoreTableMetadata(String createTableStatement) {

		// Implement parsing of CREATE TABLE statement and store metadata in
		// metadata.txt
		// You can use regular expressions or other parsing techniques to extract column
		// names and data types.
		// For simplicity, let's assume you have a method to store the metadata.

		return MetadataStorage.storeMetadata(createTableStatement);
	}

	public void parseAndStoreData(String insertStatement) {
		// Implement parsing of INSERT INTO statement and store data in the appropriate
		// table file.
		// You can use regular expressions or other parsing techniques to extract table
		// name and values.
		// For simplicity, let's assume you have a method to store the data.

		System.out.println("from tableservice:" + insertStatement);
		DataStorage.storeData(insertStatement);
	}

}
