package hospital.service;

import hospital.models.enums.EDisease;
import hospital.models.patient.Diagnostic;
import hospital.models.patient.Patient;
import hospital.models.staff.Doctor;

import java.time.LocalDate;

public interface TreatmentService {

	void createMedicalRecord(long id, Patient patient, Doctor doctor);

	Diagnostic Diagnosis(LocalDate date, EDisease disease, Patient patient);
}
