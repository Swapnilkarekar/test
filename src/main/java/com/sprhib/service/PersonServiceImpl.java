package com.sprhib.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sprhib.dao.PersonDAO;
import com.sprhib.model.Person;

@Transactional
@Service
public class PersonServiceImpl implements PersonService {
	
	private PersonDAO personDAO;

	public void setPersonDAO(PersonDAO personDAO) {
		this.personDAO = personDAO;
	}

	public void addPerson(Person p) {
		this.personDAO.addPerson(p);
	}

	public void updatePerson(Person p) {
		this.personDAO.updatePerson(p);
	}

	public List<Person> listPersons() {
		return this.personDAO.listPersons();
	}

	public Person getPersonById(int id) {
		return this.personDAO.getPersonById(id);
	}

	public void removePerson(int id) {
		this.personDAO.removePerson(id);
	}

}
