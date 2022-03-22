package hospital.service.impl;

import hospital.models.department.Hospital;
import hospital.models.patient.Appointment;
import hospital.models.patient.Patient;
import hospital.models.staff.Doctor;
import hospital.service.AppointmentService;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

public class AppointmentServiceImpl implements AppointmentService {

	@Override
	public void saveAppointment(
			Hospital hospital,LocalDate date,LocalTime time,Doctor doctor,Patient patient,BigDecimal cost) {
		Appointment appointment = new Appointment(hospital, date, time, doctor, patient, cost);
	}
}
