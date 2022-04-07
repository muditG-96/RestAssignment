package com.impl.demo.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Suburb 
{
	@Id                        
	private String suburbName ;
	private String district;
	private int postCode;
	
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getSuburbName() {
		return suburbName;
	}
	public void setSuburbName(String suburbName) {
		this.suburbName = suburbName;
	}
	public int getPostCode() {
		return postCode;
	}
	public void setPostCode(int postCode) {
		this.postCode = postCode;
	}

}
