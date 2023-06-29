package com.springproject.SpringBoot.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.springproject.SpringBoot.Dto.LoginDTO;
import com.springproject.SpringBoot.Dto.RegistrationDTO;
import com.springproject.SpringBoot.Entity.Registration;
import com.springproject.SpringBoot.Repository.RegistrationRepo;
import com.springproject.SpringBoot.Response.LoginResponse;
import com.springproject.SpringBoot.Service.RegistrationService;

import java.util.Optional;

@Service
public class RegistrationServiceImpl implements RegistrationService{
	
	@Autowired
	private RegistrationRepo registrationRepo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public String addDetails(RegistrationDTO registrationDTO)
	{
		Registration register=new Registration(
				registrationDTO.getId(),
				registrationDTO.getName(),
				registrationDTO.getEmail(),
				this.passwordEncoder.encode(registrationDTO.getPassword()));
		
		registrationRepo.save(register);
		return register.getName();
	}
	RegistrationDTO registrationDTO;

	@Override
	public LoginResponse loginEmployee(LoginDTO loginDTO) {
		
		String msg="";
		Registration register1=registrationRepo.findByEmail(loginDTO.getEmail());
		
		if(register1!= null) {
			String password=loginDTO.getPassword();
			String encodedPassword=register1.getPassword();
			Boolean isPwdRight=passwordEncoder.matches(password, encodedPassword);
			if(isPwdRight) {
				Optional<Registration> register= registrationRepo.findOneByEmailAndPassword(loginDTO.getEmail(), encodedPassword);
			
				if (register.isPresent()) {
                    return new LoginResponse("Login Success", true);
                } else {
                    return new LoginResponse("Login Failed", false);
                }
            } else {
 
                return new LoginResponse("password Not Match", false);
            }
        }else {
            return new LoginResponse("Email not exits", false);
        }
			
		}
}
