package hospital.models;

public class Doctor extends Employee{

	private Specialty speciality;

	public Doctor() {
	}

	public Doctor(long id, String firstName, String lastName, Specialty speciality) {
		super.setId(id);
		super.setFirstName(firstName);
		super.setLastName(lastName);
		this.speciality = speciality;
	}

	public Specialty getSpeciality() {
		return speciality;
	}

	public void setSpeciality(Specialty speciality) {
		this.speciality = speciality;
	}

	@Override
	public String toString() {
		return "\nDoctor Information:\n" +
				super.toString() +
				"\nspeciality= " + speciality.getSpecialty();
	}
}
