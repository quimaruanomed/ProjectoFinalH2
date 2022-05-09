package com.example.DigitalVitalFileH2.modelos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;

@Entity
@Table(name = "Medicacion")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Medicacion{
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)//generará una clave automatica incremental//Indica que la clave principal será la id
	private Long id;
	private String fileMedicacion;
	private long size;
	private byte[] content;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFileMedicacion() {
		return fileMedicacion;
	}
	public void setFileMedicacion(String fileMedicacion) {
		this.fileMedicacion = fileMedicacion;
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

}

