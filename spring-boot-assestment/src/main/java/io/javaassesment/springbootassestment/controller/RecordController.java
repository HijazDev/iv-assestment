package io.javaassesment.springbootassestment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.javaassesment.springbootassestment.service.RecordService;
import io.javaassesment.springbootassestment.entity.Record;

//Please enable annotation @Controller to see the pagination
//and disable the @RestController, restart the app and open in browser http://localhost:8080/
//@Controller

@RestController
public class RecordController {

	@Autowired
	private RecordService recordService;
	
	@GetMapping("/viewRecord")
	public List<Record> getAllRecord() {
		return recordService.getAllRecords();
	}
	
	@GetMapping("/getRecordById/{id}")
	public Record getRecordById(@PathVariable int id) {
		return recordService.getRecordById(id);
	}
	
	@GetMapping("/")
	public String viewHomePage(Model model) {
		return findPaginatedRecord(1,model);
	}
	
	@GetMapping("/page/{pageNo}")
	public String findPaginatedRecord(@PathVariable (value = "pageNo") int pageNo, Model model) {
		int pageSize = 10;
		
		Page<Record> page = recordService.findPaginatedRecords(pageNo, pageSize);
		List<Record> listRecords = page.getContent();
		
		model.addAttribute("currentPage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());
		model.addAttribute("listRecords", listRecords);
		return "list";
	}
	
	@PutMapping("/updateRecord")
	public Record updateRecord(@RequestBody String id, Record record) {
		return recordService.updateRecord(record);
	}
	
	@PostMapping("/addRecord")
	public Record addRecord(@RequestBody Record record) {
		return recordService.saveRecord(record);
	}
	
	@PostMapping("/addRecords")
	public List<Record> addRecords(@RequestBody List<Record> records) {
		return recordService.saveMultipleRecord(records);
	}
}
