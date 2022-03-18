package hospital.models.patient;

import hospital.models.util.Person;

public class Patient extends Person {

	private long id;
	private String healthInsuranceCompany;
	private MedicalRecord medicalRecord;
	private boolean medicalDischarge;

	@Override
	public long getId() {
		return id;
	}

	@Override
	public void setId(long id) {
		this.id = id;
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
