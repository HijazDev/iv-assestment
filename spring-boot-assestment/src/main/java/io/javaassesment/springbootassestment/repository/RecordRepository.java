package io.javaassesment.springbootassestment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.javaassesment.springbootassestment.entity.Record;

@Repository
public interface RecordRepository extends JpaRepository<Record, Integer>{

}
