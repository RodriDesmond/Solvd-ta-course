package hospital.models.department;

import hospital.exceptions.EmployeeNotFoundException;
import hospital.models.staff.Doctor;
import hospital.models.staff.Nurse;

import java.util.ArrayList;
import java.util.List;

public class Hospital {

	private String name;
	private String address;
	private List<Doctor> doctorList = new ArrayList<>();
	private List<Nurse> nurseList = new ArrayList<>();

	public Hospital() {
	}

	public Hospital(String name, String address) {
		this.name = name;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<Doctor> getDoctorList() {
		return doctorList;
	}

	public void setDoctorList(List<Doctor> doctorList) {
		this.doctorList = doctorList;
	}

	public List<Nurse> getNurseList() {
		return nurseList;
	}

	public void setNurseList(List<Nurse> nurseList) {
		this.nurseList = nurseList;
	}

	public void addDoctor(Doctor doctor) {
		this.getDoctorList().add(doctor);
	}

	public void removeDoctor(Doctor doctor) {

		if (this.getDoctorList().contains(doctor)) {
			this.getDoctorList().remove(doctor);
		} else {
			throw new EmployeeNotFoundException("Employee not found.");
		}
	}

	public void addNurse(Nurse nurse) {
		this.getNurseList().add(nurse);
	}

	public void removeNurse(Nurse nurse) {
		this.getNurseList().remove(nurse);
	}

	@Override
	public String toString() {
		return "\nHospital information: " +
				"\nname: " + name +
				"\naddress: " + address;
	}
}
