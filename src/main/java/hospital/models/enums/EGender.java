package hospital.models.enums;

public enum EGender {

	M("Male"),
	F("Female");

	private final String eGender;

	EGender(String gender) {this.eGender = gender;}

	public String geteGender() {
		return eGender;
	}

	@Override
	public String toString() {return eGender;}
}
