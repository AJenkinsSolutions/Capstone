package com.jenkins.capstone;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.startsWith;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.jenkins.capstone.model.Contact;
import com.jenkins.capstone.model.Developer;
import com.jenkins.capstone.model.Training;
import com.jenkins.capstone.repository.ContactRepository;
import com.jenkins.capstone.repository.DeveloperRepository;
import com.jenkins.capstone.repository.TrainingRepository;
import com.jenkins.capstone.service.ContactService;
import com.jenkins.capstone.service.DeveloperService;
import com.jenkins.capstone.service.TrainingService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class CapstoneApplicationTests {

	@MockBean
	private ContactRepository contactRepository;

	@MockBean
	private TrainingRepository trainingRepository;

	@MockBean
	private DeveloperRepository developerRepository;


	@Autowired
	private  TrainingService trainingService;

	@Autowired
	private ContactService contactService;

	@Autowired
	private DeveloperService developerService;


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

	@Test
	public void get_all_trainings_test(){

		List<Training> trainingList = new ArrayList<>();
		trainingList.add(new Training());

		//Mock and return
		when(trainingRepository.findAll()).thenReturn(trainingList);
		assertNotEquals(0, trainingService.getAllTrainingTypes().size());

	}

	@Test
	public void insertDeveloperTest(){

		Developer developer = new Developer(111, "jane doe", "jane@email.com", "123-123-1234", "testExample");

		//Mock and return
		when(developerRepository.save(developer)).thenReturn(developer);
		assertTrue(developerService.AddDeveloper(developer));

	}









}
