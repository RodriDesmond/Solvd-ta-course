package hospital;

import collection.HospitalEmployeesLinkedList;
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
import hospital.models.util.Employee;
import hospital.service.impl.AppointmentServiceImpl;
import hospital.service.impl.TreatmentServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import thread.DoctorRunnable;
import thread.connectionpool.ConnectionPool;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class HospitalApplication {

	private static final Logger LOGGER = LogManager.getLogger(HospitalApplication.class);

	public static void main(String[] args) throws AppointmentNotFoundException {

		final TreatmentServiceImpl treatment = new TreatmentServiceImpl();
		final AppointmentServiceImpl appointment = new AppointmentServiceImpl();

		//initializing Private Hospitals
		Hospital hospital = new Hospital("Princeton-Plainsboro Teaching Hospital", "123 Fake Street, 740 Evergreen Terrace");
		LOGGER.info(hospital.toString());

		//initializing employees
		Doctor docA = new Doctor(1L, "Morty", "Smith", ESpecialty.CARD);
		Doctor docB = new Doctor(2L, "Mr.", "Meeseek", ESpecialty.CARD);
		Doctor docD = new Doctor(4L, "Beth", "Smith", ESpecialty.DIAG_MED);
		Doctor docE = new Doctor(5L, "Rick", "Sanchez", ESpecialty.DIAG_MED);
		Doctor docF = new Doctor(6L, "Scary", "Terry", ESpecialty.DIAG_MED);
		Doctor docG = new Doctor(7L, "Tammy", "Guetermann", ESpecialty.DIAG_MED);
		Doctor docH = new Doctor(8L, "Mr.", "T", ESpecialty.DIAG_MED);

		Nurse nurseA = new Nurse(1L, "Jerry", "Smith", 54634L, NurseCredential.STAFF_NURSE);
		Nurse nurseB = new Nurse(2L, "Rick", "Sanchez", 67867L, NurseCredential.STAFF_NURSE);

		//Adding employee's to the Hospital
		hospital.addDoctor(docA);
		hospital.addDoctor(docB);
		hospital.addDoctor(docD);
		hospital.addDoctor(docE);
		hospital.addDoctor(docF);
		hospital.addDoctor(docG);
		hospital.addDoctor(docH);

		hospital.addNurse(nurseA);
		hospital.addNurse(nurseB);

		//initializing patients
		Patient patientA = new Patient(1L, "John", "Doe", "OSDE");
		Patient patientB = new Patient(2L, "Jane", "Doe", "OSDE");
		Patient patientC = new Patient(2L, "Walter", "White", "");

		//Appointments
		Appointment appointment1 = appointment.saveAppointment(hospital, LocalDate.now(), LocalTime.now(), docA, patientA, BigDecimal.valueOf(2000));
		Appointment appointment2 = appointment.saveAppointment(hospital, LocalDate.now(), LocalTime.now(), docB, patientB, BigDecimal.valueOf(2000));

		//Trying to appoint a client without Health Insurance Company
		try {

			Appointment appointment3 = appointment.saveAppointment(hospital, LocalDate.now(), LocalTime.now(), docB, patientC, BigDecimal.valueOf(2000));
		} catch (HealthInsuranceCompanyException e) {
			LOGGER.error(e);
		}

		//Treat Patient
		try {
			treatment.treatPatient(appointment1, patientA, docA);
			treatment.treatPatient(appointment2, patientA, docB);
		} catch (AppointmentNotFoundException e) {
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
			hospital.removeDoctor(docA);
		} catch (EmployeeNotFoundException e) {
			LOGGER.error(e.getMessage());
		}

		/* HomeTask 5
		* Generate a List of Employees using a custom LinkedList with generics
		* */
		HospitalEmployeesLinkedList<Employee> employeesList = new HospitalEmployeesLinkedList<Employee>();
		employeesList.add(docA);
		employeesList.add(docB);
		employeesList.add(nurseA);
		employeesList.add(nurseB);
		LOGGER.info(employeesList.iterate());

		/*=========================== THREADS =====================================================
		Initialize pool with 5 sizes.
		Load Connection Pool using threads and Thread Pool(7 threads).
		5 threads should be able to get the connection.
		2 Threads should wait for the next available connection. The program should wait as well.
		* */
		ThreadPoolExecutor tp = (ThreadPoolExecutor) Executors.newFixedThreadPool(5);

		tp.execute(docA);
		tp.execute(docB);
		tp.execute(docD);
		tp.execute(docE);
		tp.execute(docF);
		tp.execute(docG);
		tp.execute(docH);
		LOGGER.info(tp.toString());
		tp.shutdown();
	}
}