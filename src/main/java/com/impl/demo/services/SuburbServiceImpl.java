package com.impl.demo.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.impl.demo.entities.Suburb;

@Component
public class SuburbServiceImpl implements SuburbService
{
	
	@Autowired
    private SuburbRepository surburbRepository;

	@Override
	public List<Suburb> findByPostCode(int postcode){
		
		return surburbRepository.findByPostCode(postcode);
	}

	@Override
	public List<Suburb> saveSuburbList(List<Suburb> suburbList) {

		return (List<Suburb>)surburbRepository.saveAll(suburbList);
	}
	
}
