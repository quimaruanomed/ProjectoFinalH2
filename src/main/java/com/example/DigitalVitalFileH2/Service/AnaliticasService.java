package com.example.DigitalVitalFileH2.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.DigitalVitalFileH2.modelos.Analiticas;
import com.example.DigitalVitalFileH2.Repository.AnaliticasRepository;


@Service
public class AnaliticasService {
 
	@Autowired
	private AnaliticasRepository analiticasRepository;
	
 
	public Analiticas createAnaliticas(Analiticas analitcas) {
       return analiticasRepository.save(analitcas);
  
		}
	public List<Analiticas> getAllAnaliticas(){
		return analiticasRepository.findAll();
  
	}
 
	public Optional<Analiticas> findAnaliticasById(long id){
		return analiticasRepository.findById(id);
	}
	
	
	
	
	}