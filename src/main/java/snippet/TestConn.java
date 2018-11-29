package snippet;

import com.journaldev.spring.model.Person;
import com.journaldev.spring.service.PersonServiceImpl;

public class TestConn
{
	public static void main(String[] args) {
		PersonServiceImpl personDAO = new PersonServiceImpl();
		personDAO.addPerson(new Person());
	}
}