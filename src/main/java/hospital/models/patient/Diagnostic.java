package hospital.models.patient;


import hospital.models.enums.EDisease;

import java.time.LocalDate;

public class Diagnostic {

	private LocalDate date;
	private EDisease disease;
	private Patient patient;

	public Diagnostic(LocalDate date,
	                  EDisease disease) {
		this.date = date;
		this.disease = disease;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public EDisease getDisease() {
		return disease;
	}

	public void setDisease(EDisease disease) {
		this.disease = disease;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}


	@Override
	public String toString() {
		return "\ndate: " + date +
				disease;
	}
}
