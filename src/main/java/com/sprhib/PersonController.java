package com.sprhib;


import javax.inject.Singleton;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sprhib.model.Person;
import com.sprhib.service.PersonService;

@Controller
@Singleton
public class PersonController 
{
	int count =0;
	@Autowired
	private PersonService personService;
	
	
	//@Qualifier(value="personService")
	public void setPersonService(PersonService ps){
		this.personService = ps;
	}

	@RequestMapping(value = {"/","index","/persons"}, method = RequestMethod.GET)	//  "/persons"
	public String listPersons(Model model)
	{
		count =count +1;
		model.addAttribute("person", new Person());
		model.addAttribute("listPersons", this.personService.listPersons());
		model.addAttribute("numbervist", count);
		return "person";
	}
	
	//For add and update person both
	@RequestMapping(value= "/person/add", method = RequestMethod.POST)
	public String addPerson(@ModelAttribute("person") Person p)
	{
		
		System.out.println("data   "+p);
		if(p.getId() == 0)
		{
			if(p.getName().equals("")&&p.getCountry().equals(""))
				throw new NullPointerException("Not add");
			else
			//new person, add it
				this.personService.addPerson(p);
		}else
		{
			//existing person, call update
			System.out.println("ad  Person "+p);
			this.personService.updatePerson(p);
		}
		
		return "redirect:/persons";
		
	}
	
	@RequestMapping("/remove/{id}")
    public String removePerson(@PathVariable("id") int id){
		
		System.out.println("Idd "+id);
        this.personService.removePerson(id);
        return "redirect:/persons";
    }
 
    @RequestMapping("/edit/{id}")
    public String editPerson(@PathVariable("id") int id, Model model){
    	

		System.out.println("Idd "+id);
        model.addAttribute("person", this.personService.getPersonById(id));
        model.addAttribute("listPersons", this.personService.listPersons());
        return "person";
    }
    /*useing this type we handel exception only specific to this controller only 
     * 
     * 
     * @ExceptionHandler(Exception.class)
	    public String showError()
	    {
	    	return "exp";
	    }
	    
    */
}
