package com.turkey.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.turkey.business.Turkey;


@RestController
@RequestMapping("/turkey")
public class TurkeyController {

	private List<Turkey> turkeys = new ArrayList<>();
	
	//this is the get all, or select *
	@GetMapping("/")
	public List<Turkey> getTurkeys() {
		return turkeys;
	}
	
	//get single turkey by id
	// in the url we are going to pass the id into the url
	// get we use path variable 
	@GetMapping ("/{id}")
	public  Turkey getTurkeyById(@PathVariable int id) {
		// loop through all of the turkeys in the list, then the turkey that's equal to the 
		// id, then we return that turkey;
		Turkey t = null;
		for(Turkey turkey: turkeys) {
			if(turkey.getId() == id) {
				t = turkey;
			}
		}
		return t;
		
	}
	
	// delete turkey by id
	@DeleteMapping ("/{id}")
	public  Turkey deleteTurkeyById(@PathVariable int id) {
		// loop through all of the turkeys in the list, then the turkey that's equal to the 
		// id, then we return that turkey;
		Turkey t = null;
		for(Turkey turkey: turkeys) {
			if(turkey.getId() == id) {
				t = turkey;
				turkeys.remove(t);
			}
		}
		return t;
		
	}
	
	// when we accept request paramaters we don't need a leading '/'
	// post you use request params
	@PostMapping("")
	public Turkey createTurkey(@RequestParam int id,  @RequestParam String name, @RequestParam double weight) {
		Turkey turkey = new Turkey(id, name, weight);
		turkeys.add(turkey);
		return turkey;
		
	}
	
}
