package com.impl.demo.services;

import java.util.List;

import org.springframework.stereotype.Component;

import com.impl.demo.entities.Suburb;

@Component
public interface SuburbService {
	
	List<Suburb> saveSuburbList(List<Suburb> suburbList);
	List<Suburb> findByPostCode(int postcode);

}
