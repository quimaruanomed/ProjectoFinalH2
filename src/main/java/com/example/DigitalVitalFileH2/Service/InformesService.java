package com.example.DigitalVitalFileH2.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.DigitalVitalFileH2.Repository.InformesRepository;
import com.example.DigitalVitalFileH2.modelos.Informes;



@Service
public class InformesService {
	
	@Autowired
	private InformesRepository informesRepository;
	
 
	public Informes createInformes(Informes informes) {
       return  informesRepository.save(informes);
  
		}
	public List<Informes> getAllInformes(){
		return informesRepository.findAll();
  
	}
 
	public Optional<Informes> findInformesById(long id){
		return  informesRepository.findById(id);
	}
	
	
	
	
	}