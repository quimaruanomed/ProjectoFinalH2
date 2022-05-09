package com.example.DigitalVitalFileH2.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.DigitalVitalFileH2.modelos.PruebasImagen;

import com.example.DigitalVitalFileH2.Repository.PruebasImagenRepository;


@Service
public class PruebasImagenService {
 
	@Autowired
	private PruebasImagenRepository pruebasImagenRepository;
	
 
	public PruebasImagen createPruebasimagen(PruebasImagen pruebasImagen) {
       return pruebasImagenRepository.save(pruebasImagen);
  
		}
	public List<PruebasImagen> getAllPruebasImagen(){
		return pruebasImagenRepository.findAll();
  
	}
 
	public Optional<PruebasImagen> findPruebasImagenById(long id){
		return pruebasImagenRepository.findById(id);
	}
	
	
	
	
	}