package com.EvolentHealth.contactInfo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.EvolentHealth.contactInfo.model.Contact;
import com.EvolentHealth.contactInfo.repository.ContactRepository;

@Service
public class ContactServiceImp implements ContactServiceInterface {

	@Autowired
	private ContactRepository contactRepository;
	
	public List<Contact> getAllContact() {
		
		return contactRepository.findAll();
	}

	public void saveContact(Contact contact) {
		// TODO Auto-generated method stub
		this.contactRepository.save(contact);
		
	}

	public Contact getContactById(long id) {
		Optional<Contact> op = contactRepository.findById(id);
		Contact contact = null;
		if(op.isPresent()){
			contact= op.get();
		}
		else{
			throw new RuntimeException("Contact not found for id :"+ id);
		}
		return contact;
	}

	public void deleteContactbyId(long id) {
		this.contactRepository.deleteById(id);
		
	}

}
