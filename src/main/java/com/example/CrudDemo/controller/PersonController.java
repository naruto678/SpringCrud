package com.example.CrudDemo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.CrudDemo.dao.PersonRepository;
import com.example.CrudDemo.entity.Person;

@Controller
public class PersonController {
	@Autowired
	private PersonRepository personRepository;

	public PersonRepository getPersonRepository() {
		return personRepository;
	}

	public void setPersonRepository(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}

	@GetMapping("/home")
	public String showHomePage(ModelMap model) {
		List<Person> users = personRepository.findAll();
	
		model.addAttribute("users", users);
		
		
		
		return "index";

	}
	@GetMapping("/signup")
	public String addUser(ModelMap model) {
		Person person=new Person();
		model.addAttribute("user",person);
		return "add-user";
	}
	@PostMapping("/adduser")
	public String addUser(@ModelAttribute Person person,ModelMap model) {
		
		
		
		this.personRepository.save(person);
		
		
		
		return "redirect:/home";
	}
	@GetMapping("/edit/{personId}")
	public String editUser(@PathVariable int personId,ModelMap model) {
		Optional<Person> person=this.personRepository.findById(personId);
		if(!person.isPresent())
			throw new RuntimeException("Person not Found");
		model.addAttribute("user",person);
		return "add-user";
		
		
	}
	
	@GetMapping("/delete/{personId}")
	public String deletePerson(@PathVariable int personId) {
		this.personRepository.deleteById(personId);
		return "redirect:/home";
	}
	
	

}
