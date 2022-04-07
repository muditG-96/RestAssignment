package com.impl.demo.controller;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.impl.demo.entities.Suburb;
import com.impl.demo.services.SuburbRepository;
import com.impl.demo.services.SuburbService;

@RestController
public class MyController 
{
	@Autowired
	private SuburbService suburbService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(MyController.class);
		
    @GetMapping("/suburbs/{postCode}")
    public List<Suburb> fetchSubUrbList(@PathVariable("postCode") int postCode)
    {
    	List<Suburb> newSuburbList=(List<Suburb>)suburbService.findByPostCode(postCode);
    	Collections.sort(newSuburbList,Comparator.comparing(Suburb::getSuburbName));
    	int noOfCharacter= newSuburbList.stream().mapToInt(suburb->suburb.getSuburbName().length()).sum();
    	LOGGER.info("No of Character of all suburb name of post code {} is {}",postCode,noOfCharacter);
        return newSuburbList;
    }
	
	@PostMapping(value="/suburb1/{postCode}", consumes={"application/json"})
	public List<Suburb> addSuburb(@PathVariable("postCode") int postCode,@RequestBody List<Suburb> suburbList)
	{
		
		suburbList.forEach(suburb->suburb.setPostCode(postCode));
		return suburbService.saveSuburbList(suburbList);
	}
	
}
