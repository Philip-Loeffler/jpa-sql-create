package com.turkey.web;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.turkey.business.Turkey;
import com.turkey.db.TurkeyRepo;


@CrossOrigin
@RestController
@RequestMapping("/turkeys")
public class TurkeyController {


	
@Autowired
private TurkeyRepo turkeyRepo;
	
@GetMapping("/")
public List<Turkey> getAll() {
	//find all is doing a select all query, and literally doing everything for you. like opening connection ectect
	return turkeyRepo.findAll();

	}

// get movie by id
@GetMapping("/{id}")
public Optional<Turkey> getById(@PathVariable int id) {
	return turkeyRepo.findById(id);
	}

//add a movie
@PostMapping("/")
public Turkey addMovie(@RequestBody Turkey m) {
	 m = turkeyRepo.save(m);
	return m;
}

//update a movie
@PutMapping("/")
public Turkey updateMovie(@RequestBody Turkey m) {
	 m = turkeyRepo.save(m);
	return m;
}

//delete a movie by id
@DeleteMapping("/{id}")
public  Turkey deleteMovie(@PathVariable int id) {
	Optional<Turkey> m = turkeyRepo.findById(id);
	if(m.isPresent()) {
		turkeyRepo.deleteById(id);
}
	else {
		System.out.println("Error- movie not found for id " + id);
	}
		return m.get();
	}

}

