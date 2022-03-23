package hospital;

import hospital.exceptions.AppointmentNotFoundException;
import hospital.exceptions.EmployeeNotFoundException;
import hospital.exceptions.HealthInsuranceCompanyException;
import hospital.models.department.Hospital;
import hospital.models.enums.EDisease;
import hospital.models.enums.NurseCredential;
import hospital.models.enums.ESpecialty;
import hospital.models.patient.Appointment;
import hospital.models.patient.Patient;
import hospital.models.staff.Doctor;
import hospital.models.staff.Nurse;
import hospital.service.impl.AppointmentServiceImpl;
import hospital.service.impl.TreatmentServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

public class HospitalApplication {

	private static final Logger LOGGER = LogManager.getLogger(HospitalApplication.class);

	public static void main (String[] args) throws AppointmentNotFoundException {

		final TreatmentServiceImpl treatment = new TreatmentServiceImpl();
		final AppointmentServiceImpl appointment = new AppointmentServiceImpl();

		//initializing Private Hospitals
		Hospital hospital = new Hospital("Princeton-Plainsboro Teaching Hospital", "123 Fake Street, 740 Evergreen Terrace");
		LOGGER.info(hospital.toString());

		//initializing employees
		Doctor docA = new Doctor (1L,"Morty","Smith", ESpecialty.CARD);
		Doctor docB = new Doctor (2L,"Tammy","Guetermann", ESpecialty.GEN_SUR);
		Doctor docC = new Doctor (3L,"Gregory","House", ESpecialty.DIAG_MED);

		Nurse nurseA = new Nurse (1L,"Jerry", "Smith", 54634L, NurseCredential.STAFF_NURSE);
		Nurse nurseB = new Nurse (2L,"Rick", "Sanchez", 67867L, NurseCredential.STAFF_NURSE);

		//Adding employee's to the Hospital
		hospital.addDoctor(docA);
		hospital.addDoctor(docB);
		hospital.addNurse(nurseA);
		hospital.addNurse(nurseB);

		//initializing patients
		Patient patientA = new Patient(1L,"John","Doe","OSDE");
		Patient patientB = new Patient(2L,"Jane","Doe","OSDE");
		Patient patientC = new Patient(2L,"Walter","White","");

		//Appointments
		Appointment appointment1 = appointment.saveAppointment(hospital, LocalDate.now(), LocalTime.now(),docA,patientA, BigDecimal.valueOf(2000));
		Appointment appointment2 = appointment.saveAppointment(hospital, LocalDate.now(), LocalTime.now(),docB,patientB, BigDecimal.valueOf(2000));

		//Trying to appoint a client without Health Insurance Company
		try {

			Appointment appointment3 = appointment.saveAppointment(hospital, LocalDate.now(), LocalTime.now(),docB,patientC, BigDecimal.valueOf(2000));
		}catch (HealthInsuranceCompanyException e) {
			LOGGER.error(e);
		}

		//Treat Patient
		try {
			treatment.treatPatient(appointment1, patientA, docA);
			treatment.treatPatient(appointment2, patientA, docB);
		} catch(AppointmentNotFoundException e) {
			LOGGER.error(e.getMessage());
		}

		//Diagnose patient
		patientA.getMedicalRecord().setDiagnostic(treatment.diagnosis(LocalDate.now(), EDisease.INFLUENZA, patientA));
		LOGGER.info("Patient " + patientA.getFirstName() + " " + patientA.getLastName() + patientA.getMedicalRecord());

		LOGGER.info("Patient was diagnosed with " + patientA.getMedicalRecord().getDiagnostic().getDisease().getName());

		//Cure Patient
		treatment.curePatient(patientA);
		LOGGER.info("Medical Discharged: " + patientA.getMedicalRecord().isMedicalDischarge());

		//Remove Employee from the list
		try {
			hospital.removeDoctor(docC);
		} catch (EmployeeNotFoundException e) {
			LOGGER.error(e.getMessage());
		}
	}
}
