package com.EvolentHealth.contactInfo.service;

import java.util.List;

import com.EvolentHealth.contactInfo.model.Contact;

public interface ContactServiceInterface {

	List<Contact> getAllContact();
	void saveContact(Contact contact);
	Contact getContactById(long id);
	void deleteContactbyId(long id);
}
