package com.EvolentHealth.contactInfo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.EvolentHealth.contactInfo.model.Contact;
import com.EvolentHealth.contactInfo.service.ContactServiceImp;
import com.EvolentHealth.contactInfo.service.ContactServiceInterface;

@Controller
public class ContactController {

	@Autowired
	private ContactServiceInterface contactServiceInterface;

	@GetMapping("/")
	public String viewHomePage(Model model) {
		model.addAttribute("contactList", contactServiceInterface.getAllContact());

		return "index";

	}
	
	@GetMapping("/showNewContactForm")
	public String showNewContactForm(Model model){
		
		// create model attribute to bind from data
		Contact contact = new Contact();
		model.addAttribute("contact", contact);	
		return "new_contact";
		
	}
	
	@PostMapping("/saveContact")
	public String saveContact(@ModelAttribute("contact") Contact contact, Errors error){
		
		contactServiceInterface.saveContact(contact);
		return "redirect:/";
	}
	
	@GetMapping(value = "/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable (value= "id") long id, Model	model) {
	    
		Contact contact = contactServiceInterface.getContactById(id);		
		model.addAttribute("contact", contact);
	    return "update_contact";
	}
	
	@GetMapping(value = "/delete/{id}")
	public String delete(@PathVariable (value= "id") long id){
		this.contactServiceInterface.deleteContactbyId(id);
		return "redirect:/";
	}
}
