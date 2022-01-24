package io.javaassesment.springbootassestment.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import io.javaassesment.springbootassestment.repository.RecordRepository;
import io.javaassesment.springbootassestment.entity.Record;

@Service
public class RecordService {
	
	@Autowired
	private RecordRepository recordRepo;
	
	public List<Record> getAllRecords(){
		return recordRepo.findAll();
	}
	
	@Transactional
	public Record updateRecord(Record record) {
		
		Record currentRecordId = recordRepo.getById(record.getId());
		
		currentRecordId.setName(record.getName());
		currentRecordId.setDescription(record.getDescription());
		return recordRepo.save(record);
	}
	
	@Transactional
	public Record saveRecord(Record record) {
		return recordRepo.save(record);
	}
	
	@Transactional
	public List<Record> saveMultipleRecord(List<Record> records) {
		return recordRepo.saveAll(records);
	}
	
	public Page<Record> findPaginatedRecords(int pageNo, int pageSize){
		Pageable pageable = PageRequest.of(pageNo - 1 ,  pageSize);
		return this.recordRepo.findAll(pageable);
	}

	public Record getRecordById(int id) {
		return recordRepo.findById(id).orElse(null);
	}

}
