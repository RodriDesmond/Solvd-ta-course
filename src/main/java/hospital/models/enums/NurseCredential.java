package hospital.models.enums;

public enum NurseCredential {

	STAFF_NURSE("Staff Nurse"),
	MANAGER("Nurse Manager"),
	DIRECTOR("Director of nursing");

	private final String eCredential;

	NurseCredential (String credential) {this.eCredential = credential;}

	public String geteCredential() {
		return eCredential;
	}

	@Override
	public String toString() {return eCredential;}
}
