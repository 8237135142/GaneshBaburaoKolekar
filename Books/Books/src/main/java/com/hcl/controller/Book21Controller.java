package com.hcl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.model.Book21;
import com.hcl.service.Book21Service;

@RestController
@RequestMapping("/book21")
public class Book21Controller {

	@Autowired
	Book21Service book21Service;
	
	@PostMapping("/insert")
	public String addBook(@RequestBody Book21 book)
	{
		book21Service.insert(book);
		return "added";
		
	}
	
	@GetMapping("/get")
	public List<Book21> getAll()
	{
		return book21Service.getall();
	}
	
	@DeleteMapping("/delete")
	public String delete()	
	{
		book21Service.delete();
		return "delete";
		
	}
	
	@DeleteMapping("/deleteById/{bookId}")
	public String deleteById(@PathVariable("bookId") int bookId)
	{
		book21Service.deleteById(bookId);
		return "deleteById";
	}
	
	
	@PutMapping("/update/{bookId}")
	public String updateById(@PathVariable int bookId , @RequestBody Book21 book)
	{
		book21Service.updateById(bookId, book);
		return "updateById";
	
	
	}
}
