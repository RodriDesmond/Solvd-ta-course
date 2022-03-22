package hospital.models.patient;

import hospital.models.department.Hospital;
import hospital.models.staff.Doctor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

public class Appointment {

	private LocalDate date;
	private LocalTime time;
	private Hospital hospital;
	private Doctor doctor;
	private Patient patient;
	private BigDecimal cost;

	public Appointment() {
	}

	public Appointment(Hospital hospital, LocalDate date, LocalTime time, Doctor doctor, Patient patient, BigDecimal cost) {
		this.hospital = hospital;
		this.date = date;
		this.time = time;
		this.doctor = doctor;
		this.patient = patient;
		this.cost = cost;
	}


	public String getHospital() {
		return hospital.getName();
	}

	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
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

	@Override
	public String toString() {
		return "Appointment{" +
				"date=" + date +
				", time=" + time +
				", hospital=" + hospital +
				", doctor=" + doctor +
				", patient=" + patient +
				", cost=" + cost +
				'}';
	}
}