package com.hcl.service;

import java.util.List;

import com.hcl.model.Book21;

public interface Book21Service {

	public void insert(Book21 book);
	
	public List<Book21> getall();
	
	 public	void delete();
	 
	 public void deleteById( int id);
	 
	 public void updateById(int id, Book21 book);
}
