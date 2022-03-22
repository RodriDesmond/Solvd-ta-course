package hospital.service;

import hospital.models.department.Hospital;
import hospital.models.patient.Appointment;
import hospital.models.patient.Patient;
import hospital.models.staff.Doctor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

public interface AppointmentService {

	Appointment saveAppointment(
			Hospital hospital,LocalDate date,LocalTime time,Doctor doctor,Patient patient,BigDecimal cost);
}
