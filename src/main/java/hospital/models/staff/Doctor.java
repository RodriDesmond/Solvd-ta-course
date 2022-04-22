package hospital.models.staff;

import hospital.models.enums.ESpecialty;
import hospital.models.util.Employee;

import java.util.Objects;

public class Doctor extends Employee implements Runnable {

	private ESpecialty speciality;

	public Doctor() {
	}

	public Doctor(long id, String firstName, String lastName, ESpecialty speciality) {
		super.setId(id);
		super.setFirstName(firstName);
		super.setLastName(lastName);
		this.speciality = speciality;
	}

	public ESpecialty getSpeciality() {
		return speciality;
	}

	public void setSpeciality(ESpecialty speciality) {
		this.speciality = speciality;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Doctor doctor)) return false;
		return getSpeciality() == doctor.getSpeciality();
	}

	@Override
	public int hashCode() {
		return Objects.hash(getSpeciality());
	}

	@Override
	public String toString() {
		return "\nDoctors Information:" +
				super.toString() +
				"\nSpeciality: " + speciality.getSpecialty() + "\n";
	}

    @Override
    public void run() {
        System.out.println("Doctor " + super.getFirstName() + " " + super.getLastName() + " is working");
    }
}
