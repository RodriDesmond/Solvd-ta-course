package hospital.service.impl;

import hospital.exceptions.AppointmentNotFoundException;
import hospital.models.enums.EDisease;
import hospital.models.patient.Appointment;
import hospital.models.patient.Diagnostic;
import hospital.models.patient.MedicalRecord;
import hospital.models.patient.Patient;
import hospital.models.staff.Doctor;
import hospital.service.TreatmentService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDate;
import java.util.Random;

public class TreatmentServiceImpl implements TreatmentService {

	private static final Logger LOGGER = LogManager.getLogger(TreatmentServiceImpl.class);
	Random random = new Random();

	@Override
	public void createMedicalRecord(long id, Patient patient, Doctor doctor){
		MedicalRecord medicalRecord = new MedicalRecord (id, patient, doctor);
		patient.setMedicalRecord(medicalRecord);
	}

	@Override
	public Diagnostic diagnosis(LocalDate date, EDisease disease, Patient patient) {
		Diagnostic diag = new Diagnostic(date,disease);
		diag.setPatient(patient);
		return diag;
	}

	@Override
	public void treatPatient(Appointment appointment, Patient patient, Doctor doctor) throws AppointmentNotFoundException {
		if(patient == appointment.getPatient() &&  doctor == appointment.getDoctor()) {

			createMedicalRecord(random.nextLong(99),patient,doctor);

			LOGGER.info("Appointment " + appointment.getDate() + ". Patient " + patient.getFirstName() + " " + patient.getLastName() +
					" was treated by the doctor " + doctor.getLastName());

		} else  {
			throw new AppointmentNotFoundException("Appointment not found");
		}
	}

	@Override
	public void curePatient(Patient patient) {
		patient.getMedicalRecord().setMedicalDischarge(true);
		LOGGER.info("Patient " + patient.getFirstName() + " " + patient.getLastName() + " no longer need to receive inpatient care and can go home.");
	}
}
