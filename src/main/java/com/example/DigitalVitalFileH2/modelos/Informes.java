package com.example.DigitalVitalFileH2.modelos;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Informes")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Informes{
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String fileInformes;
	private long size;
	private byte[] content;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFileInformes() {
		return fileInformes;
	}
	public void setFileInformes(String fileInformes) {
		this.fileInformes = fileInformes;
	}
	public long getSize() {
		return size;
	}
	public void setSize(long size) {
		this.size = size;
	}
	public byte[] getContent() {
		return content;
	}
	public void setContent(byte[] content) {
		this.content = content;
	}
	public void addAttribute(String string, String list) {
		// TODO Auto-generated method stub
		
	}
	public void addAttribute(String string, List<Informes> list) {
		// TODO Auto-generated method stub
		
	}

}

