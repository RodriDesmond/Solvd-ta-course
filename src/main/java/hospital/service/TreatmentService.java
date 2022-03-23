package hospital.service;

import hospital.exceptions.AppointmentNotFoundException;
import hospital.models.enums.EDisease;
import hospital.models.patient.Appointment;
import hospital.models.patient.Diagnostic;
import hospital.models.patient.Patient;
import hospital.models.staff.Doctor;

import java.time.LocalDate;

public interface TreatmentService {

	void createMedicalRecord(long id, Patient patient, Doctor doctor);

	Diagnostic diagnosis(LocalDate date, EDisease disease, Patient patient);

	void treatPatient(Appointment appointment, Patient patient, Doctor doctor) throws AppointmentNotFoundException;

	void curePatient(Patient patient);
}
