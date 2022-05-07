package com.example.DigitalVitalFileH2.modelos;



import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import javax.persistence.*;

@Entity
@Table(name = "PATIENT")
public class Patient{
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO) //generará una clave automatica incremental//Indica que la clave principal será la id
	private Long id;
	private LocalDate date;	
	private String name;
	private String surname;
	private String age;
	private String cip;
	private String telephone;
	private String address;

public Patient() {
		
	}
	
	public Patient(LocalDate date,String name, String surname, String age, String cip, String telephone, String address) {
		this.date= date;
		this.name= name;
		this.surname=surname;
		this.age=age;
		this.cip=cip;
		this.telephone=telephone;
		this.address=address;
		
	}
	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public  Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getCip() {
		return cip;
	}
	public void setCip(String cip) {
		this.cip = cip;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Patient [id=" + id + ", date=" + date + ", name=" + name + ", surname=" + surname + ", age=" + age
				+ ", cip=" + cip + ", telephone=" + telephone + ", address=" + address + "]";
	}
	
	 
	
	
	
}


