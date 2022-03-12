package hospital.models;

public class Pharmacist extends Employee{

	private long licence;

	public Pharmacist() {
	}

	public Pharmacist(long id, String firstName, String lastName, long licence) {
		super(id, firstName, lastName);
		this.licence = licence;
	}

	public long getLicence() {
		return licence;
	}

	public void setLicence(long licence) {
		this.licence = licence;
	}
}
