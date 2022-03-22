package hospital.models.patient;

import hospital.models.staff.Doctor;

import java.util.Locale;

public class MedicalRecord {

	private long id;
	private Patient patient;
	private Doctor doctor;
	private Diagnostic diagnostic;
	private boolean medicalDischarge = false;

	public MedicalRecord() {
	}

	public MedicalRecord(long id,
	                     Patient patient,
	                     Doctor doctor) {
		this.id = id;
		this.patient = patient;
		this.doctor = doctor;
	}


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPatient() {
		return (patient.getFirstName() + " " + patient.getLastName());
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public String getDoctor() {
		return (doctor.getFirstName() + " " + doctor.getLastName());
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Diagnostic getDiagnostic() {
		return diagnostic;
	}

	public void setDiagnostic(Diagnostic diagnostic) {
		this.diagnostic = diagnostic;
	}

	public boolean isMedicalDischarge() {
		return medicalDischarge;
	}

	public void setMedicalDischarge(boolean medicalDischarge) {
		this.medicalDischarge = medicalDischarge;
	}

	@Override
	public String toString() {
		return "\nMedicalRecord " + id + ": " +
				"\ndoctor: "  + doctor.getLastName().toUpperCase() + ", " + doctor.getFirstName() +
				"\nDiagnostic: " + diagnostic +
				"\nMedical Discharged: " + medicalDischarge;
	}
}
