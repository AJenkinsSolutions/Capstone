package com.jenkins.capstone;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.startsWith;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.jenkins.capstone.model.Contact;
import com.jenkins.capstone.repository.ContactRepository;
import com.jenkins.capstone.service.ContactService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootTest
class CapstoneApplicationTests {

	@MockBean
	private ContactRepository contactRepository;

	@Autowired
	private ContactService contactService;


	@Test
	public void insertContactTest(){

		Contact contact1 = new Contact(101,
				"johnDoe",
				"123-123-1234",
				"john@email.com",
				"dev",
				"hello world ",
				"Open");

		//Mock and return
		when(contactRepository.save(contact1)).thenReturn(contact1);
		assertEquals("johnDoe", contactService.addMessageToInbox(contact1).getName());



	}





}
