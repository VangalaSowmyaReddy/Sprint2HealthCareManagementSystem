package com.capgemini.controller;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.entities.DiagnosticCentre;
import com.capgemini.entities.Tests;
import com.capgemini.exception.RecordFoundException;
import com.capgemini.service.TestService;


@RestController
@RequestMapping("/Test")
@CrossOrigin(origins = "http://localhost:4200")
public class TestController {
	@Autowired
	TestService service;
	

	@PostMapping("/create")
	public ResponseEntity<String> create(@RequestBody Tests test) {
		Tests test1 = null;

		DiagnosticCentre center= service.findByCentreName(test.getCentre().getCentreName());
		if (center != null) {
			Optional<Tests> testEntity = service.findBycentreNameAndTestName(center.getCentreName(), test.getTestName());
			if (testEntity.isPresent()) {
				throw new RecordFoundException("TestName found");
			}
			test1 = new Tests(test.getTestName(), center);
		} else {
			DiagnosticCentre centre = new DiagnosticCentre(test.getCentre().getCentreName());
			service.save(centre);
			test1 = new Tests(test.getTestName(), centre);

		}
		
		service.addTest(test1);
		return new ResponseEntity<String>("Test is created Successfully", new HttpHeaders(), HttpStatus.OK);
		
	}
	@GetMapping("/Centres")
	public ResponseEntity<List<DiagnosticCentre>> getCentres() {
		List<DiagnosticCentre> list = service.getCentres();
		return new ResponseEntity<>(list, new HttpHeaders(), HttpStatus.OK);

	}

	@GetMapping("/Tests")
	public ResponseEntity<List<Tests>> getTests() {
		List<Tests> list = service.getTests();
		return new ResponseEntity<>(list, new HttpHeaders(), HttpStatus.OK);

	}

	@DeleteMapping("/delete/{testId}")
	public ResponseEntity<Boolean> deleteTestById(@PathVariable("testId") String testId) {
		System.out.println(testId);
		service.deleteBytestId(testId);
		return new ResponseEntity<Boolean>(true, new HttpHeaders(), HttpStatus.OK);

	}


	@ExceptionHandler(RecordFoundException.class)
	public ResponseEntity<Boolean> userNotFound(RecordFoundException e) {
		return new ResponseEntity<>(false, HttpStatus.OK);
	}

}
