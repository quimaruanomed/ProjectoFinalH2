package com.example.DigitalVitalFileH2.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.DigitalVitalFileH2.modelos.Medicacion;
import com.example.DigitalVitalFileH2.Repository.MedicacionRepository;


@Service
public class MedicacionService {
 
	@Autowired
	private MedicacionRepository medicacionRepository;
	
 
	public Medicacion createMedicacion(Medicacion medicacion) {
       return medicacionRepository.save(medicacion);
  
		}
	public List<Medicacion> getAllMedicacion(){
		return medicacionRepository.findAll();
  
	}
 
	public Optional<Medicacion> findMedicacionById(long id){
		return medicacionRepository.findById(id);
	}
	
	
	
	
	}