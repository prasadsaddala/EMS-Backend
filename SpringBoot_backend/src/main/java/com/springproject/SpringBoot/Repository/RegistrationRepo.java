package com.springproject.SpringBoot.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import com.springproject.SpringBoot.Entity.Registration;



@EnableJpaRepositories
@Repository
public interface RegistrationRepo extends JpaRepository<Registration,Long>{
	Optional<Registration> findOneByEmailAndPassword(String email, String password);
    Registration findByEmail(String email);
	
}
