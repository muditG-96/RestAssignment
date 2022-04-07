package com.impl.demo.services;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.impl.demo.entities.Suburb;


@Repository
public interface SuburbRepository  extends CrudRepository<Suburb,Long>
{
	List<Suburb> findByPostCode(int postCode);
}
