package com.example.DigitalVitalFileH2.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.DigitalVitalFileH2.modelos.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long>{

}
	
	
	
	

	
	