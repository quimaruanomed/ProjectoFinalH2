package com.example.DigitalVitalFileH2.modelos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name="TA")
public class BloodPressurePulse {

	@Id
	private String id;

	private LocalDate date;
	private String systolic;
	private String diastolic;
	private String pulse; 
	
   
	public String getPulse() {
		return pulse;
	}

	public void setPulse(String pulse) {
		this.pulse = pulse;
	}

	public BloodPressurePulse() {
		
	}
	
	public BloodPressurePulse( String id, LocalDate date,String systolic, String diastolic, String pulse) {
		
		this.id= id;
		this.date= date;
		this.systolic= systolic;
		this.diastolic= diastolic;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSystolic() {
		return systolic;
	}

	public void setSystolic(String systolic) {
		this.systolic = systolic;
	}

	public String getDiastolic() {
		return diastolic;
	}

	public void setDiastolic(String diastolic) {
		this.diastolic = diastolic;
	}

	@Override
	public String toString() {
		return "BloodPressurePulse [id=" + id + ", date=" + date + ", systolic=" + systolic + ", diastolic=" + diastolic
				+ ", pulse=" + pulse + "]";
	}
	
	
}
