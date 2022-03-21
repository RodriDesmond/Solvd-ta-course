package hospital;

import hospital.models.department.Hospital;
import hospital.models.enums.NurseCredential;
import hospital.models.enums.ESpecialty;
import hospital.models.staff.Doctor;
import hospital.models.staff.Nurse;
import org.apache.log4j.Logger;


public class HospitalApplication {

	public static void main (String[] args) {

		final Logger LOGGER = Logger.getLogger(HospitalApplication.class);

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

		LOGGER.info(hospital.toString());
		LOGGER.info(hospital.getDoctorList());
		LOGGER.info(hospital.getNurseList());
	}
}
