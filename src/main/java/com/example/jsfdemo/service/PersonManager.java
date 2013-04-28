package com.example.jsfdemo.service;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import com.example.jsfdemo.domain.Person;

@ApplicationScoped
public class PersonManager {
	private List<Person> db = new ArrayList<Person>();
private static int size;

	
	public void addPerson(Person person) {
		
		Person p = get(person.getId());
		if (p==null){
		Person newPerson = new Person();
		
		PersonManager.size++;
		setPerson(newPerson, person);
		newPerson.setId(PersonManager.size);

		db.add(newPerson);}
		else setPerson(p, person);
	}

	public Person get(int id){
		for (Person p : db){
			if(p.getId()==id)
				return p;
		}
		return null;
	}
	
	// Removes the person with given PIN
	public void deletePerson(Person person) {
		Person personToRemove = null;
		for (Person p : db) {
			if (person.getPin().equals(p.getPin())) {
				personToRemove = p;
				break;
			}
		}
		if (personToRemove != null)
			db.remove(personToRemove);
	}

	public List<Person> getAllPersons() {
		return db;
	}
	

	private void setPerson(Person newPerson, Person person){
		newPerson.setFirstName(person.getFirstName());
		newPerson.setZipCode(person.getZipCode());
		newPerson.setPin(person.getPin());
		newPerson.setDateOfBirth(person.getDateOfBirth());
		newPerson.setMarried(person.isMarried());
		newPerson.setWeight(person.getWeight());
		newPerson.setNumOfChildren(person.getNumOfChildren());
	}
		
	
}
