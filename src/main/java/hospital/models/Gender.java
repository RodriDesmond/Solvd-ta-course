package hospital.models;

public enum Gender {

	M("Male"),
	F("Female");

	private final String eGender;

	Gender (String gender) {this.eGender = gender;}

	public String geteGender() {
		return eGender;
	}

	@Override
	public String toString() {return eGender;}
}
