package com.example.CrudDemo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.CrudDemo.dao.PersonRepository;
import com.example.CrudDemo.entity.Person;
import com.example.CrudDemo.entity.PersonJson;

@RestController
@RequestMapping("/api")
public class DemoController {

	@Autowired
	private PersonRepository repository;

	public PersonRepository getRepository() {
		return repository;
	}

	public void setRepository(PersonRepository repository) {
		this.repository = repository;
	}

	@GetMapping("/persons")
	public List<Person> getAllPersons() {
		return repository.findAll();
	}

	@PostMapping("/persons")
	public Person addPerson(@RequestBody PersonJson personJson) {
		Person person = personJson.makePersonFromJson();
		repository.save(person);
		return person;

	}

	@PutMapping("/persons/{personId}")
	public Person updatePersion(@PathVariable int personId, @RequestBody PersonJson personJson) {
		Optional<Person> optionalPerson = repository.findById(personId);
		Person newPerson = personJson.makePersonFromJson();

		if (!optionalPerson.isPresent())
			throw new RuntimeException("Person Not found");

		Person person = optionalPerson.get();

		person.setAge(newPerson.getAge());
		person.setFavouriteColour(newPerson.getFavouriteColour());
		person.setAge(newPerson.getAge());
		person.setHobby(newPerson.getHobby());
		person.setFirstName(newPerson.getFirstName());
		person.setLastName(newPerson.getLastName());
		repository.save(person);
		return person;
	}

	@DeleteMapping("/persons/{personId}")
	public Person deletePersion(@PathVariable int personId) {
		Optional<Person> optionalPerson = repository.findById(personId);
		repository.deleteById(personId);
		if (!optionalPerson.isPresent())
			throw new RuntimeException("Person not found");
		Person person = optionalPerson.get();
		return person;

	}
	
	@GetMapping("/persons/{personId}")
	public Person getPersonById(@PathVariable int personId) {
		Optional<Person> optionalPerson=repository.findById(personId);
		if(!optionalPerson.isPresent())
			throw new RuntimeException("Person not found");
		
		Person person=optionalPerson.get();
		return person;
	}

}
