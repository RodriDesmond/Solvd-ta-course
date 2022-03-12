package hospital.models;

public class Nurse extends Employee{

	private long licence;
	private NurseCredential credential;

	public Nurse() {
	}

	public Nurse(long id, String firstName, String lastName, long licence, NurseCredential credential) {
		super(id, firstName, lastName);
		this.licence = licence;
		this.credential = credential;
	}
}
