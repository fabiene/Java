package org.serratec.java2.backend.marketplace.service;

public class DataNotFoundException extends Exception{
	private Integer id;
	public DataNotFoundException(Integer id) {
		this.id = id;
	}
	
	public Integer getId() {
		return id;
	}
}
