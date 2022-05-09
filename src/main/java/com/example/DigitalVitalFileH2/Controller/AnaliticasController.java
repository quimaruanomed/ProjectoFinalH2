package com.example.DigitalVitalFileH2.Controller;


import java.io.IOException;
import java.util.List;
import java.util.Optional;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.multipart.MultipartFile;
import com.example.DigitalVitalFileH2.modelos.Analiticas;
import com.example.DigitalVitalFileH2.modelos.Informes;
import com.example.DigitalVitalFileH2.modelos.Medicacion;
import com.example.DigitalVitalFileH2.modelos.PruebasImagen;
import com.example.DigitalVitalFileH2.Service.AnaliticasService;
import com.example.DigitalVitalFileH2.Service.InformesService;
import com.example.DigitalVitalFileH2.Service.MedicacionService;
import com.example.DigitalVitalFileH2.Service.PruebasImagenService;


	@Controller
	public class AnaliticasController {
		
	    @Autowired
	    private AnaliticasService analiticasService;
	    @Autowired
	    private InformesService informesService ;
	   
	    @Autowired
	    private PruebasImagenService pruebasImagenService ;
	    
	    @Autowired
	    private MedicacionService medicacionService ;
	    
	    
	    @GetMapping("/") 
	    public String home(Model model) {
	    	  List<Analiticas> list =  analiticasService.getAllAnaliticas();
	    	  model.addAttribute("list", list);
	    	  return "indexAnaliticas";
	    	 }

	    @PostMapping("/upload")
	    public String fileUpload(@RequestParam("file") MultipartFile file,  Model model) throws IOException {
	    Analiticas analiticas = new Analiticas();
	     String fileName = file.getOriginalFilename();
	     analiticas.setFileAnalitica(fileName);
	     analiticas.setContent(file.getBytes());
	     analiticas.setSize(file.getSize());
	     analiticasService.createAnaliticas(analiticas);
	     model.addAttribute("success", "File Uploaded Successfully!!!");
	     return "indexAnaliticas";
	    } 

	     @GetMapping("/downloadfile")
	     public void downloadFile(@Param("id") Long id , Model model, HttpServletResponse response) throws IOException {
	      Optional<Analiticas> temp = analiticasService.findAnaliticasById(id);
	      if(temp!=null) {
	    	  
	      Analiticas analiticas = temp.get();
	      response.setContentType("application/octet-stream");
	      String headerKey = "Content-Disposition";
	      String headerValue = "attachment; filename = "+analiticas.getFileAnalitica();
	      response.setHeader(headerKey, headerValue);
	      ServletOutputStream outputStream = response.getOutputStream();
	      outputStream.write(analiticas.getContent());
	      outputStream.close();
	     }
	    }
	    
	     @GetMapping("/image") //para visualizar las imagenes
	     public void showImage(@Param("id") Long id, HttpServletResponse response, Optional<Analiticas> analiticas)
	       throws ServletException, IOException {
	      
	      analiticas = analiticasService.findAnaliticasById(id);
	      response.setContentType("image/jpeg, image/jpg, image/png, image/gif, image/pdf");
	      response.getOutputStream().write(analiticas.get().getContent());
	      response.getOutputStream().close();
	     }
	    //INFORMES
	     @GetMapping("/informes") //http://localhost:8888/informes
		    public String homeInformes(Model model) {
		    	  List<Informes> list =  informesService.getAllInformes();
		    	  model.addAttribute("list", list);
		    	  return "indexInformes";
		    	 }

	     
	     @PostMapping("/uploadInformes")//http://localhost:8888/informes
		    public String fileUploadInformes(@RequestParam("file") MultipartFile file,  Model model) throws IOException {
		    Informes informes = new Informes();
		     String fileName = file.getOriginalFilename();
		     informes.setFileInformes(fileName);
		     informes.setContent(file.getBytes());
		     informes.setSize(file.getSize());
		     informesService.createInformes(informes);
		     model.addAttribute("success", "File Uploaded Successfully!!!");
		     return "indexInformes";
		    } 
	     @GetMapping("/downloadInformes")//http://localhost:8888/downloadInformes?id=10
	     public void downloadInformes(@Param("id") Long id , Model model, HttpServletResponse response) throws IOException {
	      Optional<Informes> temp = informesService.findInformesById(id);
	      if(temp!=null) {
	    	  
	      Informes informes = temp.get();
	      response.setContentType("application/octet-stream");
	      String headerKey = "Content-Disposition";
	      String headerValue = "attachment; filename = "+ informes.getFileInformes();
	      response.setHeader(headerKey, headerValue);
	      ServletOutputStream outputStream = response.getOutputStream();
	      outputStream.write(informes.getContent());
	      outputStream.close();
	     }
	     }
	     @GetMapping("/imageInformes")//Para visualizar las imagenes
	     public void showInforme(@Param("id") Long id, HttpServletResponse response, Optional<Informes> informes)
	       throws ServletException, IOException {
	      
	      informes = informesService.findInformesById(id);
	      response.setContentType("image/jpeg, image/jpg, image/png, image/gif, image/pdf");
	      response.getOutputStream().write(informes.get().getContent());
	      response.getOutputStream().close();
	     }
	     
	     //PRUEBAS IMAGEN 
	     @GetMapping("/pruebasImagen") //http://localhost:8888/pruebasImagen
		    public String homePruebasImagen(Model model) {
		    	  List<PruebasImagen> list =  pruebasImagenService.getAllPruebasImagen();
		    	  model.addAttribute("list", list);
		    	  return "indexPruebasImagen";
		    	 }


		    @PostMapping("/uploadPruebasImagen")
		    public String fileUploadPruebasImagen(@RequestParam("file") MultipartFile file,  Model model) throws IOException {
		   PruebasImagen pruebasImagen = new PruebasImagen();
		     String fileName = file.getOriginalFilename();
		     pruebasImagen.setFileAnalitica(fileName);
		     pruebasImagen.setContent(file.getBytes());
		     pruebasImagen.setSize(file.getSize());
		     pruebasImagenService.createPruebasimagen(pruebasImagen);
		     model.addAttribute("success", "File Uploaded Successfully!!!");
		     return "indexPruebasImagen";
		    } 

		     @GetMapping("/downloadPruebasImagen")//para descargar pdf etc. por id
		     public void downloadFilePruebasImagen(@Param("id") Long id , Model model, HttpServletResponse response) throws IOException {
		      Optional<PruebasImagen> temp = pruebasImagenService.findPruebasImagenById(id);
		      if(temp!=null) {
		    	  
		      PruebasImagen pruebasImagen = temp.get();
		      response.setContentType("application/octet-stream");
		      String headerKey = "Content-Disposition";
		      String headerValue = "attachment; filename = "+ pruebasImagen.getFilePruebasImagen();
		      response.setHeader(headerKey, headerValue);
		      ServletOutputStream outputStream = response.getOutputStream();
		      outputStream.write(pruebasImagen.getContent());
		      outputStream.close();
		     }
		    }
		    
		     @GetMapping("/imagePruebasImagen") //para visualizar las imagenes 
		     public void showPruebasImagen(@Param("id") Long id, HttpServletResponse response, Optional<PruebasImagen> pruebasImagen)
		       throws ServletException, IOException {
		      
		      pruebasImagen = pruebasImagenService.findPruebasImagenById(id);
		      response.setContentType("image/jpeg, image/jpg, image/png, image/gif, image/pdf");
		      response.getOutputStream().write(pruebasImagen.get().getContent());
		      response.getOutputStream().close();
		     }
		     
		     //MEDICACION 
		     
		     @GetMapping("/medicacion") 
			    public String homeMedicacion(Model model) {
			    	  List<Medicacion> list =  medicacionService.getAllMedicacion();
			    	  model.addAttribute("list", list);
			    	  return "indexMedicacion";
			    	 }

			    @PostMapping("/uploadMedicacion")
			    public String fileUploadMedicacion(@RequestParam("file") MultipartFile file,  Model model) throws IOException {
			    Medicacion medicacion = new Medicacion();
			     String fileName = file.getOriginalFilename();
			     medicacion.setFileMedicacion(fileName);
			     medicacion.setContent(file.getBytes());
			     medicacion.setSize(file.getSize());
			     medicacionService.createMedicacion(medicacion);
			     model.addAttribute("success", "File Uploaded Successfully!!!");
			     return "indexAnaliticas";
			    } 

			     @GetMapping("/downloadMedicacion")
			     public void downloadMedicacion(@Param("id") Long id , Model model, HttpServletResponse response) throws IOException {
			      Optional<Medicacion> temp = medicacionService.findMedicacionById(id);
			      if(temp!=null) {
			    	  
			      Medicacion medicacion = temp.get();
			      response.setContentType("application/octet-stream");
			      String headerKey = "Content-Disposition";
			      String headerValue = "attachment; filename = "+medicacion.getFileMedicacion();
			      response.setHeader(headerKey, headerValue);
			      ServletOutputStream outputStream = response.getOutputStream();
			      outputStream.write(medicacion.getContent());
			      outputStream.close();
			     }
			    }
			    
			     @GetMapping("/imageMedicacion") //para visualizar las imagenes
			     public void showMedicacion(@Param("id") Long id, HttpServletResponse response, Optional<Medicacion> medicacion)
			       throws ServletException, IOException {
			      
			      medicacion = medicacionService.findMedicacionById(id);
			      response.setContentType("image/jpeg, image/jpg, image/png, image/gif, image/pdf");
			      response.getOutputStream().write(medicacion.get().getContent());
			      response.getOutputStream().close();
			     }
}
