package contacts.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import contacts.entity.Contact;
import contacts.respsitory.ContactRepository;

@Controller
@RequestMapping("/contact")
public class ContactController {
	
	@Autowired
	private ContactRepository contactRepo;

	@RequestMapping(method=RequestMethod.GET)
	public String home(Map<String,Object> model) {
		List<Contact> contacts = contactRepo.findAll();
		model.put("contacts", contacts);
		return "home";
	}
	
	@RequestMapping(value="/detail",method=RequestMethod.GET)
	public String detail(Map<String,Object> model) throws Exception {
		// ≤È—Ø
		String name = "test";
		Contact contact = contactRepo.findContactByFirstName(name);
		
		List<Contact> contacts = new ArrayList<Contact>();
		contacts.add(contact);
		model.put("contacts", contacts);
		
		return "home";
	}
	
	@RequestMapping(value="/insert",method=RequestMethod.GET)
	public String insert(Map<String,Object> model) throws Exception {
		// ≤È—Ø
		Contact contact = new Contact();
		contact.setFirstName("chen1751");
		contact.setLastName("chen1751");
		contact.setPhoneNumber("chen1751");
		contact.setEmailAddress("chen1751");
		contactRepo.save(contact);
		
		List<Contact> contacts = new ArrayList<Contact>();
		contacts.add(contact);
		model.put("contacts", contacts);
		
		return "home";
	}
	
	@RequestMapping(value="/update",method=RequestMethod.GET)
	public String update(Map<String,Object> model) throws Exception {
		// ≤È—Ø
		String name = "test";
		Contact contact = contactRepo.findContactByFirstName(name);
		
		// update
		contact.setLastName("chen");
		contact.setEmailAddress("chen@163.com");
		contact.setEmailAddress("chen@163.com");
		contactRepo.updateContact(contact.getId(), contact);
		
		List<Contact> contacts = new ArrayList<Contact>();
		contacts.add(contact);
		return "home";
	}
	
	
	@RequestMapping(method=RequestMethod.POST)
	public String submit(Contact contact) {
		contactRepo.save(contact);
		return "redirect:/";
	}
}