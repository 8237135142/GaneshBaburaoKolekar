package com.hcl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.dao.Book21Dao;
import com.hcl.model.Book21;

@Service
public class Book21ServiceImpl implements Book21Service{

	@Autowired
	Book21Dao book21Dao; 
	@Override
	public void insert(Book21 book) {
		book21Dao.save(book);
		
	}
	@Override
	public List<Book21> getall() {
		return book21Dao.findAll();
		
	}
	@Override
	public void  delete() {
		book21Dao.deleteAll();
	
	}
	@Override
	public void deleteById(int id) {
		book21Dao.deleteById(id);
		
	}
	@Override
	public void updateById(int id, Book21 book) {
		book21Dao.save(book);
		
	}


}
