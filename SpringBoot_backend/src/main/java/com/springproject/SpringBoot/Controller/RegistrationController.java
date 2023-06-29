package com.springproject.SpringBoot.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springproject.SpringBoot.Dto.LoginDTO;
import com.springproject.SpringBoot.Dto.RegistrationDTO;
import com.springproject.SpringBoot.Response.LoginResponse;
import com.springproject.SpringBoot.Service.RegistrationService;



@RestController
@CrossOrigin(origins="http://localhost:3000")
@RequestMapping("api/")
public class RegistrationController {
	
	@Autowired
	private RegistrationService registrationService;
	
	@PostMapping(path="/register/save")
	public String saveEmployee(@RequestBody RegistrationDTO registerDTO) {
		String id=registrationService.addDetails(registerDTO);
		return id;          
	}
	
	@PostMapping(path="/register/login")
	public ResponseEntity<?> loginEmployee(@RequestBody LoginDTO loginDTO)
	{
		LoginResponse loginResponse = registrationService.loginEmployee(loginDTO);
		return ResponseEntity.ok(loginResponse);
	}
}