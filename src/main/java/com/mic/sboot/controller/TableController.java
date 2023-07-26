package com.mic.sboot.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mic.sboot.model.Response;
import com.mic.sboot.service.TableService;

@RestController
public class TableController {
	private final TableService tableService;

	public TableController(TableService tableService) {

		this.tableService = tableService;
	}

	@GetMapping("msg")
	public ResponseEntity<String> getMessage() {
		return new ResponseEntity<String>("Successfully Executed", HttpStatus.OK);
	}

	@PostMapping("/createTable")
	public ResponseEntity<?> createTable(@RequestBody String createTableStatement) {
		try {
			Response response = null;
			boolean flag = tableService.parseAndStoreTableMetadata(createTableStatement);
			if (flag== true) {
				response = new Response("SUCCESS");
				return new ResponseEntity<Response>(response, HttpStatus.OK);
			} else {
				response = new Response("FAILURE");
				return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
			}

			// return ResponseEntity.ok("Table metadata stored successfully.");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Error while storing table metadata: " + e.getMessage());
		}
	}

	@PostMapping("/insertData")
	public ResponseEntity<String> insertData(@RequestBody String insertStatement) {
		try {
			tableService.parseAndStoreData(insertStatement);

			return ResponseEntity.ok("Data inserted successfully.");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Error while inserting data: " + e.getMessage());
		}
	}
}
