package model;

import java.util.ArrayList;
import java.util.List;

public class ContactManager {

	private List<Contact> contacts;
	
	public ContactManager() {
		contacts = new ArrayList <Contact>();
		contacts.add(new Contact("1","Gonzalo","zalonore@gmail.com"));
	}
	
	public boolean add(Contact newContact) {
		if (contacts.add(newContact)) {
			return true;
		}else {
			return false;
		}
	}
	
	//TODO
	public boolean remove(int index) {
		return true;
	}

	public List<Contact> getContacts() {
		return contacts;
	}
	
}
