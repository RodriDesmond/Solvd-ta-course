package hospital.models.patient;

import hospital.models.staff.Doctor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

public class Appointment {

	private LocalDate date;
	private LocalTime time;
	private Doctor doctor;
	private Patient patient;
	private BigDecimal cost;

	public Appointment() {
	}

	public Appointment(LocalDate date, LocalTime time, Doctor doctor, Patient patient, BigDecimal cost) {
		this.date = date;
		this.time = time;
		this.doctor = doctor;
		this.patient = patient;
		this.cost = cost;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public LocalTime getTime() {
		return time;
	}

	public void setTime(LocalTime time) {
		this.time = time;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public BigDecimal getCost() {
		return cost;
	}

	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}
}