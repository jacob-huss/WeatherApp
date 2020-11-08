package com.tts.weatherapp.repository;

import com.tts.weatherapp.model.ZipCodes;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface ZipCodeRepository extends CrudRepository<ZipCodes,Long> {
    
	
}