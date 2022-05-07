package com.example.DigitalVitalFileH2.Controller;

import java.time.LocalDate;
import java.util.HashMap;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.DigitalVitalFileH2.modelos.Patient;
import com.example.DigitalVitalFileH2.modelos.BloodPressurePulse;


import com.example.DigitalVitalFileH2.Repository.PatientRepository;

import com.example.DigitalVitalFileH2.modelos.ResourceNotFoundException;

	@RestController
	@RequestMapping("/api")
	public class PatientController {
	    @Autowired
	    private PatientRepository patientRepository;
	   

	    @GetMapping("/patient") //http://localhost:8086/api/patient
	    public List < Patient > getAllPatient() {
	        return patientRepository.findAll();
	    }

	    @GetMapping("/patient/{id}")//http://localhost:8086/api/patient/1
	    public ResponseEntity < Patient > getPatientById(@PathVariable(value = "id") Long id)
	    
	    	    throws ResourceNotFoundException {
	    	        Patient patient = patientRepository.findById(id)
	    	            .orElseThrow(() -> new ResourceNotFoundException("Patient not found for this id :: " + id));
	    	        return ResponseEntity.ok().body(patient);
	    	    }
	   
	    @PostMapping("/create")//http://localhost:8086/api/create  --> enviar json
	    public Patient createPatient(@RequestBody Patient patient) {
	        return patientRepository.save(patient);
	    }

	    @PutMapping("/patientUpload/{id}")//http://localhost:8086/api/patientUpload/3
	    public ResponseEntity < Patient > updatePatient(@PathVariable(value = "id") Long patientId,
	        @RequestBody Patient patientDetails) throws ResourceNotFoundException {
	        Patient patient = patientRepository.findById(patientId)
	        		.orElseThrow(() -> new ResourceNotFoundException("Patient not found for this id :: " + patientId));

	        patient.setName(patientDetails.getName());
	        patient.setSurname(patientDetails.getSurname());
	        patient.setAge(patientDetails.getAge());
	        patient.setCip(patientDetails.getCip());
	        patient.setTelephone(patientDetails.getTelephone());
	        patient.setAddress(patientDetails.getAddress());
	        final Patient updatedPatient = patientRepository.save(patient);
	        return ResponseEntity.ok(updatedPatient);
	    }

	    @DeleteMapping("/delete/{id}")//http://localhost:8086/api/delete/2
	    public Map < String, Boolean > deletePatient(@PathVariable(value = "id") Long patientId)
	    throws ResourceNotFoundException {
	        Patient patient = patientRepository.findById(patientId)
	        		.orElseThrow(() -> new ResourceNotFoundException("Patient not found for this id :: " + patientId));

	        patientRepository.delete(patient);
	        Map < String, Boolean > response = new HashMap < > ();
	        response.put("deleted", Boolean.TRUE);
	        return response;
	    }


}
