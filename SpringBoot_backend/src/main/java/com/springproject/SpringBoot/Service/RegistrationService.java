package com.springproject.SpringBoot.Service;

import com.springproject.SpringBoot.Dto.LoginDTO;
import com.springproject.SpringBoot.Dto.RegistrationDTO;
import com.springproject.SpringBoot.Response.LoginResponse;

public interface RegistrationService {

	String addDetails(RegistrationDTO registerDTO);

	LoginResponse loginEmployee(LoginDTO loginDTO);
}

