package hospital.models.patient;

import hospital.models.util.Person;

public class Patient extends Person {

	private String healthInsuranceCompany;
	private MedicalRecord medicalRecord;
	private boolean medicalDischarge;

	public Patient(long id,
	               String firstName,
	               String lastName,
	               String healthInsuranceCompany) {
		super.setId(id);
		super.setFirstName(firstName);
		super.setLastName(lastName);
		this.healthInsuranceCompany = healthInsuranceCompany;
	}


	public String getHealthInsuranceCompany() {
		return healthInsuranceCompany;
	}

	public void setHealthInsuranceCompany(String healthInsuranceCompany) {
		this.healthInsuranceCompany = healthInsuranceCompany;
	}

	public MedicalRecord getMedicalRecord() {
		return medicalRecord;
	}

	public void setMedicalRecord(MedicalRecord medicalRecord) {
		this.medicalRecord = medicalRecord;
	}

	public boolean isMedicalDischarge() {
		return medicalDischarge;
	}

	public void setMedicalDischarge(boolean medicalDischarge) {
		this.medicalDischarge = medicalDischarge;
	}
}
