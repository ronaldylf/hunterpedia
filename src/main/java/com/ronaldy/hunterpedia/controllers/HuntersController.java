package com.ronaldy.hunterpedia.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ronaldy.hunterpedia.entities.Hunter;
import com.ronaldy.hunterpedia.repositories.HunterRepository;

@RestController
@RequestMapping(value="/hunters")
public class HuntersController {	
	@Autowired
	private HunterRepository repository;
	
	
	@GetMapping()
	public List<Hunter> filterByParams(
			@RequestParam(value="name",required=false) String name,
			@RequestParam(value="gender", required=false) String gender,
			@RequestParam(value="nen_type", required=false) String nen_type) {

		// checking if the params was passed
		String checked_name = (name==null) ? "" : name;
		String checked_gender = (gender==null) ? "" : gender;
		String checked_nen_type = (nen_type==null) ? "" : nen_type;
		
		List<Hunter> hunters = repository.getHuntersBySearchParams(
				checked_name,
				checked_gender,
				checked_nen_type);
		return hunters;
	}

	// read
	@GetMapping(value = "/{id}")
	public Hunter findById(@PathVariable UUID id) {
		Hunter result = repository.findById(id).get();
		return result;
	}
	
	// create
	@PostMapping(value = "/add")
	public Hunter insert(@RequestBody Hunter hunter) {
		Hunter result = repository.save(hunter);
		return result;
	}
	
	// update
	@PostMapping(value = "/update")
	public Hunter update(@RequestBody Hunter hunter) {
		Hunter result = repository.save(hunter);
		return result;
	}
	
	// delete passing the user
	@DeleteMapping(value = "/delete")
	public Hunter deleteByHunter(@RequestBody Hunter hunter) {
		repository.delete(hunter);
		return hunter;
	}

	// delete passing just the id
	@DeleteMapping(value = "/deleteById/{id}")
	public UUID deleteById(@PathVariable UUID id) {
		repository.deleteById(id);
		return id;
	}
}