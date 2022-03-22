package hospital;

import hospital.models.department.Hospital;
import hospital.models.enums.EDisease;
import hospital.models.enums.NurseCredential;
import hospital.models.enums.ESpecialty;
import hospital.models.patient.Diagnostic;
import hospital.models.patient.Patient;
import hospital.models.staff.Doctor;
import hospital.models.staff.Nurse;
import hospital.service.impl.AppointmentServiceImpl;
import hospital.service.impl.TreatmentServiceImpl;
import org.apache.log4j.Logger;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;


public class HospitalApplication {

	public static void main (String[] args) {

		final Logger LOGGER = Logger.getLogger(HospitalApplication.class);

		final TreatmentServiceImpl treatment = new TreatmentServiceImpl() {
		};
		final AppointmentServiceImpl appointment = new AppointmentServiceImpl();

		//initializing Private Hospitals
		Hospital hospital = new Hospital("Hospital 1", "Evergreen St. 123");

		//initializing employees
		Doctor docA = new Doctor (1L,"Morty","Smith", ESpecialty.CARD);
		Doctor docB = new Doctor (2L,"Tammy","Guetermann", ESpecialty.GEN_SUR);
		Nurse nurseA = new Nurse (1L,"Jerry", "Smith", 54634L, NurseCredential.STAFF_NURSE);
		Nurse nurseB = new Nurse (2L,"Rick", "Sanchez", 67867L, NurseCredential.STAFF_NURSE);

		hospital.addDoctor(docA);
		hospital.addDoctor(docB);
		hospital.addNurse(nurseA);
		hospital.addNurse(nurseB);

		//initializing patients
		Patient patientA = new Patient(1L,"John","Doe","OSDE");
		Patient patientB = new Patient(2L,"Jane","Doe","OSDE");

		//Appointments
		appointment.saveAppointment(hospital, LocalDate.now(), LocalTime.now(),docA,patientA, BigDecimal.valueOf(2000));
		appointment.saveAppointment(hospital, LocalDate.now(), LocalTime.now(),docB,patientB, BigDecimal.valueOf(2000));

		//patients medical records
		treatment.createMedicalRecord(1L,patientA,docA);

		//set diagnostic to patient
		patientA.getMedicalRecord().setDiagnostic(treatment.Diagnosis(LocalDate.now(), EDisease.INFLUENZA, patientA));

		LOGGER.info(hospital.toString());
		LOGGER.info(patientA.getMedicalRecord());
	}
}
