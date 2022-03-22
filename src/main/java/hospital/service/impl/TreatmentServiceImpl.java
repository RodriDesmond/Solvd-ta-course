package hospital.service.impl;

import hospital.models.enums.EDisease;
import hospital.models.patient.Diagnostic;
import hospital.models.patient.MedicalRecord;
import hospital.models.patient.Patient;
import hospital.models.staff.Doctor;
import hospital.service.TreatmentService;

import java.time.LocalDate;

public class TreatmentServiceImpl implements TreatmentService {

	@Override
	public void createMedicalRecord(long id, Patient patient, Doctor doctor){
		MedicalRecord medicalRecord = new MedicalRecord (id, patient, doctor);
		patient.setMedicalRecord(medicalRecord);
	}

	@Override
	public Diagnostic Diagnosis(LocalDate date, EDisease disease, Patient patient) {
		Diagnostic diag = new Diagnostic(date,disease);
		diag.setPatient(patient);
		return diag;
	}
}
