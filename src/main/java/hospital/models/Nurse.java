package hospital.models;

import java.util.Objects;

public class Nurse extends Employee{

	private long licence;
	private NurseCredential credential;

	public Nurse() {
	}

	public Nurse(long id, String firstName, String lastName, long licence, NurseCredential credential) {
		super.setId(id);
		super.setFirstName(firstName);
		super.setLastName(lastName);
		this.licence = licence;
		this.credential = credential;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Nurse nurse)) return false;
		return licence == nurse.licence && credential == nurse.credential;
	}

	@Override
	public int hashCode() {
		return Objects.hash(licence, credential);
	}

	@Override
	public String toString() {
		return "\nNurse Information: " +
				super.toString() +
				"\nlicence= " + licence +
				"\ncredential= " + credential.geteCredential();
	}
}
